package gameoflife;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Grid {
    private Cell[][] cells;
    private Cell[][] tmpC;
    private int sizeGrid;
    private Random rd;
    private String temp = "";
    private Integer NbAlive = 0;
    private Boolean isCellAlive;


    public Grid(int sizeGrid) {
        this.rd = new Random();
        this.sizeGrid = sizeGrid;
        generateRandomInitialState();
    }

    Grid(int sizeGrid, Cell[][] cells) {
        this.sizeGrid = sizeGrid;
        this.cells = cells;
    }

    private void generateRandomInitialState() {


    }

    private void Corner(int i, int j) { // Check all corners

        if (i == 0 && j == 0) {             // For the top-left corner
            if (cells[0][1].isAlive()) NbAlive++;
            if (cells[1][0].isAlive()) NbAlive++;
            if (cells[1][1].isAlive()) NbAlive++;

            isCellAlive = Cell.processState(cells[i][j].isAlive(), NbAlive);
            tmpC[i][j].setIsAlive(isCellAlive);

        }

        if (i == sizeGrid - 1 && j == sizeGrid - 1) {       // For the bottom-right corner
            if (cells[sizeGrid - 1][sizeGrid - 2].isAlive()) NbAlive++;
            if (cells[sizeGrid - 2][sizeGrid - 1].isAlive()) NbAlive++;
            if (cells[sizeGrid - 2][sizeGrid - 2].isAlive()) NbAlive++;

            isCellAlive = Cell.processState(cells[i][j].isAlive(), NbAlive);
            tmpC[i][j].setIsAlive(isCellAlive);

        }

        if (i == sizeGrid - 1 && j == 0) {       // For the bottom-left corner
            if (cells[sizeGrid - 2][0].isAlive()) NbAlive++;
            if (cells[sizeGrid - 2][1].isAlive()) NbAlive++;
            if (cells[sizeGrid - 1][1].isAlive()) NbAlive++;

            isCellAlive = Cell.processState(cells[i][j].isAlive(), NbAlive);
            tmpC[i][j].setIsAlive(isCellAlive);

        }

        if (i == 0 && j == sizeGrid - 1) {       // For the top-right corner
            if (cells[0][sizeGrid - 2].isAlive()) NbAlive++;
            if (cells[1][sizeGrid - 2].isAlive()) NbAlive++;
            if (cells[1][sizeGrid - 1].isAlive()) NbAlive++;

            isCellAlive = Cell.processState(cells[i][j].isAlive(), NbAlive);
            tmpC[i][j].setIsAlive(isCellAlive);

        }
    }

    private void side(int i, int j) {


        if (i > 0 && i < sizeGrid - 1 && j == 0) {       // For the left range
            avoidDupli(i, j);

            isCellAlive = Cell.processState(cells[i][j].isAlive(), NbAlive);
            tmpC[i][j].setIsAlive(isCellAlive);
        }


        if (j > 0 && j < sizeGrid - 1 && i == 0) {      // For the top range
            System.out.println(cells[i][j]);
            if (cells[i][j - 1].isAlive()) NbAlive++;
            if (cells[i + 1][j - 1].isAlive()) NbAlive++;
            if (cells[i + 1][j].isAlive()) NbAlive++;
            if (cells[i + 1][j + 1].isAlive()) NbAlive++;
            if (cells[i][j + 1].isAlive()) NbAlive++;

            isCellAlive = Cell.processState(cells[i][j].isAlive(), NbAlive);
            tmpC[i][j].setIsAlive(isCellAlive);
            System.out.println(" 94" + NbAlive);
        }
        // System.out.println(cells[i][j]);

        if (j > 0 && j < sizeGrid - 1 && i == sizeGrid - 1) {  // For the bottom range
            if (cells[i][j - 1].isAlive()) NbAlive++;
            if (cells[i - 1][j - 1].isAlive()) NbAlive++;
            if (cells[i - 1][j].isAlive()) NbAlive++;
            if (cells[i - 1][j + 1].isAlive()) NbAlive++;
            if (cells[i][j + 1].isAlive()) NbAlive++;

            isCellAlive = Cell.processState(cells[i][j].isAlive(), NbAlive);
            tmpC[i][j].setIsAlive(isCellAlive);

        }

        if (i > 0 && i < sizeGrid - 1 && j == sizeGrid - 1) {  // For the right range
            if (cells[i - 1][j].isAlive()) NbAlive++;
            if (cells[i - 1][j - 1].isAlive()) NbAlive++;
            if (cells[i][j - 1].isAlive()) NbAlive++;
            if (cells[i + 1][j - 1].isAlive()) NbAlive++;
            if (cells[i + 1][j].isAlive()) NbAlive++;

            isCellAlive = Cell.processState(cells[i][j].isAlive(), NbAlive);
            tmpC[i][j].setIsAlive(isCellAlive);
        }
    }

    private void avoidDupli(int i, int j) {
        if (cells[i - 1][j].isAlive()) NbAlive++;
        if (cells[i - 1][j + 1].isAlive()) NbAlive++;
        if (cells[i][j + 1].isAlive()) NbAlive++;
        if (cells[i + 1][j + 1].isAlive()) NbAlive++;
        if (cells[i + 1][j].isAlive()) NbAlive++;
    }

    private void cellIn(int i, int j) {

        if (i != 0 && j != 0 && j != sizeGrid - 1 && i != sizeGrid - 1) {

            avoidDupli(i, j);
            if (cells[i - 1][j - 1].isAlive()) NbAlive++;
            if (cells[i + 1][j - 1].isAlive()) NbAlive++;
            if (cells[i][j - 1].isAlive()) NbAlive++;

            isCellAlive = Cell.processState(cells[i][j].isAlive(), NbAlive);
            tmpC[i][j].setIsAlive(isCellAlive);
        }

    }

    public void generateNextState() {
        tmpC = cells.clone();
        for (int i = 0; i < sizeGrid; i++) {
            for (int j = 0; j < sizeGrid; j++) { // Select the cell to look on

                side(i, j);
                Corner(i, j);
                cellIn(i, j);

                NbAlive = 0;
            }
        }
        for (int i = 0; i < sizeGrid; i++) {
            for (int j = 0; j < sizeGrid; j++) { // Select the cell to look on
                System.out.println("tmp : " + tmpC[i][j]);
                System.out.println("cells :" + cells[i][j]);
            }
        }
        cells = tmpC.clone();
    }


    public String toString() {
        for (int i = 0; i < this.sizeGrid; i++) {
            Cell[] myRow = this.cells[i]; // get 1 row of cells
            for (int j = 0; j < myRow.length; j++) {
                if (myRow[j] == myRow[myRow.length - 1]) {    // if the last cell of the row
                    this.temp = this.temp + myRow[j];            // We just add add the cell to the string
                } else this.temp = this.temp + myRow[j] + " ";  // Else we put the cell to the string + a space
            }
            if (i != sizeGrid - 1) {
                this.temp = this.temp + "\n"; // If its not the last row we put an \n
            }
        }
        System.out.println(this.temp);
        return this.temp;
    }
}
