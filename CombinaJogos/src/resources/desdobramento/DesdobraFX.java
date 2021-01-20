package resources.desdobramento;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DesdobraFX extends Application {
	
	private static Stage stage;
	//public static Stage primaryStage;
	public static Class thisClass;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public static Stage getStage() {
		return stage;
	}
	
	public DesdobraFX() {
		thisClass = getClass();
	}

	@Override
	public void start(Stage stage) throws Exception {
		this.stage = stage;
		
		Parent root = FXMLLoader.load(getClass().getResource("/telas/fxml/telaDesdobramento.fxml")); //Carrega FXML
		Scene scene = new Scene(root); // Coloca FXML em uma cena
		stage.setTitle("DESDOBRAMENTO MEGA SENA"); // Coloca o Título da Janela
		stage.setScene(scene); //Coloca a Cena em uma Janela
		stage.show(); //Abre a Janela ( JANELA2 )
		DesdobraFX.stage = stage;
	}
	
	public static void loadScene(String nameFile, String titlePage) {

		Parent root;
		try {
			root = FXMLLoader.load(thisClass.getClass().getResource(nameFile));
			Scene scene = new Scene(root);;
			stage.setTitle(titlePage);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
