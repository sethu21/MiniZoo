public class Spider extends AbstractAnimal {

    private String hasHair;
    private String legType;

    // Default constructor
    public Spider() {
        super();
        this.hasHair = "";
        this.legType = "";
    }

    // Constructor that assigns values to class and superclass variables
    public Spider(int id, String title, FoodType foodType, String hasHair, String legType) {
        super(id, title, foodType);
        this.hasHair = hasHair;
        this.legType = legType;
        setAnimalCode(); // Setting animalCode
    }

    // Getters


    public String getLegType() {
        return legType;
    }
    public String getAnimalCode() {
        return animalCode;
    }



    @Override
    public void setAnimalCode() {
        String animalId = String.valueOf(getId());
        String firstLetter = "S"; // First letter of Spider
        String title = getTitle().replaceAll("\\s+", "_"); // Replace spaces in title with underscore
        String legType = getLegType(); // Get the value of legType
        this.animalCode = firstLetter + "_" + animalId + "_" + title + "_" + legType;
    }

    // toString function
    @Override
    public String toString() {
        return super.toString() + ", Has Hair: " + hasHair + ", Leg Type: " + legType;
    }
}
