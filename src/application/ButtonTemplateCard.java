package application;

import adjustor.NewButton;import javafx.animation.FadeTransition;import javafx.event.EventHandler;import javafx.geometry.Pos;import javafx.scene.Cursor;import javafx.scene.control.Label;import javafx.scene.input.MouseEvent;import javafx.scene.layout.Region;import javafx.scene.layout.StackPane;import javafx.scene.paint.Color;import javafx.scene.text.TextAlignment;import javafx.stage.Stage;import javafx.util.Duration;

public class ButtonTemplateCard extends StackPane {
	
	static final int PREVIEW_HEIGHT = 300;
	static final int PREVIEW_WIDTH = 220;
	
	public ButtonTemplateCard(NewButton button, Stage primaryStage) {
		setPrefWidth(PREVIEW_WIDTH);
		setPrefHeight(PREVIEW_HEIGHT);
		setAlignment(Pos.CENTER);
		getStyleClass().add("previewCard");
		
		final Label selectText = new Label("SELECT\nTHIS TEMPLATE");
		selectText.setTextFill(Color.WHITE);
		selectText.setStyle("-fx-font-weight: bold;"
							+ "-fx-font-size: 18;");
		selectText.setTextAlignment(TextAlignment.CENTER);
		selectText.setVisible(false);
		
		final Region overlay = new Region();
		overlay.setPrefSize(PREVIEW_HEIGHT, PREVIEW_WIDTH);
		overlay.setStyle("-fx-background-color: rgba(0, 0, 0, 1);-fx-background-radius: 10px; -fx-border-radius: 10px;");
		overlay.setVisible(false);
		
		final FadeTransition overlayFade = new FadeTransition(Duration.seconds(0.5), overlay);
		overlayFade.setFromValue(0.0);
		overlayFade.setToValue(0.7);
		overlayFade.setAutoReverse(true);
		
		final FadeTransition textFade = new FadeTransition(Duration.seconds(0.4), selectText);
		textFade.setFromValue(0.0);
		textFade.setToValue(1.0);
		textFade.setAutoReverse(true);
		
		setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				try {
					setCursor(Cursor.HAND);

					textFade.play();
					overlayFade.play();
					
					selectText.setVisible(true);
					overlay.setVisible(true);
					
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		setOnMouseExited(new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent mouseEvent) {
				try {
					setCursor(Cursor.DEFAULT);
					
					if (selectText.isVisible()) {
						selectText.setVisible(false);
						overlay.setVisible(false);
					} 
					
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
			
		});
		
		setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				Generator buttonGenerator = new Generator(button, primaryStage);
				primaryStage.setScene(buttonGenerator.getGeneratorScene());
			}
		});
		
		getChildren().addAll(button.getButtonBorder(), button, overlay, selectText);
	}

}
