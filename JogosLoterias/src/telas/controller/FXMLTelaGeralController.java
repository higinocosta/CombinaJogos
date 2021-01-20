package telas.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import util.Cartoes;

public class FXMLTelaGeralController implements Initializable {
	
	Cartoes gridCartoes = new Cartoes();
	//JFXNodesList nodesGridbuttons = new JFXNodesList();
	
	@FXML
	private AnchorPane apPrincipal, apMenu, apJogos, apGridPane;
	
    @FXML
    private ImageView imLotoFacil, imMegaSena, imDuplaSena, imQuina, imLotoMania, imTimeMania, imSair;

	@FXML
	private void handleButtonAction(MouseEvent event) throws Exception {
		//apGridPane.getChildren().clear();
		if (event.getTarget() == imLotoFacil) {
			apGridPane.getChildren().add(gridCartoes.Cartoes(5,5,1,25));
			//apJogos.setTopAnchor((Node) gridCartoes, 59.0);
		} else if (event.getTarget() == imMegaSena) {
			apGridPane.getChildren().add(gridCartoes.Cartoes(6,10,1,60));
		} else if (event.getTarget() == imDuplaSena) {
			apGridPane.getChildren().add(gridCartoes.Cartoes(5,10,1,50));
		} else if (event.getTarget() == imQuina) {
			apGridPane.getChildren().add(gridCartoes.Cartoes(8,10,1,80));
		} else if (event.getTarget() == imLotoMania) {
			apGridPane.getChildren().add(gridCartoes.Cartoes(10,10,1,100));
		} else if (event.getTarget() == imTimeMania) {
			apGridPane.getChildren().add(gridCartoes.Cartoes(8,10,1,80));
		} else if (event.getTarget() == imSair) {
			System.exit(0);
		}
		
		/*
		 * apLotoFacil.getChildren().add(gridCartoes.Cartoes(5,5,1,25));
			//gpLotoFacil.setColumnResizePolicy(gpLotoFacil.CONSTRAINED_RESIZE_POLICY);
			apLotoFacil.setVisible(true);
		 */
		
		//nodesGridbuttons.addAnimatedNode((Region) gridCartoes);
		//apJogos.setTopAnchor(nodesGridbuttons, 59.0);
		//apJogos.setRightAnchor(nodesGridbuttons, 69.0);
		apGridPane.setVisible(true);
		apJogos.setVisible(true);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

}
