package com.bv_gruppe_d.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.bv_gruppe_d.calculations.Histogram;

import ij.measure.ResultsTable;
import ij.process.ImageProcessor;

class CalculateStatisticsListener implements ActionListener{

	ImageProcessor imageProcessor;
	
	public CalculateStatisticsListener(ImageProcessor ip) {
		imageProcessor = ip;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Histogram histogram = Histogram.calculate(imageProcessor);
		
		ResultsTable table = ResultsTable.getResultsTable();
		table.incrementCounter();
		table.addValue("Minimum", histogram.getMin());
		table.addValue("Maximum", (double)histogram.getMax());
		table.addValue("Modus", (double)histogram.getMode());
		table.addValue("Mittelwert", (double)histogram.getMoment(1));
		table.addValue("Varianz", (double)histogram.getMoment(2));
		table.addValue("Schiefe", (double)histogram.getMoment(3));
		table.addValue("Wölbung", (double)histogram.getMoment(4));
		table.addValue("Entropie", (double)histogram.getEntropy());
		table.show("Results");
	}	
}