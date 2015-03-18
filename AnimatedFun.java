/* Author: Luigi Vincent
Just a fun animation.

Displays a transparent gif file that can be moved by arrow keys.

Created to practice JavaFX concepts.

Second in a series of simple apps made for the sake of learning.
*/

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.effect.Bloom;
import javafx.scene.effect.Glow;
import javafx.scene.effect.MotionBlur;
import javafx.scene.effect.Reflection;
import javafx.scene.effect.Shadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class AnimatedFun extends Application {
	int animationSpeed = 5;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {
		ImageView view = new ImageView(new Image(
			getClass().getResourceAsStream("Assets/Arbiter.gif")));
		view.setEffect(new Glow());
		view.setOnMouseClicked(e -> stage.close());
		view.setFocusTraversable(true);
		view.setOnKeyPressed(e -> { 
    		if (e.getCode() == KeyCode.ESCAPE) { 	
    			stage.close();
    		} else if (e.getCode() == KeyCode.SPACE) {
    			view.setEffect(new Reflection());
    		} else if (e.getCode() == KeyCode.DELETE) {
    			view.setEffect(null);
    		} else if (e.getCode() == KeyCode.ENTER) {
    			view.setEffect(new Bloom());
    		} else if (e.getCode() == KeyCode.SHIFT) {
    			view.setEffect(new Shadow());
    		} else if (e.getCode() == KeyCode.RIGHT) {
    			stage.setX(stage.getX() + animationSpeed);
    		} else if (e.getCode() == KeyCode.LEFT) {
    			stage.setX(stage.getX() - animationSpeed);
    		} else if (e.getCode() == KeyCode.UP) {
    			stage.setY(stage.getY() - animationSpeed);
    		} else if (e.getCode() == KeyCode.DOWN) {
    			stage.setY(stage.getY() + animationSpeed);
    		} else if (e.getCode() == KeyCode.CONTROL) {
    			animationSpeed += 3;
    			if (animationSpeed >= 15) {
    				view.setEffect(new MotionBlur());
    			}
    		} else if (e.getCode() == KeyCode.ALT) {
    			if (animationSpeed >= 15 && animationSpeed < 18){
    				view.setEffect(new Glow());
    			}
    			animationSpeed = (Math.max(5, animationSpeed - 2));
    		}
    	});

		Group root = new Group();
		root.getChildren().add(view);

		stage.setScene(new Scene(root, Color.TRANSPARENT));
		stage.initStyle(StageStyle.TRANSPARENT);
		stage.getIcons().add(new Image(
			getClass().getResourceAsStream("Assets/Icon.png")));
		stage.show();
	}
}