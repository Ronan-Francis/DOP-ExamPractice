package ie.atu.sw;

/**
 * Represents a Book in the library system.
 */
public record Book(String id, String title, String author, Genre genre, boolean isAvailable) {

    /**
     * Marks the book as loaned out.
     * @return a new Book instance marked as unavailable.
     * @throws IllegalStateException if the book is already on loan.
     */
    public Book loanOut() {
        if (!isAvailable) {
            throw new IllegalStateException("The book '%s' is already loaned out.".formatted(title));
        }
        return new Book(id, title, author, genre, false);
    }

    /**
     * Marks the book as returned.
     * @return a new Book instance marked as available.
     */
    public Book returnBook() {
        return new Book(id, title, author, genre, true);
    }
}
