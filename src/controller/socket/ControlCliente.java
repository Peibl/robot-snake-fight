package controller.socket;

import socket.Cliente;
import view.FramePrincipal;
import view.PanelCliente;

public class ControlCliente implements Controlador {
	private Cliente cliente;
	private PanelCliente panel;
	private Thread thread;

	public ControlCliente(FramePrincipal fm) {
		super();
		panel = new PanelCliente(this);
		fm.setPp(panel);

	}

	@Override
	public void CrearSocket() {
		// TODO Auto-generated method stub
		cliente = new Cliente(panel.getPanelConfigCliente().getDc(), panel.getPanelChat());
		panel.getPanelChat().setClienteServidor(cliente);
		thread = new Thread(cliente);
		thread.start();
	}

	@Override
	public void DetenerSocket() {
		// TODO Auto-generated method stub
		thread.stop();
	}

}
