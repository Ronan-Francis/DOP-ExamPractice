package ie.atu.sw;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Service class for managing library operations.
 */
public class LibraryService {

    /**
     * Loans a book to a member.
     * @param member the member borrowing the book.
     * @param book the book being borrowed.
     * @param loanDate the date of the loan.
     * @return the created Loan object.
     * @throws IllegalArgumentException if the book is not available or the member has reached the maximum loan limit.
     */
    public static Loan loanBook(Member member, Book book, LocalDate loanDate) {
        if (!book.isAvailable()) {
            throw new IllegalArgumentException("The book '%s' is already on loan.".formatted(book.title()));
        }
        if (member.loans().size() >= 5) {
            throw new IllegalArgumentException("Member '%s' cannot borrow more than 5 books.".formatted(member.fullName()));
        }
        
        Loan loan = new Loan(member, book.loanOut(), loanDate);
        member.loans().add(loan);
        return loan;
    }

    /**
     * Returns a book borrowed by a member.
     * @param member the member returning the book.
     * @param book the book being returned.
     * @throws IllegalArgumentException if no matching loan is found.
     */
    public static void returnBook(Member member, Book book) {
        Loan loanToRemove = member.loans().stream()
            .filter(loan -> loan.book().id().equals(book.id()))  // Compare by ID
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("Loan for book '%s' not found.".formatted(book.title())));

        member.loans().remove(loanToRemove); 
        System.out.println("Book returned: " + book.title());
    }


    /**
     * Lists all active loans of a member.
     * @param member the member whose loans are listed.
     * @return a list of active loans.
     */
    public static List<Loan> listLoans(Member member) {
        if (member.loans().isEmpty()) {
            System.out.println("No active loans for " + member.fullName());
            return List.of();  // Return an empty list
        }

        member.loans().forEach(System.out::println);  // Print all loans
        return new ArrayList<>(member.loans());  // Return a copy of the loans list
    }
}
