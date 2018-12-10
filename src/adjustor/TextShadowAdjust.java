package adjustor;

import inputfield.ColorInputField;import inputfield.SliderInputField;import javafx.beans.value.ChangeListener;import javafx.beans.value.ObservableValue;import javafx.scene.control.CheckBox;

public class TextShadowAdjust extends Adjustor {
	
	private CheckBox applyCheckBox;
	private SliderInputField blurRadius;
	private SliderInputField shadowXOffest;
	private SliderInputField shadowYOffest;
	private ColorInputField shadowColor;

	public TextShadowAdjust(NewButton button) {
		super("TEXT SHADOW");
		
		applyCheckBox = new CheckBox("");
		blurRadius = new SliderInputField("Blur Radius", (int)button.getTextShadow().getRadius(), 0, 10);
		shadowXOffest = new SliderInputField("X Offset", (int)button.getTextShadow().getOffsetX(), -5, 5);
		shadowYOffest = new SliderInputField("Y Offset", (int)button.getTextShadow().getOffsetY(), -5, 5);
		shadowColor = new ColorInputField("Shadow Color", button.getTextShadow().getColor());
		
		if (button.isSlectedTextShadow()) {
			button.getTextLabel().setEffect(button.getTextShadow());
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
		button.getTextShadow().radiusProperty().bind(blurRadius.getSlider().valueProperty());
		button.getTextShadow().offsetXProperty().bind(shadowXOffest.getSlider().valueProperty());
		button.getTextShadow().offsetYProperty().bind(shadowYOffest.getSlider().valueProperty());
		button.getTextShadow().colorProperty().bind(shadowColor.getColorPicker().valueProperty());
		
		applyCheckBox.selectedProperty().addListener(new ChangeListener<Boolean>() {
	           public void changed(ObservableValue<? extends Boolean> observable, Boolean oldVal, Boolean newVal) {
	        	   try {
	        		   if (oldVal == true && newVal == false) {
	  	            	 setAdjustorDisable(true);
	  	            	 button.setSlectedTextShadow(false);
	  	            	 button.getTextLabel().setEffect(null);
	  	            	
	  	             } else {
	  	         	     setAdjustorDisable(false);
	  	         	     button.setSlectedTextShadow(true);
	  	            	 button.getTextLabel().setEffect(button.getTextShadow());
	  	             }
	        	   } catch (NullPointerException e) {
	        		   if (oldVal == true) {
	        			   setAdjustorDisable(false);
	        			   button.setSlectedTextShadow(true);
	        			   button.getTextLabel().setEffect(button.getTextShadow());
	        		   } else {
	        			   setAdjustorDisable(true);
		  	               button.setSlectedTextShadow(false);
		  	               button.getTextLabel().setEffect(null);
	        		   }
	        	   }
	          }
	    });
		
	}

}
