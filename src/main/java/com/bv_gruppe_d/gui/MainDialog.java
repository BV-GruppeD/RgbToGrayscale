package com.bv_gruppe_d.gui;

import java.awt.GridLayout;
import java.awt.Dialog.ModalityType;

import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.JButton;

import com.bv_gruppe_d.calculations.Noise;

import ij.ImagePlus;
import ij.gui.GenericDialog;
import ij.process.ImageProcessor;

public class MainDialog extends UserDialog {
	
	private ImageProcessor imageProcessor;
	
	
	public MainDialog(ImageProcessor ip) {

		dialog = new GenericDialog("Bildverarbeitung Projekt 03");
		dialog.setLayout(new GridLayout(0, 3));
		
		dialog.addImage(getImage(ip));
		dialog.add(getMainDialogJPanel());
	}

	private ImagePlus getImage(ImageProcessor ip) {
		ImagePlus image = new ImagePlus();
		image.setImage(ip.createImage());
		imageProcessor = image.getProcessor();
		return image;
	}

	private JPanel getMainDialogJPanel() {
		JPanel topLevelJPanel = new JPanel();
		topLevelJPanel.setLayout(new GridLayout(2,1));		
		
		topLevelJPanel.add(getStatisticsJPanel());
		topLevelJPanel.add(getNoiceJPanel());
		
		return topLevelJPanel;
	}
	
	
	private JPanel getStatisticsJPanel() {
		JPanel statisticsJPanel = new JPanel();
		statisticsJPanel.setLayout(new GridLayout(2,1));
		
		statisticsJPanel.add(getStatisticsHeader());
		statisticsJPanel.add(getStatisticsCalculationButton());
		
		return statisticsJPanel;
	}

	private JLabel getStatisticsHeader() {
		JLabel statisticsHeader = new JLabel("Statistik generieren:");
		statisticsHeader.setHorizontalAlignment(JLabel.CENTER);
		return statisticsHeader;
	}
	
	private JButton getStatisticsCalculationButton() {
		JButton histogramCalculation = new JButton("Berechne Histogramm");
		histogramCalculation.addActionListener(new CalculateStatisticsListener(imageProcessor));
		return histogramCalculation;
	}
	

	private JPanel getNoiceJPanel() {
		JPanel noiceJPanel = new JPanel();
		noiceJPanel.setLayout(new GridLayout(2, 1));
		
		noiceJPanel.add(getNoiceHeader());
		noiceJPanel.add(getNoiceButtons());
		
		return noiceJPanel;
	}	

	private JLabel getNoiceHeader() {
		JLabel noiceHeader = new JLabel("Rauschen hinzufügen:");
		noiceHeader.setHorizontalAlignment(JLabel.CENTER);
		return noiceHeader;
	}

	private JPanel getNoiceButtons() {
		JPanel noiceButtons = new JPanel();
		noiceButtons.add(getGausschenNoiseButton());
		noiceButtons.add(getSaltAndPepperNoiceButton());
		return noiceButtons;
	}

	private JButton getGausschenNoiseButton() {
		JButton gausschenNoiceButton = new JButton("Gaussches Rauschen");
		gausschenNoiceButton.addActionListener(e -> {Noise.addGausschenNoise(imageProcessor, 10); dialog.repaint();});
		return gausschenNoiceButton;
	}

	private JButton getSaltAndPepperNoiceButton() {
		JButton saltAndPepperNoiceButton = new JButton("Salt-And-Pepper Rauschen");
		saltAndPepperNoiceButton.addActionListener(e -> {Noise.addSaltAndPepperNoise(imageProcessor); dialog.repaint();});
		return saltAndPepperNoiceButton;
	}
}