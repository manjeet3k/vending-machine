import exception.InsufficientMoneyExpeption;
import exception.OutOfStockException;

import java.util.HashMap;

public class ManageDrinks {
    HashMap<Integer, Drink> drinks = new HashMap<>();
    public void registerDrink(int button, Drink drink) {
        drinks.put(button, drink);
    }

    public DispatchDrink getDrink(int button, int money) throws InsufficientMoneyExpeption, OutOfStockException {
        Drink drink = drinks.get(button);
        int pricePerUnit = drink.getPrice();
        int quantityLeft = drink.getQuantityLeft();
        if(quantityLeft < 1) {
            String message = drink.getName() + " is out of stock.";
            throw new OutOfStockException(message);
        }

        if(money < pricePerUnit) {
            throw new InsufficientMoneyExpeption();
        }

        int change = money - pricePerUnit;
        drink.serveDrink();
        return new DispatchDrink(drink, change);

    }
}
