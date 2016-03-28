package controller.socket;

import socket.Servidor;
import view.FramePrincipal;
import view.PanelServidor;

public class ControlServidor implements Controlador {
	private Servidor server;
	private PanelServidor panel;
	private Thread thread;

	public ControlServidor(FramePrincipal fm) {
		panel = new PanelServidor(this);

		fm.setPp(panel);

	}

	@Override
	public void CrearSocket() {
		server = new Servidor(panel.getPanelConfigServidor().getDc(), panel.getPanelChat());
		panel.getPanelChat().setClienteServidor(server);
		thread = new Thread(server);
		thread.start();

	}

	@Override
	public void DetenerSocket() {
		// TODO Auto-generated method stub
		thread.stop();
	}

}
