package com.bv_gruppe_d.imagej;

import com.bv_gruppe_d.imagej.TransformImage.IntensityBased;
import com.bv_gruppe_d.imagej.TransformImage.StateOfTheArt;
import com.bv_gruppe_d.imagej.TransformImage.TransformInterface;
import ij.ImagePlus;
import ij.plugin.filter.PlugInFilter;
import ij.process.ImageProcessor;

public class RgbToGrayscale_PlugIn implements PlugInFilter {
	
	@Override
	public void run(ImageProcessor ip) {
		TransformInterface transform = new IntensityBased();

		transform.transform(ip);
	}

	@Override
	public int setup(String arg0, ImagePlus img) {
		return DOES_RGB;
	}
}