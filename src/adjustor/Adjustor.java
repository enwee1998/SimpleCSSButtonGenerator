package adjustor;

import inputfield.OptionAddable;import javafx.scene.Node;import javafx.scene.control.TitledPane;import javafx.scene.layout.VBox;

abstract public class Adjustor implements OptionAddable {

	private VBox optionPane;
	private TitledPane titledPane;
	
	public Adjustor(String title) {
		
		optionPane = new VBox(10);
		titledPane = new TitledPane();
		titledPane.setText(title);
		titledPane.setPrefWidth(350);
		titledPane.setContent(optionPane);
	
	}
	
	abstract public void valueBinding(NewButton button);
	
	public void setAdjustorDisable(boolean disable) {
		optionPane.setDisable(disable);
	};
	
	@Override
	public void addOption(Node option) {
		getOptionPane().getChildren().add(option);
	}

	public VBox getOptionPane() {
		return optionPane;
	}

	public TitledPane getTitledPane() {
		return titledPane;
	}	
	
}
