package ua.edu.ucu.flower_store;

/**
 * Represents a Tulip flower, inheriting properties from Flower.
 * This class is declared final to satisfy DesignForExtension check.
 */
public final class Tulip extends Flower { // Added 'final'
    
    // Assuming Flower has a constructor: Flower(double sepalLength, FlowerColor color, double price)
    
    /**
     * Constructor for Rose.
     * @param sepalLength length of the sepal (Fix for FinalParameters)
     * @param color color of the flower (Fix for FinalParameters)
     * @param price price of the flower (Fix for FinalParameters)
     */
    public Tulip(final double sepalLength, final FlowerColor color, final double price) {
        super(sepalLength, color, price);
        this.setFlowerType(FlowerType.TULIP);
    }
}
