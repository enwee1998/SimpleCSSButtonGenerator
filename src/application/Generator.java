package application;

import java.io.File;import java.io.PrintWriter;import java.util.ArrayList;import adjustor.ButtonAdjust;import adjustor.NewButton;import javafx.geometry.Insets;import javafx.geometry.Pos;import javafx.scene.Cursor;import javafx.scene.Scene;import javafx.scene.control.Button;import javafx.scene.control.Label;import javafx.scene.control.TextArea;import javafx.scene.layout.HBox;import javafx.scene.layout.StackPane;import javafx.scene.layout.VBox;import javafx.scene.paint.Color;import javafx.scene.shape.Rectangle;import javafx.stage.FileChooser;import javafx.stage.Modality;import javafx.stage.Screen;import javafx.stage.Stage;import javafx.stage.StageStyle;

public class Generator extends HBox {
	
	private Scene generatorScene;
	private ArrayList<String> cssCode;
	
	static final String CONTROL_CSS_PATH = ClassLoader.getSystemResource("controlStyleSheet.css").toString();
	
	public Generator(NewButton button, Stage primaryStage) {
		
		cssCode = new ArrayList<String>();
		
		final ButtonAdjust btnAdjust = new ButtonAdjust(button);
		
		final Rectangle bgButtonShow = new Rectangle(300, 300);
		bgButtonShow.setFill(Color.web("#DADADA"));
		
		final StackPane buttonShow = new StackPane();
		buttonShow.setPrefWidth(Screen.getPrimary().getVisualBounds().getWidth());
		buttonShow.setPrefHeight(680);
		buttonShow.getChildren().addAll(bgButtonShow, button.getButtonBorder(), button);
		
		final VBox buttonPreview = new VBox(20);
		buttonPreview.getStyleClass().add("button-show");
		buttonPreview.setPadding(new Insets(0, 0, 20, 0));
		buttonPreview.setAlignment(Pos.CENTER);
		
		final HBox bottomMenu = new HBox(20);
		bottomMenu.setAlignment(Pos.CENTER);
		
		final Button exportButton = new Button("EXPORT");
		exportButton.setCursor(Cursor.HAND);
		exportButton.setPrefSize(150, 70);
		exportButton.getStyleClass().add("export-button");
		exportButton.setOnAction(export -> {
			createExportDialog(button);
		});
		
		final Button newButton = new Button("NEW BUTTON");
		newButton.setCursor(Cursor.HAND);
		newButton.setPrefSize(150, 70);
		newButton.getStyleClass().add("new-button");
		newButton.setOnAction(newBtn -> {
			ButtonTemplate btnTemplate = new ButtonTemplate(primaryStage);
			primaryStage.setScene(btnTemplate.getButtonTemplateScene());
		});
		
		bottomMenu.getChildren().addAll(exportButton, newButton);
		buttonPreview.getChildren().addAll(buttonShow, bottomMenu);
		
		
		getChildren().addAll(btnAdjust, buttonPreview);
		
		generatorScene = new Scene(this);
		generatorScene.getStylesheets().add(CONTROL_CSS_PATH);
		
	}

	public Scene getGeneratorScene() {
		return generatorScene;
	}
	
	private void createExportDialog(NewButton button) {
		
		cssCode.clear();
		
		final Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        
        final VBox dialogVbox = new VBox(10);
        dialogVbox.setPadding(new Insets(10));
        dialogVbox.setAlignment(Pos.CENTER);
        
        final TextArea cssGenerator = new TextArea();
        cssGenerator.setEditable(false);
        cssGenerator.setMaxSize(350, 180);
        cssGenerator.setPrefSize(350, 180);
        
        cssCode.add(button.getTextLabel().getText());
        cssCode.add("width: " + (int)button.getWidth() + "px;");
        cssCode.add("height: " + (int)button.getHeight() + "px;");
        cssCode.add("color: " + button.getTextLabel().getTextFill().toString().replace("0x", "#").substring(0, 7) + ";");
        cssCode.add("font-size: " + button.getFontSize() + "px;");
        cssCode.add("text-align: " + button.getTextAlign() + ";");
        cssCode.add("line-height: " + (int)button.getHeight() + "px;");
        cssCode.add("cursor: pointer;");

        if (button.getPrimaryBackground() instanceof Color) {
        	cssCode.add("background-color: " +  button.getBackgroundColor().toString().replace("0x", "#").substring(0, 7) + ";");

        } else {
        	
        	cssCode.add("background:linear-gradient(to bottom, " 
						+ button.getFromGradientColor().toString().replace("0x", "#").substring(0, 7) + " 5% , " 
						+ button.getToGradientColor().toString().replace("0x", "#").substring(0, 7) + " 100%)"
						+ ";");
        	cssCode.add("filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='"
					+ button.getFromGradientColor().toString().replace("0x", "#").substring(0, 7) + "', endColorstr='" 
					+ button.getToGradientColor().toString().replace("0x", "#").substring(0, 7) + "',GradientType=0);");

        }
        
        if (button.getBorderWidth() > 0) {
        	
        	cssCode.add("border: " + button.getBorderWidth() + "px solid " 
        				+ button.getBorderColor().toString().replace("0x", "#").substring(0, 7) + ";");
        	cssCode.add("border-radius: " + button.getBorderRadius() + "px;");
        	
        }
        
        if (button.isSlectedTextShadow()) {
        	
        	cssCode.add("text-shadow: " + (int)button.getTextShadow().getOffsetX() + "px " 
						+ (int)button.getTextShadow().getOffsetY() + "px " + (int)button.getTextShadow().getRadius() 
						+ "px " + button.getTextShadow().getColor().toString().replace("0x", "#").substring(0, 7) + ";");
        	
        }
        
        if (button.isSlectedBoxShadow()) {
        	
        	cssCode.add("box-shadow: " + (int)button.getBoxShadow().getOffsetX() + "px " 
					+ (int)button.getBoxShadow().getOffsetY() + "px " + (int)button.getBoxShadow().getRadius() 
					+ "px " + button.getBoxShadow().getColor().toString().replace("0x", "#").substring(0, 7) + ";");
        	
        }
        
        cssGenerator.setText(".myCSSButton {");
        
        for (int i=1; i<cssCode.size(); i++) {
        	cssGenerator.setText(cssGenerator.getText() + "\n\t" + cssCode.get(i));
        }
        
        cssGenerator.setText(cssGenerator.getText() + "\n}");
        
        final Button exportCss = new Button("Export to HTML");
        exportCss.setOnAction(action -> {
            exportHtmlFile(cssCode, dialog);
        });
        
        final Button closeDialog = new Button("Close");
        closeDialog.setOnAction(action -> {
        	dialog.hide();;
        });
        
        final HBox groupButton = new HBox(10);
        groupButton.setAlignment(Pos.CENTER);
        groupButton.getChildren().addAll(exportCss, closeDialog);
        
        dialogVbox.getChildren().addAll(new Label("CSS"), cssGenerator, groupButton);
        final Scene dialogScene = new Scene(dialogVbox, 400, 300);
        dialog.setScene(dialogScene);
        dialog.setMaximized(false);
        dialog.setResizable(false);
        dialog.initStyle(StageStyle.UNDECORATED);
        dialog.show();
		
	}
	
	private void exportHtmlFile(ArrayList<String> cssCode, Stage dialog) {
		
        final FileChooser directoryChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Web pages", "*.html", "*.HTML");
        directoryChooser.getExtensionFilters().add(extFilter);
        directoryChooser.setTitle("Where to save your html and css files");
        directoryChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        try {
        	File file = directoryChooser.showSaveDialog(dialog);
        	PrintWriter writer = new PrintWriter(file);
            writer.println("<style>");
            writer.println("body {background-color: #1A2029}");
            writer.println("\t.center-div {" + 
            		"\r\n\t\tmargin: 0;" + 
            		"\r\n\t\tposition: absolute;" + 
            		"\r\n\t\ttop: 50%;" + 
            		"\r\n\t\tleft: 50%;" + 
            		"\r\n\t\ttransform: translate(-50%, -50%);\r\n\t}");
            writer.println("\r\n\t.myCSSButton {");
            for (int i=1; i<cssCode.size(); i++) {
            	writer.println("\t\t" + cssCode.get(i));
            }
            writer.println("\t}\r\n</style>\r\n\r\n<html>\r\n\t<head>\r\n\t\t<title>myCSSButton</title>\n\t</head>\r\n\t<body>"
            				+ "\r\n\t\t<div class=\"center-div\">\r\n\t\t\t<div class = \"myCSSButton\">"+ cssCode.get(0) 
            				+ "</div>\r\n\t\t</div>\n\t</body>\r\n</html>");
            writer.close();
        } catch (Exception e) {
        	System.out.println("Cannot save this file.");
        }
	}
	
}
