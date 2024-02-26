package zemlianyi.mykyta.calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class CalculatorEngine implements ActionListener {
	Calculator parent;

	char selectedAction;
	double currentResult = 0;
	char previousAction;

	CalculatorEngine(Calculator parent) {
		this.parent = parent;
	}

	public void actionPerformed(ActionEvent e) {
		JButton clickedButton = (JButton) e.getSource();
		String dispFieldText = parent.displayField.getText();
		double displayValue = displayValueGetter();
		Object src = e.getSource();
		char selectedAction = actionSelecter(src);

		if (src == parent.buttonEual) {
			if (previousAction != ' ') {
				currentResultCalculation(previousAction, displayValue);
				parent.displayField.setText("" + currentResult);
			}
			previousAction = ' ';
		} else if (clickedButtonIsNotAction(clickedButton)) {
			clickedButtonPrinter(clickedButton, dispFieldText);
		} else {
			previousAction = selectedAction;
			if (previousAction != ' ') {
				currentResult = displayValue;
				parent.displayField.setText("");
			}
		}
	}

	public char actionSelecter(Object src) {
		if (src == parent.buttonPlus) {
			selectedAction = '+';
		} else if (src == parent.buttonMinus) {
			selectedAction = '-';
		} else if (src == parent.buttonDivide) {
			selectedAction = '/';
		} else if (src == parent.buttonMultiply) {
			selectedAction = '*';
		} else if (src == parent.buttonPoint) {
			selectedAction = '.';
		} else {
			return ' ';
		}

		return selectedAction;
	}

	public double currentResultCalculation(char selectedAction, double displayValue) {
		switch (selectedAction) {
		case '+':
			currentResult += displayValue;
			break;
		case '-':
			currentResult -= displayValue;
			break;
		case '/':
			if (displayValue != 0 || currentResult != 0) {
				currentResult /= displayValue;
			} else
				parent.displayField.setText("You cannot divide by 0! ");
			return 0;
		case '*':
			currentResult *= displayValue;
			break;
		}
		return currentResult;
	}

	public double displayValueGetter() {
		String dispFieldText = parent.displayField.getText();
		double displayValue = 0;
		if (!"".equals(dispFieldText)) {
			try {

				return Double.parseDouble(dispFieldText);

			} catch (NumberFormatException e1) {

				javax.swing.JOptionPane.showConfirmDialog(null, "Please enter a Number", "wrong input",
						javax.swing.JOptionPane.PLAIN_MESSAGE);

			}
		}

		return displayValue;
	}

	public void clickedButtonPrinter(JButton clickedButton, String dispFieldText) {
		if (clickedButtonIsNotAction(clickedButton)) {
			char buttonText = clickedButtonTextGetter(clickedButton);
			if ('.' == buttonText && dispFieldText.indexOf(".") != -1) {

			} else {
				parent.displayField.setText(dispFieldText + String.valueOf(buttonText));
			}
		}
	}

	public char clickedButtonTextGetter(JButton clickedButton) {
		return clickedButton.getText().charAt(0);
	}

	public boolean clickedButtonIsNotAction(JButton clickedButton) {
		char ch = clickedButtonTextGetter(clickedButton);
		if (ch == '+' || ch == '-' || ch == '/' || ch == '*') {
			return false;
		} else
			return true;
	}

}
