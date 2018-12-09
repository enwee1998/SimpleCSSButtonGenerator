package inputfield;

import javafx.beans.value.ChangeListener;import javafx.beans.value.ObservableValue;import javafx.geometry.Pos;import javafx.scene.control.Label;import javafx.scene.control.Slider;import javafx.scene.layout.GridPane;

public class SliderInputField extends GridPane {
	
	private Label label;
	private Slider slider;
	private IntField sliderValue;
	
	public SliderInputField(String labelName,int initialValue, int minSliderValue, int maxSliderValue) {
		setVgap(5); 
	    setHgap(5);
		
		label = new Label(labelName);
		
		slider = new Slider();
		slider.setMin(minSliderValue);
		slider.setMax(maxSliderValue);
		slider.setValue(initialValue);
		slider.setMajorTickUnit(1);
		slider.setSnapToTicks(true);
		slider.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observableValue, Number oldValue, Number newValue) {
				if (newValue == null) {
					sliderValue.setText("");
					return;
				}
				sliderValue.setText(Math.round(newValue.intValue()) + "");
			}
		});
		
		sliderValue = new IntField((int)slider.getMin(), (int)slider.getMax(), (int)slider.getValue());
		sliderValue.setPrefWidth(40);
		sliderValue.setAlignment(Pos.BASELINE_CENTER);
		sliderValue.valueProperty().bindBidirectional(slider.valueProperty());
		
		add(label, 0, 0);
		add(slider, 1, 0);
		add(sliderValue, 2, 0);
		
	}

	public Slider getSlider() {
		return slider;
	}

	
	
}
