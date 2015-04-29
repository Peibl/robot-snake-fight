package vista;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.*;

public class FramePrincipal extends JFrame{
	 private Container c;
	 private JPanel pp;

	public FramePrincipal(){
		super("Vivorita");
		c= this.getContentPane();
	    c.setLayout(new BorderLayout());
		this.setBounds(10, 10, 500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.AddPanel(new PanelMenu(this));

		this.setVisible(true);

	}
	public JPanel getPp() {
		return pp;
	}
	public void setPp(JPanel pp) {
		c.remove(this.pp);
		this.pp = pp;
		this.AddPanel(pp);
	}
	private void AddPanel(JPanel pp){

		this.pp=pp;
		c.add(pp,BorderLayout.CENTER);
		this.setContentPane(c);

	}
}
