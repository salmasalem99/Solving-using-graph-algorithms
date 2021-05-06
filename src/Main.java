

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Question1 one = new Question1();
        Question2 two = new Question2();
        Question3 three = new Question3();

        System.out.println("Hello!");

        while (true) {
            System.out.println("Please Choose One Of The Following\n1) Question 1 \n2) Question 2 \n3) Question 3");
            int x = scan.nextInt();
            switch (x) {
                case 1:
                    one.PartOne();
                    break;

                case 2:
                    two.PartTwo();
                    break;

                case 3:
                    three.PartThree();

                default:
                    System.out.println("Please Choose 1,2 or 3 Only");
                    break;
            }


        }
    }
}



