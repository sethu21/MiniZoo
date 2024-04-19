import java.util.HashSet;
import java.util.Set;


public abstract class AbstractAnimal {

    private static Set<Integer> idSet = new HashSet<>(); // Set to ensure id uniqueness
    private int id;
    private String title;
    protected String animalCode;
    private FoodType foodType;

    // Default constructor
    public AbstractAnimal() {
        id = generateUniqueId();
        animalCode = "";
    }

    // Constructor with parameters
    public AbstractAnimal(int id, String title, FoodType foodType) {
        this.id = id;
        this.title = title;
        this.foodType = foodType;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAnimalCode() {
        return animalCode;
    }

    public FoodType getFoodType() {
        return foodType;
    }

    // Setters with validations


    public void setTitle(String title) {
        this.title = title;
    }

    public void setFoodType(FoodType foodType) {
        this.foodType = foodType;
    }

    // Abstract method for setting animalCode
    public abstract void setAnimalCode();


    @Override
    public String toString() {
        return "ID: " + id + ", Title: " + title + ", Animal Code: " + animalCode + ", Food Type: " + foodType;
    }

    // Generate a unique ID
    private int generateUniqueId() {
        int newId = (int) (Math.random() * 1000); // Generate a random ID
        while (idSet.contains(newId)) {
            newId = (int) (Math.random() * 1000);
        }
        idSet.add(newId);
        return newId;
    }
}
