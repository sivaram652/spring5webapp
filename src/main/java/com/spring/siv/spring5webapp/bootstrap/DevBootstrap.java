package com.spring.siv.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.spring.siv.spring5webapp.model.Author;
import com.spring.siv.spring5webapp.model.Book;
import com.spring.siv.spring5webapp.model.Publisher;
import com.spring.siv.spring5webapp.model.repositories.AuthorRepository;
import com.spring.siv.spring5webapp.model.repositories.BookRepository;
import com.spring.siv.spring5webapp.model.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	
	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	private PublisherRepository publisherRepository;
	
	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}	
	

	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
		initData();
	}
	
	private void initData() {
			Author eric = new Author("Eric", "Evans");
			Publisher dddPub = new Publisher("Harper Collins", "1 Silicon Valley, CA");
			Book ddd = new Book("Domain Driven Design", "1234",dddPub);
			ddd.getAuthors().add(eric);
			eric.getBooks().add(ddd);
			
			authorRepository.save(eric);
			bookRepository.save(ddd);
			publisherRepository.save(dddPub);
			
			Author rod = new Author("Rod", "Johnson");
			Publisher noEJBpub = new Publisher("Wrox", "10 Downing Street, UK");
			Book noEJB = new Book("J2EE Development without EJB", "23444", noEJBpub);
			noEJB.getAuthors().add(rod);
			rod.getBooks().add(noEJB);	
			
			authorRepository.save(rod);
			bookRepository.save(noEJB);		
			publisherRepository.save(noEJBpub);
	}
}
