package ua.edu.ucu.flower_store;

/**
 * A specification to filter FlowerBuckets based on the presence
 * of a specific FlowerType within its FlowerPacks.
 */
public final class FlowerTypeSpecification implements
        Specification<FlowerBucket> {

    /** The desired flower type to search for. */
    private final FlowerType type;

    /**
     * Constructor for FlowerTypeSpecification.
     * @param typeValue the flower type to match
     */
    public FlowerTypeSpecification(final FlowerType typeValue) {
        this.type = typeValue;
    }

    /**
     * Checks if the FlowerBucket contains at least one FlowerPack
     * with the specified flower type.
     * @param bucket the FlowerBucket to check
     * @return true if the bucket is satisfied by the specification
     */
    @Override
    public boolean isSatisfiedBy(final FlowerBucket bucket) {
        for (FlowerPack pack : bucket.getFlowerPacks()) {
            if (pack.getFlower().getFlowerType() == type) {
                return true;
            }
        }
        return false;
    }
}
