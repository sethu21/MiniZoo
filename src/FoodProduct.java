import java.time.LocalDate;


public class FoodProduct {

    private int id;
    private String title;
    private int quantity;
    private LocalDate expiryDate;
    private FoodType foodType;


    // Constructor with parameters
    public FoodProduct(int id, String title, int quantity, LocalDate expiryDate, FoodType foodType) {
        this.id = id;
        this.title = title;
        this.quantity = quantity;
        this.expiryDate = expiryDate;
        this.foodType = foodType;
    }

    // Getters


    public int getQuantity() {
        return quantity;
    }


    public FoodType getFoodType() {
        return foodType;
    }


    @Override
    public String toString() {
        return "ID: " + id + ", Title: " + title + ", Quantity: " + quantity + ", Expiry Date: " + expiryDate + ", Food Type: " + foodType;
    }
}
