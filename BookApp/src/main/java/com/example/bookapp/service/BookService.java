package com.example.bookapp.service;

import com.example.bookapp.model.Book;
import com.example.bookapp.repository.BookRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import jakarta.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    public List<Book> search(String title, String author, Integer pages) {
        Specification<Book> spec = (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (title != null && !title.trim().isEmpty())
                predicates.add(cb.like(cb.lower(root.get("title")), "%" + title.trim().toLowerCase() + "%"));
            if (author != null && !author.trim().isEmpty())
                predicates.add(cb.like(cb.lower(root.get("author")), "%" + author.trim().toLowerCase() + "%"));
            if (pages != null)
                predicates.add(cb.equal(root.get("pages"), pages));

            return cb.and(predicates.toArray(new Predicate[0]));
        };

        return bookRepository.findAll(spec);
    }
}
