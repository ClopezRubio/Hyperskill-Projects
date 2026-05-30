import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        int arraySize = Integer.parseInt(scanner.nextLine());

        String[] inputArray = scanner.nextLine().split(" ");
        int[] arrayOfNums = new int[arraySize];

        for(int i = 0; i < arraySize; i++){
            arrayOfNums[i] = Integer.parseInt(inputArray[i]);
        }

        int helper[] = new int[arraySize];

        for (int i = 0; i < arrayOfNums.length; i++) {
            if (i == 0) {
                helper[i] = arrayOfNums[arraySize-1];
            } else {
                // caso general
                helper[i] = arrayOfNums[i-1];
            }
        }

        for (int i = 0; i < helper.length; i++) {
            if (i < helper.length - 1) {
                System.out.print(helper[i]+" ");
            } else {
                System.out.print(helper[i]);
            }
        }

    }
}