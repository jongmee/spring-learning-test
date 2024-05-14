package cholog;

import jakarta.persistence.*;

import java.util.Set;
import java.util.stream.Collectors;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Publisher publisher;

    @OneToMany(mappedBy="book")
    Set<BookAuthor> authors;

    public Book() {
    }

    public Book(String name, Publisher publisher) {
        this.name = name;
        this.publisher = publisher;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public Set<Author> getAuthors() {
        return authors.stream()
                .map(BookAuthor::getAuthor)
                .collect(Collectors.toUnmodifiableSet());
    }
}
