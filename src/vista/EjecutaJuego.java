package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controladorSocket.Controlador;

class EjecutaJuego implements ActionListener {
	PanelConfig pc;
	Controlador contr;

	public EjecutaJuego(PanelConfig pc, Controlador contr) {
		this.pc = pc;
		this.contr = contr;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == pc.jbConectar) {
			contr.DetenerSocket();
			System.out.print(contr.getClass());
		}

	}

}
