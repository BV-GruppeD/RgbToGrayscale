package com.bv_gruppe_d.gui;

import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.bv_gruppe_d.calculations.Noise;

import ij.gui.GenericDialog;
import ij.process.ImageProcessor;

public class MainDialog extends UserDialog {
	
	private ImageProcessor ip;
	
	public MainDialog(ImageProcessor ip) {

		dialog = new GenericDialog("Bildverarbeitung Projekt 03");
		
		Panel topLevelPanel = getMainDialogPanel();
		dialog.add(topLevelPanel);
	}

	private Panel getMainDialogPanel() {
		Panel topLevelPanel = new Panel();
		topLevelPanel.setLayout(new GridLayout(3,1));		
		
		topLevelPanel.add(getConversionPanel());
		topLevelPanel.add(getStatisticsPanel());
		topLevelPanel.add(getNoicePanel());
		
		return topLevelPanel;
	}

	private Panel getConversionPanel() {
		Panel conversionPanel = new Panel();
		conversionPanel.setLayout(new GridLayout(2,1));
		
		conversionPanel.add(getConversionHeader());
		conversionPanel.add(getConversionButtons());
		
		return conversionPanel;
	}

	private Label getConversionHeader() {
		Label conversionHeader = new Label("Zu Grauwertbild konvertieren:");
		conversionHeader.setAlignment(Label.CENTER);
		return conversionHeader;
	}
	
	private Panel getConversionButtons() {
		Panel conversionButtons = new Panel();
		conversionButtons.add(getIntencityBasedConversionButton());
		conversionButtons.add(getCommonTransformationButton());
		return conversionButtons;
	}

	private JButton getIntencityBasedConversionButton() {
		JButton intencityBasedTransformation = new JButton("Intensitätsbasierte Konvertierung");
		intencityBasedTransformation.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Add IntencityBasedTransformation
				
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
	
	
	private Panel getStatisticsPanel() {
		Panel statisticsPanel = new Panel();
		statisticsPanel.setLayout(new GridLayout(2,1));
		
		statisticsPanel.add(getStatisticsHeader());
		statisticsPanel.add(getStatisticsCalculationButton());
		
		return statisticsPanel;
	}

	private Label getStatisticsHeader() {
		Label statisticsHeader = new Label("Statistik generieren:");
		statisticsHeader.setAlignment(Label.CENTER);
		return statisticsHeader;
	}
	
	private JButton getStatisticsCalculationButton() {
		JButton histogramCalculation = new JButton("Berechne Histogramm");
		histogramCalculation.addActionListener(e -> new StatisticsDialog(ip).show(););
		return histogramCalculation;
	}
	

	private Panel getNoicePanel() {
		Panel noicePanel = new Panel();
		noicePanel.setLayout(new GridLayout(2, 1));
		
		noicePanel.add(getNoiceHeader());
		noicePanel.add(getNoiceButtons());
		
		return noicePanel;
	}	

	private Label getNoiceHeader() {
		Label noiceHeader = new Label("Rauschen hinzufügen:");
		noiceHeader.setAlignment(Label.CENTER);
		return noiceHeader;
	}

	private Panel getNoiceButtons() {
		Panel noiceButtons = new Panel();
		noiceButtons.add(getGausschenNoiseButton());
		noiceButtons.add(getSaltAndPepperNoiceButton());
		return noiceButtons;
	}

	private JButton getGausschenNoiseButton() {
		JButton gausschenNoiceButton = new JButton("Gaussches Rauschen");
		gausschenNoiceButton.addActionListener(e -> Noise.addGausschenNoise(ip, 1));
		return gausschenNoiceButton;
	}

	private JButton getSaltAndPepperNoiceButton() {
		JButton saltAndPepperNoiceButton = new JButton("Salt-And-Pepper Rauschen");
		saltAndPepperNoiceButton.addActionListener(e -> Noise.addSaltAndPepperNoise(ip, 1));
		return saltAndPepperNoiceButton;
	}
}