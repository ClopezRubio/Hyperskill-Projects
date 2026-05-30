package lastpencil;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {

        gameplay();

    }

    static int checkIntInput(){
        while(true){
            String line = sc.nextLine().trim();
            if(line.isEmpty()){
                System.out.println("The number of pencils should be numeric");
                continue;
            }
            try {
                return Integer.parseInt(line);
            } catch(NumberFormatException e){
                System.out.println("The number of pencils should be numeric");
            }
        }
    }

    static int checkPencilsOut(int numOfPencils){
        while(true){
            String line = sc.nextLine().trim();
            if(line.isEmpty()){
                System.out.println("Possible values: '1', '2' or '3'");
                continue;
            }
            try {
                int value = Integer.parseInt(line);
                if(value < 1 || value > 3){
                    System.out.println("Possible values: '1', '2' or '3'");
                } else if(value > numOfPencils){
                    System.out.println("Too many pencils were taken");
                } else {
                    return value;
                }
            } catch(NumberFormatException e){
                System.out.println("Possible values: '1', '2' or '3'");
            }
        }
    }

    static int botMove(int numOfPencils){
        if(numOfPencils % 4 == 0){
            return 3;
        }else if(numOfPencils % 4 == 3){
            return 2;
        }else if(numOfPencils % 4 == 2){
            return 1;
        }else{
            return random.nextInt(3 - 1 + 1) + 1;
        }
    }

    static void gameplay() {

        // Asking for initial number of pencils and making sure it's a number
        System.out.println("How many pencils would you like to use:");
        int numOfPencils = checkIntInput();

        // Making sure the number is > 0
        while(numOfPencils <= 0){
            if(numOfPencils == 0){
                System.out.println("The number of pencils should be positive");
            }else{
                System.out.println("The number of pencils should be numeric");
            }
            numOfPencils = checkIntInput();
        }

        // Asking for who's going to start the game
        System.out.println("Who will be the first (John, Jack):");
        String firstTurn = sc.nextLine();
        while(!firstTurn.equals("John") && !firstTurn.equals("Jack")){
            System.out.println("Choose between 'John' and 'Jack'");
            firstTurn = sc.nextLine();
        }

        // Showing the initial amount of pencils
        for (int i = 1; i <= numOfPencils; i++) {
            System.out.print("|");
        }

        System.out.println("");

        while (true) {

            if (numOfPencils <= 0) {
                break;
            }

            int pencilsOut;

            if(firstTurn.equals("John")){
                System.out.println("John's turn!");
                pencilsOut = checkPencilsOut(numOfPencils);
            }else{
                System.out.println("Jack's turn:");
                pencilsOut = botMove(numOfPencils);
                System.out.println(pencilsOut);
            }

            if (pencilsOut >= numOfPencils) {
                if (firstTurn.equals("John")) {
                    firstTurn = "Jack";
                } else if (firstTurn.equals("Jack")) {
                    firstTurn = "John";
                }
                System.out.println(firstTurn + " won!");
                break;
            }

            numOfPencils -= pencilsOut;

            for (int i = 1; i <= numOfPencils; i++) {
                System.out.print("|");
            }

            System.out.println("");

            if (firstTurn.equals("John")) {
                firstTurn = "Jack";
            } else if (firstTurn.equals("Jack")) {
                firstTurn = "John";
            }

        }

    }
}
