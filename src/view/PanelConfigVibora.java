package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PanelConfigVibora extends JPanel implements ActionListener, ChangeListener {
	private static final long serialVersionUID = -7990237998381926588L;
	private ButtonGroup bgSonido = new ButtonGroup();
	private ButtonGroup bgTeclas = new ButtonGroup();
	private JRadioButton rbSOn = new JRadioButton("On", true);
	private JRadioButton rbSOff = new JRadioButton("Off", false);
	private JRadioButton rbTeclas1 = new JRadioButton("Flechas", true);
	private JRadioButton rbTeclas2 = new JRadioButton("WASD", false);
	private JLabel jlSonido = new JLabel("Sonido");
	private JLabel jlTeclas = new JLabel("Teclas");
	private JLabel jlBug1 = new JLabel();
	private JLabel jlBug2 = new JLabel();
	private JButton jbCred = new JButton("Cr�ditos");
	private JButton jbInstru = new JButton("Instrucciones");
	private JButton jbVolver = new JButton("Volver");
	private JSlider jS = new JSlider(JSlider.HORIZONTAL, 0, 10, 5);

	public PanelConfigVibora() {

		this.setLayout(new GridLayout(4, 3, 0, 20));

		Hashtable<Integer, JLabel> labelTable = new Hashtable<Integer, JLabel>();
		labelTable.put(0, new JLabel("facil"));
		labelTable.put(5, new JLabel("moderado"));
		labelTable.put(10, new JLabel("dificil"));

		jS.addChangeListener(this);
		jS.setLabelTable(labelTable);
		jS.setPaintLabels(true);
		jS.setMajorTickSpacing(5);
		jS.setMinorTickSpacing(1);
		jS.setPaintTicks(true);

		bgSonido.add(rbSOn);
		bgSonido.add(rbSOff);

		bgTeclas.add(rbTeclas1);
		bgTeclas.add(rbTeclas2);

		jbVolver.addActionListener(this);

		this.add(jlSonido);
		this.add(rbSOn);
		this.add(rbSOff);
		this.add(jlTeclas);
		this.add(rbTeclas1);
		this.add(rbTeclas2);
		this.add(jlBug1);
		this.add(jS);
		this.add(jlBug2);
		this.add(jbInstru);
		this.add(jbCred);
		this.add(jbVolver);

		this.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jbVolver) {

		}

		if (e.getSource() == rbSOn) {

		}

		if (e.getSource() == rbSOff) {

		}

		if (e.getSource() == rbTeclas1) {

		}

		if (e.getSource() == rbTeclas2) {

		}

		if (e.getSource() == jbInstru) {

		}

		if (e.getSource() == jbCred) {

		}

	}

	@Override
	public void stateChanged(ChangeEvent e) {
		JSlider source = (JSlider) e.getSource();
		// Imprime cada vez que cambia de valor el JSlider
		if (!source.getValueIsAdjusting()) {
			int fps = source.getValue();
			System.out.println(fps);
		}

	}

}
