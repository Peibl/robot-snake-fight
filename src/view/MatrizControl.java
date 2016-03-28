package view;

public class MatrizControl {
	private int filas;
	private int columnas;
	private int mat[][];
	private Boolean estado = Boolean.TRUE;

	public MatrizControl(Snake coor) {
		this.filas = (600 / coor.getSize());
		this.columnas = (800 / coor.getSize());
		mat = new int[filas][columnas];
		this.fillMatriz();
	}

	private void fillMatriz() {
		for (int fil = 0; fil < filas; fil++) {
			for (int col = 0; col < columnas; col++) {
				mat[fil][col] = 0;
				mat[fil][0] = 1;
				mat[fil][columnas - 1] = 1;
				mat[0][col] = 1;
				mat[filas - 1][col] = 1;
			}
		}

	}

	public int getFilas() {
		return filas;
	}

	public void setFilas(int filas) {
		this.filas = filas;
	}

	public int getColumnas() {
		return columnas;
	}

	public void setColumnas(int columnas) {
		this.columnas = columnas;
	}

	public boolean Controlar(Snake coor) {
		int fil = coor.getY() / coor.getSize();
		int col = coor.getX() / coor.getSize();

		if (this.getDato(fil, col) == 0) {
			this.setDato(fil, col);

		} else {
			estado = false;
		}
		return estado;
	}

	private int getDato(int fil, int col) {
		return (mat[fil][col]);
	}

	private void setDato(int fil, int col) {
		mat[fil][col] = 1;
	}
}
