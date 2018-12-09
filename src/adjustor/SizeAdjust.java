package adjustor;

import inputfield.IntInputField;import javafx.scene.layout.HBox;

public class SizeAdjust extends Adjustor {

	private IntInputField buttonHeightAdjust;
	private IntInputField buttonWidthAdjust;
	
	public SizeAdjust(NewButton button) {
		super("SIZE");

		buttonHeightAdjust = new IntInputField("Height", 0, 200, (int)button.getHeight());
		buttonWidthAdjust = new IntInputField("Width", 0, 200, (int)button.getWidth());
		buttonHeightAdjust.getIntInput().setPrefWidth(100);
		buttonWidthAdjust.getIntInput().setPrefWidth(100);
		
		valueBinding(button);
		
		final HBox groupOption = new HBox(30);
		groupOption.getChildren().addAll(buttonHeightAdjust, buttonWidthAdjust);
		
		addOption(groupOption);
		
	}
	
	@Override
	public void valueBinding(NewButton button) {
		button.prefHeightProperty().bind(buttonHeightAdjust.getIntInput().valueProperty());
		button.prefWidthProperty().bind(buttonWidthAdjust.getIntInput().valueProperty());
		button.getButtonBorder().prefHeightProperty().bind(buttonHeightAdjust.getIntInput().valueProperty());
		button.getButtonBorder().prefWidthProperty().bind(buttonWidthAdjust.getIntInput().valueProperty());
	}
	
}
