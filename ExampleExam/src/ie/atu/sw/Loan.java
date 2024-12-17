package ie.atu.sw;

import java.time.LocalDate;

/**
 * Represents a loan record in the library system.
 */
public record Loan(Member member, Book book, LocalDate loanDate) {

    /**
     * Creates a Loan with validation.
     * @param member the member borrowing the book.
     * @param book the book being borrowed.
     * @param loanDate the date the loan was made.
     * @throws IllegalArgumentException if member or book is null.
     */
    public Loan {
        if (member == null) {
            throw new IllegalArgumentException("A Loan must reference a Member.");
        }
        if (book == null) {
            throw new IllegalArgumentException("A Loan must reference a Book.");
        }
    }

    @Override
    public String toString() {
        return "Loan{Book='%s', Member='%s', LoanDate='%s'}"
            .formatted(book.title(), member.fullName(), loanDate);
    }
}
