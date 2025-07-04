package org.example.tictaktoe;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

import java.util.ArrayList;
import java.util.List;

import static java.util.List.of;

public class HelloController {
    @FXML private int clickCounter = 1;
    @FXML private GridPane gridPane;

    @FXML private StackPane c00, c01, c02, c10, c11, c12, c20, c21, c22;

    List<StackPane> stacks;

    public int getClickCounter(){
        return clickCounter;
    }

    public void setClickCounter(int value){
        this.clickCounter = value;
    }

    @FXML
    public void initialize()
    {
        stacks = List.of(c00, c01, c02, c10, c11, c12, c20, c21, c22);
        actionWhenClicked();
    }

    public void actionWhenClicked()
    {
        gridPane.setOnMouseClicked(mouseEvent -> {
            double mouseX = mouseEvent.getX();
            double mouseY = mouseEvent.getY();

            int colCount = gridPane.getColumnCount();
            int rowCount = gridPane.getRowCount();

            double colWidth = gridPane.getWidth() / colCount;
            double rowHeight = gridPane.getHeight() / rowCount;

            int clickedCol = (int)(mouseX / colWidth);
            int clickedRow = (int)(mouseY / rowHeight);
        //    System.out.println(clickedCol + " " + clickedRow);
            StackPane cell = getCell(clickedCol, clickedRow);

            if (!cell.getChildren().isEmpty()) return;

            int numbersClicked = getClickCounter();
            setClickCounter(numbersClicked + 1);

            String symbol;
            if (getClickCounter() % 2 == 1)
                symbol = "X";
            else
                symbol = "O";

            Label newLabel = new Label(symbol);
            newLabel.setStyle("-fx-font-size: 68;");
            cell.getChildren().add(newLabel);
            checkGame(cell, clickedCol, clickedRow, symbol, colCount, rowCount);
        });
    }

    public void checkGame(StackPane cell, int col, int row, String symbol, int colCount, int rowCount)
    {
        int checked = 1;
        int currentCol = col - 1;
        int currentRow = row;
        while(currentCol >= 0)
        {
            StackPane tmpStack = getCell(currentCol, currentRow);
            if (tmpStack.getChildren().isEmpty()) break;
            Node node = tmpStack.getChildren().get(0);
            if (node instanceof Label label)
            {
                String currentSymbol = label.getText();

                if (currentSymbol.equals(symbol))
                    checked++;
                else
                    break;
            }
            currentCol--;
        }

        currentCol = col + 1;
        while(currentCol < colCount)
        {
            StackPane tmpStack = getCell(currentCol, currentRow);
            if (tmpStack.getChildren().isEmpty()) break;
            Node node = tmpStack.getChildren().get(0);
            if (node instanceof Label label)
            {
                String currentSymbol = label.getText();

                if (currentSymbol.equals(symbol))
                    checked++;
                else
                    break;
            }
            currentCol++;
        }
        checkWinner(checked, symbol);
        checked = 1;
        currentCol = col;
        currentRow = row - 1;
        while(currentRow >= 0)
        {
            StackPane tmpStack = getCell(currentCol, currentRow);
            if(tmpStack.getChildren().isEmpty()) break;
            Node node = tmpStack.getChildren().get(0);
            if (node instanceof Label label)
            {
                String currentSymbol = label.getText();
                if (currentSymbol.equals(symbol))
                {
                    checked++;
                } else
                    break;
            }
            currentRow--;
        }

        currentRow = row + 1;

        while(currentRow < rowCount)
        {
            StackPane tmpStack = getCell(currentCol, currentRow);
            if(tmpStack.getChildren().isEmpty()) break;
            Node node = tmpStack.getChildren().get(0);
            if (node instanceof Label label)
            {
                String currentSymbol = label.getText();
                if (currentSymbol.equals(symbol))
                {
                    checked++;
                } else
                    break;
            }
            currentRow++;
        }

        checkWinner(checked, symbol);

        checked = 1;
        currentCol = col - 1;
        currentRow = row - 1;
        while(currentRow >= 0 && currentCol >= 0)
        {
            StackPane tmpStack = getCell(currentCol, currentRow);
            if(tmpStack.getChildren().isEmpty()) break;
            Node node = tmpStack.getChildren().get(0);
            if (node instanceof Label label)
            {
                String currentSymbol = label.getText();
                if (currentSymbol.equals(symbol))
                {
                    checked++;
                } else
                    break;
            }
            currentRow--;
            currentCol--;
        }

        currentRow = row + 1;
        currentCol = col + 1;

        while(currentRow < rowCount && currentCol < colCount)
        {
            StackPane tmpStack = getCell(currentCol, currentRow);
            if(tmpStack.getChildren().isEmpty()) break;
            Node node = tmpStack.getChildren().get(0);
            if (node instanceof Label label)
            {
                String currentSymbol = label.getText();
                if (currentSymbol.equals(symbol))
                {
                    checked++;
                } else
                    break;
            }
            currentRow++;
            currentCol++;
        }

        checkWinner(checked, symbol);

        checked = 1;
        currentCol = col - 1;
        currentRow = row + 1;
        while(currentRow < rowCount && currentCol >= 0)
        {
            StackPane tmpStack = getCell(currentCol, currentRow);
            if(tmpStack.getChildren().isEmpty()) break;
            Node node = tmpStack.getChildren().get(0);
            if (node instanceof Label label)
            {
                String currentSymbol = label.getText();
                if (currentSymbol.equals(symbol))
                {
                    checked++;
                } else
                    break;
            }
            currentRow++;
            currentCol--;
        }

        currentRow = row - 1;
        currentCol = col + 1;

        while(currentRow >= 0 && currentCol < colCount)
        {
            StackPane tmpStack = getCell(currentCol, currentRow);
            if(tmpStack.getChildren().isEmpty()) break;
            Node node = tmpStack.getChildren().get(0);
            if (node instanceof Label label)
            {
                String currentSymbol = label.getText();
                if (currentSymbol.equals(symbol))
                {
                    checked++;
                } else
                    break;
            }
            currentRow--;
            currentCol++;
        }

        checkWinner(checked, symbol);
    }

    public void checkWinner(int checked, String symbol)
    {
        if (checked >= 3)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("GAME OVER");
            alert.setHeaderText("GAME OVER");
            alert.setContentText(symbol + " WINS!");
            alert.showAndWait();

            restartGame();
        }
    }

    public void restartGame()
    {
        for (StackPane stack : stacks)
        {
            stack.getChildren().clear();
        }
    }

    private StackPane getCell(int col, int row) {
        String id = "c" + col + row;
        return switch (id) {
            case "c00" -> c00;
            case "c01" -> c01;
            case "c02" -> c02;
            case "c10" -> c10;
            case "c11" -> c11;
            case "c12" -> c12;
            case "c20" -> c20;
            case "c21" -> c21;
            case "c22" -> c22;
            default -> null;
        };
    }
}