package com.psl.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psl.entity.Book;
import com.psl.exceptions.IntegrityVoilationException;
import com.psl.service.BookDaoService;
import com.psl.service.MainService;
@Service
public class MainServiceImpl  implements MainService{
	@Autowired
	private BookDaoService bDao;

	@Override
	public int addBook(Book book) throws IntegrityVoilationException {
		// TODO Auto-generated method stub
		return bDao.addBook(book);   
	}

	@Override
	public Book getBook(int id) throws IntegrityVoilationException {
		// TODO Auto-generated method stub
		return bDao.getAll(id);
	}

	@Override
	public int update(int id, int copies) throws IntegrityVoilationException {
		// TODO Auto-generated method stub
		return bDao.update(id, copies);
	}

	@Override
	public int delete(int id) throws IntegrityVoilationException {
		// TODO Auto-generated method stub
		return bDao.delete(id);
	}

}
