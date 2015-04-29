package vista;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

import domain.Direction;

public class Vista extends JFrame implements ActionListener {

	private Container container;
	private SnakePanel snakePanel = new SnakePanel();
	private Snake snake;
	private SnakeEvent snakeEvents;
	private Timer timer;

	public Vista() {

		super("Prueba grafica");

		this.setBounds(0, 0, 810, 610);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		container = this.getContentPane();
		container.setLayout(null);
		snakePanel.setBounds(0, 0, 810, 610);
		container.add(snakePanel);

		this.setContentPane(container);
		this.setVisible(true);

		snake = new Snake(10, 10, Direction.RIGHT);
		snakeEvents = new SnakeEvent(snake);
		this.addKeyListener(snakeEvents);
		timer = new Timer(50, this);
		timer.start();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		snakeEvents.actionPerformed(e);
		if (snakeEvents.Controlar()) {
			snakePanel.seterSnake(snake);
			snakePanel.repaint();
		} else {
			snakePanel.lost();
			timer.stop();
		}
	}

}
