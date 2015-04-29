package vista;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controladorSocket.ControlCliente;
import controladorSocket.ControlServidor;

public class PanelMenu extends JPanel implements ActionListener {

	private JButton jbCrearP = new JButton("Create Match");
	private JButton jbUnirseP = new JButton("Join match");
	private JButton jbConfig = new JButton("Settings");
	private JButton jbSalir = new JButton("Exit");
	private JLabel jlBug = new JLabel("1");
	private JLabel jlBug2 = new JLabel("2");
	private JLabel jlBug3 = new JLabel("3");
	private JLabel jlBug4 = new JLabel("4");
	private JLabel jlSRSF = new JLabel("Super Robot Snake Fight!");
	private FramePrincipal fm;

	public PanelMenu(FramePrincipal fm) {
		this.fm = fm;

		this.setBounds(0, 0, 500, 150);
		this.setLayout(new GridLayout(3, 3));

		jbCrearP.addActionListener(this);
		jbUnirseP.addActionListener(this);
		jbConfig.addActionListener(this);
		jbSalir.addActionListener(this);

		this.add(jbCrearP);
		this.add(jlBug);
		this.add(jbUnirseP);
		this.add(jlBug2);
		this.add(jlSRSF);
		this.add(jlBug3);
		this.add(jbConfig);
		this.add(jlBug4);
		this.add(jbSalir);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jbConfig) {

		}

		if (e.getSource() == jbSalir) {
			System.exit(0);
		}

		if (e.getSource() == jbCrearP) {
			System.out.println("Crea Partida");
			new ControlServidor(fm);

		}
		if (e.getSource() == jbUnirseP) {
			System.out.println("Crea Partida");
			new ControlCliente(fm);

		}

	}

}
