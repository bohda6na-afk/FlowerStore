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
    /** Test flower object. */
    private Flower rose;

    /**
     * Set up a new Rose object before each test.
     */
    @BeforeEach
    public void setUp() {
        // Initialize a flower for the pack
        rose = new Rose(10.0, FlowerColor.RED, 5.0);
    }

    /**
     * Test price calculation.
     */
    @Test
    public void testGetPrice() {
        final int quantity = 5;
        final FlowerPack pack = new FlowerPack(rose, quantity);
        // Expected price: 5.0 * 5 = 25.0
        assertEquals(25.0, pack.getPrice(), DELTA);
    }

    /**
     * Test deep copy of the Flower object inside the FlowerPack.
     * The internal flower's state should be independent of the external flower.
     */
    @Test
    public void testDeepCopy() {
        final int quantity = 2;
        final FlowerPack pack = new FlowerPack(rose, quantity);
        final double originalPrice = pack.getPrice(); // 10.0

        // Change the price of the external 'rose' object
        rose.setPrice(500.0);

        // Verify that FlowerPack's price remains unchanged (10.0),
        // proving that it holds a copy.
        assertEquals(originalPrice, pack.getPrice(), DELTA);
        assertNotSame(rose, pack.getFlower());
    }

    /**
     * Test the FlowerType is correctly set.
     */
    @Test
    public void testFlowerType() {
        final FlowerPack pack = new FlowerPack(rose, 1);
        assertEquals(FlowerType.ROSE, pack.getFlower().getFlowerType());
    }
}
