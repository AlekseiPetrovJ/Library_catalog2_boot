package ru.petrov.Library_catalog2_boot.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.List;

@Entity
@Table(name = "Person")
public class Person {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Transient
    private static final int MAX_YEAR = 2023;

    @NotEmpty(message = "ФИО не должно быть пустым")
    @Size(min = 2, max = 60, message = "Длина ФИО должна быть 2-60")
    @Pattern(regexp = "([А-ЯЁ][а-яё]+[\\-\\s]?){3,}", message = "ФИО должно быть в формате Фамилия Имя Отчество")
    @Column(name = "fullname")
    private String fullname;

    @Min(value = (MAX_YEAR - 99), message = "Год рождения не должен быть раньше " + (MAX_YEAR - 99))
    @Max(value = MAX_YEAR, message = "Год рождения не должен быть позже " + MAX_YEAR)
    @Column(name = "year_of_birth")
    private int yearOfBirth;

    @OneToMany(mappedBy = "person", fetch = FetchType.LAZY)
    private List<Book> books;

    public Person(int id, String fullname, int yearOfBirth) {
        this.id = id;
        this.fullname = fullname;
        this.yearOfBirth = yearOfBirth;
    }

    public Person() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }
}
