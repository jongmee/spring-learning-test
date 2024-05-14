package cholog;

import jakarta.persistence.*;

@Entity
public class BookAuthor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Book book;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Author author;

    public BookAuthor() {
    }

    public BookAuthor(Book book, Author author) {
        this.book = book;
        this.author = author;
    }

    public Author getAuthor() {
        return author;
    }
}
