package ua.edu.ucu.flower_store;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a bucket containing one or more flower packs.
 * This class is declared final to satisfy DesignForExtension check.
 */
public final class FlowerBucket { // Added 'final'

    /** List of flower packs in the bucket. (Fix for JavadocVariable) */
    private List<FlowerPack> flowerPacks;

    /**
     * Constructor initializes an empty list of flower packs.
     */
    public FlowerBucket() { // Added Javadoc
        this.flowerPacks = new ArrayList<>();
    }

    /**
     * Adds a flower pack to the bucket.
     * @param flowerPack the pack to be added (Fix for FinalParameters)
     */
    public void addFlowerPack(final FlowerPack flowerPack) { // Added 'final'
        flowerPacks.add(flowerPack);
    }

    /**
     * Calculates the total price of all flowers in the bucket.
     * @return the total price
     */
    public double getPrice() { // Added Javadoc
        return flowerPacks
            .stream().mapToDouble(pack -> pack
            .getPrice()).sum();
    }
}
