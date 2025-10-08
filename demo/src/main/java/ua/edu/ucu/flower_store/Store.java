package ua.edu.ucu.flower_store;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Represents the main flower store, holding and managing flower inventory.
 * This class is declared final to satisfy DesignForExtension check.
 */
public final class Store {

    /** The inventory of flower buckets available in the store. */
    private final List<FlowerBucket> buckets;

    /**
     * Constructor initializes the store with an empty inventory.
     */
    public Store() {
        this.buckets = new ArrayList<>();
    }

    /**
     * Adds a flower bucket to the store's inventory.
     * @param bucket the flower bucket to be added
     */
    public void addBucket(final FlowerBucket bucket) {
        this.buckets.add(bucket);
    }

    /**
     * Searches the store's inventory for flower buckets that match a given
     * search specification. This implements the Search Design pattern
     * using the Specification Pattern.
     * @param spec the specification object defining the search criteria
     * @return a list of FlowerBucket objects that satisfy the specification
     */
    public List<FlowerBucket> search(final Specification<FlowerBucket> spec) {
        return buckets.stream()
                .filter(spec::isSatisfiedBy)
                .collect(Collectors.toList());
    }

    /**
     * Getter for the list of buckets (used primarily for testing and checkstyle).
     * @return the list of flower buckets in the store
     */
    public List<FlowerBucket> getBuckets() {
        return new ArrayList<>(this.buckets);
    }
}
