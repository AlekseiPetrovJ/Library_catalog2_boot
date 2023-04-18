package ru.petrov.Library_catalog2_boot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.petrov.Library_catalog2_boot.models.Book;
import ru.petrov.Library_catalog2_boot.models.Person;

import java.util.List;

@Repository
public interface BooksRepository extends JpaRepository<Book, Integer> {
    List<Book> findByPerson(Person person);

    List<Book> findByNameStartingWith(String startName);
}
