package ua.edu.ucu.flower_store;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Random;

/**
 * Test suite for the FlowerBucket class.
 */
public final class FlowerBucketTest { // Додано 'final'
    /** Constant for a fixed flower price for test. */
    private static final double FLOWER_PRICE = 10.0;
    /** Random generator for testing. */
    private static final Random RANDOM_GENERATOR = new Random();
    /** Maximum quantity constant for random generation. */
    private static final int MAX_QUANTITY = 1000;
    /** FlowerBucket object for testing. */
    private FlowerBucket flowerBucket;

    /**
     * Set up a new FlowerBucket object before each test.
     */
    @BeforeEach
    public void init() { // Додано Javadoc
        flowerBucket = new FlowerBucket();
    }

    /**
     * Test total price calculation.
     */
    @Test
    public void testPrice() { // Додано Javadoc
        final int quantity = RANDOM_GENERATOR.nextInt(MAX_QUANTITY);
        // Використання конструктора з ціною і типом для коректної ініціалізації
        final Flower flower = new Rose(1.0, FlowerColor.RED, FLOWER_PRICE); 
        
        final FlowerPack flowerPack = new FlowerPack(flower, quantity);
        // Виправлено: використання коректного методу addFlowerPack
        flowerBucket.addFlowerPack(flowerPack); 
        
        final double expectedPrice = FLOWER_PRICE * quantity;
        // Використання дельти (0.0001) для порівняння чисел з плаваючою комою (double)
        Assertions.assertEquals(expectedPrice, flowerBucket.getPrice(), 0.0001); 
    }
}
