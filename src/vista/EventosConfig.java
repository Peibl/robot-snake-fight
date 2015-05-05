package vista;

import javax.swing.JPanel;

public class EventosConfig {

	private JPanel datos;
	private int test = 0;
	private boolean valido = false;

	public EventosConfig(PanelConfig datos) {
		this.datos = datos;
		if (!(datos.tfNick.getText().matches("[a-zA-Z_0-9]*")
				&& datos.tfNick.getText().length() >= 4 && datos.tfNick
				.getText().length() <= 10)) {
			valido = false;
		} else {
			if (datos.tfIP.getText() == "") {
				valido = false;
			} else {
				if (datos.tfPuerto.getText().length() == 4
						|| datos.tfPuerto.getText().length() == 5) {
					try {
						// si no se puede castear implica que no es un puerto
						// valido
						test = Integer.valueOf(datos.tfPuerto.getText());
						valido = true;
					} catch (Exception e) {

						valido = false;
					}
				}
			}

		}

	}

	public boolean valido() {
		return this.valido;

	}

}
