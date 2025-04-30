public class DispatchDrink {
    private Drink drink;
    private int change;

    public DispatchDrink(Drink drink, int change) {
        this.drink = drink;
        this.change = change;
    }

    public Drink getDrink() {
        return drink;
    }

    public int getChange() {
        return change;
    }
}
