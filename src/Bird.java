public class Bird extends AbstractAnimal {

    private String wingWidth;
    private Enum<FoodType> enumVar;

    // Default constructor
    public Bird() {
        super();
        this.wingWidth = "";
    }

    // Constructor that assigns values to class and superclass variables
    public Bird(int id, String title, FoodType foodType, String wingWidth, Enum<FoodType> enumVar) {
        super(id, title, foodType);
        this.wingWidth = wingWidth;
        this.enumVar = enumVar;
        setAnimalCode(); // Setting animalCode
    }

    // Setters
    public void setWingWidth(String wingWidth) {
        this.wingWidth = wingWidth;
    }
    public void setEnumVar(Enum<FoodType> enumVar) {
        this.enumVar = enumVar;
    }


    @Override
    public void setAnimalCode() {
        String animalId = String.valueOf(getId());
        String firstLetter = "B"; // First letter of Bird
        String title = getTitle().replaceAll("\\s+", "_"); // Replace spaces in title with underscore
        String enumVarStr = enumVar.name().toUpperCase();
        this.animalCode = firstLetter + "_" + animalId + "_" + title + "_" + enumVarStr;
    }


    @Override
    public String toString() {
        return super.toString() + ", Wing Width: " + wingWidth + ", Enum Variable: " + enumVar;
    }
}
