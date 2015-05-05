// Configurar un servidor que reciba una conexi�n de un cliente, env�e
// una cadena al cliente y cierre la conexi�n.
package socket;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import vista.PanelChat;

public class Servidor implements ClienteServidor, Runnable {

	private ObjectOutputStream salida;
	private ObjectInputStream entrada;
	private ServerSocket servidor;
	private Socket conexion;
	private int contador = 1;
	private PanelChat panel;
	private DatosClienteServidor dc;

	public Servidor(DatosClienteServidor dc, PanelChat panel) {
		this.panel = panel;
		this.dc = dc;

	} // fin del constructor de Servidor

	// configurar y ejecutar el servidor
	@Override
	public void ejecutar() {
		// configurar servidor para que reciba conexiones; procesar las
		// conexiones
		try {

			// Paso 1: crear un objeto ServerSocket.
			servidor = new ServerSocket(dc.getPuerto(), 100);

			while (true) {

				try {
					esperarConexion(); // Paso 2: esperar una conexi�n.
					obtenerFlujos(); // Paso 3: obtener flujos de entrada y
										// salida.
					procesarConexion(); // Paso 4: procesar la conexi�n.
				}

				// procesar excepci�n EOFException cuando el cliente cierre la
				// conexi�n
				catch (EOFException excepcionEOF) {
					System.err.println("El servidor termin� la conexi�n");
				}

				finally {
					cerrarConexion(); // Paso 5: cerrar la conexi�n.
					++contador;
				}

			} // fin de instrucci�n while

		} // fin del bloque try

		// procesar problemas con E/S
		catch (IOException excepcionES) {
			excepcionES.printStackTrace();
		}

	} // fin del m�todo ejecutarServidor

	// esperar que la conexi�n llegue, despu�s mostrar informaci�n de la
	// conexi�n
	private void esperarConexion() throws IOException {
		mostrarMensaje("Esperando una conexi�n\n");
		conexion = servidor.accept(); // permitir al servidor aceptar la
										// conexi�n

		mostrarMensaje("Conexi�n " + contador + " recibida de: "
				+ conexion.getInetAddress().getHostName());
	}

	// obtener flujos para enviar y recibir datos
	@Override
	public void obtenerFlujos() throws IOException {
		// establecer flujo de salida para los objetos
		salida = new ObjectOutputStream(conexion.getOutputStream());
		salida.flush(); // vaciar b�fer de salida para enviar informaci�n de
						// encabezado

		// establecer flujo de entrada para los objetos
		entrada = new ObjectInputStream(conexion.getInputStream());

		mostrarMensaje("\nSe recibieron los flujos de E/S\n");
	}

	// procesar la conexi�n con el cliente
	@Override
	public void procesarConexion() throws IOException {
		// enviar mensaje de conexi�n exitosa al cliente
		String mensaje = "Conexi�n exitosa";
		panel.setCampIntr(true);

		enviarDatos(mensaje);

		// habilitar campoIntroducir para que el usuario del servidor pueda
		// enviar mensajes
		// establecerCampoTextoEditable( true );

		do { // procesar los mensajes enviados por el cliente

			// leer el mensaje y mostrarlo en pantalla
			try {
				mensaje = (String) entrada.readObject();
				mostrarMensaje("\n" + mensaje);
			}

			// atrapar problemas que pueden ocurrir al tratar de leer del
			// cliente
			catch (ClassNotFoundException excepcionClaseNoEncontrada) {
				mostrarMensaje("\nSe recibi� un tipo de objeto desconocido");
			}

		} while (!mensaje.equals("CLIENTE>>> TERMINAR"));

	} // fin del m�todo procesarConexion

	// cerrar flujos y socket
	@Override
	public void cerrarConexion() {
		mostrarMensaje("\nFinalizando la conexi�n\n");
		// establecerCampoTextoEditable( false ); // deshabilitar
		// campoIntroducir

		try {
			salida.close();
			entrada.close();
			conexion.close();
		} catch (IOException excepcionES) {
			excepcionES.printStackTrace();
		}
	}

	// enviar mensaje al cliente
	@Override
	public void enviarDatos(Object mensaje) {
		// enviar objeto al cliente
		try {
			salida.writeObject(dc.getNick() + "(servidor)>>> " + mensaje);
			salida.flush();
			mostrarMensaje("\n" + dc.getNick() + "(servidor)>>> " + mensaje);
		}

		// procesar problemas que pueden ocurrir al enviar el objeto
		catch (IOException excepcionES) {
			// frame.areaPantalla.append( "\nError al escribir objeto" );
		}
	}

	// m�todo utilitario que es llamado desde otros subprocesos para manipular a
	// areaPantalla en el subproceso despachador de eventos
	@Override
	public void mostrarMensaje(final String mensajeAMostrar) {
		// mostrar mensaje del subproceso de ejecuci�n despachador de eventos
		// SwingUtilities.invokeLater(
		// new Runnable() { // clase interna para asegurar que la GUI se
		// actualice apropiadamente

		// public void run() // actualiza areaPantalla
		// {
		panel.setAreaPantalla(mensajeAMostrar);
		// }

		// } // fin de la clase interna

		// ); // fin de la llamada a SwingUtilities.invokeLater
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.ejecutar();

	}

} // fin de la clase Servidor