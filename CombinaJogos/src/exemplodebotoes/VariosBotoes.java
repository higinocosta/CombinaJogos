package exemplodebotoes;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class VariosBotoes extends Application {
	ArrayList<Integer> listOfnumbers = new ArrayList<Integer>();
	private final IntegerProperty value = new SimpleIntegerProperty();

	class NumberButtonHandler implements EventHandler<ActionEvent> {
		private final int number;

		NumberButtonHandler(int number) {
			this.number = number;
		}

		@Override
		public void handle(ActionEvent event) {
			
			ToggleButton source = (ToggleButton) event.getSource();
			if (source.isSelected()) {
				value.set(number);
				listOfnumbers.add(number);
			} else {
				listOfnumbers.remove(Integer.valueOf(number));
			}
			
			System.out.println(value.get());
			System.out.println(listOfnumbers);
		}
	}
		
	@Override
	public void start(Stage primaryStage) throws Exception {
		GridPane grid = createGrid();
		for (int n = 1; n <= 60; n++) {
			ToggleButton button = createNumberButton(n);
			int row = (n - 1) / 10;
			int col = (n - 1) % 10;
			grid.add(button, col, row);
		}
		BorderPane root = new BorderPane();
		root.setPadding(new Insets(10));
		root.setCenter(grid);
		Scene scene = new Scene(root, 400, 300);
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	private ToggleButton createNumberButton(int number) {
		ToggleButton button = createButton(Integer.toString(number));
		button.setOnAction(new NumberButtonHandler(number));
		return button;
	}

	private ToggleButton createButton(String text) {
		ToggleButton button = new ToggleButton(text);
		button.setMaxSize(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
		GridPane.setFillHeight(button, true);
		GridPane.setFillWidth(button, true);
		GridPane.setHgrow(button, Priority.ALWAYS);
		GridPane.setVgrow(button, Priority.ALWAYS);
		return button;
	}

	private GridPane createGrid() {
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(5);
		grid.setVgap(5);
		grid.setPadding(new Insets(10));
		return grid;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
