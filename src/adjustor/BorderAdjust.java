package adjustor;

import inputfield.ColorInputField;import inputfield.SliderInputField;import javafx.beans.value.ChangeListener;import javafx.beans.value.ObservableValue;import javafx.geometry.Insets;import javafx.scene.layout.Background;import javafx.scene.layout.BackgroundFill;import javafx.scene.layout.Border;import javafx.scene.layout.BorderStroke;import javafx.scene.layout.BorderStrokeStyle;import javafx.scene.layout.BorderWidths;import javafx.scene.layout.CornerRadii;import javafx.scene.paint.Color;

public class BorderAdjust extends Adjustor {
	
	private SliderInputField borderWidth;
	private SliderInputField borderRadius;
	private ColorInputField borderColor;

	public BorderAdjust(NewButton button) {
		super("BORDER");
		
		borderWidth = new SliderInputField("Border Size", button.getBorderWidth(), 0,5);
		borderRadius = new SliderInputField("Border Radius", button.getBorderRadius(), 0,100);
		borderColor = new ColorInputField("Border Color", button.getBorderColor());
		
		valueBinding(button);
		
		addOption(borderWidth);
		addOption(borderRadius);
		addOption(borderColor);
		
	}

	@Override
	public void valueBinding(NewButton button) {
		
		borderWidth.getSlider().valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldVal, Number newVal) {
				try {
					final double changedVal = (double) newVal;
					button.setBorderWidth((int)changedVal);
					button.setBorderStyle("-fx-border-style: solid outside; -fx-border-width: " + button.getBorderWidth()
					+ "; -fx-border-color: " + button.getBorderColor().toString().replace("0x", "#") + "; "
					+ "-fx-border-radius: " + button.getBorderRadius() 
					+ ";");
					button.setBackground(new Background(new BackgroundFill(button.getPrimaryBackground()
							, new CornerRadii(button.getBorderRadius()), Insets.EMPTY)));
					button.setBorder(new Border(new BorderStroke(Color.TRANSPARENT, BorderStrokeStyle.NONE
							, new CornerRadii(button.getBorderRadius()), BorderWidths.EMPTY)));
					button.getButtonBorder().setStyle(button.getBorderStyle());
					button.getButtonBorder().setBackground(new Background(new BackgroundFill(button.getPrimaryBackground()
							, new CornerRadii(button.getBorderRadius()), Insets.EMPTY)));
				} catch (NullPointerException e) {
					final double changedVal = (double) oldVal;
					button.setBorderWidth((int)changedVal);
					button.setBorderWidth((int)changedVal);
				}
			}
		});
		
		borderRadius.getSlider().valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldVal, Number newVal) {
				try {
					final double changedVal = (double) newVal;
					button.setBorderRadius((int)changedVal);
					button.setBorderStyle("-fx-border-style: solid outside; -fx-border-width: " + button.getBorderWidth()
							+ "; -fx-border-color: " + button.getBorderColor().toString().replace("0x", "#") + "; "
							+ "-fx-border-radius: " + button.getBorderRadius() 
							+ ";");
					button.setBackground(new Background(new BackgroundFill(button.getPrimaryBackground()
							, new CornerRadii(button.getBorderRadius()), Insets.EMPTY)));
					button.setBorder(new Border(new BorderStroke(Color.TRANSPARENT, BorderStrokeStyle.NONE
							, new CornerRadii(button.getBorderRadius()), BorderWidths.EMPTY)));
					button.getButtonBorder().setStyle(button.getBorderStyle());
					button.getButtonBorder().setBackground(new Background(new BackgroundFill(button.getPrimaryBackground()
							, new CornerRadii(button.getBorderRadius()), Insets.EMPTY)));
					} catch (NullPointerException e) {
						final double changedVal = (double) oldVal;
						button.setBorderWidth((int)changedVal);
						button.setBorderWidth((int)changedVal);
				}
			}
		});
		
		borderColor.getColorPicker().valueProperty().addListener(new ChangeListener<Color>() {
			@Override
			public void changed(ObservableValue<? extends Color> observable, Color oldVal, Color newVal) {
				try {
					button.setBorderColor(newVal);
					button.setBorderStyle("-fx-border-style: solid outside; -fx-border-width: " + button.getBorderWidth()
					+ "; -fx-border-color: " + button.getBorderColor().toString().replace("0x", "#") + "; "
					+ "-fx-border-radius: " + button.getBorderRadius() 
					+ ";");
					button.setBackground(new Background(new BackgroundFill(button.getPrimaryBackground()
							, new CornerRadii(button.getBorderRadius()), Insets.EMPTY)));
					button.setBorder(new Border(new BorderStroke(Color.TRANSPARENT, BorderStrokeStyle.NONE
							, new CornerRadii(button.getBorderRadius()), BorderWidths.EMPTY)));
					button.getButtonBorder().setStyle(button.getBorderStyle());
					button.getButtonBorder().setBackground(new Background(new BackgroundFill(button.getPrimaryBackground()
							, new CornerRadii(button.getBorderRadius()), Insets.EMPTY)));
				} catch (NullPointerException e) {
					button.setBorderColor(oldVal);
				}
			}
		});
	}

}
