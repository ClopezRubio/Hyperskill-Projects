import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);

        int arraySize = Integer.parseInt(sc.nextLine());

        String numsInput = sc.nextLine();

        String[] nums = numsInput.split(" ");

        int[] arrayOfNums = new int[nums.length];

        for(int i = 0; i < arrayOfNums.length; i++) {
            arrayOfNums[i] = Integer.parseInt(nums[i]);
        }

        int n =  Integer.parseInt(sc.nextLine());

        int count = 0;

        for(int number : arrayOfNums) {
            if(number == n) {
                count++;
            }
        }

        System.out.println(count);



    }
}