package view;

import domain.Direction;

public class Snake {
	private int x;
	private int y;
	private int size;
	private Direction direction;

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Snake(int x, int y, Direction direcc) {
		this.setX(x);
		this.setY(y);
		this.setDirection(direcc);
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

	public Direction getSnakeDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

}
