package Sprint;

class Goods implements Comparable<Goods> {
    private String name;
    private double price;
    private int quantity;

    public Goods(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Goods() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return name + "; " + price + "; " + quantity;
    }

    @Override
    public int compareTo(Goods o) {
        if ((this.price * this.quantity) > (o.price * o.quantity)) {
            return 1;
        } else {
            return -1;
        }
    }
}
