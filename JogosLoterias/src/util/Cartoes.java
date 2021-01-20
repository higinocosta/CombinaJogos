package util;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

public class Cartoes {
	ArrayList<Integer> listOfnumbers = new ArrayList<Integer>();
	private final IntegerProperty value = new SimpleIntegerProperty();
	NumberFormat f = new DecimalFormat("00");

	class NumberButtonHandler implements EventHandler<ActionEvent> {
		private final int number;

		NumberButtonHandler(int number) {
			this.number = number;
		}

		@Override
		public void handle(ActionEvent event) {
			
			ToggleButton source = (ToggleButton) event.getSource();
			if (source.isSelected()) {
				source.setStyle("-fx-background-radius: 50; -fx-color: blue");
				value.set(number);
				listOfnumbers.add(number);
			} else {
				listOfnumbers.remove(Integer.valueOf(number));
				source.setStyle("-fx-background-radius: 50;");
			}
			
			System.out.println(value.get());
			System.out.println(listOfnumbers);
		}
	}
		
	public GridPane Cartoes(final int linhas,final int colunas, final int minimo, final int max) throws Exception {
		GridPane grid = createGrid();
		for (int n = minimo; n <= max; n++) {
			ToggleButton button = createNumberButton(n);
			int row = (n - 1) / colunas;
			int col = (n - 1) % colunas;
			grid.add(button, col, row);
		}
		return grid;
	}

	private ToggleButton createNumberButton(int number) {
		if (number == 100) number = 0;
		ToggleButton button = createButton(f.format(number));
		button.setOnAction(new NumberButtonHandler(number));
		button.setStyle("-fx-background-radius: 50;");
		//button.set
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
		grid.setPadding(new Insets(5));
		return grid;
	}
}
