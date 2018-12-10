package application;

import javafx.application.Application;import javafx.geometry.Rectangle2D;import javafx.scene.Scene;import javafx.scene.layout.VBox;import javafx.scene.text.Font;import javafx.stage.Screen;import javafx.stage.Stage;

public class Main extends Application {
	
	static final String PREVIEW_CSS_PATH = ClassLoader.getSystemResource("previewStyleSheet.css").toString();
	
	@Override
	public void start(Stage primaryStage) throws Exception {

		Font.loadFont(ClassLoader.getSystemResource("Quicksand-Regular.ttf").toExternalForm(), 10);
		
		VBox root = new VBox();
		
		ButtonTemplate btnTemplate = new ButtonTemplate(primaryStage);
		
		root.getChildren().add(btnTemplate);
		
		Scene btnTemplateScene = new Scene(root);
		btnTemplateScene.getStylesheets().add(PREVIEW_CSS_PATH);
		
		primaryStage.setScene(btnTemplateScene);
		primaryStage.setTitle("CSS Button Generator");
		primaryStage.setWidth(1024);
	    primaryStage.setHeight(750);
		Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
		primaryStage.setX((screenBounds.getWidth() - primaryStage.getWidth()) / 2);
		primaryStage.setY((screenBounds.getHeight() - primaryStage.getHeight()) / 2);
		primaryStage.setResizable(false);
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);

	}
	
}
