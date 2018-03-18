package com.spring.siv.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.spring.siv.spring5webapp.model.Author;
import com.spring.siv.spring5webapp.model.Book;
import com.spring.siv.spring5webapp.model.repositories.AuthorRepository;
import com.spring.siv.spring5webapp.model.repositories.BookRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	
	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	
	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
	}

	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
		initData();
	}
	
	private void initData() {
			Author eric = new Author("Eric", "Evans");
			Book ddd = new Book("Domain Driven Design", "1234", "Harper Collins");
			ddd.getAuthors().add(eric);
			eric.getBooks().add(ddd);
			
			authorRepository.save(eric);
			bookRepository.save(ddd);
			
			Author rod = new Author("Rod", "Johnson");
			Book noEJB = new Book("J2EE Development without EJB", "23444", "Wrox");
			noEJB.getAuthors().add(rod);
			rod.getBooks().add(noEJB);	
			
			authorRepository.save(rod);
			bookRepository.save(noEJB);			
	}
}
