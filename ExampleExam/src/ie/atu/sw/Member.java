package ie.atu.sw;

import java.util.List;

/**
 * Represents a library member.
 */
public record Member(String id, String fullName, String email, List<Loan> loans) {

    /**
     * Creates a Member with validation.
     * @param id the unique ID of the member.
     * @param fullName the full name of the member.
     * @param email the email address of the member.
     * @param loans the list of current loans (initially empty).
     * @throws IllegalArgumentException if any field is null or loans exceed the maximum limit.
     */
    public Member {
        if (id == null || fullName == null || email == null || loans == null) {
            throw new IllegalArgumentException("Member details cannot be null.");
        }
        if (loans.size() > 5) {
            throw new IllegalArgumentException("A Member cannot borrow more than 5 books.");
        }
    }

    @Override
    public String toString() {
        return "Member{id='%s', fullName='%s', email='%s'}".formatted(id, fullName, email);
    }
}
