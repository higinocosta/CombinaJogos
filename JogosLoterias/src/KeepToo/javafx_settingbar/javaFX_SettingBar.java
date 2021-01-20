package KeepToo.javafx_settingbar;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class javaFX_SettingBar extends Application {
	private double xoffset = 0;
	private double yoffset = 0;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/KeepToo/telas/javafxsettingbar.fxml"));
		stage.initStyle(StageStyle.TRANSPARENT);
		
		root.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				xoffset = event.getSceneX();
				yoffset = event.getSceneY();
			}
		});

		root.setOnMouseDragged(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				stage.setX(event.getScreenX() - xoffset);
				stage.setY(event.getScreenY() - yoffset);
			}
		});
		
		Scene scene = new Scene(root);
		scene.setFill(javafx.scene.paint.Color.TRANSPARENT);
		stage.setScene(scene);
		stage.show();
		
	}

}
