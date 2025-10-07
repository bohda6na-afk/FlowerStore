/**
 * Class Flower
 */
package ua.edu.ucu.flower_store;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
/** ... */
public class Flower {
    /** ... */
private FlowerColor color;
/** ... */
private int price;
/** ... */
private int sepalLength;
/** ... */
private FlowerType flowerType;

/** ... */
public Flower(Flower other) {
    this.color = other.color;
    this.price = other.price;
    this.sepalLength = other.sepalLength;
    this.flowerType = other.flowerType;
}
}






