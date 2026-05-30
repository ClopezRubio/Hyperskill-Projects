import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);

        String[] inputArray = sc.nextLine().split(" ");

        boolean condition = true;

        for(int i = 1; i < inputArray.length; i++){
            int comparison = inputArray[i-1].compareTo(inputArray[i]);
            if(comparison == 0  ||  comparison < 0){
                condition = true;
            }else if(comparison > 0){
                condition = false;
            }
        }

        System.out.println(condition);
    }
}