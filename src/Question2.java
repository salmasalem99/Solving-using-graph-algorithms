

import java.util.Scanner;

public class Question2 {

    public void PartTwo(){
    Scanner scan = new Scanner(System.in);
        System.out.println("Enter Number Of Rows & Columns\t");
        Maze MyGraph = new Maze(scan.nextInt(), scan);

        System.out.println("Enter Matrix\t");
        MyGraph.EnterData();

        MyGraph.printMatrix();
        MyGraph.FindPath(0,0);
        System.out.println("Number of moves: "+MyGraph.moves.size());

        for (String num : MyGraph.moves) {
            System.out.println(num);
        }
        if(MyGraph.moves.size()==0)
            System.out.println("No Paths Exist");

}
}
