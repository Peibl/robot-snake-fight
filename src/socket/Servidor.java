// Configurar un servidor que reciba una conexión de un cliente, envíe
// una cadena al cliente y cierre la conexión.
package socket;

import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import vista.*;

public class Servidor  implements ClienteServidor,Runnable{

   private ObjectOutputStream salida;
   private ObjectInputStream entrada;
   private ServerSocket servidor;
   private Socket conexion;
   private int contador = 1;
   private PanelChat panel;
   private DatosClienteServidor dc;

   public Servidor( DatosClienteServidor dc,PanelChat panel)
   {
	   this.panel=panel;
	   this.dc=dc;

   } // fin del constructor de Servidor

   // configurar y ejecutar el servidor
   public void ejecutar()
   {
      // configurar servidor para que reciba conexiones; procesar las conexiones
      try {

         // Paso 1: crear un objeto ServerSocket.
         servidor = new ServerSocket( dc.getPuerto(),100 );



         while ( true ) {

            try {
               esperarConexion(); // Paso 2: esperar una conexión.
               obtenerFlujos();        // Paso 3: obtener flujos de entrada y salida.
               procesarConexion(); // Paso 4: procesar la conexión.
            }

            // procesar excepción EOFException cuando el cliente cierre la conexión
            catch ( EOFException excepcionEOF ) {
               System.err.println( "El servidor terminó la conexión" );
            }

            finally {
               cerrarConexion();   // Paso 5: cerrar la conexión.
               ++contador;
            }

         } // fin de instrucción while

      } // fin del bloque try

      // procesar problemas con E/S
      catch ( IOException excepcionES ) {
         excepcionES.printStackTrace();
      }

   } // fin del método ejecutarServidor

   // esperar que la conexión llegue, después mostrar información de la conexión
   private void esperarConexion() throws IOException
   {
      mostrarMensaje( "Esperando una conexión\n" );
      conexion = servidor.accept(); // permitir al servidor aceptar la conexión

      mostrarMensaje( "Conexión " + contador + " recibida de: " +
         conexion.getInetAddress().getHostName() );
   }

   // obtener flujos para enviar y recibir datos
   public void obtenerFlujos() throws IOException
   {
      // establecer flujo de salida para los objetos
      salida = new ObjectOutputStream( conexion.getOutputStream() );
      salida.flush(); // vaciar búfer de salida para enviar información de encabezado

      // establecer flujo de entrada para los objetos
      entrada = new ObjectInputStream( conexion.getInputStream() );

      mostrarMensaje( "\nSe recibieron los flujos de E/S\n" );
   }

   // procesar la conexión con el cliente
   public void procesarConexion() throws IOException
   {
      // enviar mensaje de conexión exitosa al cliente
      String mensaje = "Conexión exitosa";
      panel.setCampIntr(true);

      enviarDatos( mensaje );

      // habilitar campoIntroducir para que el usuario del servidor pueda enviar mensajes
      //establecerCampoTextoEditable( true );

      do { // procesar los mensajes enviados por el cliente

         // leer el mensaje y mostrarlo en pantalla
         try {
            mensaje = ( String ) entrada.readObject();
            mostrarMensaje( "\n" + mensaje );
         }

         // atrapar problemas que pueden ocurrir al tratar de leer del cliente
         catch ( ClassNotFoundException excepcionClaseNoEncontrada ) {
            mostrarMensaje( "\nSe recibió un tipo de objeto desconocido" );
         }

      } while ( !mensaje.equals( "CLIENTE>>> TERMINAR" ) );

   } // fin del método procesarConexion

   // cerrar flujos y socket
   public void cerrarConexion()
   {
      mostrarMensaje( "\nFinalizando la conexión\n" );
     // establecerCampoTextoEditable( false ); // deshabilitar campoIntroducir

      try {
         salida.close();
         entrada.close();
         conexion.close();
      }
      catch( IOException excepcionES ) {
         excepcionES.printStackTrace();
      }
   }

   // enviar mensaje al cliente
   public void enviarDatos( Object mensaje )
   {
      // enviar objeto al cliente
      try {
         salida.writeObject( dc.getNick()+"(servidor)>>> " + mensaje );
         salida.flush();
         mostrarMensaje( "\n"+dc.getNick()+"(servidor)>>> " + mensaje );
      }

      // procesar problemas que pueden ocurrir al enviar el objeto
      catch ( IOException excepcionES ) {
        // frame.areaPantalla.append( "\nError al escribir objeto" );
      }
   }

   // método utilitario que es llamado desde otros subprocesos para manipular a
   // areaPantalla en el subproceso despachador de eventos
   public void mostrarMensaje( final String mensajeAMostrar )
   {
      // mostrar mensaje del subproceso de ejecución despachador de eventos
     // SwingUtilities.invokeLater(
         //new Runnable() {  // clase interna para asegurar que la GUI se actualice apropiadamente

            //public void run() // actualiza areaPantalla
            //{
            	 panel.setAreaPantalla(mensajeAMostrar);
          //  }

        // }  // fin de la clase interna

      //); // fin de la llamada a SwingUtilities.invokeLater
   }



public void run() {
	// TODO Auto-generated method stub
	this.ejecutar();

}



}  // fin de la clase Servidor