package entities;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "borrower")
public class Borrower {
    @Id
    @Column(name = "borrower_id", nullable = false, length = 12)
    private String id;

    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @Column(name = "birthdate")
    private LocalDate birthdate;

    @Column(name = "address", nullable = false, length = 45)
    private String address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "library_id")
    private Library library;

    @Column(name = "joined_date")
    private Instant joinedDate;

    @Column(name = "updated_date")
    private Instant updatedDate;

    @OneToMany(mappedBy = "borrower")
    private Set<Loan> loans = new LinkedHashSet<>();

    public Set<Loan> getLoans() {
        return loans;
    }

    public Borrower() {
    }

    public Borrower(String id, String name, LocalDate birthdate, String address) {
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
        this.address = address;
    }

    public void setLoans(Set<Loan> loans) {
        this.loans = loans;
    }

    public Instant getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Instant updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Instant getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(Instant joinedDate) {
        this.joinedDate = joinedDate;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}