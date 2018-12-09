package inputfield;

import javafx.scene.Node;import javafx.scene.control.Label;import javafx.scene.control.TextField;import javafx.scene.layout.GridPane;

public class StringInputField extends GridPane implements OptionAddable {
	
	private int elementPos;
	private Label label;
	private TextField textInput;
	
	public StringInputField(String labelText) {
		setVgap(5);
		setHgap(5);
		
		label = new Label(labelText);
		textInput = new TextField();
		
		add(label, 0, 0);
		add(textInput, 1, 0);
		
		elementPos = 2;
	}
	
	@Override
	public void addOption(Node option) {
		add(option, elementPos, 0);
		elementPos++;
	}

	public TextField getTextInput() {
		return textInput;
	}

}
