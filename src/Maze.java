

import java.util.ArrayList;
import java.util.Scanner;

public class Maze {
    int AdjacencyMatrix[][];
    Scanner scan;
    ArrayList<String> moves;
    int Rows;
    int cell;
    String check;


    public Maze(int number, Scanner scan) {
        AdjacencyMatrix = new int[number][number];
        this.scan = scan;
        this.Rows = number;
        moves = new ArrayList<>();
        setCells();
    }

    public void setCells() {
        this.cell = this.Rows - 1;
        this.check = "(" + cell + cell + ")";
    }

    public void EnterData() {
        for (int i = 0; i < this.Rows; i++) {
            for (int j = 0; j < this.Rows; j++) {
                AdjacencyMatrix[i][j] = scan.nextInt();
            }
        }
    }

    public void printMatrix() {
        System.out.println("Your Matrix is : ");

        for (int i = 0; i < this.Rows; i++) {
            for (int j = 0; j < this.Rows; j++) {
                System.out.print(AdjacencyMatrix[i][j] + "\t");
            }

            System.out.println();
        }
    }


    public boolean FindPath(int i,int j){

        String move ="("+i+j+")";

        if (i>Rows-1 || j>Rows-1 || i==-1 || j==-1){
            return false;}

        if (("("+i+j+")").equals(check)){
            moves.add(move);
            return true;}

        if(AdjacencyMatrix[i][j]!=0){
            return false; }

        if(moves.contains(move))
            return false;
        moves.add(move);

        if(FindPath(i,j+1))
            return true;

        if(FindPath(i,j-1))
            return true;

        if(FindPath(i+1,j))
            return true;

        if(FindPath(i-1,j))
            return true;

        moves.remove(move);
        return false;
    }
}

