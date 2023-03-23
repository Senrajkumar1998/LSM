package com.backendMarch.librarymanagementsystem.Service;

import com.backendMarch.librarymanagementsystem.Entity.Author;
import com.backendMarch.librarymanagementsystem.Entity.Book;
import com.backendMarch.librarymanagementsystem.Repository.AuthorRepository;
import com.backendMarch.librarymanagementsystem.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

  //  @Autowired
   // BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    public String  addBook(Book book) throws Exception {

        Author author;
        try {
            author = authorRepository.findById(book.getAuthor().getId()).get();
        }
        catch (Exception e){
            return "book not present";
        }

        List<Book> bookswritten =author.getBooks();
        bookswritten.add(book);

        authorRepository.save(author);
        return "Book Added";
    }
}
