package com.bv_gruppe_d.gui;

import java.awt.Label;
import java.awt.Panel;

import ij.gui.GenericDialog;
import ij.process.ImageProcessor;

class StatisticsDialog extends UserDialog{

	public StatisticsDialog(ImageProcessor ip) {
		dialog = new GenericDialog("Statistische Informationen:");
		Panel panel = new Panel();
		panel.add(new Label("Maximum:"));
		panel.add(new Label(""+ip.getHistogramMax()));
		panel.add(new Label("Minimum:"));
		panel.add(new Label(""+ip.getHistogramMin()));	
		dialog.addPanel(panel);
	}
	
}