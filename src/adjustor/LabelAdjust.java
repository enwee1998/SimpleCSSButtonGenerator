/* *
 * Icons by Dave Gandy
 * https://www.flaticon.com/authors/dave-gandy
 *  */

package adjustor;

import inputfield.ColorInputField;import inputfield.SliderInputField;import inputfield.StringInputField;import javafx.beans.value.ChangeListener;import javafx.beans.value.ObservableValue;import javafx.event.EventHandler;import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Toggle;import javafx.scene.control.ToggleButton;import javafx.scene.control.ToggleGroup;import javafx.scene.image.Image;import javafx.scene.image.ImageView;import javafx.scene.input.MouseEvent;import javafx.scene.layout.HBox;import javafx.scene.paint.Color;import javafx.scene.text.Font;

public class LabelAdjust extends Adjustor {

	private StringInputField buttonLabel;
	private SliderInputField fontSizeAdjust;
	private ColorInputField fontColor;
	private ToggleButton leftAlignment;
	private ToggleButton centerAlignment;
	private ToggleButton rightAlignment;
	private ToggleGroup groupAlignment;
	
	public LabelAdjust(NewButton button) {
		super("LABEL");
		
		buttonLabel = new StringInputField("Label");
		buttonLabel.getTextInput().setText(button.getTextLabel().getText());
		fontColor = new ColorInputField("Font Color", (Color) button.getTextLabel().getTextFill());
		fontSizeAdjust = new SliderInputField("Font Size", button.getFontSize(), 0, 36);
		
		groupAlignment = new ToggleGroup();
		
		leftAlignment = new ToggleButton();
		leftAlignment.setGraphic(new ImageView(new Image(ClassLoader.getSystemResource("images/left-alignment.png").toString())));
		leftAlignment.setStyle("-fx-background-radius:2 0 0 2;");
		leftAlignment.setUserData(Pos.CENTER_LEFT);
		leftAlignment.setCursor(Cursor.HAND);
		leftAlignment.setToggleGroup(groupAlignment);
		
		centerAlignment = new ToggleButton();
		centerAlignment.setGraphic(new ImageView(new Image(ClassLoader.getSystemResource("images/center-alignment.png").toString())));
		centerAlignment.setStyle("-fx-background-radius:0 0 0 0;");
		centerAlignment.setUserData(Pos.CENTER);
		centerAlignment.setCursor(Cursor.HAND);
		centerAlignment.setSelected(true);
		centerAlignment.setToggleGroup(groupAlignment);
		
		rightAlignment = new ToggleButton();
		rightAlignment.setGraphic(new ImageView(new Image(ClassLoader.getSystemResource("images/right-alignment.png").toString())));
		rightAlignment.setStyle("-fx-background-radius:0 2 2 0;");
		rightAlignment.setUserData(Pos.CENTER_RIGHT);
		rightAlignment.setCursor(Cursor.HAND);
		rightAlignment.setToggleGroup(groupAlignment);
		
		leftAlignment.addEventFilter(MouseEvent.MOUSE_RELEASED, new EventHandler<MouseEvent>() {
		      @Override
		      public void handle(MouseEvent mouseEvent) {
		        if (leftAlignment.equals(groupAlignment.getSelectedToggle())) {
		          mouseEvent.consume();
		        }
		      }
		});
		
		centerAlignment.addEventFilter(MouseEvent.MOUSE_RELEASED, new EventHandler<MouseEvent>() {
		      @Override
		      public void handle(MouseEvent mouseEvent) {
		        if (centerAlignment.equals(groupAlignment.getSelectedToggle())) {
		          mouseEvent.consume();
		        }
		      }
		});
		
		rightAlignment.addEventFilter(MouseEvent.MOUSE_RELEASED, new EventHandler<MouseEvent>() {
		      @Override
		      public void handle(MouseEvent mouseEvent) {
		        if (rightAlignment.equals(groupAlignment.getSelectedToggle())) {
		          mouseEvent.consume();
		        }
		      }
		});
		
		final HBox alignmentAdjust = new HBox();
		alignmentAdjust.getChildren().addAll(leftAlignment, centerAlignment, rightAlignment);
		
		buttonLabel.addOption(alignmentAdjust);
		
		valueBinding(button);
		
		addOption(buttonLabel);
		addOption(fontColor);
		addOption(fontSizeAdjust);
		
	}
	
	@Override
	public void valueBinding(NewButton button) {
		button.getButtonBorder().textProperty().bind(buttonLabel.getTextInput().textProperty());
		button.getTextLabel().textProperty().bind(buttonLabel.getTextInput().textProperty());
		button.getTextLabel().textFillProperty().bind(fontColor.getColorPicker().valueProperty());
		fontSizeAdjust.getSlider().valueProperty().addListener(new ChangeListener<Number>() {
			
			@Override
			public void changed(ObservableValue<? extends Number> observableValue, Number oldValue, Number newValue) {
				button.setFontSize((int)((double) newValue));
				button.getTextLabel().setFont(Font.font(button.getFontSize()));
				button.getButtonBorder().setFont(Font.font(button.getFontSize()));
			}
			
		});
		
		groupAlignment.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {

			@Override
			public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
				button.setAlignment((Pos) groupAlignment.getSelectedToggle().getUserData());
				if (groupAlignment.getSelectedToggle().getUserData() == Pos.CENTER) {
					button.setTextAlign("center");
				} else if (groupAlignment.getSelectedToggle().getUserData() == Pos.CENTER_LEFT) {
					button.setTextAlign("left");
				} else {
					button.setTextAlign("right");
				}
				
			}
			
		});
	}

}
