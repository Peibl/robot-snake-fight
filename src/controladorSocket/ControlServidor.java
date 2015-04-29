package controladorSocket;

import socket.*;
import vista.*;
public class ControlServidor implements Controlador {
	private Servidor server;
	private PanelServidor panel;
	private Thread thread;
	private FramePrincipal fm;

	public ControlServidor(FramePrincipal fm){
		//super();
		this.fm=fm;
		panel= new PanelServidor(this);

		fm.setPp(panel);


	}
	public void CrearSocket(){
		server=new Servidor ( panel.getPanelConfigServidor().getDc(),panel.getPanelChat());
		panel.getPanelChat().setClienteServidor(server);
		thread= new Thread(server);
		thread.start();

	}
	public void DetenerSocket() {
		// TODO Auto-generated method stub
		thread.stop();
	}


}
