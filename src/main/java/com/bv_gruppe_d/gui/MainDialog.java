package com.bv_gruppe_d.gui;

import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;

import javax.swing.JButton;

import ij.gui.GenericDialog;

public class MainDialog extends UserDialog {
	
	public MainDialog() {

		dialog = new GenericDialog("Bildverarbeitung Projekt 03");
		
		Panel topLevelPanel = createMainDialogPanel();
		dialog.add(topLevelPanel);
	}

	private Panel createMainDialogPanel() {
		Panel topLevelPanel = new Panel();
		topLevelPanel.setLayout(new GridLayout(3,1));		
		
		topLevelPanel.add(createConversionPanel());
		topLevelPanel.add(createStatisticsPanel());
		topLevelPanel.add(createNoicePanel());
		
		return topLevelPanel;
	}

	private Panel createNoicePanel() {
		Panel noicePanel = new Panel();
		noicePanel.setLayout(new GridLayout(2, 1));
		
		Label noiceHeader = new Label("Rauschen hinzufügen:");
		noiceHeader.setAlignment(Label.CENTER);
		noicePanel.add(noiceHeader);
		
		Panel noiceButtons = new Panel();	
		JButton saltAndPepperNoiceButton = new JButton("Salt-And-Pepper Rauschen");
		JButton gausschenNoiceButton = new JButton("Gaussches Rauschen");
		noiceButtons.add(gausschenNoiceButton);
		noiceButtons.add(saltAndPepperNoiceButton);
		
		noicePanel.add(noiceButtons);
		return noicePanel;
	}

	private Panel createStatisticsPanel() {
		Panel statisticsPanel = new Panel();
		statisticsPanel.setLayout(new GridLayout(2,1));
		
		Label statisticsHeader = new Label("Statistik generieren:");
		statisticsHeader.setAlignment(Label.CENTER);
		statisticsPanel.add(statisticsHeader);
		
		JButton histogramCalculation = new JButton("Berechne Histogramm");
		
		statisticsPanel.add(histogramCalculation);
		return statisticsPanel;
	}

	private Panel createConversionPanel() {
		Panel conversionPanel = new Panel();
		conversionPanel.setLayout(new GridLayout(2,1));
		
		Label conversionHeader = new Label("Zu Grauwertbild konvertieren:");
		conversionHeader.setAlignment(Label.CENTER);
		conversionPanel.add(conversionHeader);
		
		Panel conversionButtons = new Panel();		
		JButton intencityBasedTransformation = new JButton("Intensitätsbasierte Konvertierung");
		JButton commonTransformation = new JButton("Übliche Konvertierung");
		conversionButtons.add(intencityBasedTransformation);
		conversionButtons.add(commonTransformation);
		
		conversionPanel.add(conversionButtons);
		return conversionPanel;
	}
}
