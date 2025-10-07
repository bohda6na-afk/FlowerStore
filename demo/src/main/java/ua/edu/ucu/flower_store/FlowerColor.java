package ua.edu.ucu.flower_store;

import lombok.Getter;

/**
 * Defines the available colors for flowers, represented by HEX codes.
 * (Fix for Javadoc for enum class)
 */
@Getter
public enum FlowerColor {
    // --- Fix for Missing a Javadoc comment [JavadocVariable] ---

    /** Represents the red color. */
    RED("#FF0000"), 
    /** Represents the yellow color. */
    YELLOW("#FFFF00"), 
    /** Represents the white color. */
    WHITE("#FFFFFF");

    /** The HEX code representation of the color. */
    private final String code; // Fix for JavadocVariable and Final (code should be final)

    /**
     * Constructor for FlowerColor enum.
     * @param code The HEX string representation of the color (Fix for FinalParameters, WhitespaceAround)
     */
    FlowerColor(final String code) { // Added 'final', removed redundant 'private' (enum ctors are implicitly private), added space before '{'
        // Fix for HiddenField: 'code' hides a field
        this.code = code; 
    }
}
