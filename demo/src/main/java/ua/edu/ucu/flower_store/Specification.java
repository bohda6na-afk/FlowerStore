package ua.edu.ucu.flower_store;

/**
 * Defines the contract for a search specification.
 * Any object that can be checked against an item for a match
 * should implement this interface.
 * @param <T> the type of object to check
 */
public interface Specification<T> {
    /**
     * Checks if a given item satisfies the specification.
     * @param item the object to check
     * @return true if the item matches the specification, false otherwise
     */
    boolean isSatisfiedBy(T item);
}
