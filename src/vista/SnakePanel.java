package vista;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class SnakePanel extends JPanel {

	private Snake snake;
	private Boolean hasToPaint;

	public SnakePanel() {

		hasToPaint = false;
		snake = new Snake();
		this.setBackground(Color.BLACK);
		this.setVisible(true);
	}

	@Override
	public void paintComponent(Graphics graphic) {
		if (hasToPaint) {

			graphic.fillRect(snake.getX(), snake.getY(), snake.getSize(), snake.getSize());

		}
	}

	public void seterSnake(Snake snake) {
		hasToPaint = true;
		this.snake = snake;

	}

	public void lost() {
		this.repaint();
	}

}