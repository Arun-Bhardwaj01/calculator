package com.arun.bhardwaj.controller;

import java.awt.event.ActionEvent;

import javax.swing.JButton;

import com.arun.bhardwaj.ui.CalculatorUI;

/**
 * 
 * @author Arun Bhardwaj
 * This class is used to define all the logic on click event for calculator application.
 */
public class CalculatorController {

	private CalculatorUI view;

	private MathOperation operation;

	private double a, b;
	private boolean isControlBtnClick;
	private boolean isFirstValue, isSecondValue = false;

	public CalculatorController(CalculatorUI view) {

		this.view = view;

		view.getNumberButtons().forEach(button -> {
			button.addActionListener((ActionEvent e) -> {
				
				if(".".equals(button.getText())) {
					addSingleDot();
				}else {
					String value = view.getInputAndResultField().getText().equals("0") || isControlBtnClick
							? "" + button.getText()
							: view.getInputAndResultField().getText() + button.getText();
					view.getInputAndResultField().setText(value);
					isControlBtnClick = false;
				}
				
			});
		});
		
		view.getControlButtons().forEach(button -> {
			button.addActionListener((ActionEvent e) -> {
				executeAction(button);
				isControlBtnClick = true;
				
			});
		});

	}

	
	/**
	 * This method is used to execute operations on the basis of button click.
	 * @param button
	 */
	private void executeAction(JButton button) {

		if ("+".equals(button.getText()) 
				|| "-".equals(button.getText()) 
				|| "*".equals(button.getText()) 
				|| "/".equals(button.getText())
				|| "=".equals(button.getText())) {
			initializeValue();
		}	
		
		if ("AC".equals(button.getText())) {
			this.view.getInputAndResultField().setText("0");
			resetInitialization();
		} else if ("+".equals(button.getText())) {
			operation = (a, b) -> a + b;
		} else if ("-".equals(button.getText())) {
			operation = (a, b) -> a - b;
		} else if ("*".equals(button.getText())) {
			operation = (a, b) -> a * b;
		} else if ("/".equals(button.getText())) {
			operation = (a, b) -> a / b;
		} else if ("=".equals(button.getText())) {
			calculate(operation);
		}else if ("+/-".equals(button.getText())) {
			makeValueNagitive();
		}else if (".".equals(button.getText())) {
			addSingleDot();
		}else if ("%".equals(button.getText())) {
			calculatePercentage();
		}
		
	}

	/**
	 * This method is used to initialize the value to the variable for operation. 
	 */
	private void initializeValue() {

		if (!isFirstValue) {
			a = Double.parseDouble(view.getInputAndResultField().getText());
			isFirstValue = true;
		} else {
			
			if(!isSecondValue) {
				b = Double.parseDouble(view.getInputAndResultField().getText());
				isSecondValue = true;
			}
			
		}
	}

	/**
	 * This method is used to operate and set the result. 
	 * @param mathOperation
	 */
	private void calculate(MathOperation mathOperation) {
		
		if(isFirstValue && isSecondValue) {
			view.getInputAndResultField().setText(transformString(String.valueOf(operate(a, b, mathOperation))));
			a = operate(a, b, mathOperation);
		}
	}

	/**
	 * This method is used to operate the calculation operations on defined variables.
	 * @param a
	 * @param b
	 * @param mathOperation
	 * @return the operation result.
	 */
	private double operate(double a, double b, MathOperation mathOperation) {
		return mathOperation.operation(a, b);
	}

	private String transformString(String value) {

		if (value.split("\\.").length > 1) {
			 if("0".equals(value.split("\\.")[1])? true : false) {
				 return value.split("\\.")[0]; 
			 }else {
				 return value;
			 }
		}

		return value;
	}
	
	/**
	 * This method is used to reset the values.
	 */
	private void resetInitialization() {
		isFirstValue = false;
		isSecondValue = false;
	}
	
	
	/**
	 * This method is used to make the value negative If value is positive and vise-versa.
	 */
	private void makeValueNagitive() {
		
		String value = view.getInputAndResultField().getText();
		
		if(!"0".equals(value)) {
			if(value.contains("-")) {
				value = value.substring(1);
			}else {
				value ="-"+value;
			}
			view.getInputAndResultField().setText(value);
		}
	}
	
	/**
	 * This method is used to add decimal to the number.
	 */
	private void addSingleDot() {
		
		String value = view.getInputAndResultField().getText();
		
		if(!value.contains(".")) {
			value = value+".";
			view.getInputAndResultField().setText(value);
		}
		
	}
	
	/**
	 * This method is used to calculate the percentage.
	 */
	private void calculatePercentage() {
		Double result = Double.parseDouble(view.getInputAndResultField().getText());
		float percentage = result.floatValue()/100;
		view.getInputAndResultField().setText(Float.toString(percentage));
		initializeValue();
	}
}
