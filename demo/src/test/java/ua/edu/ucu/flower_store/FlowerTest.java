package ua.edu.ucu.flower_store;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Random;

/**
 * Test suite for the Flower class.
 */
public final class FlowerTest { // Додано 'final'
    /** Random generator for testing. */
    private static final Random RANDOM_GENERATOR = new Random();
    /** Maximum price constant for random generation. */
    private static final int MAX_PRICE = 100;
    /** Flower object for testing. */
    private Flower flower;

    /**
     * Set up a new Flower object before each test.
     */
    @BeforeEach
    public void init() { // Додано Javadoc
        flower = new Flower();
    }

    /**
     * Test price setter and getter.
     */
    @Test
    public void testPrice() { // Додано Javadoc
        final int price = RANDOM_GENERATOR.nextInt(MAX_PRICE);
        flower.setPrice(price);
        Assertions.assertEquals(price, flower.getPrice());
    }

    /**
     * Test color setter and getter.
     */
    @Test
    public void testColor() { // Додано Javadoc
        final FlowerColor color = FlowerColor.RED;
        flower.setColor(color);
        // Функціональне виправлення: викликаємо getCode() для порівняння зі строковим кодом
        Assertions.assertEquals("#FF0000", flower.getColor().getCode()); 
    }
}
