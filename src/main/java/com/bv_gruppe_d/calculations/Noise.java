package com.bv_gruppe_d.calculations;

import java.util.Random;

import ij.plugin.filter.SaltAndPepper;
import ij.process.ImageProcessor;

public class Noise {
	
	public static void addGausschenNoise(ImageProcessor ip, double s) {
		int w = ip.getWidth();
		int h = ip.getHeight();
		Random rnd = new Random();
		for (int v = 0; v < h; v++) {
			for (int u = 0; u < w; u++) {
				float val = ip.getf(u, v);
				float noise = (float) (rnd.nextGaussian() * s);
				ip.setf(u, v, Math.min(Math.max(0, val + noise), 255.0f));
			}
		}
	}
	
	public static void addSaltAndPepperNoise(ImageProcessor ip, double percent) {
		new SaltAndPepper().run(ip);
	}
}
