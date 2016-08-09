package com.psl.service;



import java.util.List;

import com.psl.entity.Book;
import com.psl.exceptions.IntegrityVoilationException;

public interface MainService {
	public int addBook(Book book) throws IntegrityVoilationException;
	public Book getBook(int id) throws IntegrityVoilationException;
	public int update(int id,int copies) throws IntegrityVoilationException;
	public int delete(int id) throws IntegrityVoilationException;
}
