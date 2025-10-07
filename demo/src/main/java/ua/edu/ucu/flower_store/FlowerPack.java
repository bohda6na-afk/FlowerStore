package ua.edu.ucu.flower_store;

import lombok.Data;

/**
 * Represents a pack containing multiple flowers of the same type.
 * This class is declared final to satisfy DesignForExtension check.
 */
@Data
public final class FlowerPack { // Added 'final'

    // --- Fix for Missing a Javadoc comment [JavadocVariable] ---

    /** The type of flower in the pack. */
    private Flower flower;
    
    /** The quantity of flowers in the pack. */
    private int quantity;

    /**
     * Calculates the total price of the flower pack.
     * @return the total price of the pack
     */
    public double getPrice() { // Added Javadoc
        return flower.getPrice() * quantity;
    }
    
    /**
     * Constructor for creating a FlowerPack.
     * @param flower the flower type (Fix for FinalParameters, HiddenField)
     * @param quantity the number of flowers (Fix for FinalParameters, HiddenField, WhitespaceAround)
     */
    public FlowerPack(final Flower flower, final int quantity) { // Added 'final', space before '{'
        // Use 'this.' to resolve HiddenField error
        this.flower = new Flower(flower);
        this.quantity = quantity;
    }

    /**
     * Sets the flower type for the pack.
     * @param flower the new flower type (Fix for FinalParameters, HiddenField, WhitespaceAround)
     */
    public void setFlower(final Flower flower) { // Added 'final', space before '{'
        // Use 'this.' to resolve HiddenField error
        this.flower = new Flower(flower);
    }
    
    // Lombok's @Data annotation generates other methods like setQuantity, which might also need manual Javadoc/Final if your checkstyle config targets generated methods. 
    // Usually, SuperLinter doesn't check generated code.
}
