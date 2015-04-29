package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controladorSocket.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import socket.*;

public class PanelConfigServidor extends PanelConfig  {

	public PanelConfigServidor(ControlServidor cs ){
		super(cs);
		this.setTextoJbConectar("Crear");
		tfIP.setText(this.getIP());
		tfIP.setEnabled(false);
		this.setVisible(true);


	}


	public String getIP(){
		try{
			return (InetAddress.getLocalHost().getHostAddress());
		}catch(IOException se){
			return ("No funca.");
		}
	}
}