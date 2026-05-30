import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here

        String shape =  scanner.nextLine();

        switch (shape) {
            case "triangle":
                double sideA = scanner.nextDouble();
                double sideB = scanner.nextDouble();
                double sideC = scanner.nextDouble();
                double p = (sideA + sideB + sideC) / 2;
                double area = Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
                System.out.println(area);
                break;
            case "rectangle":
                double sideA1 = scanner.nextDouble();
                double sideA2 = scanner.nextDouble();
                System.out.println(sideA1 * sideA2);
                break;
            case "circle":
                double radius =  scanner.nextDouble();
                System.out.println((radius*radius) * 3.14);
                break;
        }
    }
}