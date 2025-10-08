package ua.edu.ucu.flower_store;

/**
 * Represents a Rose flower, inheriting properties from Flower.
 * This class is declared final to satisfy DesignForExtension check.
 */
public final class Rose extends Flower {

    /**
     * Constructor for Rose.
     * @param sepalLength length of the sepal
     * @param color color of the flower
     * @param price price of the flower
     */
    public Rose(final double sepalLength,
                final FlowerColor color,
                final double price) {
        super(sepalLength, color, price);
        this.setFlowerType(FlowerType.ROSE);
    }
}
