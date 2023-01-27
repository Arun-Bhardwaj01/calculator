package com.arun.bhardwaj;

import javax.swing.SwingUtilities;

import com.arun.bhardwaj.ui.CalculatorUI;

public class Main {
	
	public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Main();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
	
	private Main() {
		new CalculatorUI();
	}
}