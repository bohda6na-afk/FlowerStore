/**
 * Main utility class for application entry point and demonstration.
 */
package ua.edu.ucu.flower_store;

// Import statements should be placed here

/**
 * Main utility class for application entry point and demonstration.
 * Checkstyle requires utility classes to be declared final and
 * have a private constructor.
 */
public final class Main {

    /** Constant for the flower's default price. */
    public static final double FLOWER_PRICE = 100;
    /** Constant for the flower's sepal length. */
    public static final double SEPAL_LENGTH = 10;
    /** Constant for the default quantity of flowers in a pack. */
    public static final int PACK_QUANTITY = 11;

    /**
     * Private constructor to prevent instantiation of this utility class.
     */
    private Main() {
        // Utility class
    }

    /**
     * The application entry point.
     * @param args command line arguments
     */
    public static void main(final String[] args) {
        System.out.println("Hello world!");

        Flower flower = new Flower();
        // Usage of constants instead of magic numbers
        flower.setColor(FlowerColor.RED);
        flower.setPrice(FLOWER_PRICE);
        flower.setSepalLength(SEPAL_LENGTH);
        flower.setFlowerType(FlowerType.ROSE);
        System.out.println(flower);

        FlowerPack flowerPack = new FlowerPack(flower, PACK_QUANTITY);
        // Видалено зайві setFlower/setQuantity, оскільки вони вже
        // виконуються в конструкторі.
        // flowerPack.setFlower(flower);
        // flowerPack.setQuantity(PACK_QUANTITY);

        FlowerBucket flowerBucket = new FlowerBucket();
        flowerBucket.addFlowerPack(flowerPack);
        System.out.println(flowerBucket.getPrice());
    }
}
