package com.spring.siv.spring5webapp.model.repositories;

import org.springframework.data.repository.CrudRepository;

import com.spring.siv.spring5webapp.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

}
