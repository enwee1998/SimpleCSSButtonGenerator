package adjustor;

import javafx.scene.control.ScrollPane;import javafx.scene.layout.VBox;

public class ButtonAdjust extends ScrollPane {
	
	private LabelAdjust labelAdjust;
	private SizeAdjust sizeAdjust;
	private BackgroundAdjust backgroundAdjust;
	private BorderAdjust borderAdjust;
	private TextShadowAdjust textShadowAdjust;
	private BoxShadowAdjust boxShadowAdjust;
	
	public ButtonAdjust(NewButton button) {
		setMinWidth(350);
		setPrefWidth(350);
		setHbarPolicy(ScrollBarPolicy.NEVER);
		setVbarPolicy(ScrollBarPolicy.NEVER);
		
		final VBox adjustCollection = new VBox();
		
		labelAdjust = new LabelAdjust(button);
		sizeAdjust = new SizeAdjust(button);
		backgroundAdjust = new BackgroundAdjust(button);
		borderAdjust = new BorderAdjust(button);
		textShadowAdjust = new TextShadowAdjust(button);
		boxShadowAdjust = new BoxShadowAdjust(button);
		
		adjustCollection.getChildren().addAll(labelAdjust.getTitledPane(), sizeAdjust.getTitledPane()
				, backgroundAdjust.getTitledPane(), borderAdjust.getTitledPane(), textShadowAdjust.getTitledPane()
				, boxShadowAdjust.getTitledPane());
		
		setContent(adjustCollection);
	}
	
}
