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
     * @param sepalLengthValue The length of the sepal
     * @param colorValue The color of the flower
     * @param priceValue The price of the flower
     */
    public Flower(final double sepalLengthValue,
                  final FlowerColor colorValue,
                  final double priceValue) {
        this.sepalLength = sepalLengthValue; // Виправлено HiddenField
        this.color = colorValue; // Виправлено HiddenField
        this.price = priceValue; // Виправлено HiddenField
    }

    /**
     * Copy constructor for creating a new Flower object from an existing one.
     * @param other the Flower object to copy properties from
     */
    public Flower(final Flower other) {
        this.price = other.price;
        this.sepalLength = other.sepalLength;
        this.flowerType = other.flowerType;
        this.color = other.color; // Додано копіювання кольору
    }
}
