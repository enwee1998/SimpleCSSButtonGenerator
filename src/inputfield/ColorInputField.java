package inputfield;

import javafx.scene.control.ColorPicker;import javafx.scene.control.Label;import javafx.scene.layout.GridPane;import javafx.scene.paint.Color;

public class ColorInputField extends GridPane {
	
	private Label label;
	private ColorPicker colorPicker;
	
	public ColorInputField(String labelText, Color initialColor) {
		
		setVgap(5); 
	    setHgap(5);
		
		label = new Label(labelText);
		colorPicker = new ColorPicker();
		colorPicker.setValue(initialColor);
		
		colorPicker.setPrefWidth(45);
		
		add(label, 0, 0);
		add(colorPicker, 1, 0);
		
	}

	public ColorPicker getColorPicker() {
		return colorPicker;
	}
	
}
