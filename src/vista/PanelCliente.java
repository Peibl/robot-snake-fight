package vista;

import java.awt.GridLayout;
import javax.swing.JPanel;

import controladorSocket.*;
import socket.*;
public class PanelCliente extends JPanel {

	 PanelConfigCliente jp1;
	 PanelChat jp2 ;

	public PanelCliente(ControlCliente mc){
		 jp1 = new PanelConfigCliente(mc);
		 jp2 = new PanelChat();
		this.setBounds(0, 0, 600, 400);
		this.setLayout(new GridLayout(1,2));
		this.add(jp1);
		this.add(jp2);

		this.setVisible(true);
	}

	public PanelConfigCliente getPanelConfigCliente(){
		return jp1;
	}

	public PanelChat getPanelChat(){
		return jp2;
	}


}
