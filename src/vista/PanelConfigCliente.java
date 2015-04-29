package vista;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controladorSocket.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import socket.*;

public class PanelConfigCliente extends PanelConfig  {


	private ControlCliente mc;


	public PanelConfigCliente(ControlCliente cc){
		super(cc);
		this.setTextoJbConectar("Conectar");
		this.setVisible(true);


	}


	public DatosClienteServidor getDc() {
		return dc;
	}
}