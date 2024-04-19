import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MainService {
    static ArrayList<AbstractAnimal> allAnimals = new ArrayList<>();
    static ArrayList<FoodProduct> allFoodProducts = new ArrayList<>();

    public static void main(String[] args) {
        // Creating Bird objects
        Bird bird1 = new Bird(1, "Eagle", FoodType.MEAT, "Large", FoodType.MEAT);
        Bird bird2 = new Bird(2, "Owl", FoodType.OTHER, "Medium", FoodType.OTHER);

        // Creating Spider objects
        Spider spider1 = new Spider(1, "Tarantula", FoodType.MEAT, "Yes", "Furry");
        Spider spider2 = new Spider(2, "Black Widow", FoodType.MEAT, "Yes", "Sleek");

        // Adding animals to the list
        allAnimals.add(bird1);
        allAnimals.add(bird2);
        allAnimals.add(spider1);
        allAnimals.add(spider2);

        // Creating FoodProduct objects
        FoodProduct meat1 = new FoodProduct(1, "Beef", 100, LocalDate.of(2024, 4, 30), FoodType.MEAT);
        FoodProduct meat2 = new FoodProduct(2, "Chicken", 100, LocalDate.of(2024, 5, 15), FoodType.MEAT);
        FoodProduct grass1 = new FoodProduct(3, "Hay", 100, LocalDate.of(2024, 6, 1), FoodType.GRASS);

        // Adding food products to the list
        allFoodProducts.add(meat1);
        allFoodProducts.add(meat2);
        allFoodProducts.add(grass1);





        // Creating a new Bird object
        createNewBird(3, "Hawk", FoodType.MEAT, "Medium", FoodType.MEAT);


        int meatEatersCount = howManyMeatEaters();
        System.out.println("Number of meat-eating animals: " + meatEatersCount);

        int feedUnitsForSpider1 = howManyFeedUnitsForSpider(spider1);
        System.out.println("Feed units for Spider 1: " + feedUnitsForSpider1);

        boolean isPossibleToFeedAll = isPossibleToFeedAllAnimals();
        if (isPossibleToFeedAll) {
            System.out.println("All animals can be fed.");
        } else {
            System.out.println("Not enough food to feed all animals.");
        }

        // Getting all Bird objects
        List<Bird> allBirds = getAllBirds();
        System.out.println("All Bird objects:");
        for (Bird bird : allBirds) {
            System.out.println(bird);
        }

        // Getting a specific Bird object by ID
        Bird specificBird = getBirdById(1);
        System.out.println("\nSpecific Bird object by ID:");
        System.out.println(specificBird);

        // Getting a specific Bird object by animalCode
        Bird specificBirdByCode = getBirdByAnimalCode("B_3_Hawk_MEAT");
        if (specificBirdByCode != null) {
            System.out.println("\nSpecific Bird object by animalCode:");
            System.out.println(specificBirdByCode);
        } else {
            System.out.println("No bird found with the specified animal code.");
        }

        // Updating a specific Bird object
        updateBirdById(1, "Updated Title", FoodType.OTHER, "Updated Var1", FoodType.OTHER);

        // Deleting a specific Bird object
        deleteBirdById(2);
    }

    // CRUD functionalities for Bird objects
    public static void createNewBird(int id, String title, FoodType foodType, String wingWidth, Enum<FoodType> enumVar) {
        Bird newBird = new Bird(id, title, foodType, wingWidth, enumVar);
        allAnimals.add(newBird);
    }

    public static List<Bird> getAllBirds() {
        List<Bird> result = new ArrayList<>();
        for (AbstractAnimal animal : allAnimals) {
            if (animal instanceof Bird) {
                result.add((Bird) animal);
            }
        }
        return result;
    }

    public static Bird getBirdById(int id) {
        for (AbstractAnimal animal : allAnimals) {
            if (animal instanceof Bird && animal.getId() == id) {
                return (Bird) animal;
            }
        }
        return null;
    }

    public static Bird getBirdByAnimalCode(String animalCode) {
        for (AbstractAnimal animal : allAnimals) {
            if (animal instanceof Bird && animal.getAnimalCode().equals(animalCode)) {
                return (Bird) animal;
            }
        }
        return null;
    }

    public static void updateBirdById(int id, String title, FoodType foodType, String wingWidth, Enum<FoodType> enumVar) {
        for (AbstractAnimal animal : allAnimals) {
            if (animal instanceof Bird bird && animal.getId() == id) {
                bird.setTitle(title);
                bird.setFoodType(foodType);
                bird.setWingWidth(wingWidth);
                bird.setEnumVar(enumVar);
                return;
            }
        }
    }

    public static void deleteBirdById(int id) {
        allAnimals.removeIf(animal -> animal instanceof Bird && animal.getId() == id);
    }

    // Filtering function: Calculate how many AbstractAnimal objects have foodType as meat
    public static int howManyMeatEaters() {
        int count = 0;
        for (AbstractAnimal animal : allAnimals) {
            if (animal.getFoodType() == FoodType.MEAT) {
                count++;
            }
        }
        return count;
    }

    // Filtering function: Calculate how many feed units are left in the store for a specific animal
    public static int howManyFeedUnitsForSpider(AbstractAnimal animal) {
        int totalFeedUnits = 0;
        for (FoodProduct foodProduct : allFoodProducts) {
            if (foodProduct.getFoodType() == animal.getFoodType()) {
                totalFeedUnits += foodProduct.getQuantity();
            }
        }
        return totalFeedUnits;
    }


    public static boolean isPossibleToFeedAllAnimals() {
        for (AbstractAnimal animal : allAnimals) {
            boolean suitableFoodExists = false;
            for (FoodProduct foodProduct : allFoodProducts) {
                if (foodProduct.getFoodType() == animal.getFoodType() && foodProduct.getQuantity() > 0) {
                    suitableFoodExists = true;
                    break;
                }
            }
            if (!suitableFoodExists) {
                return false;
            }
        }
        return true;
    }
}
