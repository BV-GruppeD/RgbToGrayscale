package com.bv_gruppe_d.gui;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.BorderLayout;
import java.awt.Dialog.ModalityType;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import com.bv_gruppe_d.calculations.Noise;

import darrylbu.icon.StretchIcon;
import ij.ImagePlus;
import ij.gui.GenericDialog;
import ij.process.ImageProcessor;

public class MainDialog extends UserDialog {
	
	private ImageProcessor imageProcessor;
	private JFrame dialog;
	
	
	public MainDialog(ImageProcessor ip) {
		dialog = new JFrame("Bildverarbeitung Projekt 03");
		dialog.setLayout(new GridLayout(1, 0));
				
		Image i = getImage(ip).getImage();//.getScaledInstance(640, 640, Image.SCALE_SMOOTH);
		dialog.add(new JLabel(new StretchIcon(i)));
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
		topLevelJPanel.setLayout(new GridLayout(3,1));		
		
		topLevelJPanel.add(getConversionJPanel());
		topLevelJPanel.add(getStatisticsJPanel());
		topLevelJPanel.add(getNoiceJPanel());
		
		return topLevelJPanel;
	}

	private JPanel getConversionJPanel() {
		JPanel conversionJPanel = new JPanel();
		conversionJPanel.setLayout(new GridLayout(2,1));
		
		conversionJPanel.add(getConversionHeader());
		conversionJPanel.add(getConversionButtons());
		
		return conversionJPanel;
	}

	private JLabel getConversionHeader() {
		JLabel conversionHeader = new JLabel("Zu Grauwertbild konvertieren:");
		conversionHeader.setHorizontalAlignment(JLabel.CENTER);
		return conversionHeader;
	}
	
	private JPanel getConversionButtons() {
		JPanel conversionButtons = new JPanel();
		conversionButtons.add(getIntencityBasedConversionButton());
		conversionButtons.add(getCommonTransformationButton());
		return conversionButtons;
	}

	private JButton getIntencityBasedConversionButton() {
		JButton intencityBasedTransformation = new JButton("Intensitätsbasierte Konvertierung");
		intencityBasedTransformation.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Add IncentiveTransformation
			}
		});
		return intencityBasedTransformation;
	}
	
	private JButton getCommonTransformationButton() {
		JButton commonTransformation = new JButton("Übliche Konvertierung");
		commonTransformation.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Add CommonTransformation
				
			}
		});
		return commonTransformation;
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
		JPanel noiceButtons = new JPanel(new GridLayout(1, 0));
		noiceButtons.add(getGausschenNoiseButton());
		noiceButtons.add(getSaltAndPepperNoiceButton());
		return noiceButtons;
	}

	private JButton getGausschenNoiseButton() {
		JButton gausschenNoiceButton = new JButton("Gaussches Rauschen");
		gausschenNoiceButton.addActionListener(e -> {Noise.addGausschenNoise(imageProcessor, 25); dialog.repaint();});
		return gausschenNoiceButton;
	}

	private JButton getSaltAndPepperNoiceButton() {
		JButton saltAndPepperNoiceButton = new JButton("Salt-And-Pepper Rauschen");
		saltAndPepperNoiceButton.addActionListener(e -> {Noise.addSaltAndPepperNoise(imageProcessor, 1); dialog.repaint();});
		return saltAndPepperNoiceButton;
	}
	
	public void show() {
		dialog.pack();
		dialog.setVisible(true);
	}
}