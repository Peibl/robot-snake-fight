package vista;

import java.io.IOException;
import java.net.InetAddress;

import controlador.socket.ControlServidor;

public class PanelConfigServidor extends PanelConfig {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5892715287966854060L;

	public PanelConfigServidor(ControlServidor cs) {
		super(cs);
		this.setTextoJbConectar("Crear");
		tfIP.setText(this.getIP());
		tfIP.setEnabled(false);
		this.setVisible(true);

	}

	public String getIP() {
		try {
			return (InetAddress.getLocalHost().getHostAddress());
		} catch (IOException se) {
			return ("No funca.");
		}
	}
}