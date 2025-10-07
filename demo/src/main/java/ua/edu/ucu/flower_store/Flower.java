/**
 * Class Flower represents a single flower with its characteristics.
 */
package ua.edu.ucu.flower_store;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Flower {

    /** The color of the flower. */
    private FlowerColor color;

    /** The price of the flower. */
    private double price;
    
    /** The sepal length of the flower. */
    private double sepalLength;

    /** The type of the flower (e.g., ROSE, TULIP). */
    private FlowerType flowerType;

    /**
     * Constructor for creating a Flower object.
     * @param sepalLength The length of the sepal
     * @param color The color of the flower
     * @param price The price of the flower
     */
    public Flower(final double sepalLength, 
                  final FlowerColor color, 
                  final double price) { 
        this.sepalLength = sepalLength;
        this.color = color;
        this.price = price;
    }

    /**
     * Copy constructor for creating a new Flower object from an existing one.
     * @param other the Flower object to copy properties from
     */
    public Flower(final Flower other) {
        this.price = other.price;
        this.sepalLength = other.sepalLength;
        this.flowerType = other.flowerType;
    }
}
