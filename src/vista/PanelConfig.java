package vista;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import socket.DatosClienteServidor;
import controladorSocket.Controlador;

@SuppressWarnings("serial")
public class PanelConfig extends JPanel implements ActionListener {
	JLabel jlIP = new JLabel("Puerto:");
	JLabel jlPuerto = new JLabel("IP:");
	JLabel jlNick = new JLabel("Nick:");
	JLabel jlBug = new JLabel();

	protected JTextField tfPuerto = new JTextField();
	protected JTextField tfIP = new JTextField();
	protected JTextField tfNick = new JTextField();
	protected JButton jbConectar = new JButton("");
	DatosClienteServidor dc;
	Controlador contr;

	public PanelConfig(Controlador contr) {
		this.setSize(300, 200);

		this.setLayout(new GridLayout(9, 1, 0, 20));
		jbConectar.addActionListener(this);

		this.contr = contr;
		this.add(jlNick);
		this.add(tfNick);
		this.add(jlIP);
		this.add(tfPuerto);
		this.add(jlPuerto);

		this.add(tfIP);
		this.add(jlBug);
		this.add(jbConectar);

		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == jbConectar) {
			EventosConfig ef = new EventosConfig(this);
			if (ef.valido() == false)
				JOptionPane.showMessageDialog(null,
						"Ingrese los datos correctamente.", "ERROR",
						JOptionPane.ERROR_MESSAGE);
			else {
				dc = new DatosClienteServidor();
				dc.setNick(tfNick.getText());
				dc.setIp(tfIP.getText());
				dc.setPuerto(Integer.parseInt(tfPuerto.getText()));
				jbConectar.setText("Play!!");
				jbConectar.addActionListener(new EjecutaJuego(this, contr));
				// jbConectar.setEnabled(false);
				contr.CrearSocket();

			}

		}
	}

	public void setTextoJbConectar(String jbConectar) {
		this.jbConectar.setText(jbConectar);
	}

	public DatosClienteServidor getDc() {
		return dc;
	}

}
