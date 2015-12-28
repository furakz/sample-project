package com.greenhouse9.bookmaster.service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Service;

import com.greenhouse9.bookmaster.domain.Book;
import com.greenhouse9.bookmaster.domain.BookHelper;
import com.greenhouse9.bookmaster.domain.BookInput;
import com.greenhouse9.bookmaster.domain.Books;
import com.greenhouse9.bookmaster.domain.BooksHelper;
import com.greenhouse9.bookmaster.domain.BooksInput;
import com.greenhouse9.bookmaster.persistence.BooksMapper;

@Service
public class BooksService {

	private static String resource = "mybatis-config.xml";

	private BooksMapper mapper;

	public List<Books> selectAllBook() throws IOException{

        SqlSession session = getSession();

        mapper = session.getMapper(BooksMapper.class);
		List<Books> bookList = mapper.selectAllBooks();
		//List<Book> bookList = null;

		session.close();

		return bookList;
	}

	public List<Books> selectByCondition(Map<String,Object> conditionMap) throws IOException{

        SqlSession session = getSession();

        mapper = session.getMapper(BooksMapper.class);
		List<Books> bookList = mapper.selectByCondition(conditionMap);

		session.close();

		return bookList;
	}

	public Books selectByPrimaryKey(Integer id) throws IOException {

        SqlSession session = getSession();

        mapper = session.getMapper(BooksMapper.class);
		Books book = mapper.selectBook(id);

		session.close();

		return book;
	}

	public void insert(Books record) throws IOException {

        SqlSession session = getSession();

        mapper = session.getMapper(BooksMapper.class);

        System.out.println("BooksService#insert " + record.getId());
        mapper.insert(record);

        session.commit();
		session.close();
	}

	public int update(Books book) throws IOException {

        SqlSession session = getSession();

        mapper = session.getMapper(BooksMapper.class);

		int ret = mapper.updateByPrimaryKey(book);

        session.commit();
		session.close();

		return ret;
	}

	public Book update(BookInput bookInput) throws IOException {

		BookHelper helper = new BookHelper();
		Book book = helper.getBook(bookInput);
		//update(book);

		return book;
	}

	public Books create(BooksInput booksInput) throws IOException {

		BooksHelper helper = new BooksHelper();
		Books books = new Books();
		helper.bind(booksInput,books);

		insert(books);

		return books;
	}

	public void upload(String filepath, String errpath) {

		BufferedReader br = null;
		try {

			String line;
			String tokenArray [];
			FileInputStream fis = new FileInputStream(filepath);
			InputStreamReader fsr = new InputStreamReader(fis, Charset.forName("UTF-8"));
			br = new BufferedReader(fsr);

			while((line = br.readLine()) != null) {

				tokenArray = line.split(",");

				if (tokenArray.length < 4) {
					continue;
				}

				BookInput book = new BookInput();
				book.setId(tokenArray[0]);
				book.setTitle(tokenArray[1]);
				book.setPrice(tokenArray[2]);
				book.setNbOfPage(tokenArray[3]);

				Books book2 = null;
				try {
					Integer.parseInt(book.getId());
					book2 = selectByPrimaryKey(Integer.parseInt(book.getId()));
				} catch (Exception e){

				}

				if (book2 == null) {
					//create(book);
				} else {
					update(book);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (Exception e){

			}
		}
	}

	private SqlSession getSession() throws IOException{

		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();

        return session;

	}
}
