package gameoflife;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Grid {
    private Cell[][] cells;
    private int sizeGrid;
    private Random rd;
    private String temp = "";
    private Integer isAlive = 0;
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

    public void generateNextState() {
        for (int i = 0; i < sizeGrid; i++){
            for (int j =0; j < sizeGrid ; j++) {
                for (int k = 0; k < sizeGrid; k++){
                    for (int l = 0; l  < sizeGrid ; l++) {

                        cells[i][j].setIsAlive(isCellAlive);
                    }
                }
            }
        }

        System.out.println("Il y a : " + isAlive + " Cellules en vie");
    }

    public String toString() {
        for (int i = 0; i < this.sizeGrid; i++){
            Cell[] myRow = this.cells[i]; // get 1 row of cells
            for(int j = 0; j < myRow.length; j++){
                if(myRow[j] == myRow[myRow.length - 1]){    // if the last cell of the row
                    this.temp = temp + myRow[j];            // We just add add the cell to the string
                } else  this.temp = temp + myRow[j] + " ";  // Else we put the cell to the string + a space
            }
            if(i != sizeGrid - 1){
                this.temp = this.temp + "\n"; // If its not the last row we put an \n
            }
        }
        System.out.println(this.temp);
        return this.temp;
    }
}
