package ua.edu.ucu.flower_store;

/**
 * Represents a Tulip flower, inheriting properties from Flower.
 * This class is declared final to satisfy DesignForExtension check.
 */
public final class Tulip extends Flower {

    /**
     * Constructor for Tulip.
     * @param sepalLength length of the sepal
     * @param color color of the flower
     * @param price price of the flower
     */
    public Tulip(final double sepalLength, 
                 final FlowerColor color, 
                 final double price) {
        super(sepalLength, color, price);
        this.setFlowerType(FlowerType.TULIP);
    }
}
