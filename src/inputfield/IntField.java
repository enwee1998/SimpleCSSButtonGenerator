package inputfield;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class IntField extends TextField {
	
	private IntegerProperty value;
	private int minValue;
	private int maxValue;
	
	public IntField(int minValue, int maxValue, int initialValue) {
		if (minValue > maxValue) {
			throw new IllegalArgumentException ("The minimum value (" + minValue 
					+ ") is more than the maximum value (" + maxValue + ")");
		}
		if (!((minValue <= initialValue) && (initialValue <= maxValue))) {
			throw new IllegalArgumentException ("The initial value is not in the correct range.");
		}
		
		this.minValue = minValue;
		this.maxValue = maxValue;
		value = new SimpleIntegerProperty(initialValue);
	    setText(initialValue + "");
	    
	    final IntField intField = this;
	    
	    value.addListener(new ChangeListener<Number>() {
	    	@Override
	    	public void changed(ObservableValue<? extends Number> observableValue, Number oldValue, Number newValue) {
	    		if (newValue == null) {
	                intField.setText("");
	              } else {
	                if (newValue.intValue() < intField.minValue) {
	                  value.setValue(intField.minValue);
	                  return;
	                }
	     
	                if (newValue.intValue() > intField.maxValue) {
	                  value.setValue(intField.maxValue);
	                  return;
	                }
	     
	                if (newValue.intValue() == 0 && (textProperty().get() == null || "".equals(textProperty().get()))) {
	                } else {
	                  intField.setText(newValue.toString());
	                }
	              }
	    	}
	    });
	    
	    this.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
	        @Override
	        public void handle(KeyEvent keyEvent) {
	          if (!"0123456789".contains(keyEvent.getCharacter())) {
	            keyEvent.consume();
	          }
	        }
	    });
	    
	    this.textProperty().addListener(new ChangeListener<String>() {
	        @Override
	        public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
	          if (newValue == null || "".equals(newValue)) {
	            value.setValue(0);
	            return;
	          }
	 
	          final int intValue = Integer.parseInt(newValue);
	 
	          if (intField.minValue > intValue || intValue > intField.maxValue) {
	            textProperty().setValue(oldValue);
	          }
	          
	          value.set(Integer.parseInt(textProperty().get()));
	        }
	    });   
	}
	
	public int  getValue() {
		return value.getValue();
	}
	
    public void setValue(int newValue) {
    	value.setValue(newValue);
    }
    
    public IntegerProperty valueProperty() {
    	return value;
    }
	
}
