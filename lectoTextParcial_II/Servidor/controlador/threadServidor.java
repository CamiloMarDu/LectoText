package controlador;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import java.io.FileReader;
import java.util.Locale;

import javax.speech.AudioException;
import javax.speech.Central;
import javax.speech.EngineException;
import javax.speech.EngineStateError;
import javax.speech.synthesis.Synthesizer;
import javax.speech.synthesis.SynthesizerModeDesc;
import javax.speech.synthesis.Voice;

import Modelo.Usuario;

/**
 * Clase que maneja la comunicación con un cliente en un hilo separado.
 */
public class threadServidor extends Thread  {
	
    Socket scli=null;
    Socket scli2=null;
    DataInputStream entrada=null;
    DataOutputStream salida=null;
    boolean verificacionRealizada = false;
    boolean usuarioEnBase = true;

    Usuario user;

    String nameUser;
    GestorServidor serv;

    /**
     * Constructor de la clase ThreadServidor.
     * @param scliente Socket de comunicación con el cliente.
     * @param scliente2 Socket de comunicación con el cliente para enviar mensajes.
     * @param serv Gestor del servidor.
     */
    public threadServidor(Socket scliente, Socket scliente2, GestorServidor serv) {
        scli = scliente;
        scli2 = scliente2;
        this.serv = serv;
    }

    /**
     * Método que se ejecuta cuando se inicia el hilo.
     */
    public void run() {
        controlUsuarios controlUs = new controlUsuarios();
        try {
            entrada = new DataInputStream(scli.getInputStream());
            salida = new DataOutputStream(scli.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        while(true) {
            try {
                if (!verificacionRealizada) {
                    String usuario = entrada.readUTF();
                    String contraseña = entrada.readUTF();
                    String ip = entrada.readUTF();
                    String estado = entrada.readUTF();
                    usuarioEnBase = controlUs.verificar(usuario, contraseña, ip, estado);
                    verificacionRealizada = true;
                }
                
                if (!usuarioEnBase) {
                    serv.vista.aviso("servidor>>CLIENTE NO EXISTE");
                    salida.writeUTF("servidor>>CLIENTE NO EXISTE");
                    break;
                } else {
                    salida.writeUTF("di");
                }
                
                String idioma = entrada.readUTF();
                String texto = entrada.readUTF();
                
                SynthesizerModeDesc required = new SynthesizerModeDesc();
                
                if (idioma.equals("1")) {
                    required.setLocale(Locale.ROOT); // Español (España)
                    required.setEngineName("general");
                } else if (idioma.equals("2")) {
                    required.setLocale(Locale.ENGLISH); // Inglés
                    required.setEngineName("general");
                } else if (idioma.equals("3")) {
                    required.setLocale(Locale.GERMAN); // Alemán
                    required.setEngineName("general");
                } else {
                    required.setLocale(Locale.getDefault()); // Idioma predeterminado
                    required.setEngineName("general");
                }
                
                Voice voice = new Voice(null, Voice.GENDER_MALE, Voice.GENDER_MALE, null);
                required.addVoice(voice);
                
                Synthesizer synth = Central.createSynthesizer(null);
                synth.allocate();
                synth.resume();
                
                synth.speakPlainText(texto,null);
                synth.waitEngineState(Synthesizer.QUEUE_EMPTY);
                synth.deallocate();
                
            } catch (IOException | EngineException | EngineStateError | AudioException | IllegalArgumentException | InterruptedException e) {
                System.out.println("El cliente terminó la conexión");
                break;
            }
        }
        
        try {
            serv.vista.enConsola("Se desconectó un usuario");
            scli.close();
        } catch(Exception et) {
            serv.vista.enConsola("No se puede cerrar el socket");
        }   
    }
}

