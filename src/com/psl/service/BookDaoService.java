package com.psl.service;

import com.psl.entity.Book;
import com.psl.exceptions.IntegrityVoilationException;

public interface BookDaoService {
	public int addBook(Book book) throws IntegrityVoilationException;
	public Book getAll(int id) throws IntegrityVoilationException;
	public int update(int id, int copies) throws IntegrityVoilationException;
	public int delete(int id) throws IntegrityVoilationException;

}
