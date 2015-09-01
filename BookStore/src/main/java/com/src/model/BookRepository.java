package com.src.model;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.src.entity.BookMON;

@Repository
public interface BookRepository extends MongoRepository<BookMON, String>{
	
}
