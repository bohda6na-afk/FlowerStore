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
     * @param flowerType The flower type
     * @param flowerQuantity The number of flowers
     */
    public FlowerPack(final Flower flowerType,
                      final int flowerQuantity) {
        // Виправлено HiddenField, використовуючи інші назви параметрів
        this.flower = new Flower(flowerType);
        this.quantity = flowerQuantity;
    }

    /**
     * Sets the flower type for the pack.
     * @param newFlower the new flower type
     */
    public void setFlower(final Flower newFlower) { // Виправлено HiddenField
        this.flower = new Flower(newFlower);
    }
}
