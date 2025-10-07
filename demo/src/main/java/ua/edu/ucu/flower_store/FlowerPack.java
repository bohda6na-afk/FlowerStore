package ua.edu.ucu.flower_store;

import lombok.Data;

/**
 * Represents a pack containing multiple flowers of the same type.
 * This class is declared final to satisfy DesignForExtension check.
 */
@Data
public final class FlowerPack {

    /** The type of flower in the pack. */
    private Flower flower;
    
    /** The quantity of flowers in the pack. */
    private int quantity;

    /**
     * Calculates the total price of the flower pack.
     * @return the total price of the pack
     */
    public double getPrice() {
        return flower.getPrice() * quantity;
    }
    
    /**
     * Constructor for creating a FlowerPack.
     * @param flower the flower type
     * @param quantity the number of flowers
     */
    public FlowerPack(final Flower flower, 
                      final int quantity) {
        // Use 'this.' to resolve HiddenField error
        this.flower = new Flower(flower);
        this.quantity = quantity;
    }

    /**
     * Sets the flower type for the pack.
     * @param flower the new flower type
     */
    public void setFlower(final Flower flower) {
        // Use 'this.' to resolve HiddenField error
        this.flower = new Flower(flower);
    }
}
