package com.bv_gruppe_d.gui;

import ij.gui.GenericDialog;

public abstract class UserDialog {
	GenericDialog dialog;
	
	public void show() {
		dialog.showDialog();
	}
}
