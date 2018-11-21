package com.bv_gruppe_d.imagej;

import com.bv_gruppe_d.gui.TransformationDialog;

import ij.ImagePlus;
import ij.plugin.filter.PlugInFilter;
import ij.process.ImageProcessor;

public class RgbToGrayscale_PlugIn implements PlugInFilter {
	
	ImageProcessor imageProcessor;
	
	@Override
	public void run(ImageProcessor ip) {
		imageProcessor = ip;
		
		new TransformationDialog(this).show();
	}

	@Override
	public int setup(String arg0, ImagePlus img) {
		return DOES_RGB;
	}
	
	public ImageProcessor getImageProcessor() {
		return imageProcessor;
	}
	
	public void setImageProcessor(ImageProcessor ip) {
		this.imageProcessor = ip;
	}
}