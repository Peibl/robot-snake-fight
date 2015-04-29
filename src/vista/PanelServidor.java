package vista;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controladorSocket.*;
import socket.*;

public class PanelServidor extends JPanel{
	private PanelConfigServidor jp1;
	private PanelChat jp2;

	public PanelServidor(ControlServidor cs){

		jp1 = new PanelConfigServidor(cs);
		jp2 = new PanelChat();

		this.setLayout(new GridLayout(1,2));

		this.add(jp1);
		this.add(jp2);

		this.setVisible(true);
	}

	public PanelChat getPanelChat(){
			return(jp2);
	}

	public PanelConfigServidor getPanelConfigServidor(){
		return (jp1);

	}


}
