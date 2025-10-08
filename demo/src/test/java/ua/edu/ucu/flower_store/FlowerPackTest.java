package ua.edu.ucu.flower_store;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

/**
 * Test suite for the FlowerPack class.
 */
public final class FlowerPackTest {
    /** Delta constant for double comparison. */
    private static final double DELTA = 0.0001;
    /** Default sepal length for test flower. */
    private static final double DEFAULT_SEPAL_LENGTH = 10.0;
    /** Default price for test flower. */
    private static final double DEFAULT_PRICE = 5.0;
    /** Test quantity 1. */
    private static final int QTY_FIVE = 5;
    /** Test quantity 2. */
    private static final int QTY_ONE = 1;
    /** Price used for deep copy test mutation. */
    private static final double MUTATED_PRICE = 500.0;
    /** Expected price for QTY_FIVE. */
    private static final double EXPECTED_PRICE_25 = 25.0;
    /** Test flower object. */
    private Flower rose;

    /**
     * Set up a new Rose object before each test.
     */
    @BeforeEach
    public void setUp() {
        // Initialize a flower for the pack
        rose = new Rose(DEFAULT_SEPAL_LENGTH, FlowerColor.RED, 
                        DEFAULT_PRICE);
    }

    /**
     * Test price calculation.
     */
    @Test
    public void testGetPrice() {
        final FlowerPack pack = new FlowerPack(rose, QTY_FIVE);
        // Expected price: 5.0 * 5 = 25.0
        assertEquals(EXPECTED_PRICE_25, pack.getPrice(), DELTA);
    }

    /**
     * Test deep copy of the Flower object inside the FlowerPack.
     * The internal flower's state should be independent of the external flower.
     */
    @Test
    public void testDeepCopy() {
        final int quantity = 2; // Can keep this if it's not reused
        final FlowerPack pack = new FlowerPack(rose, quantity);
        final double originalPrice = pack.getPrice(); // 10.0

        // Change the price of the external 'rose' object
        rose.setPrice(MUTATED_PRICE);

        // Verify that FlowerPack's price remains unchanged.
        assertEquals(originalPrice, pack.getPrice(), DELTA);
        assertNotSame(rose, pack.getFlower());
    }

    /**
     * Test the FlowerType is correctly set.
     */
    @Test
    public void testFlowerType() {
        final FlowerPack pack = new FlowerPack(rose, QTY_ONE);
        assertEquals(FlowerType.ROSE, pack.getFlower().getFlowerType());
    }
}
