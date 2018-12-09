package inputfield;

import javafx.scene.Node;import javafx.scene.control.Label;import javafx.scene.layout.GridPane;

public class IntInputField extends GridPane implements OptionAddable {
	
	private int elementPos;
	private Label label;
	private IntField intInput;
	
	public IntInputField(String labelText, int minValue, int maxValue, int initialValue) {
		setHgap(1);
		setHgap(5);
		
		label = new Label(labelText);
		intInput = new IntField(minValue, maxValue, initialValue);
		
		add(label, 0, 0);
		add(intInput, 0, 1);

	}
	
	@Override
	public void addOption(Node option) {
		add(option, elementPos, 1);
		elementPos++;
	}

	public IntField getIntInput() {
		return intInput;
	}
	
}