package com.psl.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.psl.entity.Book;
import com.psl.exceptions.IntegrityVoilationException;
import com.psl.service.BookDaoService;
@Component
public class BookDao implements BookDaoService {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	class BookMapper implements RowMapper<Book>{

		@Override
		public Book mapRow(ResultSet res, int arg1) throws SQLException {
			// TODO Auto-generated method stub
			Book book =new Book();
			book.setBookId(res.getInt(1));
			book.setName(res.getString(2));
			book.setAuthorName(res.getString(3));
			book.setCopies(res.getInt(4));
			return book;
		}
		
	}
	
	@Override
	public int addBook(Book book) throws IntegrityVoilationException {
	
	    String sql;
		int i = 0;
	    try {
			sql = "insert into book values(?,?,?,?)";
		
	     i=jdbcTemplate.update(sql,book.getBookId(),book.getName(),book.getAuthorName(),book.getCopies());
		}catch (Exception e) {
			// TODO Auto-generated catch block
			throw new IntegrityVoilationException("integrity");
			
		}
	    return i;
	
		
	}

	@Override
	public Book getAll(int id) throws IntegrityVoilationException {
		// TODO Auto-generated method stub
	   String sql;
	   try{
	   sql="select * from book where id="+id;
      return (Book) jdbcTemplate.queryForObject(sql, new BookMapper());
	   }catch (Exception e) {
			// TODO Auto-generated catch block
			throw new IntegrityVoilationException("integrity");
			
		}
	
	   
	}

	@Override
	public int update(int id, int copies) throws IntegrityVoilationException {
		// TODO Auto-generated method stub
		String sql;
		try{
		sql="update book SET copies=? where id="+id;
		return jdbcTemplate.update(sql,copies);
		}catch (Exception e) {
			// TODO Auto-generated catch block
			throw new IntegrityVoilationException("update error");
			
		}
	}

	@Override
	public int delete(int id) throws IntegrityVoilationException {
		// TODO Auto-generated method stub
		String sql;
		try {
			sql="delete from book where id="+id;
			return jdbcTemplate.update(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new IntegrityVoilationException("delete error");

		}
		
	}
	

}
