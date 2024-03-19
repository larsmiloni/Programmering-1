/**
 * An enumeration of categories for different items.
 *
 * @author Lars Mikkel Lødeng Nilsen
 * @since 11.12.2022
 */
public enum Category {
    /**
     * A category for floor laminates.
     */
    FLOOR_LAMINATE,
    /**
     * A category for windows.
     */
    WINDOWS,
    /**
     * A category for doors.
     */
    DOORS,
    /**
     * A category for lumber.
     */
    LUMBER;

    /**
     * Returns a {@code Category} instance for the given integer.
     *
     * @param x the integer representing a category
     * @return a {@code Category} instance for the given integer
     */
    public static Category fromInteger(int x){
        try {
            return Category.values()[x - 1];
        } catch (Exception e) {
            System.out.println(e);
            return Category.FLOOR_LAMINATE;
        }
    }
}
