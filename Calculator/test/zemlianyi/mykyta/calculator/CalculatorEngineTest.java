package zemlianyi.mykyta.calculator;

import javax.swing.JButton;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CalculatorEngineTest {

	Calculator calculator = new Calculator();
	CalculatorEngine calculatorEngine = new CalculatorEngine(calculator);

	@Test
	public void testActionSelecterButtonPlus() {

		char result = calculatorEngine.actionSelecter(calculatorEngine.parent.buttonPlus);
		assertEquals('+', result);
	}

	@Test
	public void testActionSelecterButtonMinus() {
		char result = calculatorEngine.actionSelecter(calculatorEngine.parent.buttonMinus);
		assertEquals('-', result);
	}

	@Test
	public void testActionSelecterButtonMultiply() {
		char result = calculatorEngine.actionSelecter(calculatorEngine.parent.buttonMultiply);
		assertEquals('*', result);
	}

	@Test
	public void testActionSelecterButtonDivide() {
		char result = calculatorEngine.actionSelecter(calculatorEngine.parent.buttonDivide);
		assertEquals('/', result);
	}

	@Test
	public void testCurrentResultCalculationAddition() {
		double result = calculatorEngine.currentResultCalculation('+', 5.0);
		assertEquals(5.0, result, 0.0001);
	}

	@Test
	public void testCurrentResultCalculationSubtraction() {

		double result = calculatorEngine.currentResultCalculation('-', 3.0);
		assertEquals(-3.0, result, 0.0001);
	}

	@Test
	public void testCurrentResultCalculationDivisionByNonZero() {

		double result = calculatorEngine.currentResultCalculation('/', 2.0);
		assertEquals(0.0, result, 0.0001);
	}

	@Test
	public void testCurrentResultCalculationDivisionByZero() {

		double result = calculatorEngine.currentResultCalculation('/', 0.0);
		assertEquals(0.0, result, 0.0001);

		assertEquals("You cannot divide by 0! ", calculatorEngine.parent.displayField.getText());
	}

	@Test
	public void testCurrentResultCalculationMultiplication() {

		double result = calculatorEngine.currentResultCalculation('*', 4.0);
		assertEquals(0.0, result, 0.0001);
	}

	@Test
	public void testDisplayValueGetterWithValidInput() {

		double result = calculatorEngine.displayValueGetter();
		assertEquals(0.0, result, 0.0001);
	}

	@Test
	public void testDisplayValueGetterWithInvalidInput() {

		calculatorEngine.parent.displayField.setText("invalidInput");

		double result = calculatorEngine.displayValueGetter();
		assertEquals(0.0, result, 0.0001);
	}
	
	@Test
	public void testClickedButtonPrinterWithDecimalButton() {
        JButton decimalButton = new JButton(".");
        String dispFieldText = "123";
        calculatorEngine.clickedButtonPrinter(decimalButton, dispFieldText);

        assertFalse(calculator.displayField.getText().contains("JButton"), 
                    "displayField should not contain 'JButton'");
        
        assertEquals("123.", calculator.displayField.getText());
    }

}
