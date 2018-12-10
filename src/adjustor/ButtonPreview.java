package adjustor;

import javafx.geometry.Insets;import javafx.geometry.Pos;import javafx.scene.Cursor;import javafx.scene.control.Button;import javafx.scene.layout.HBox;import javafx.scene.layout.StackPane;import javafx.scene.layout.VBox;import javafx.scene.paint.Color;import javafx.scene.shape.Rectangle;import javafx.stage.Screen;

public class ButtonPreview extends VBox {
	
	private StackPane buttonShow;
	private Rectangle bgButtonShow;
	private HBox bottomMenu;
	private Button exportButton;
	private Button newButton;
	
	public ButtonPreview(NewButton button) {
		super(20);
		getStyleClass().add("button-show");
		setPadding(new Insets(0, 0, 20, 0));
		setAlignment(Pos.CENTER);
		
		exportButton = new Button("EXPORT");
		exportButton.setCursor(Cursor.HAND);
		exportButton.setPrefSize(150, 70);
		exportButton.getStyleClass().add("export-button");
		
		newButton = new Button("NEW BUTTON");
		newButton.setCursor(Cursor.HAND);
		newButton.setPrefSize(150, 70);
		newButton.getStyleClass().add("new-button");
		
		bgButtonShow = new Rectangle(300, 300);
		bgButtonShow.setFill(Color.web("#DADADA"));
		
		buttonShow = new StackPane();
		buttonShow.setPrefWidth(Screen.getPrimary().getVisualBounds().getWidth());
		buttonShow.setPrefHeight(680);
		buttonShow.getChildren().addAll(bgButtonShow, button.getButtonBorder(), button);
		
		bottomMenu = new HBox(20);
		bottomMenu.setAlignment(Pos.CENTER);
		
		bottomMenu.getChildren().addAll(exportButton, newButton);
		
		getChildren().addAll(buttonShow, bottomMenu);
		
	}

	public Button getExportButton() {
		return exportButton;
	}

	public Button getNewButton() {
		return newButton;
	}

}
