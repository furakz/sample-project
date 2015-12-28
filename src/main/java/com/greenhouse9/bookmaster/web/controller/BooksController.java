package com.greenhouse9.bookmaster.web.controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.greenhouse9.bookmaster.common.AppError;
import com.greenhouse9.bookmaster.domain.Book;
import com.greenhouse9.bookmaster.domain.BookInput;
import com.greenhouse9.bookmaster.domain.Books;
import com.greenhouse9.bookmaster.domain.BooksHelper;
import com.greenhouse9.bookmaster.domain.BooksInput;
import com.greenhouse9.bookmaster.service.BooksService;

@Controller
@RequestMapping(value="books")
public class BooksController {

	@Autowired
	private BooksService service;

	@RequestMapping(value="select", method=GET)
	public String select(Model model) {

		try {

			List<Books> bookList = service.selectAllBook();
			model.addAttribute("bookList", bookList);

		} catch (IOException e) {
			e.printStackTrace();
		}
		//return "sample1";
		return "books/list";
	}

	@RequestMapping(value="select/{id}", method=GET)
	public String selectById(@PathVariable Integer id, Model model) {

		try {
			Books book = service.selectByPrimaryKey(id);
			model.addAttribute("book", book);

		} catch (IOException e) {
			e.printStackTrace();
		}

		//return "sample2";
		return "books/edit";
	}

	@RequestMapping(value="edit_new", method=GET)
	public String editNew(Model model) {

		//return "sample3";
		return "books/edit_new";
	}

	@RequestMapping(value="edit_upload", method=GET)
	public String editUpload(Model model){

		//return "sample4";
		return "books/edit_upload";
	}

	@RequestMapping(value="sch_download", method=GET)
	public String schDownload(Model model){

		//return "sample5";
		return "books/sch_download";
	}

	@RequestMapping(value="update", method=POST)
	public String update(@ModelAttribute BookInput form, Model model) {

		System.out.println("TEST: " + form.getPrice());

		try {
			Book book = service.update(form);
			model.addAttribute("book", book);

		} catch (Exception e) {
			e.printStackTrace();

			model.addAttribute("book", form);
			return "books/edit";
		}

		return "redirect:select/" + form.getId();
	}

	@RequestMapping(value="create", method=POST)
	public String create(@ModelAttribute BooksInput form, Model model, RedirectAttributes attributes) {

		try {
			Books books = new Books();
			BooksHelper booksHelper = new BooksHelper();
			booksHelper.bind(form, books);

			if (booksHelper.hasErrors()) {
				String message = "error occured! <br />";

				for (AppError err:booksHelper.getErrors()){
					message = message + err.getErrorMessage() + "<br />";
				}
				attributes.addFlashAttribute("message", message);
				attributes.addFlashAttribute("book", form);
			} else {
				books = service.create(form);
			}

		} catch (Exception e) {
			e.printStackTrace();

			model.addAttribute("book", form);
			//return "sample3";
			return "books/edit_new";
		}

		return "redirect:edit_new";
	}

	@RequestMapping(value="search", method=POST)
	public String search(HttpServletRequest request, Model model) {

		Map<String,String[]> map = request.getParameterMap();
		Map<String, Object> condMap = bindCondition(map);

		for(String key: condMap.keySet()){
			System.out.println("key: " + key + " value: " + condMap.get(key));
		}
		try {

			List<Books> bookList = service.selectByCondition(condMap);
			model.addAttribute("bookList", bookList);

		} catch (IOException e) {

			e.printStackTrace();
		}

		model.addAttribute("conditionForm", map);

		//return "sample1";
		return "books/list";
	}

	@RequestMapping(value="download", method=POST, produces="text/csv;charset=utf-8")
	@ResponseBody
	public String download(HttpServletRequest request, HttpServletResponse response, Model model) {

		Map<String,String[]> map = request.getParameterMap();
		Map<String, Object> condMap = bindCondition(map);

		StringBuilder sb = null;

		try {

			List<Books> bookList = service.selectByCondition(condMap);

			sb = new StringBuilder();

			for (Books book:bookList) {

				sb.append(book.getId()).append(",");
				sb.append(book.getBookCode()).append(",");
				sb.append(book.getName()).append(",");
				sb.append(book.getName2()).append(",");
				sb.append(book.getKanaName()).append(",");
				sb.append(book.getAuthorName()).append(",");
				sb.append(book.getPublisher()).append(",");
				sb.append(book.getPaperSize()).append(",");
				sb.append(book.getSeries()).append(",");
				sb.append(book.getIsPartFlg()).append(",");
				sb.append(book.getNumber()).append(",");
				sb.append(book.getTotalVolume()).append(",");
				sb.append(book.getPublishYear()).append(",");
				sb.append(book.getEditionDisp()).append(",");
				sb.append(book.getEditionInfo()).append(",");
				sb.append(book.getIsbn()).append(",");
				sb.append(book.getPages()).append(",");
				sb.append(book.getHeight()).append(",");
				sb.append(book.getWidth()).append(",");
				sb.append(book.getDepth()).append(",");
				sb.append(book.getWeight());

				sb.append("\r\n");
			}

			response.setHeader("Content-Disposition", "attachment; filename=\"books.csv\"");

		} catch (IOException e) {

			e.printStackTrace();
		}


		return sb.toString();
	}

	/**
	 * @param form 入力フォーム
	 * @param model
	 * @return
	 */
	@RequestMapping(value="upload", method=POST)
	public String upload(@ModelAttribute BookInput form, Model model) {

		FileOutputStream fos = null;
		try {
			InputStream is  = form.getFilename().getInputStream();

			byte buffer[] = new byte[1024];
			is.reset();
			int len;
			File outFile = new File("C:\\development\\book-master\\app\\temp\\out.txt");
			if (outFile.exists() || outFile.createNewFile()) {
				fos = new FileOutputStream(outFile);
				while((len = is.read(buffer)) != -1) {
					fos.write(buffer, 0, len);
				}
			}

			service.upload("C:\\development\\book-master\\app\\temp\\out.txt", "C:\\development\\book-master\\app\\temp\\err.txt");

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				if (fos != null) {
					fos.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		//return "sample4";
		return "books/edit_upload";
	}

//	private boolean containsNonEmpty(String [] array) {
//		for (String str: array){
//			if (str != null && str.length() >0){
//				return true;
//			}
//		}
//		return false;
//	}

	private Map<String,Object> bindCondition(Map<String,String[]> map){

		Map<String, Object> condMap = new HashMap<String,Object>();

		for(String key: map.keySet()){

			switch(key){
				case "name":
				case "kanaName":
				case "authorName":
				case "publisher":
				case "isbn":
					condMap.put(key, map.get(key)[0]);
			}
		}

		return condMap;
	}
}
