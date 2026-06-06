package machine;

import java.util.Scanner;

public class CoffeeMachine {

    public static void main(String[] args) {

        CoffeeMachine coffeeMachine = new CoffeeMachine();

        coffeeMachine.start();

    }

    static Scanner sc = new Scanner(System.in);

    static int availableWater;
    int availableMilk;
    int availableCoffee;
    int moneyStored;
    int availableCups;
    int cupOfCoffeeCount;

    Coffee espresso = new Coffee(250, 16, 0, 4);
    Coffee latte = new Coffee(350, 20, 75, 7);
    Coffee capuccino = new Coffee(200, 12, 100, 6);


    public CoffeeMachine() {
        availableWater = 400;
        availableMilk = 540;
        availableCoffee = 120;
        moneyStored = 550;
        availableCups = 9;
        cupOfCoffeeCount = 0;
    }

    public int getAvailableWater() {
        return availableWater;
    }

    public void setAvailableWater(int availableWater) {
        this.availableWater = availableWater;
    }

    public int getAvailableCoffee() {
        return availableCoffee;
    }

    public void setAvailableCoffee(int availableCoffee) {
        this.availableCoffee = availableCoffee;
    }

    public int getAvailableMilk() {
        return availableMilk;
    }

    public void setAvailableMilk(int availableMilk) {
        this.availableMilk = availableMilk;
    }

    public int getMoneyStored() {
        return moneyStored;
    }

    public void setMoneyStored(int moneyStored) {
        this.moneyStored = moneyStored;
    }

    public int getAvailableCups() {
        return availableCups;
    }

    public void setAvailableCups(int availableCups) {
        this.availableCups = availableCups;
    }

    public String toString(){
        return "The coffee machine has:\n" +
                getAvailableWater()+" ml of water\n" +
                getAvailableMilk()+" ml of milk\n" +
                getAvailableCoffee()+" g of coffee beans\n" +
                getAvailableCups()+" disposable cups\n" +
                "$" + getMoneyStored() + " of money\n";
    }

    // Program methods
    public void start(){

        doAction();

    }

    public void doAction(){
        boolean loop = true;

        while(loop){
            System.out.println("Write action (buy, fill, take, clean, remaining, exit):");
            String action = sc.nextLine();

            switch (action){
                case "buy":
                    if(cupOfCoffeeCount < 10) {
                        buyCoffee();
                    }else{
                        System.out.println("I need cleaning!");
                    }
                    break;
                case "fill":
                    fillMachine();
                    break;
                case "take":
                    System.out.println("I gave you $" + getMoneyStored() + "\n");
                    setMoneyStored(0);
                    break;
                case "clean":
                    System.out.println("I have been cleaned!");
                    cupOfCoffeeCount = 0;
                    break;
                case "remaining":
                    System.out.println(this.toString());
                    break;
                case "exit":
                    loop = false;
                    break;
            }
        }

    }

    public void buyCoffee(){
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String choice = sc.nextLine();
        switch (choice){
            case "1":
                makeCoffee(espresso);
                System.out.println("");
                break;
            case "2":
                makeCoffee(latte);
                System.out.println("");
                break;
            case "3":
                makeCoffee(capuccino);
                System.out.println("");
                break;
            case "back":
                return;
        }
    }

    public void makeCoffee(Coffee coffee){

        if(getAvailableWater() < coffee.getWater()){
            System.out.println("Sorry, not enough water!");
            return;
        }else if(getAvailableMilk() < coffee.getMilk()){
            System.out.println("Sorry, not enough milk!");
            return;
        }else if(getAvailableCoffee()< coffee.getCoffee()){
            System.out.println("Sorry, not enough coffee!");
            return;
        }else if(getAvailableCups() < 1){
            System.out.println("Sorry, not enough cups!");
            return;
        }

        System.out.println("I have enough resources, making you a coffee!");
        setAvailableWater(getAvailableWater() - coffee.getWater());
        setAvailableMilk(getAvailableMilk() - coffee.getMilk());
        setAvailableCoffee(getAvailableCoffee() - coffee.getCoffee());
        setAvailableCups(getAvailableCups() - 1);
        setMoneyStored(getMoneyStored() + coffee.getCost());
        cupOfCoffeeCount++;
    }

    public void fillMachine(){
        System.out.println("Write how many ml of water you want to add: ");
        setAvailableWater(sc.nextInt() + getAvailableWater());
        System.out.println("Write how many ml of milk you want to add: ");
        setAvailableMilk(sc.nextInt() + getAvailableMilk());
        System.out.println("Write how many grams of coffee beans you want to add: ");
        setAvailableCoffee(sc.nextInt() + getAvailableCoffee());
        System.out.println("Write how many disposable cups you want to add: ");
        setAvailableCups(sc.nextInt() + getAvailableCups());
        sc.nextLine();
        System.out.println("");
    }

}

class Coffee{

    private int water;
    private int coffee;
    private int milk;
    private int cost;

    public Coffee(int water, int coffee, int milk, int cost) {
        this.water = water;
        this.coffee = coffee;
        this.milk = milk;
        this.cost = cost;
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public int getCoffee() {
        return coffee;
    }

    public void setCoffee(int coffee) {
        this.coffee = coffee;
    }

    public int getMilk() {
        return milk;
    }

    public void setMilk(int milk) {
        this.milk = milk;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}