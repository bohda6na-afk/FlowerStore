package ua.edu.ucu.flower_store;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a bucket containing one or more flower packs.
 * This class is declared final to satisfy DesignForExtension check.
 */
public final class FlowerBucket {

    /** List of flower packs in the bucket. */
    private final List<FlowerPack> flowerPacks; // Зроблено final

    /**
     * Constructor initializes an empty list of flower packs.
     */
    public FlowerBucket() {
        this.flowerPacks = new ArrayList<>();
    }

    /**
     * Adds a flower pack to the bucket.
     * @param flowerPack the pack to be added
     */
    public void addFlowerPack(final FlowerPack flowerPack) {
        flowerPacks.add(flowerPack);
    }

    /**
     * Calculates the total price of all flowers in the bucket.
     * @return the total price
     */
    public double getPrice() {
        return flowerPacks
            .stream()
            .mapToDouble(pack -> pack.getPrice())
            .sum();
    }

    /**
     * Getter for the list of flower packs (used for searching).
     * Returns a new ArrayList instance to protect the internal state
     * of the bucket from external modification.
     * @return a copy of the list of flower packs
     */
    public List<FlowerPack> getFlowerPacks() {
        return new ArrayList<>(this.flowerPacks);
    }
}
