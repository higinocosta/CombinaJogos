package resources.desdobramento;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DesdobraFX1 extends Application {
	
	private static Stage stage;
	private static Scene tela1, tela2, telaInicial;
	
	//public static Stage primaryStage;
	public static Class thisClass;
	
	public static Stage getStage() {
		return stage;
	}
	
	public DesdobraFX1() {
		thisClass = getClass();
	}

	@Override
	public void start(Stage stage) throws Exception {
		this.stage = stage;
		stage.setTitle("DESDOBRAMENTO MEGA SENA"); // Coloca o Título da Janela
		
		Parent fxmlTelaInicial = FXMLLoader.load(getClass().getResource("/telas/fxml/telaDesdobramento.fxml")); //Carrega FXML
		telaInicial = new Scene(fxmlTelaInicial); // Coloca FXML em uma cena
		
		Parent fxmlTela1 = FXMLLoader.load(getClass().getResource("/telas/fxml/telaDesdobramento.fxml")); //Carrega FXML
		tela1 = new Scene(fxmlTela1); // Coloca FXML em uma cena
		
		Parent fxmlTtela2 = FXMLLoader.load(getClass().getResource("/telas/fxml/telaDesdobramento.fxml")); //Carrega FXML
		tela2 = new Scene(fxmlTtela2); // Coloca FXML em uma cena
		
		stage.setScene(telaInicial); //Coloca a Cena em uma Janela
		stage.show(); //Abre a Janela ( JANELA2 )
		DesdobraFX1.stage = stage;
	}
	
	public static void main(String[] args) {
		launch(args);
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
