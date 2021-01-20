package telas.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class DesdobraController implements Initializable {

	@FXML
	private TextField txArqOrigem, txArqDestino, txAcertos;
	@FXML
	private Label lbPorcentagem, lbRegressiva;
	@FXML
	private Button btGerar;
	@FXML
	private ProgressBar barProgresso;

	private File arqOrigem, arqDestino, arqTerminal, arqTemporario;
	private String path = "C:\\TEMP\\", caminhoOrigem, caminhoDestino;
	private int acertosLimite, numeroLinha = 0 ;
	
	
	public void incrementaRegressiva() {
		/*
		Platform.runLater(() -> 
			lbRegressiva.setText(String.valueOf(numeroLinha));
		);
		*/
		lbRegressiva.setText(String.valueOf(numeroLinha));
		lbRegressiva.setVisible(true);
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {

		initComponents();

		btGerar.setOnMouseClicked((MouseEvent e) -> {
			
			/*
			// teste com thread
			new Thread(() -> {
				try {
					desdobra();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}).start();
			//lbRegressiva.setText(String.valueOf(numeroLinha));
			*/
			
			// original funcionado
			try {
				desdobra();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
		});

		txArqOrigem.setOnMouseClicked(e -> {
			FileChooser f = new FileChooser();
			f.setInitialDirectory(new File("C:\\TEMP"));
			f.getExtensionFilters().add(new ExtensionFilter("Arquivos CSV e TEXTO", "*.csv", "*.txt"));
			File file = f.showOpenDialog(new Stage());

			if (file != null) {
				// imgFoto.setImage(new Image("file:///"+file.getAbsolutePath()));
				caminhoOrigem = file.getAbsolutePath();
				txArqOrigem.setText(caminhoOrigem);
			}
		});

		txArqDestino.setOnMouseClicked(e -> {
			FileChooser f = new FileChooser();
			f.setInitialDirectory(new File("C:\\TEMP"));
			f.getExtensionFilters().add(new ExtensionFilter("Arquivos CSV e TEXTO", "*.csv", "*.txt"));
			File file = f.showSaveDialog(new Stage());

			if (file != null) {
				// imgFoto.setImage(new Image("file:///"+file.getAbsolutePath()));
				caminhoDestino = file.getAbsolutePath();
				txArqDestino.setText(caminhoDestino);
			}
		});

		txAcertos.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.isEmpty()) {
					try {
						long pointI = Integer.parseInt(newValue);
						txAcertos.setText(String.valueOf(pointI));
						acertosLimite = Integer.parseInt(newValue);
					} catch (Exception e) {
						txAcertos.clear();
						txAcertos.setText(getNumber(oldValue));
					}
				}
			}
		});

	}

	private String getNumber(String value) {
		String n = "";
		try {
			return String.valueOf(Integer.parseInt(value));
		} catch (Exception e) {
			String[] array = value.split("");
			for (String tab : array) {
				try {
					System.out.println(tab);
					n = n.concat(String.valueOf(Integer.parseInt(String.valueOf(tab))));
				} catch (Exception ex) {
					System.out.println("not nomber");
				}
			}
			return n;
		}
	}

	private boolean isLetter(char validar) {
		// TODO Auto-generated method stub
		return false;
	}

	private void initComponents() {
		
		/*
		new Thread(() -> {
				incrementaRegressiva();
		}).start();
		 */
		
		// txqOrigem = new TextField();
		// txArqDestino = new TextField();
		// txAcertos = new TextField();

		lbPorcentagem = new Label();
		//lbRegressiva = new Label();

		//DesdobraFX.getStage();
		//DesdobraFX.loadScene("/View/TelaInicial.fxml", "1� P�g�na");

		// root.getChildren().addAll(lbGarantia, lbArqOrigem,
		// lbArqDestino,txtGarantia,txtSenha,btEntrar,btSair);
	}

	private void desdobra() throws IOException {

		// arqOrigem = new File("C://temp//Desdobra 23 num 15 dez garante 12.csv");
		arqOrigem = new File(caminhoOrigem);
		// arqTerminal = new File("C://temp//terminal.csv");
		arqTerminal = new File(caminhoDestino);
		arqDestino = new File("C://temp//original.txt");
		BufferedWriter finalmente = new BufferedWriter(new FileWriter(arqTerminal));

		Files.copy(arqOrigem.toPath(), new File("C://temp//original.txt").toPath());
		
		//int numeroLinha = 0;
		
		while (arqDestino.length() != 0) {

			arqTemporario = new File("C://temp//destino.tmp");
			BufferedReader reader = new BufferedReader(new FileReader(arqDestino));
			BufferedWriter writer = new BufferedWriter(new FileWriter(arqTemporario));
			String currentLine = reader.readLine();
			String[] comparador = currentLine.split(";");
			Integer tamanho = comparador.length, acertos = 0;
			finalmente.write(currentLine + System.getProperty("line.separator"));
			finalmente.flush();

			while ((currentLine = reader.readLine()) != null) {

				String[] linha = currentLine.split(";");
				List<String> dezenasGeral = new ArrayList();// String[tamanho*2] dezenas;
				Collections.addAll(dezenasGeral, linha);
				Collections.addAll(dezenasGeral, comparador);
				Collections.sort(dezenasGeral);
				acertos = dezenasGeral.size() - new HashSet(dezenasGeral).size();

				if (acertos < acertosLimite) {
					writer.write(currentLine + System.getProperty("line.separator"));
					writer.flush();
					System.out.println(Arrays.toString(dezenasGeral.toArray()) + " + " + acertos + " ->>> " + numeroLinha);
					numeroLinha++;
					incrementaRegressiva();
				}
				
				//lbRegressiva.setText(""+numeroLinha);
				
			} // Fecha do while

			writer.close();
			reader.close();
			arqDestino.delete();
			System.out.println("Arquivo renomeado com sucesso " + arqTemporario.renameTo(arqDestino));

		} // Fecha do while

		finalmente.close();

		try {
			(new File("C://temp//original.txt")).delete();
			(new File("C://temp//destino.tmp")).delete();
		} catch (SecurityException e) {
			e.printStackTrace();
		} // Fecha try/catch para apagar arquivos temporários

	} // Fecha Desdobra

}
