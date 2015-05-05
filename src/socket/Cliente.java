// Cliente que lee y muestra la informaci�n que le env�a un Servidor.
package socket;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

import vista.PanelChat;

public class Cliente implements ClienteServidor, Runnable {

	private ObjectOutputStream salida;
	private ObjectInputStream entrada;
	private String mensaje = "";
	private String servidorChat;
	private Socket cliente;
	private PanelChat panel;
	private DatosClienteServidor dc;

	// inicializar servidorChat y configurar GUI
	public Cliente(DatosClienteServidor dc, PanelChat panel) {
		this.dc = dc;
		servidorChat = dc.getIp(); // establecer el servidor al que se va a
									// conectar este cliente

		this.panel = panel;

	} // fin del constructor de Cliente

	// conectarse al servidor y procesar mensajes del servidor
	@Override
	public void ejecutar() {
		// conectarse al servidor, obtener flujos, procesar la conexi�n
		try {
			conectarAServidor(); // Paso 1: crear un socket para realizar la
									// conexi�n
			obtenerFlujos(); // Paso 2: obtener los flujos de entrada y salida
			procesarConexion(); // Paso 3: procesar la conexi�n
		}

		// el servidor cerr� la conexi�n
		catch (EOFException excepcionEOF) {
			System.err.println("El cliente termino la conexi�n");
		}

		// procesar los problemas que pueden ocurrir al comunicarse con el
		// servidor
		catch (IOException excepcionES) {
			excepcionES.printStackTrace();
		}

		finally {
			cerrarConexion(); // Paso 4: cerrar la conexi�n
		}

	} // fin del m�todo ejecutarCliente

	// conectarse al servidor
	public void conectarAServidor() throws IOException {
		mostrarMensaje("Intentando realizar conexi�n\n");

		// crear Socket para realizar la conexi�n con el servidor
		cliente = new Socket(InetAddress.getByName(servidorChat),
				dc.getPuerto());

		// mostrar la informaci�n de la conexi�n
		mostrarMensaje("Conectado a: " + cliente.getInetAddress().getHostName());
	}

	// obtener flujos para enviar y recibir datos
	@Override
	public void obtenerFlujos() throws IOException {
		// establecer flujo de salida para los objetos
		salida = new ObjectOutputStream(cliente.getOutputStream());
		salida.flush(); // vac�ar b�fer de salida para enviar informaci�n de
						// encabezado

		// establecer flujo de entrada para los objetos
		entrada = new ObjectInputStream(cliente.getInputStream());

		mostrarMensaje("\nSe recibieron los flujos de E/S\n");
	}

	// procesar la conexi�n con el servidor
	@Override
	public void procesarConexion() throws IOException {
		// habilitar campoIntroducir para que el usuario del cliente pueda
		// enviar mensajes
		// establecerCampoTextoEditable( true );
		panel.setCampIntr(true);

		do { // procesar mensajes enviados del servidor

			// leer mensaje y mostrarlo en pantalla
			try {
				mensaje = (String) entrada.readObject();
				mostrarMensaje("\n" + mensaje);
			}

			// atrapar los problemas que pueden ocurrir al leer del servidor
			catch (ClassNotFoundException excepcionClaseNoEncontrada) {
				mostrarMensaje("\nSe recibi� un objeto de tipo desconocido");
			}

		} while (!mensaje.equals("SERVIDOR>>> TERMINAR"));

	} // fin del m�todo procesarConexion

	// cerrar flujos y socket
	@Override
	public void cerrarConexion() {
		mostrarMensaje("\nCerrando conexi�n");
		// establecerCampoTextoEditable( false ); // deshabilitar
		// campoIntroducir

		try {
			salida.close();
			entrada.close();
			cliente.close();
		} catch (IOException excepcionES) {
			excepcionES.printStackTrace();
		}
	}

	// enviar mensaje al servidor
	@Override
	public void enviarDatos(Object mensaje) {
		// enviar objeto al servidor
		try {
			salida.writeObject(dc.getNick() + "(cliente)>>> " + mensaje);
			salida.flush();
			mostrarMensaje("\n" + dc.getNick() + "(cliente)>>> " + mensaje);
		}

		// procesar los problemas que pueden ocurrir al enviar el objeto
		catch (IOException excepcionES) {
			// frame.areaPantalla.append( "\nError al escribir el objeto" );
		}
	}

	// m�todo utilitario que es llamado desde otros subprocesos para manipular a
	// areaPantalla en el subproceso despachador de eventos
	@Override
	public void mostrarMensaje(final String mensajeAMostrar) {
		// mostrar mensaje del subproceso de ejecuci�n de la GUI
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

} // fin de la clase Cliente