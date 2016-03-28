package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import socket.ClienteServidor;

public class PanelChat extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2657362811370544268L;
	private JTextField campoIntroducir;
	private JTextArea areaPantalla;
	private ClienteServidor cs;
	private boolean CampIntr = false;

	public PanelChat() {
		this.setLayout(new BorderLayout());
		campoIntroducir = new JTextField();
		campoIntroducir.setEditable(CampIntr);
		campoIntroducir.addActionListener(new ActionListener() {

			// enviar mensaje al cliente
			@Override
			public void actionPerformed(ActionEvent evento) {
				cs.enviarDatos(evento.getActionCommand());
				campoIntroducir.setText("");
			}
		});
		areaPantalla = new JTextArea();
		this.add(campoIntroducir, BorderLayout.NORTH);

		this.add(new JScrollPane(areaPantalla), BorderLayout.CENTER);
	}

	public void setAreaPantalla(String mensajeAMostrar) {
		areaPantalla.append(mensajeAMostrar);
		areaPantalla.setCaretPosition(areaPantalla.getText().length());

	}

	public void setClienteServidor(final ClienteServidor cs) {
		this.cs = cs;
	}

	public void setCampIntr(boolean campIntr) {
		this.CampIntr = campIntr;
		campoIntroducir.setEditable(CampIntr);

	}
}
