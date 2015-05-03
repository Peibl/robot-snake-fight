package vista;

import java.awt.GridLayout;

import javax.swing.JPanel;

import controladorSocket.ControlServidor;

public class PanelServidor extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1299805481166649906L;
	private PanelConfigServidor jp1;
	private PanelChat jp2;

	public PanelServidor(ControlServidor cs) {

		jp1 = new PanelConfigServidor(cs);
		jp2 = new PanelChat();

		this.setLayout(new GridLayout(1, 2));

		this.add(jp1);
		this.add(jp2);

		this.setVisible(true);
	}

	public PanelChat getPanelChat() {
		return (jp2);
	}

	public PanelConfigServidor getPanelConfigServidor() {
		return (jp1);

	}

}
