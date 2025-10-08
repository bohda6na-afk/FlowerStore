package ua.edu.ucu.flower_store;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * Test suite for the Store and Specification classes, focusing on the search logic.
 */
public final class StoreTest {
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
        rose = new Rose(10.0, FlowerColor.RED, 5.0);
        tulip = new Tulip(5.0, FlowerColor.YELLOW, 4.0);
        chamomile = new Chamomile(7.0, FlowerColor.WHITE, 3.0);

        // Bucket 1: Roses only
        final FlowerBucket bucket1 = new FlowerBucket();
        bucket1.addFlowerPack(new FlowerPack(rose, 10));

        // Bucket 2: Roses and Tulips
        final FlowerBucket bucket2 = new FlowerBucket();
        bucket2.addFlowerPack(new FlowerPack(rose, 5));
        bucket2.addFlowerPack(new FlowerPack(tulip, 5));

        // Bucket 3: Chamomiles only
        final FlowerBucket bucket3 = new FlowerBucket();
        bucket3.addFlowerPack(new FlowerPack(chamomile, 20));

        store.addBucket(bucket1);
        store.addBucket(bucket2);
        store.addBucket(bucket3);
    }

    /**
     * Test that buckets are added correctly.
     */
    @Test
    public void testAddBucket() {
        assertEquals(3, store.getBuckets().size());
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
        assertEquals(2, results.size());

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
        assertEquals(1, results.size());

        // Verify that a bucket without chamomiles does not satisfy the spec
        assertFalse(
            new FlowerTypeSpecification(FlowerType.ROSE).isSatisfiedBy(results.get(0))
        );
    }

    /**
     * Test search when no bucket matches the specification (e.g., Lily).
     */
    @Test
    public void testSearchNoMatch() {
        // Specification: search for buckets containing Lilies (which are not in store)
        final Specification<FlowerBucket> lilySpec =
            new FlowerTypeSpecification(FlowerType.LILY);

        final List<FlowerBucket> results = store.search(lilySpec);

        // Expect 0 buckets
        assertTrue(results.isEmpty());
    }
}
