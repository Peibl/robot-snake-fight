package vista;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class SnakePanel extends JPanel {

	private Vivorita coor;
	private boolean B;
	private int tam = 1;
	private BufferedImage fondo, vivora;
	private Imagen i;

	public SnakePanel() {

		B = false;
		coor = new Vivorita();
		// this.addMouseMotionListener(this);
		this.setBackground(Color.BLACK);
		i = new Imagen();
		this.setVisible(true);
		// vivora= new Imagen().loadImg("images/tuvieja.jpg");
		// fondo=new Imagen().loadImg("images/fondo.jpg");
	}

	@Override
	public void paintComponent(Graphics g) {
		// g.drawImage(fondo, 0,0, null);
		if (B) {

			// g.drawImage(vivora, coor.getX(),coor.getY(), null);

			g.fillRect(coor.getX(), coor.getY(), coor.getSize(), coor.getSize());

		}
	}

	public void setearCoor(Vivorita C) {
		B = true;
		coor = C;

	}

	public void perdio() {
		// coor.setX(100);
		// coor.setY(50);
		// fondo= i.loadImg("images/1.jpg");
		this.repaint();
	}

}