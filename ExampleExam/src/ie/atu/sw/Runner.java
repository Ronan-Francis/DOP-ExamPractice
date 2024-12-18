package ie.atu.sw;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Main entry point to run the library system.
 */
public class Runner {
    public static void main(String[] args) {
        var book1 = new Book("B001", "1984", "George Orwell", Genre.FICTION, true);
        var book2 = new Book("B002", "Dune", "Frank Herbert", Genre.FANTASY, true);

        // Initialize a mutable list
        var member = new Member("M001", "John Doe", "john.doe@example.com", new ArrayList<>());

        try {
            var loan1 = LibraryService.loanBook(member, book1, LocalDate.of(2024, 12, 10));
            System.out.println(loan1);

            var loan2 = LibraryService.loanBook(member, book2, LocalDate.of(2024, 10, 12));
            System.out.println(loan2);

            LibraryService.returnBook(member, book1);
            var loans = LibraryService.listLoans(member);
            System.out.println("Current loans for member " + member.fullName() + ": " + loans);

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
