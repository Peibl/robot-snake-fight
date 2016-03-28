package view;

import controller.socket.ControlCliente;
import socket.DatosClienteServidor;

public class PanelConfigCliente extends PanelConfig {

	private static final long serialVersionUID = 1813774215670904398L;

	public PanelConfigCliente(ControlCliente cc) {
		super(cc);
		this.setTextoJbConectar("Conectar");
		this.setVisible(true);

	}

	@Override
	public DatosClienteServidor getDc() {
		return dc;
	}
}