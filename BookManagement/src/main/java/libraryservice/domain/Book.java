package libraryservice.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import libraryservice.BookManagementApplication;
import libraryservice.domain.BookRegistered;
import libraryservice.domain.BookStatusUpdated;
import lombok.Data;

@Entity
@Table(name = "Book_table")
@Data
//<<< DDD / Aggregate Root
public class Book {

    @Id
    private String bookId;

    private String title;

    private String author;

    private String publisher;

    @Enumerated(EnumType.STRING)
    private BookCategory category;

    @Enumerated(EnumType.STRING)
    private BookStatus status;

    @Embedded
    private Isbn isbn;

    @PostPersist
    public void onPostPersist() {
        BookRegistered bookRegistered = new BookRegistered(this);
        bookRegistered.publishAfterCommit();
    }

    @PostUpdate
    public void onPostUpdate() {
        BookStatusUpdated bookStatusUpdated = new BookStatusUpdated(this);
        bookStatusUpdated.publishAfterCommit();
    }

    @PrePersist
    public void onPrePersist() {}

    public static BookRepository repository() {
        BookRepository bookRepository = BookManagementApplication.applicationContext.getBean(
            BookRepository.class
        );
        return bookRepository;
    }

    public void RegisterBook() {
        //
    }

    //<<< Clean Arch / Port Method
    public static void loanStatusUpdatePolicy(LoanCreated loanCreated) {
        //implement business logic here:

        // if aggregate reference class exists, use it

        // ObjectMapper mapper = new ObjectMapper();
        // Map<String, Object> loanMap = mapper.convertValue(loanCreated.getBookId(), Map.class);

        /** Example 1:  new item 
        Book book = new Book();
        repository().save(book);

        BookStatusUpdated bookStatusUpdated = new BookStatusUpdated(book);
        bookStatusUpdated.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(loanCreated.get???()).ifPresent(book->{
            
            book // do something
            repository().save(book);

            BookStatusUpdated bookStatusUpdated = new BookStatusUpdated(book);
            bookStatusUpdated.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void returnStatusUpdatePolicy(LoanReturned loanReturned) {
        //implement business logic here:

        // if aggregate reference class exists, use it

        // ObjectMapper mapper = new ObjectMapper();
        // Map<String, Object> loanMap = mapper.convertValue(loanReturned.getBookId(), Map.class);

        /** Example 1:  new item 
        Book book = new Book();
        repository().save(book);

        BookStatusUpdated bookStatusUpdated = new BookStatusUpdated(book);
        bookStatusUpdated.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(loanReturned.get???()).ifPresent(book->{
            
            book // do something
            repository().save(book);

            BookStatusUpdated bookStatusUpdated = new BookStatusUpdated(book);
            bookStatusUpdated.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
