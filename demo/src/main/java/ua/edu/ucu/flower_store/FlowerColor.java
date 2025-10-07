package ua.edu.ucu.flower_store;

import lombok.Getter;

/**
 * Defines the available colors for flowers, represented by HEX codes.
 */
@Getter
public enum FlowerColor {

    /** Represents the red color. */
    RED("#FF0000"), 
    /** Represents the yellow color. */
    YELLOW("#FFFF00"), 
    /** Represents the white color. */
    WHITE("#FFFFFF");

    /** The HEX code representation of the color. */
    private final String code;

    /**
     * Constructor for FlowerColor enum.
     * @param code The HEX string representation of the color
     */
    FlowerColor(final String code) {
        this.code = code; 
    }
}
