public class Coke implements Drink {
    private int price;
    private int quantityLeft;
    private String name;
    public void serveDrink() {
        this.quantityLeft = quantityLeft-1;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setQuantityLeft(int quantityLeft) {
        this.quantityLeft = quantityLeft;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantityLeft() {
        return quantityLeft;
    }

    public String getName() {
        return name;
    }
}
