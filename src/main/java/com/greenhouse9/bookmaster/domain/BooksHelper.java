package com.greenhouse9.bookmaster.domain;

import java.util.ArrayList;
import java.util.List;

import com.greenhouse9.bookmaster.common.AppError;

public class BooksHelper {

	private List<AppError> errorList = new ArrayList<AppError>();

	public List<AppError> getErrors () {
		return errorList;
	}
	public void bind(BooksInput bookInput, Books book) {

		if (book == null){
			book = new Books();
		}

		boolean isValid = true;
		AppError err;

		errorList.clear();

		//id
		Long id = null;
		if (isEmpty(bookInput.getId())) {
			isValid = false;
			err = new AppError();
			err.setErrorMessage("id is empty");
			errorList.add(err);
		}
		if(isValid){

			try {
				id = Long.parseLong(bookInput.getId());
			} catch(Exception e) {
				isValid = false;
				err = new AppError();
				err.setErrorMessage("id is not number format");
				errorList.add(err);
			}
		}
		if (isValid){
			book.setId(id);
		}

		//bookCode
		isValid = true;
		String bookCode = "";
		if (isEmpty(bookInput.getBookCode())) {
			isValid = false;
			err = new AppError();
			err.setErrorMessage("bookCode is empty");
			errorList.add(err);
		}
		if(isValid){

			bookCode = bookInput.getBookCode();
			if (bookCode.length() > 20) {
				isValid = false;
				err = new AppError();
				err.setErrorMessage("bookCode is too long (max 20)");
				errorList.add(err);
			}
		}
		if(isValid){
			book.setBookCode(bookCode);
		}

		//name (max 300 chars)
		isValid = true;
		String name = "";
		if (isEmpty(bookInput.getName())) {
			isValid = false;
			err = new AppError();
			err.setErrorMessage("name is empty");
			errorList.add(err);
		}
		if(isValid){

			name = bookInput.getName();
			if (bookCode.length() > 300) {
				isValid = false;
				err = new AppError();
				err.setErrorMessage("name is too long (max 300)");
				errorList.add(err);
			}
		}
		if(isValid){
			book.setName(name);
		}


		//page [0 , 999999]
		isValid = true;
		Integer pages = null;
		if (!isEmpty(bookInput.getPages())) {

				try {
					pages = Integer.parseInt(bookInput.getPages());
					if (pages < 0) {
						isValid = false;
						err = new AppError();
						err.setErrorMessage("pages is negative");
						errorList.add(err);
					}
					if (pages > 999999) {
						isValid = false;
						err = new AppError();
						err.setErrorMessage("pages is too big (max 999999)");
						errorList.add(err);
					}
				} catch (Exception e) {
					isValid = false;
					err = new AppError();
					err.setErrorMessage("pages is not Integer");
					errorList.add(err);
				}
		}
		if(isValid){
			book.setPages(pages);
		}
	}

	private boolean isEmpty(String str){
		return (str == null || str.length() == 0);
	}

}
