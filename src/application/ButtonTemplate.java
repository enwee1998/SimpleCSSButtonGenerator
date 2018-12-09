package application;

import adjustor.NewButton;import javafx.geometry.Insets;import javafx.geometry.Pos;import javafx.scene.Scene;import javafx.scene.control.Label;import javafx.scene.control.ScrollPane;import javafx.scene.layout.GridPane;import javafx.scene.paint.Color;import javafx.scene.text.TextAlignment;import javafx.stage.Stage;

public class ButtonTemplate extends ScrollPane {
	
	private Scene buttonTemplateScene;
	
	ButtonTemplate(Stage primaryStage) {
		setHbarPolicy(ScrollBarPolicy.NEVER);
		setVbarPolicy(ScrollBarPolicy.NEVER);
		setFitToWidth(true);
		
		GridPane gridPane = new GridPane();
		gridPane.setVgap(40);
		gridPane.setHgap(50);
		gridPane.setPadding(new Insets(30, 0, 30, 0));
		gridPane.setAlignment(Pos.CENTER);
		gridPane.getStyleClass().add("buttonTemplatePage");
		
		NewButton button1 = new NewButton();
		NewButton button2 = new NewButton(new Label("Template 1"), Color.WHITE,"center", 18, 60, 180, Color.BLACK, Color.web("#D65DB1"), Color.web("#FF6F91")
											, true, 0, 5, Color.web("#845EC2"), true, true);
		NewButton button3 = new NewButton(new Label("Template 2"), Color.WHITE,"center", 18, 120, 120, Color.BLACK, Color.web("#86A8E7"), Color.web("#5FFBF1")
											, true, 1, 60, Color.web("#845EC2"), true, true);
		NewButton button8 = new NewButton(new Label("Template 7"), Color.web("#27432C"),"center", 18, 40, 120, Color.web("#89FF49"), Color.web("#86A8E7"), Color.web("#5FFBF1")
											, false, 2, 20, Color.web("#2D3E31"), true, false);
		button8.getBoxShadow().setColor(Color.web("#5FA13B"));
		NewButton button5 = new NewButton(new Label("Template 4"), Color.web("#3B2F0C"),"center", 22, 60, 200, Color.web("#FF5829"), Color.web("#FFEF3E"), Color.web("#F08139")
											, true, 0, 5, Color.web("#2D3E31"), true, true);
		button5.getTextShadow().setRadius(0);
		button5.getTextShadow().setColor(Color.WHITE);
		button5.getTextShadow().setOffsetX(1);
		button5.getTextShadow().setOffsetY(1);
		NewButton button6 = new NewButton(new Label("Template 5"), Color.web("#FFE8F6"),"center", 16, 40, 120, Color.web("#B361FD"), Color.web("#FFEF3E"), Color.web("#F08139")
											, false, 3, 5, Color.web("#8A48C5"), true, true);
		button6.getBoxShadow().setRadius(0);
		button6.getBoxShadow().setColor(Color.web("#8A48C5"));
		button6.getBoxShadow().setOffsetX(-2);
		button6.getBoxShadow().setOffsetY(-2);
		NewButton button7 = new NewButton(new Label("Template 6"), Color.web("#FFFFFF"),"center", 14, 100, 100, Color.web("#C64040"), Color.web("#FFEF3E"), Color.web("#F08139")
											, false, 2, 50, Color.web("#FFFFFF"), true, false);
		button7.getBoxShadow().setRadius(10);
		button7.getBoxShadow().setColor(Color.web("#B2B2B2"));
		button7.getBoxShadow().setOffsetX(4);
		button7.getBoxShadow().setOffsetY(4);
		NewButton button4 = new NewButton(new Label("Template 3"), Color.web("#C64040"),"center", 18, 50, 160, Color.web("#FFFFFF"), Color.web("#86A8E7"), Color.web("#5FFBF1")
											, false, 3, 0, Color.web("#C64040"), true, false);
		button4.getBoxShadow().setRadius(0);
		button4.getBoxShadow().setColor(Color.web("#BDBDBD"));
		button4.getBoxShadow().setOffsetX(-4);
		button4.getBoxShadow().setOffsetY(4);
		NewButton button9 = new NewButton(new Label("Template 8"), Color.web("#1C1C1C"),"center", 14, 42, 120, Color.web("#5E5E5E"), Color.web("#5E5E5E"), Color.web("#D6D6D6")
											, true, 2, 2, Color.web("#5E5E5E"), false, true);
		button9.getTextShadow().setRadius(3);
		button9.getTextShadow().setColor(Color.WHITE);
		button9.getTextShadow().setOffsetX(0);
		button9.getTextShadow().setOffsetY(0);
		
		ButtonTemplateCard btn1preview = new ButtonTemplateCard(button1, primaryStage);
		btn1preview.getChildren().clear();
		
		final Label newButtonText = new Label("NEW\nBUTTON");
		newButtonText.setTextAlignment(TextAlignment.CENTER);
		newButtonText.setStyle("-fx-font-weight: bold;"
								+ "-fx-font-size: 32;"
								+ "-fx-font-color: #000000");
		
		btn1preview.getChildren().add(newButtonText);
		ButtonTemplateCard btn2preview = new ButtonTemplateCard(button2, primaryStage);
		ButtonTemplateCard btn3preview = new ButtonTemplateCard(button3, primaryStage);
		ButtonTemplateCard btn4preview = new ButtonTemplateCard(button4, primaryStage);
		ButtonTemplateCard btn5preview = new ButtonTemplateCard(button5, primaryStage);
		ButtonTemplateCard btn6preview = new ButtonTemplateCard(button6, primaryStage);
		ButtonTemplateCard btn7preview = new ButtonTemplateCard(button7, primaryStage);
		ButtonTemplateCard btn8preview = new ButtonTemplateCard(button8, primaryStage);
		ButtonTemplateCard btn9preview = new ButtonTemplateCard(button9, primaryStage);
		
		gridPane.add(btn1preview, 0, 0);
		gridPane.add(btn2preview, 1, 0);
		gridPane.add(btn3preview, 2, 0);
		gridPane.add(btn4preview, 0, 1);
		gridPane.add(btn5preview, 1, 1);
		gridPane.add(btn6preview, 2, 1);
		gridPane.add(btn7preview, 0, 2);
		gridPane.add(btn8preview, 1, 2);
		gridPane.add(btn9preview, 2, 2);
		
		setContent(gridPane);
		
		buttonTemplateScene = new Scene(this);
		buttonTemplateScene.getStylesheets().add(Main.PREVIEW_CSS_PATH);
	}

	public Scene getButtonTemplateScene() {
		return buttonTemplateScene;
	}
}
