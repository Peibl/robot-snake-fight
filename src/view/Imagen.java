package view;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Imagen {
	public Imagen() {

	}

	public BufferedImage loadImg(String path) {
		BufferedImage I = null;
		try {
			I = ImageIO.read(new File(path));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return I;
	}
}
