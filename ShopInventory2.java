import java.util.Stack;
import java.util.Queue;
import java.util.Map;
import java.util.LinkedList;
import java.util.LinkedHashMap;

class Item {
    private String name; 
    private double price; 

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}




class Basket {
    final Stack<Item> basket;

    Basket() {
        this.basket = new Stack<Item>();
    }

    public void addItem(Item item) {
        basket.push(item);
    }

    public Item removeItem() {
        return basket.pop();
    }

    public String toString() {
        return "basket:" + this.basket.toString();
    }
}

class Checkout {
    Queue<Item> checkout;

    Checkout(Basket basket) {
        this.checkout = new LinkedList<Item>();
        while(!basket.basket.isEmpty()) {
            checkout.add(basket.removeItem());
    }}
    

    public void addItem(Item item) {
        checkout.add(item);
    }

    public Item removeItem() {
        return checkout.remove();
    }

    public String toString() {
        return "checkout:" + this.checkout.toString();
    }
}

class Bill {
    private Map<String,Integer> basket;
    private double price = 0.0;

    Bill(Checkout checkout) {
        /*TODO - initialise Map, set price, bill items from checkout*/
        this.basket = new LinkedHashMap<String,Integer>();
        while(!checkout.checkout.isEmpty()){
            billItem(checkout.removeItem());
        }}


    public void billItem(Item item) {
        // TODO - put item in map, keep count of same items being billed
        // Note that the Map is from String to Integer
        // Items have names as Strings and count of items is an integer
        this.price += item.getPrice();
        if (this.basket.containsKey(item.getName())){
        this.basket.put(item.getName(), this.basket.getOrDefault(item.getName(), 0) + 1);
        }
        else{
        this.basket.put(item.getName(), 1);
        }
    }

    public double getTotal() {
        return this.price;
    }

    public String toString() {
        String output = "";
        for(String item: this.basket.keySet()) {
            output += item + " (" + this.basket.get(item) + "nos)\n";
        }
        return output + "total: " + this.price;
    }
}

class ShopInventory2{
    public static void main(String[] args) {
    Basket basket = new Basket();
    loadBasket(basket);
    //System.out.println(basket); // for DEBUG
    Checkout checkout = new Checkout(basket);
    //System.out.println(checkout); // for DEBUG
    Bill bill = new Bill(checkout);
    System.out.println(bill);
    }

    static void loadBasket(Basket basket) {
        basket.addItem(new Item("Twinings Earl Grey Tea", 4.50));
        basket.addItem(new Item("Folans Orange Marmalade", 4.00));
        basket.addItem(new Item("Free-range Eggs", 3.35));
        basket.addItem(new Item("Brennan's Bread", 2.15));
        basket.addItem(new Item("Ferrero Rocher", 7.00));
        basket.addItem(new Item("Ferrero Rocher", 7.00));
    }
}