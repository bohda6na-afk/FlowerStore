/**
 * Represents a Chamomile flower, inheriting properties from Flower.
 */
package ua.edu.ucu.flower_store;

/**
 * Represents a Chamomile flower.
 */
public final class Chamomile extends Flower {

    /**
     * Constructor for Chamomile.
     * @param sepalLength length of the sepal
     * @param color color of the flower
     * @param price price of the flower
     */
    public Chamomile(final double sepalLength,
                     final FlowerColor color,
                     final double price) {
        super(sepalLength, color, price);
        this.setFlowerType(FlowerType.CHAMOMILE);
    }
}
