package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

import domain.Direction;

public class GameView extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2093811644869322876L;
	private SnakePanel snakePanel;
	private Snake snake;
	private SnakeEvent snakeEvents;
	private Timer timer;

	public GameView() {

		super("robot-snake-fight");

		this.setBounds(0, 0, 810, 610);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = this.getContentPane();
		container.setLayout(null);

		snake = new Snake(10, 10, Direction.RIGHT);
		snakePanel = new SnakePanel(snake);
		snakePanel.setBounds(0, 0, 810, 610);

		container.add(snakePanel);
		this.setContentPane(container);
		this.setVisible(true);
		snakeEvents = new SnakeEvent(snake);
		this.addKeyListener(snakeEvents);
		timer = new Timer(50, this);
		timer.start();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		snakeEvents.actionPerformed(e);
		if (!snakeEvents.snakeCrash()) {
			timer.stop();
		} else {
			snakePanel.updateSnakeLocation(snake);
			snakePanel.repaint();
		}
	}

}
