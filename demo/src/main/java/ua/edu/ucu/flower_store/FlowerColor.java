/**
 * Enum color
 */
package ua.edu.ucu.flower_store;
/** ... */
import lombok.Getter;
/** ... */
@Getter
/** ... */
public enum FlowerColor {
    /** ... */
RED("#FF0000"), 
/** ... */
YELLOW("#FFFF00"), 
/** ... */
WHITE("#FFFFFF");
/** ... */
private final String code;
/** ... */
private FlowerColor(String code) {
    this.code = code;
}
}
