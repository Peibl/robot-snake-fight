package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import domain.Direction;

public class SnakeEvent implements KeyListener, ActionListener {
	private Vivorita snake;
	private MatrizControl matCont;

	public SnakeEvent(Vivorita snake) {
		this.snake = snake;
		matCont = new MatrizControl(snake);
	}

	@Override
	public void keyPressed(KeyEvent e) {

		switch (e.getKeyCode()) {
		case KeyEvent.VK_DOWN:
			if (currentDirectionIsNotUp()) {
				snake.setDirecc(Direction.DOWN);
			}

			break;
		case KeyEvent.VK_UP:
			if (currentDirectionIsNotDown()) {
				snake.setDirecc(Direction.UP);
			}

			break;
		case KeyEvent.VK_LEFT:

			if (currentDirectionIsNotRight()) {
				snake.setDirecc(Direction.LEFT);
			}
			break;
		case KeyEvent.VK_RIGHT:

			if (currentDirectionIsNotLeft()) {
				snake.setDirecc(Direction.RIGHT);
			}

			break;

		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (snake.getDirecc()) {
		case DOWN:
			snake.setY(snake.getY() + snake.getSize());
			break;
		case UP:
			snake.setY(snake.getY() - snake.getSize());
			break;

		case LEFT:
			snake.setX(snake.getX() - snake.getSize());
			break;

		case RIGHT:
			snake.setX(snake.getX() + snake.getSize());
			break;

		}

	}

	public boolean Controlar() {
		return matCont.Controlar(snake);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	private boolean currentDirectionIsNotLeft() {
		return !(snake.getDirecc().equals(Direction.LEFT));
	}

	private boolean currentDirectionIsNotRight() {
		return !(snake.getDirecc().equals(Direction.RIGHT));
	}

	private boolean currentDirectionIsNotDown() {
		return !(snake.getDirecc().equals(Direction.DOWN));
	}

	private boolean currentDirectionIsNotUp() {
		return !(snake.getDirecc().equals(Direction.UP));
	}
}
