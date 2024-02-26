package zemlianyi.mykyta.calculator;

import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.text.NumberFormat;
import java.awt.GridLayout;
import java.awt.BorderLayout;

public class Calculator {

	JPanel windowContent;
	JFormattedTextField displayField;
	JButton button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, buttonPoint,
			buttonEual, buttonPlus, buttonMinus, buttonDivide, buttonMultiply;
	JPanel p1, p2;

	Calculator() {
		CalculatorEngine calcEngine = new CalculatorEngine(this);
		windowContent = new JPanel();

		BorderLayout bl = new BorderLayout();
		windowContent.setLayout(bl);

		NumberFormat numberFormat = NumberFormat.getNumberInstance();
		NumberFormatter formatter = new NumberFormatter(numberFormat);

		formatter.setValueClass(Double.class);
		displayField = new JFormattedTextField(formatter);
		displayField.setHorizontalAlignment(SwingConstants.RIGHT);
		displayField.setColumns(10);
		windowContent.add("North", displayField);

		p1 = new JPanel();
		GridLayout gl = new GridLayout(4, 3);
		p1.setLayout(gl);

		GridLayout gl2 = new GridLayout(4, 1);
		p2 = new JPanel();
		p2.setLayout(gl2);

		JButton[] numButtons = new JButton[10];

		for (int i = 0; i < 10; i++) {
			numButtons[i] = new JButton("" + i);
			numButtons[i].addActionListener(calcEngine);
			if (i != 0) {
				p1.add(numButtons[i]);
			}

		}

		buttonPoint = new JButton(".");
		buttonEual = new JButton("=");
		buttonPlus = new JButton("+");
		buttonMinus = new JButton("-");
		buttonDivide = new JButton("/");
		buttonMultiply = new JButton("*");

		buttonPoint.addActionListener(calcEngine);
		buttonEual.addActionListener(calcEngine);
		buttonPlus.addActionListener(calcEngine);
		buttonMinus.addActionListener(calcEngine);
		buttonDivide.addActionListener(calcEngine);
		buttonMultiply.addActionListener(calcEngine);

		p1.add(numButtons[0]);
		p1.add(buttonPoint);
		p1.add(buttonEual);

		p2.add(buttonPlus);
		p2.add(buttonMinus);
		p2.add(buttonMultiply);
		p2.add(buttonDivide);

		windowContent.add("Center", p1);
		windowContent.add("East", p2);

		JFrame frame = new JFrame("Calculator");
		frame.setContentPane(windowContent);

		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {

		Calculator calc = new Calculator();

	}
}
