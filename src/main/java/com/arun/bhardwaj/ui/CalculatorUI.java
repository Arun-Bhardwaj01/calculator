package com.arun.bhardwaj.ui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.arun.bhardwaj.controller.CalculatorController;

/**
 * 
 * @author Arun Bhardwaj
 * This class is used to create user interface for the calculator application.
 */
public class CalculatorUI {

	private JFrame frame;
	private JPanel basePanel, controlPanel;
	private JFormattedTextField inputAndResultField;
	private List<JButton> numberButtons;
	private List<JButton> controlButtons;

	/**
	 * Intialize member variables, 
	 */
	public CalculatorUI() {

		frame = new JFrame("Calculator");

		NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.getDefault());
		DecimalFormat decimalFormat = (DecimalFormat) numberFormat;
		decimalFormat.setGroupingUsed(false);
		inputAndResultField = new JFormattedTextField(decimalFormat);
		Font bigFont = inputAndResultField.getFont().deriveFont(Font.PLAIN, 30f);
		inputAndResultField.setEditable(false);
		inputAndResultField.setFont(bigFont);
		inputAndResultField.setText("0");
		inputAndResultField.setHorizontalAlignment(JTextField.RIGHT);
		numberButtons = new ArrayList<>();
		controlButtons = new ArrayList<>();
		basePanel = new JPanel();
		controlPanel = new JPanel();
		setLayout();
		new CalculatorController(this);
	}

	/**
	 * This method is used to create layout and all the component in the container. 
	 */
	private void setLayout() {

		basePanel.setLayout(new BorderLayout());
		basePanel.add("North", inputAndResultField);

		controlPanel.setLayout(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.ipadx = 12;
		gbc.ipady = 12;
		gbc.gridx = 0;
		gbc.gridy = 0;
		controlButtons.add(new JButton("AC"));
		controlPanel.add(controlButtons.get(0), gbc);

		gbc.gridx = 1;
		gbc.gridy = 0;
		controlButtons.add(new JButton("+/-"));
		controlPanel.add(controlButtons.get(1), gbc);

		gbc.gridx = 2;
		gbc.gridy = 0;
		controlButtons.add(new JButton("%"));
		controlPanel.add(controlButtons.get(2), gbc);

		gbc.gridx = 3;
		gbc.gridy = 0;
		controlButtons.add(new JButton("/"));
		controlPanel.add(controlButtons.get(3), gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		numberButtons.add(new JButton("7"));
		controlPanel.add(numberButtons.get(0), gbc);

		gbc.gridx = 1;
		gbc.gridy = 1;
		numberButtons.add(new JButton("8"));
		controlPanel.add(numberButtons.get(1), gbc);

		gbc.gridx = 2;
		gbc.gridy = 1;
		numberButtons.add(new JButton("9"));
		controlPanel.add(numberButtons.get(2), gbc);

		gbc.gridx = 3;
		gbc.gridy = 1;
		controlButtons.add(new JButton("*"));
		controlPanel.add(controlButtons.get(4), gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		numberButtons.add(new JButton("4"));
		controlPanel.add(numberButtons.get(3), gbc);

		gbc.gridx = 1;
		gbc.gridy = 2;
		numberButtons.add(new JButton("5"));
		controlPanel.add(numberButtons.get(4), gbc);

		gbc.gridx = 2;
		gbc.gridy = 2;
		numberButtons.add(new JButton("6"));
		controlPanel.add(numberButtons.get(5), gbc);

		gbc.gridx = 3;
		gbc.gridy = 2;
		controlButtons.add(new JButton("-"));
		controlPanel.add(controlButtons.get(5), gbc);

		gbc.gridx = 0;
		gbc.gridy = 3;
		numberButtons.add(new JButton("1"));
		controlPanel.add(numberButtons.get(6), gbc);

		gbc.gridx = 1;
		gbc.gridy = 3;
		numberButtons.add(new JButton("2"));
		controlPanel.add(numberButtons.get(7), gbc);

		gbc.gridx = 2;
		gbc.gridy = 3;
		numberButtons.add(new JButton("3"));
		controlPanel.add(numberButtons.get(8), gbc);

		gbc.gridx = 3;
		gbc.gridy = 3;
		controlButtons.add(new JButton("+"));
		controlPanel.add(controlButtons.get(6), gbc);

		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 2;
		numberButtons.add(new JButton("0"));
		controlPanel.add(numberButtons.get(9), gbc);

		gbc.gridx = 2;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		numberButtons.add(new JButton("."));
		controlPanel.add(numberButtons.get(10), gbc);

		gbc.gridx = 3;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		controlButtons.add(new JButton("="));
		controlPanel.add(controlButtons.get(7), gbc);

		basePanel.add(controlPanel);
		frame.setContentPane(basePanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setSize(350, 280);
		frame.setVisible(true);
	}

	public List<JButton> getNumberButtons() {
		return numberButtons;
	}

	public List<JButton> getControlButtons() {
		return controlButtons;
	}

	public JFormattedTextField getInputAndResultField() {
		return inputAndResultField;
	}

}
