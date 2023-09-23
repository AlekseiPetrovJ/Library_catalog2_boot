package ru.petrov.Library_catalog2_boot.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.Date;

@Entity
@Table(name = "Book")
public class Book {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person person;
    @Transient
    private static final int MAX_YEAR = 2023;
    @NotEmpty(message = "Название не должно быть пустым")
    @Size(min = 2, max = 200, message = "Длина названия должна быть 2-200")
    @Column(name = "name")
    private String name;
    @NotEmpty(message = "Автор не должен быть пустым")
    @Size(min = 2, max = 200, message = "Длина имени автора должна быть 2-200")
    @Column(name = "author")
    private String author;
    @Min(value = (MAX_YEAR - 99), message = "Год издания не должен быть раньше " + (MAX_YEAR - 99))
    @Max(value = MAX_YEAR, message = "Год издания не должен быть позже " + MAX_YEAR)
    @Column(name = "publication_date")
    private int publicationDate;

    @Column(name = "date_of_issue")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfIssue;

    @Transient
    private boolean overstay;

    public Book() {
    }

    public boolean isOverstay() {
        return overstay;
    }

    public void setOverstay(boolean overstay) {
        this.overstay = overstay;
    }

    public Date getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(Date dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(int publicationDate) {
        this.publicationDate = publicationDate;
    }
}

