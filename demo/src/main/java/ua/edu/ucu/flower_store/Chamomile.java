/**
 * Class Chamomile represents a Chamomile flower, inheriting properties from Flower.
 * (Fix for JavadocPackage is handled by package-info.java in the parent directory)
 */
package ua.edu.ucu.flower_store;

/**
 * Represents a Chamomile flower.
 */
public final class Chamomile extends Flower { // Added 'final' (if you don't plan to extend this)

    // --- Fixes for Missing Javadoc and WhitespaceAround ---

    /**
     * Constructor for Chamomile.
     * @param sepalLength length of the sepal (Fix for FinalParameters)
     * @param color color of the flower (Fix for FinalParameters)
     * @param price price of the flower (Fix for FinalParameters)
     */
    public Chamomile(final double sepalLength, final FlowerColor color, final double price) {
        super(sepalLength, color, price);
        this.setFlowerType(FlowerType.CHAMOMILE);
    }
}
