package com.bv_gruppe_d.imagej;

import com.bv_gruppe_d.gui.MainDialog;

import ij.ImagePlus;
import ij.plugin.filter.PlugInFilter;
import ij.process.ImageProcessor;

public class RgbToGrayscale_PlugIn implements PlugInFilter {
	
	@Override
	public void run(ImageProcessor ip) {
		new MainDialog(ip).show();
		
	}

	@Override
	public int setup(String arg0, ImagePlus img) {
		return DOES_8G;
	}
}