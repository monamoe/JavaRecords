/**
 * 1, Abdulrahman, Blizzard Road, Mississauga, Apple Juice, 10.0, 1,
 * 2, Sam, Farm, Brampton, Orange Juice, 12.0, 1,
 * 3, Spencer, Mississauga Road, Mississauga, Apple, 10.0, 10,
 * 4, Riley, Farm, Caledon, Orange, 13.0, 1,  *
 */
package finalproject;

public class Order {

    private int orderID;
    private String name;
    private String address;
    private String city;
    private String product;
    private double price;
    private int quantity;

    public Order(int orderIDInput) {
        this.orderID = orderIDInput;

    }

    // Setters and Getters //
    public int getOrderID() {
        return orderID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
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
        String orderID = "" + this.getOrderID();
        String name = this.getName();
        String city = this.getCity();
        String address = this.getAddress();
        String product = this.getProduct();
        String price = "" + this.getPrice();
        String quantity = "" + this.getQuantity();

        String output = "OrderID " + orderID + ", " + name + ", "
                + this.getCity()
                + " - " + this.getAddress() + ", " + this.getProduct()
                + ", $"
                + this.getPrice() + ", " + this.getQuantity() + " units.";

        return output;
    }

}
