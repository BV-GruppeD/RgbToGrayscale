package com.bv_gruppe_d.gui;

import java.awt.Dialog.ModalityType;

import ij.gui.GenericDialog;

public abstract class UserDialog {
	GenericDialog dialog;
	
	public void show() {
		dialog.setModalityType(ModalityType.MODELESS);
		dialog.showDialog();
	}
}
