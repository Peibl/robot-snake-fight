package vista;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import socket.ClienteServidor;

public class PanelChat extends JPanel{
	private JTextField campoIntroducir;
	private JTextArea areaPantalla;
	private ClienteServidor cs;
	private boolean CampIntr=false;

	public PanelChat(){
		this.setLayout(new BorderLayout());
		campoIntroducir = new JTextField();
	    campoIntroducir.setEditable(  CampIntr);
	    campoIntroducir.addActionListener(
	         new ActionListener() {

	            // enviar mensaje al cliente
	            public void actionPerformed( ActionEvent evento )
	            {
	               cs.enviarDatos(evento.getActionCommand());
	               campoIntroducir.setText( "" );
	            }
	         }
	      );
	      areaPantalla = new JTextArea();
	      this.add( campoIntroducir, BorderLayout.NORTH );


	      this.add( new JScrollPane( areaPantalla ),BorderLayout.CENTER );
	}
	public void setAreaPantalla(String mensajeAMostrar){
		areaPantalla.append( mensajeAMostrar );
        areaPantalla.setCaretPosition(
        areaPantalla.getText().length() );


	}
	public void setClienteServidor(final ClienteServidor cs){
		this.cs=cs;
	}
	public void setCampIntr(boolean campIntr) {
		this.CampIntr=campIntr;
		campoIntroducir.setEditable(  CampIntr);


	}
}
