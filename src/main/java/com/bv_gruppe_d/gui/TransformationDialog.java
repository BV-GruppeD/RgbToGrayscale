package com.bv_gruppe_d.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.bv_gruppe_d.imagej.RgbToGrayscale_PlugIn;
import com.bv_gruppe_d.imagej.TransformImage.IntensityBased;
import com.bv_gruppe_d.imagej.TransformImage.StateOfTheArt;
import com.bv_gruppe_d.imagej.TransformImage.TransformInterface;

import ij.gui.GenericDialog;
import ij.process.ImageProcessor;

public class TransformationDialog extends UserDialog{
	
	RgbToGrayscale_PlugIn plugin;
	
	public TransformationDialog(RgbToGrayscale_PlugIn plugin) {
		this.plugin = plugin;
		dialog = new GenericDialog("Wähle eine Transformationsmethode zur Konvertierung in ein Grauwertbild");
		dialog.setLayout(new FlowLayout(FlowLayout.CENTER));
		dialog.add(getConversionButtons());
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
				TransformInterface intensityBased = new IntensityBased();
				
				ImageProcessor ip = plugin.getImageProcessor();
				jumpToMainDialog(intensityBased.transform(ip));
			}
		});
		return intencityBasedTransformation;
	}
	
	private JButton getCommonTransformationButton() {
		JButton commonTransformation = new JButton("Übliche Konvertierung");
		commonTransformation.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				TransformInterface stateOfTheArt = new StateOfTheArt();
				
				ImageProcessor ip = plugin.getImageProcessor();
				jumpToMainDialog(stateOfTheArt.transform(ip));
			}
		});
		return commonTransformation;
	}
	
	private void jumpToMainDialog(ImageProcessor ip) {
		new MainDialog(ip).show();
		dialog.dispose();
	}
}
