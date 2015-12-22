package com.greenhouse9.bookmaster.persistence;

import java.util.List;
import java.util.Map;

import com.greenhouse9.bookmaster.domain.Books;

public interface BooksMapper {

	Books selectBook(Integer id);

	List<Books> selectAllBooks();

	List<Books> selectByCondition(Map<String, Object> conditionMap);

	void insert(Books record);

	int updateByPrimaryKey(Books record);
}
