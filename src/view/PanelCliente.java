package view;

import java.awt.GridLayout;

import javax.swing.JPanel;

import controller.socket.ControlCliente;

public class PanelCliente extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5224093967317784887L;
	PanelConfigCliente jp1;
	PanelChat jp2;

	public PanelCliente(ControlCliente mc) {
		jp1 = new PanelConfigCliente(mc);
		jp2 = new PanelChat();
		this.setBounds(0, 0, 600, 400);
		this.setLayout(new GridLayout(1, 2));
		this.add(jp1);
		this.add(jp2);

		this.setVisible(true);
	}

	public PanelConfigCliente getPanelConfigCliente() {
		return jp1;
	}

	public PanelChat getPanelChat() {
		return jp2;
	}

}
