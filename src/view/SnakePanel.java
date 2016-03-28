package view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class SnakePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2721705475191274007L;
	private Snake snake;

	public SnakePanel(Snake snake) {

		this.snake = snake;
		this.setBackground(Color.BLACK);
		this.setVisible(true);
	}

	@Override
	public void paintComponent(Graphics graphic) {

		graphic.setColor(Color.BLUE);
		graphic.fillRect(snake.getX(), snake.getY(), snake.getSize(), snake.getSize());

	}

	public void updateSnakeLocation(Snake snake) {
		this.snake = snake;

	}

}