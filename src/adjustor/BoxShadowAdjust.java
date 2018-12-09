package adjustor;

import inputfield.ColorInputField;import inputfield.SliderInputField;import javafx.beans.value.ChangeListener;import javafx.beans.value.ObservableValue;import javafx.scene.control.CheckBox;

public class BoxShadowAdjust extends Adjustor {
	
	private CheckBox applyCheckBox;
	private SliderInputField blurRadius;
	private SliderInputField shadowXOffest;
	private SliderInputField shadowYOffest;
	private ColorInputField shadowColor;

	public BoxShadowAdjust(NewButton button) {
		super("BOX SHADOW");
		
		applyCheckBox = new CheckBox("");
		blurRadius = new SliderInputField("Blur Radius", (int)button.getBoxShadow().getRadius(), 0, 15);
		shadowXOffest = new SliderInputField("X Offset", (int)button.getBoxShadow().getOffsetX(), -10, 10);
		shadowYOffest = new SliderInputField("Y Offset", (int)button.getBoxShadow().getOffsetY(), -10, 10);
		shadowColor = new ColorInputField("Shadow Color", button.getBoxShadow().getColor());

		if (button.isSlectedBoxShadow()) {
			button.getButtonBorder().setEffect(button.getBoxShadow());
			setAdjustorDisable(false);
			applyCheckBox.setSelected(true);
		} else {
			setAdjustorDisable(true);
			applyCheckBox.setSelected(false);
		}
		
		getTitledPane().setGraphic(applyCheckBox);
		
		valueBinding(button);
		
		addOption(blurRadius);
		addOption(shadowXOffest);
		addOption(shadowYOffest);
		addOption(shadowColor);
		
	}

	@Override
	public void valueBinding(NewButton button) {
		
		button.getBoxShadow().radiusProperty().bind(blurRadius.getSlider().valueProperty());
		button.getBoxShadow().offsetXProperty().bind(shadowXOffest.getSlider().valueProperty());
		button.getBoxShadow().offsetYProperty().bind(shadowYOffest.getSlider().valueProperty());
		button.getBoxShadow().colorProperty().bind(shadowColor.getColorPicker().valueProperty());
		
		applyCheckBox.selectedProperty().addListener(new ChangeListener<Boolean>() {
	           public void changed(ObservableValue<? extends Boolean> observable, Boolean oldVal, Boolean newVal) {
	             if (oldVal == true && newVal == false) {
	            	 setAdjustorDisable(true);
	            	 button.setSlectedBoxShadow(false);
	            	 button.getButtonBorder().setEffect(null);
	            	
	             } else {
	            	 setAdjustorDisable(false);
	            	 setAdjustorDisable(false);
	            	 button.setSlectedBoxShadow(true);
	            	 button.getButtonBorder().setEffect(button.getBoxShadow());
	             }
	          }
	    });
		
	}

}
