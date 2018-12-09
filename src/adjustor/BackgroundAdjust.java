package adjustor;

import inputfield.ColorInputField;import javafx.beans.value.ChangeListener;import javafx.beans.value.ObservableValue;import javafx.geometry.Insets;import javafx.scene.control.CheckBox;import javafx.scene.layout.Background;import javafx.scene.layout.BackgroundFill;import javafx.scene.layout.CornerRadii;import javafx.scene.layout.HBox;import javafx.scene.paint.Color;import javafx.scene.paint.CycleMethod;import javafx.scene.paint.LinearGradient;import javafx.scene.paint.Stop;

public class BackgroundAdjust extends Adjustor {
	
	private CheckBox gradientApplyCheckBox;
	private ColorInputField bgColor;
	private ColorInputField fromColor;
	private ColorInputField toColor;
	
	public BackgroundAdjust(NewButton button) {
		super("Background");
		
		gradientApplyCheckBox = new CheckBox("Apply Linear Gradient Background");
		
		bgColor = new ColorInputField("Background Color", button.getBackgroundColor());
		
		fromColor = new ColorInputField("From", button.getFromGradientColor());
		toColor = new ColorInputField("To", button.getToGradientColor());
   	 	
		final HBox gradientGroup = new HBox(20);
		gradientGroup.getChildren().addAll(fromColor, toColor);
		
		if (button.isApplyGradient()) {
			bgColor.getColorPicker().setDisable(true);
			gradientApplyCheckBox.setSelected(true);
	       	fromColor.getColorPicker().setDisable(false);
	       	toColor.getColorPicker().setDisable(false);
   	 	} else {
	   	 	bgColor.getColorPicker().setDisable(false);
			gradientApplyCheckBox.setSelected(false);
       	 	fromColor.getColorPicker().setDisable(true);
       	 	toColor.getColorPicker().setDisable(true);
   	 	}
		
		valueBinding(button);
		
		addOption(bgColor);
		addOption(gradientApplyCheckBox);
		addOption(gradientGroup);
		
	}
	
	@Override
	public void valueBinding(NewButton button) {
		
		bgColor.getColorPicker().valueProperty().addListener( new ChangeListener<Color>() {
			@Override
			public void changed(ObservableValue<? extends Color> observable, Color oldValue, Color newValue) {
				try {

					button.setBackgroundColor(newValue);
					button.setBackground(new Background(new BackgroundFill(button.getBackgroundColor()
							, new CornerRadii(button.getBorderRadius()), Insets.EMPTY)));
					button.setPrimaryBackground(button.getBackgroundColor());
					button.getButtonBorder().setBackground(new Background(new BackgroundFill(button.getPrimaryBackground()
							, new CornerRadii(button.getBorderRadius()), Insets.EMPTY)));
					
				} catch (NullPointerException e) {
					button.setBackgroundColor(oldValue);
				}
			}
	    });
		
		gradientApplyCheckBox.selectedProperty().addListener(new ChangeListener<Boolean>() {
	           public void changed(ObservableValue<? extends Boolean> observable, Boolean oldVal, Boolean newVal) {
	             if (oldVal == true && newVal == false) {
	            	 button.setPrimaryBackground(button.getBackgroundColor());
	            	 button.setBackground(new Background(new BackgroundFill(button.getPrimaryBackground()
								, new CornerRadii(button.getBorderRadius()), Insets.EMPTY)));
	            	 button.getButtonBorder().setBackground(new Background(new BackgroundFill(button.getPrimaryBackground()
								, new CornerRadii(button.getBorderRadius()), Insets.EMPTY)));
	            	 bgColor.getColorPicker().setDisable(false);
	            	 fromColor.getColorPicker().setDisable(true);
	            	 toColor.getColorPicker().setDisable(true);
	             } else {
	            	 button.setPrimaryBackground(button.getGradientBackgroundColor());
	            	 button.setBackground(new Background(new BackgroundFill(button.getPrimaryBackground()
								, new CornerRadii(button.getBorderRadius()), Insets.EMPTY)));
	            	 button.getButtonBorder().setBackground(new Background(new BackgroundFill(button.getPrimaryBackground()
								, new CornerRadii(button.getBorderRadius()), Insets.EMPTY)));
	            	 bgColor.getColorPicker().setDisable(true);
	            	 fromColor.getColorPicker().setDisable(false);
	            	 toColor.getColorPicker().setDisable(false);
	             }
	          }
	    });
		
		fromColor.getColorPicker().valueProperty().addListener( new ChangeListener<Color>() {
			@Override
			public void changed(ObservableValue<? extends Color> observable, Color oldValue, Color newValue) {
				try {

					button.setFromGradientColor(newValue);
					button.setGradientBackgroundColor(new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE
				, new Stop(0.1f, button.getFromGradientColor()), new Stop(1.0f, button.getToGradientColor())));
					button.setBackground(new Background(new BackgroundFill(button.getGradientBackgroundColor()
							, new CornerRadii(button.getBorderRadius()), Insets.EMPTY)));
					button.setPrimaryBackground(button.getGradientBackgroundColor());
					button.getButtonBorder().setBackground(new Background(new BackgroundFill(button.getPrimaryBackground()
							, new CornerRadii(button.getBorderRadius()), Insets.EMPTY)));
					
				} catch (NullPointerException e) {
					button.setFromGradientColor(oldValue);
				}
			}
	    });
		
		toColor.getColorPicker().valueProperty().addListener( new ChangeListener<Color>() {
			@Override
			public void changed(ObservableValue<? extends Color> observable, Color oldValue, Color newValue) {
				try {

					button.setToGradientColor(newValue);
					button.setGradientBackgroundColor(new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE
				, new Stop(0.1f, button.getFromGradientColor()), new Stop(1.0f, button.getToGradientColor())));
					button.setBackground(new Background(new BackgroundFill(button.getGradientBackgroundColor()
							, new CornerRadii(button.getBorderRadius()), Insets.EMPTY)));
					button.setPrimaryBackground(button.getGradientBackgroundColor());
					button.getButtonBorder().setBackground(new Background(new BackgroundFill(button.getPrimaryBackground()
							, new CornerRadii(button.getBorderRadius()), Insets.EMPTY)));
					
				} catch (NullPointerException e) {
					button.setToGradientColor(oldValue);
				}
			}
	    });
		
	}

}
