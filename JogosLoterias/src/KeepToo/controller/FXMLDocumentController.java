package KeepToo.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class FXMLDocumentController implements Initializable {

	@FXML
	private ImageView btn_setting, btn_user, btn_exit;

	@FXML
	private AnchorPane starts, awards, setting, user;

	@FXML
	private void handleButtonAction(MouseEvent event) {
		if (event.getTarget() == btn_setting) {
			setting.setVisible(true);
			user.setVisible(false);
		} else if (event.getTarget() == btn_user) {
			user.setVisible(true);
			setting.setVisible(false);
		} else if (event.getTarget() == btn_exit) {
			user.setVisible(false);
			setting.setVisible(false);
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

}
