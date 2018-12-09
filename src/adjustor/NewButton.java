package adjustor;

import javafx.geometry.Insets;import javafx.geometry.Pos;import javafx.scene.control.Button;import javafx.scene.control.Label;import javafx.scene.effect.DropShadow;import javafx.scene.layout.Background;import javafx.scene.layout.BackgroundFill;import javafx.scene.layout.Border;import javafx.scene.layout.BorderStroke;import javafx.scene.layout.BorderStrokeStyle;import javafx.scene.layout.BorderWidths;import javafx.scene.layout.CornerRadii;import javafx.scene.paint.Color;import javafx.scene.paint.CycleMethod;import javafx.scene.paint.LinearGradient;import javafx.scene.paint.Paint;import javafx.scene.paint.Stop;import javafx.scene.text.Font;

public class NewButton extends Button {
	
	private Label textLabel;
	private String textAlign;
	private int fontSize;
	private Color backgroundColor;
	private LinearGradient gradientBackgroundColor;
	private boolean applyGradient;
	private Paint primaryBackground;
	private Color fromGradientColor;
	private Color toGradientColor;
	private Button buttonBorder;
	private String borderStyle;
	private int borderRadius;
	private Color borderColor;
	private int borderWidth;
	private DropShadow boxShadow;
	private boolean slectedBoxShadow;
	private DropShadow textShadow;
	private boolean slectedTextShadow;
	
	public NewButton() {
		
		super();
		
		textAlign = "center";
		fontSize = 18;
		
		textLabel = new Label("BUTTON");
		textLabel.setTextFill(Color.BLACK);
		textLabel.setFont(Font.font(fontSize));
		
		backgroundColor = Color.WHITE;
		fromGradientColor = Color.rgb(56, 124, 160);
		toGradientColor = Color.rgb(92, 202, 224);
		gradientBackgroundColor = new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE
				, new Stop(0.1f, fromGradientColor), new Stop(1.0f, toGradientColor));
		
		primaryBackground = backgroundColor;
		
		buttonBorder = new Button(textLabel.getText());
		buttonBorder.setFont(Font.font(fontSize));
		buttonBorder.setPrefHeight(60);
		buttonBorder.setPrefWidth(180);
		borderWidth = 2;
		borderRadius = 5;
		borderColor = Color.BLACK;
		borderStyle = "-fx-border-style: solid outside; -fx-border-width: " + borderWidth
				+ "; -fx-border-color: " + borderColor.toString().replace("0x", "#") + "; "
				+ "-fx-border-radius: " + borderRadius + ";";
		buttonBorder.setStyle(borderStyle);
		buttonBorder.setBackground(new Background(new BackgroundFill(backgroundColor, new CornerRadii(borderRadius), Insets.EMPTY)));
		
		boxShadow = new DropShadow(3, 1, 1, Color.BLACK);
		slectedBoxShadow = false;
		textShadow = new DropShadow(4, 0, 0, Color.BLACK);
		slectedTextShadow = false;
		
		setPrefHeight(60);
		setPrefWidth(180);
		setWidth(180);
		setHeight(60);
		setBackground(new Background(new BackgroundFill(this.primaryBackground, new CornerRadii(borderRadius), Insets.EMPTY)));
		setBorder(new Border(new BorderStroke(Color.TRANSPARENT, BorderStrokeStyle.NONE, new CornerRadii(borderRadius), BorderWidths.EMPTY)));
		setGraphic(textLabel);
		
	}
	
	public NewButton(Label textLabel, Color textColor, String textAlign, int fontSize, int buttonWidth, int buttonHeight, Color backgroundColor
			, Color fromGradientColor, Color toGradientColor, boolean applyGradient, int borderWitdh, int borderRadius
			, Color borderColor, boolean slectedBoxShadow, boolean slectedTextShadow) {
		
		
		try {
			this.textLabel = textLabel;
			this.textAlign = textAlign;
			this.fontSize = fontSize;
			this.backgroundColor = backgroundColor;
			this.applyGradient = applyGradient;
			this.fromGradientColor = fromGradientColor;
			this.toGradientColor = toGradientColor;
			this.borderWidth = borderWitdh;
			this.borderRadius = borderRadius;
			this.borderColor = borderColor;
			this.slectedBoxShadow = slectedBoxShadow;
			this.slectedTextShadow = slectedTextShadow;
		} catch (NullPointerException e) {
			throw new NullPointerException("Please fill all needed values");
		}
		
		if (textAlign.equals("right")) {
			this.setAlignment(Pos.CENTER_RIGHT);
		} else if (textAlign.equals("left")) {
			this.setAlignment(Pos.CENTER_LEFT);
		} else {
			this.setAlignment(Pos.CENTER);
		}
		
		this.textLabel.setTextFill(textColor);
		this.textLabel.setFont(Font.font(this.fontSize));
		
		if (applyGradient == true) {
			this.gradientBackgroundColor = new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE
					, new Stop(0.1f, fromGradientColor), new Stop(1.0f, toGradientColor));
			this.primaryBackground = this.gradientBackgroundColor;
		} else {
			this.gradientBackgroundColor = new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE
					, new Stop(0.1f, fromGradientColor), new Stop(1.0f, toGradientColor));
			this.primaryBackground = this.backgroundColor;
		}
			
		buttonBorder = new Button(textLabel.getText());
		buttonBorder.setFont(Font.font(fontSize));
		buttonBorder.setPrefHeight(buttonWidth);
		buttonBorder.setPrefWidth(buttonHeight);
		this.borderStyle = "-fx-border-style: solid outside; -fx-border-width: " + this.borderWidth
				+ "; -fx-border-color: " + this.borderColor.toString().replace("0x", "#") + "; "
				+ "-fx-border-radius: " + this.borderRadius + ";";
		buttonBorder.setStyle(this.borderStyle);
		buttonBorder.setBackground(new Background(new BackgroundFill(this.primaryBackground, new CornerRadii(this.borderRadius), Insets.EMPTY)));

		this.boxShadow = new DropShadow(5, 0, 0, Color.BLACK);
		if (this.slectedBoxShadow == true) {
			this.buttonBorder.setEffect(boxShadow);
		}
		
		this.textShadow = new DropShadow(2, 0, 0, Color.BLACK);
		if (this.slectedTextShadow == true) {
			this.textLabel.setEffect(textShadow);
		}	
		
		setPrefHeight(buttonWidth);
		setPrefWidth(buttonHeight);
		setWidth(buttonWidth);
		setHeight(buttonHeight);
		setBackground(new Background(new BackgroundFill(this.primaryBackground, new CornerRadii(this.borderRadius), Insets.EMPTY)));
		setBorder(new Border(new BorderStroke(Color.TRANSPARENT, BorderStrokeStyle.NONE, new CornerRadii(this.borderRadius), BorderWidths.EMPTY)));
		setGraphic(this.textLabel);
		
		
	}

	public Label getTextLabel() {
		return textLabel;
	}

	public void setTextLabel(Label textLabel) {
		this.textLabel = textLabel;
	}

	public String getTextAlign() {
		return textAlign;
	}

	public void setTextAlign(String textAlign) {
		this.textAlign = textAlign;
	}

	public int getFontSize() {
		return fontSize;
	}

	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}

	public Color getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(Color backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	public LinearGradient getGradientBackgroundColor() {
		return gradientBackgroundColor;
	}

	public void setGradientBackgroundColor(LinearGradient gradientBackgroundColor) {
		this.gradientBackgroundColor = gradientBackgroundColor;
	}

	public boolean isApplyGradient() {
		return applyGradient;
	}

	public void setApplyGradient(boolean applyGradient) {
		this.applyGradient = applyGradient;
	}

	public Paint getPrimaryBackground() {
		return primaryBackground;
	}

	public void setPrimaryBackground(Paint primaryBackground) {
		this.primaryBackground = primaryBackground;
	}

	public Color getFromGradientColor() {
		return fromGradientColor;
	}

	public void setFromGradientColor(Color fromGradientColor) {
		this.fromGradientColor = fromGradientColor;
	}

	public Color getToGradientColor() {
		return toGradientColor;
	}

	public void setToGradientColor(Color toGradientColor) {
		this.toGradientColor = toGradientColor;
	}

	public Button getButtonBorder() {
		return buttonBorder;
	}

	public void setButtonBorder(Button buttonBorder) {
		this.buttonBorder = buttonBorder;
	}

	public String getBorderStyle() {
		return borderStyle;
	}

	public void setBorderStyle(String borderStyle) {
		this.borderStyle = borderStyle;
	}

	public int getBorderRadius() {
		return borderRadius;
	}

	public void setBorderRadius(int borderRadius) {
		this.borderRadius = borderRadius;
	}

	public Color getBorderColor() {
		return borderColor;
	}

	public void setBorderColor(Color borderColor) {
		this.borderColor = borderColor;
	}

	public int getBorderWidth() {
		return borderWidth;
	}

	public void setBorderWidth(int borderWidth) {
		this.borderWidth = borderWidth;
	}

	public DropShadow getBoxShadow() {
		return boxShadow;
	}

	public void setBoxShadow(DropShadow boxShadow) {
		this.boxShadow = boxShadow;
	}

	public boolean isSlectedBoxShadow() {
		return slectedBoxShadow;
	}

	public void setSlectedBoxShadow(boolean slectedBoxShadow) {
		this.slectedBoxShadow = slectedBoxShadow;
	}

	public DropShadow getTextShadow() {
		return textShadow;
	}

	public void setTextShadow(DropShadow textShadow) {
		this.textShadow = textShadow;
	}

	public boolean isSlectedTextShadow() {
		return slectedTextShadow;
	}

	public void setSlectedTextShadow(boolean slectedTextShadow) {
		this.slectedTextShadow = slectedTextShadow;
	}
	
}
