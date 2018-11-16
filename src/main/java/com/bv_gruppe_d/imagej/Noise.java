package com.bv_gruppe_d.imagej;

import java.util.Random;

import ij.plugin.filter.SaltAndPepper;
import ij.process.ImageProcessor;

public class Noise {
	
	public void addGausschenNoise(ImageProcessor ip, double s) {
		int w = ip.getWidth();
		int h = ip.getHeight();
		Random rnd = new Random();
		for (int v = 0; v < h; v++) {
			for (int u = 0; u < w; u++) {
				float val = ip.getf(u, v);
				float noise = (float) (rnd.nextGaussian() * s);
				ip.setf(u, v, val + noise);
			}
		}
	}
	
	public void addSaltAndPepperNoise(ImageProcessor ip, double percent) {
		SaltAndPepper filter = new SaltAndPepper();
		filter.add(ip, percent);
	}
}
