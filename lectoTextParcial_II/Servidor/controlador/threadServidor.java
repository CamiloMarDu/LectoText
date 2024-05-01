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



public class threadServidor extends Thread  {
	
	 Socket scli=null;
     Socket scli2=null;
     DataInputStream entrada=null;
     DataOutputStream salida=null;
     boolean verificacionRealizada = false;
     boolean usuarioEnBase = true;

 
     Usuario user;
  //   public static Vector<threadServidor> clientesActivos=new Vector();	
     String nameUser;
     GestorServidor serv;
     /**
      * Constructor de la clase ThreadServidor.
      * @param scliente Socket de comunicación con el cliente.
      * @param scliente2 Socket de comunicación con el cliente para enviar mensajes.
      * @param serv Gestor del servidor.
      */
     public threadServidor(Socket scliente,Socket scliente2,GestorServidor serv)
     {
        scli=scliente;
        scli2=scliente2;
        this.serv=serv;
        
    //    clientesActivos.add(this);        
       	
     }
     /**
      * Obtiene el nombre del usuario asociado al hilo del servidor.
      * @return Nombre del usuario.
      */
   
     /**
    
     /**
      * Método que se ejecuta cuando se inicia el hilo.
      */
     public void run()
     {
    	controlUsuarios controlUs=new controlUsuarios();
    	
    	try
    	{
          entrada=new DataInputStream(scli.getInputStream());
          salida=new DataOutputStream(scli.getOutputStream());
          
          
          
    	}
    	catch (IOException e) {  e.printStackTrace();     }
    	
      
          
    	while(true)
    	{
          try
          {
        	  

              if(!verificacionRealizada) {
            	  String usuario = entrada.readUTF();
                  String contraseña = entrada.readUTF();
                  String ip = entrada.readUTF();
                  String estado = entrada.readUTF();
            	  usuarioEnBase=controlUs.verificar(usuario, contraseña, ip, estado);
            	  
            	  verificacionRealizada=true;
              }
              if(!usuarioEnBase) {
            	  serv.vista.aviso("servidor>>CLIENTE NO EXISTE");
            	  salida.writeUTF("servidor>>CLIENTE NO EXISTE");
            	  break;
              }else {
            	  salida.writeUTF("di");
              }
              
              String texto = entrada.readUTF();
              
              SynthesizerModeDesc required = new SynthesizerModeDesc();
              
              required.setLocale(Locale.ROOT);
              
              Voice voice=new Voice(null, Voice.GENDER_FEMALE, Voice.GENDER_FEMALE, null);
              
              required.addVoice(voice);
              
              Synthesizer synth = Central.createSynthesizer(null);
              
              synth.allocate();
              synth.resume();
              
              synth.speakPlainText(texto,null);
              
              synth.waitEngineState(Synthesizer.QUEUE_EMPTY);
              synth.deallocate();
          }
          catch (IOException e) {System.out.println("El cliente termino la conexion");break;} catch (EngineException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EngineStateError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AudioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	}
    	
    	try
    	{
          serv.vista.enConsola("Se desconecto un usuario");
          scli.close();
    	}	
        catch(Exception et)
        {serv.vista.enConsola("no se puede cerrar el socket");}   
     }
    

}
