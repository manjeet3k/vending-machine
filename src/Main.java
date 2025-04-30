import exception.InsufficientMoneyExpeption;
import exception.OutOfStockException;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws OutOfStockException, InsufficientMoneyExpeption {
        System.out.println("Welcome to a simple vending machine.");
        System.out.println("Please provide the output in sequence. Refer to the readme File for input format");
        Scanner sc = new Scanner(System.in);

        int[] quantity = new int[3];
        int[] price = new int[3];
        int[] button = new int[3];

        System.out.println("Please provide the quantities of Coke, Fanta and Sprite");
        for(int i=0;i<3;i++) {
            quantity[i] = sc.nextInt();
        }

        System.out.println("Please provide the Price per unit of Coke, Fanta and Sprite");
        for(int i=0;i<3;i++) {
            price[i] = sc.nextInt();
        }

        System.out.println("Please provide the button assigned to Coke, Fanta and Sprite");
        for(int i=0;i<3;i++) {
            button[i] = sc.nextInt();
        }

        Coke coke = new Coke();
        coke.setQuantityLeft(quantity[0]);
        coke.setPrice(price[0]);
        coke.setName("Coke");

        Fanta fanta = new Fanta();
        fanta.setQuantityLeft(quantity[1]);
        fanta.setPrice(price[1]);
        fanta.setName("Fanta");

        Sprite sprite = new Sprite();
        sprite.setQuantityLeft(quantity[2]);
        sprite.setPrice(price[2]);
        sprite.setName("Sprite");


        ManageDrinks manageDrinks = new ManageDrinks();
        manageDrinks.registerDrink(button[0], coke);
        manageDrinks.registerDrink(button[1], fanta);
        manageDrinks.registerDrink(button[2], sprite);

        System.out.println("------Vending Machine Set------");

        System.out.println("Enter number of queries");
        int n = sc.nextInt();

        for(int i=0;i<n;i++) {

            int buttonIdx = sc.nextInt();
            int money = sc.nextInt();
            try {
                DispatchDrink dispatchedDrink = manageDrinks.getDrink(buttonIdx, money);
                System.out.println(dispatchedDrink.getDrink().getName()+ " " + dispatchedDrink.getChange());
            } catch (InsufficientMoneyExpeption | OutOfStockException ex) {
                System.out.println(ex.getMessage());
            }
        }


    }
}