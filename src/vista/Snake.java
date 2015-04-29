package vista;

import domain.Direction;

public class Snake {
	private int x;
	private int y;
	private int size;
	private Direction direcc;

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Snake() {
		this.setX(10);
		this.setY(10);
		this.setSize(10);
		this.setDirecc(Direction.RIGHT);
	}

	public Snake(int x, int y, Direction direcc) {
		this.setX(x);
		this.setY(y);
		this.setDirecc(direcc);
		this.setSize(10);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Direction getDirecc() {
		return direcc;
	}

	public void setDirecc(Direction direcc) {
		this.direcc = direcc;
	}

}
