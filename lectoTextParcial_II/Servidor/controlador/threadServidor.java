package controlador;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Vector;

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
        	  String usuario = entrada.readUTF();
              String contraseña = entrada.readUTF();
              String ip = entrada.readUTF();
              String estado = entrada.readUTF();
              if(!verificacionRealizada) {
            	  
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
              
          }
          catch (IOException e) {System.out.println("El cliente termino la conexion");break;}
    	}
    	
    	try
    	{
          serv.vista.enConsola("Se desconecto un usuario");
          scli.close();
    	}	
        catch(Exception et)
        {serv.vista.enConsola("no se puede cerrar el socket");}   
     }
    
 /*    public void enviaMsg(String mencli2)
     {
        threadServidor user=null;
        for(int i=0;i<clientesActivos.size();i++)
        {
           serv.vista.mostrar("MENSAJE DEVUELTO:"+mencli2);
           try
            {
              user=clientesActivos.get(i);
              user.salida2.writeInt(1);//opcion de mensage 
              user.salida2.writeUTF(""+this.getNameUser()+" >"+ mencli2);              
            }catch (IOException e) {e.printStackTrace();}
        }
     }
     /**
      * Método para enviar la lista de usuarios activos a todos los clientes.
      */
     /*
     public void enviaUserActivos()
     {
        threadServidor user=null;
        for(int i=0;i<clientesActivos.size();i++)
        {           
           try
            {
              user=clientesActivos.get(i);
              if(user==this)continue;//ya se lo envie
              user.salida2.writeInt(2);//opcion de agregar 
              user.salida2.writeUTF(this.getNameUser());	
            }catch (IOException e) {e.printStackTrace();}
        }
     }
     /**
      * Método para enviar un mensaje a un usuario específico.
      * @param amigo Nombre del usuario destinatario.
      * @param mencli Mensaje a enviar.
      */
     /*
   private void enviaMsg(String amigo, String mencli) 
   {
      threadServidor user=null;
        for(int i=0;i<clientesActivos.size();i++)
        {           
           try
            {
              user=clientesActivos.get(i);
              if(user.nameUser.equals(amigo))
              {
                 user.salida2.writeInt(3);//opcion de mensage amigo   
                 user.salida2.writeUTF(this.getNameUser());
                 user.salida2.writeUTF(""+this.getNameUser()+">"+mencli);
              }
            }catch (IOException e) {e.printStackTrace();}
        }
   }*/
}
