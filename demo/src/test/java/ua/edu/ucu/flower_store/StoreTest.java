package ua.edu.ucu.flower_store;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * Test suite for the Store and Specification classes, 
 * focusing on the search logic.
 */
public final class StoreTest {
    /** Expected number of initial buckets. */
    private static final int EXPECTED_BUCKETS_COUNT = 3;
    /** Expected number of rose search results. */
    private static final int ROSE_RESULTS_COUNT = 2;
    /** Expected number of chamomile search results. */
    private static final int CHAMOMILE_RESULTS_COUNT = 1;
    
    /** Rose sepal length. */
    private static final double ROSE_SEPAL = 10.0;
    /** Rose price. */
    private static final double ROSE_PRICE = 5.0;
    /** Tulip sepal length. */
    private static final double TULIP_SEPAL = 5.0;
    /** Tulip price. */
    private static final double TULIP_PRICE = 4.0;
    /** Chamomile sepal length. */
    private static final double CHAMOMILE_SEPAL = 7.0;
    /** Chamomile price. */
    private static final double CHAMOMILE_PRICE = 3.0;

    /** Quantity of 10. */
    private static final int QTY_TEN = 10;
    /** Quantity of 5. */
    private static final int QTY_FIVE = 5;
    /** Quantity of 20. */
    private static final int QTY_TWENTY = 20;

    /** Store object for testing. */
    private Store store;
    /** Test Rose flower. */
    private Flower rose;
    /** Test Tulip flower. */
    private Flower tulip;
    /** Test Chamomile flower. */
    private Flower chamomile;

    /**
     * Set up the Store and test flowers before each test.
     */
    @BeforeEach
    public void setUp() {
        store = new Store();
        rose = new Rose(ROSE_SEPAL, FlowerColor.RED, ROSE_PRICE);
        tulip = new Tulip(TULIP_SEPAL, FlowerColor.YELLOW, TULIP_PRICE);
        chamomile = new Chamomile(CHAMOMILE_SEPAL, FlowerColor.WHITE, 
                                  CHAMOMILE_PRICE);

        // Bucket 1: Roses only
        final FlowerBucket bucket1 = new FlowerBucket();
        bucket1.addFlowerPack(new FlowerPack(rose, QTY_TEN));

        // Bucket 2: Roses and Tulips
        final FlowerBucket bucket2 = new FlowerBucket();
        bucket2.addFlowerPack(new FlowerPack(rose, QTY_FIVE));
        bucket2.addFlowerPack(new FlowerPack(tulip, QTY_FIVE));

        // Bucket 3: Chamomiles only
        final FlowerBucket bucket3 = new FlowerBucket();
        bucket3.addFlowerPack(new FlowerPack(chamomile, QTY_TWENTY));

        store.addBucket(bucket1);
        store.addBucket(bucket2);
        store.addBucket(bucket3);
    }

    /**
     * Test that buckets are added correctly.
     */
    @Test
    public void testAddBucket() {
        assertEquals(EXPECTED_BUCKETS_COUNT, store.getBuckets().size());
    }

    /**
     * Test searching by FlowerType Specification (e.g., all buckets with Roses).
     */
    @Test
    public void testSearchByRoseType() {
        // Specification: search for buckets containing Roses
        final Specification<FlowerBucket> roseSpec =
            new FlowerTypeSpecification(FlowerType.ROSE);

        final List<FlowerBucket> results = store.search(roseSpec);

        // Expect 2 buckets (bucket1 and bucket2)
        assertEquals(ROSE_RESULTS_COUNT, results.size());

        // Verify that results satisfy the specification
        for (final FlowerBucket bucket : results) {
             assertTrue(roseSpec.isSatisfiedBy(bucket));
        }
    }

    /**
     * Test searching by FlowerType Specification (e.g., all buckets with Chamomile).
     */
    @Test
    public void testSearchByChamomileType() {
        // Specification: search for buckets containing Chamomiles
        final Specification<FlowerBucket> chamomileSpec =
            new FlowerTypeSpecification(FlowerType.CHAMOMILE);

        final List<FlowerBucket> results = store.search(chamomileSpec);

        // Expect 1 bucket (bucket3)
        assertEquals(CHAMOMILE_RESULTS_COUNT, results.size());

        // Verify that a bucket without chamomiles does not satisfy the spec
        final Specification<FlowerBucket> roseSpec =
            new FlowerTypeSpecification(FlowerType.ROSE);
        assertFalse(roseSpec.isSatisfiedBy(results.get(0)));
    }

    /**
     * Test search when no bucket matches the specification (e.g., Lily).
     */
    @Test
    public void testSearchNoMatch() {
        // Specification: search for buckets containing Lilies
        final Specification<FlowerBucket> lilySpec =
            new FlowerTypeSpecification(FlowerType.LILY);

        final List<FlowerBucket> results = store.search(lilySpec);

        // Expect 0 buckets
        assertTrue(results.isEmpty());
    }
}
