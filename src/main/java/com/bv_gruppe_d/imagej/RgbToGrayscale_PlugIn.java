package com.bv_gruppe_d.imagej;

import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.bv_gruppe_d.gui.MainDialog;

import ij.ImagePlus;
import ij.gui.GenericDialog;
import ij.plugin.filter.PlugInFilter;
import ij.process.ImageProcessor;

public class RgbToGrayscale_PlugIn implements PlugInFilter {
	
	@Override
	public void run(ImageProcessor ip) {
		MainDialog dialog = new MainDialog(ip);
	}

	@Override
	public int setup(String arg0, ImagePlus img) {
		return DOES_8G;
	}
}