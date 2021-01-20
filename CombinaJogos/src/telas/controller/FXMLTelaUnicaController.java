package telas.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
//import javafx.scene.layout.GridPane;
import util.Cartoes;

public class FXMLTelaUnicaController implements Initializable {
	
	Cartoes gridCartoes = new Cartoes();
	
	//@FXML
    //private GridPane gpLotoFacil;

	//@FXML
	//private AnchorPane apPrincipal, apMenu, apLotoFacil, apMega, apDupla, apQuina, apLotomania, apTimemania, apGeral;
	
	@FXML
	VBox vGeral;
	
	//@FXML
	//Pane PaneGeral;
	
    @FXML
    private ImageView imLotoFacil, imMegaSena, imDuplaSena, imQuina, imLotoMania, imTimeMania, imSair;

	@FXML
	private void handleButtonAction(MouseEvent event) throws Exception 
	{
		// ocultando os Anchor Pane
		vGeral.setVisible(false);
		vGeral.getChildren().clear();
		
		if (event.getTarget() == imLotoFacil) {
			
			vGeral.getChildren().add(gridCartoes.Cartoes(5,5,1,25));
			
		} else if (event.getTarget() == imMegaSena) {
			
			vGeral.getChildren().add(gridCartoes.Cartoes(6,10,1,60));
			
		} else if (event.getTarget() == imDuplaSena) {
			
			vGeral.getChildren().add(gridCartoes.Cartoes(5,10,1,50));
			
		} else if (event.getTarget() == imQuina) {
			
			vGeral.getChildren().add(gridCartoes.Cartoes(8,10,1,80));
			
		} else if (event.getTarget() == imLotoMania) {
			
			vGeral.getChildren().add(gridCartoes.Cartoes(10,10,1,100));
			
		} else if (event.getTarget() == imTimeMania) {
			
			vGeral.getChildren().add(gridCartoes.Cartoes(8,10,1,80));
			
		} else if (event.getTarget() == imSair) {
			
			System.exit(0);
			
		}
		
		// Esse é o bicho
		vGeral.setVisible(true);
		vGeral.setCacheShape(true);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

}
