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
			if (name.length() > 300) {
				isValid = false;
				err = new AppError();
				err.setErrorMessage("name is too long (max 300)");
				errorList.add(err);
			}
		}
		if(isValid){
			book.setName(name);
		}

		//name2 (max 300 chars)
		isValid = true;
		String name2 = "";
		if(!isEmpty(bookInput.getName2())){

			name2 = bookInput.getName2();
			if (name2 != null && name2.length() > 300) {
				isValid = false;
				err = new AppError();
				err.setErrorMessage("name2 is too long (max 300)");
				errorList.add(err);
			}
		}
		if(isValid){
			book.setName2(name2);
		}

		//kanaName (max 300 chars)
		isValid = true;
		String kanaName = "";
		if(!isEmpty(bookInput.getKanaName())){

			kanaName = bookInput.getKanaName();
			if (kanaName != null && kanaName.length() > 300) {
				isValid = false;
				err = new AppError();
				err.setErrorMessage("kanaName is too long (max 300)");
				errorList.add(err);
			}
		}
		if(isValid){
			book.setKanaName(kanaName);
		}

		//authorName (max 300 chars)
		isValid = true;
		String authorName = "";
		if(!isEmpty(bookInput.getAuthorName())){

			authorName = bookInput.getAuthorName();
			if (authorName.length() > 300) {
				isValid = false;
				err = new AppError();
				err.setErrorMessage("authorName is too long (max 300)");
				errorList.add(err);
			}
		}
		if(isValid){
			book.setAuthorName(authorName);
		}

		//publisher (max 150 chars)
		isValid = true;
		String publisher = "";
		if(!isEmpty(bookInput.getPublisher())){

			publisher = bookInput.getPublisher();
			if (publisher.length() > 150) {
				isValid = false;
				err = new AppError();
				err.setErrorMessage("publisher is too long (max 150)");
				errorList.add(err);
			}
		}
		if(isValid){
			book.setPublisher(publisher);
		}

		//paperSize (max 20 chars)
		isValid = true;
		String paperSize = "";
		if(!isEmpty(bookInput.getPaperSize())){

			paperSize = bookInput.getPaperSize();
			if (paperSize.length() > 20) {
				isValid = false;
				err = new AppError();
				err.setErrorMessage("paperSize is too long (max 20)");
				errorList.add(err);
			}
		}
		if(isValid){
			book.setPaperSize(paperSize);
		}

		//series (max 150 chars)
		isValid = true;
		String series = "";
		if(!isEmpty(bookInput.getSeries())){

			series = bookInput.getSeries();
			if (series.length() > 150) {
				isValid = false;
				err = new AppError();
				err.setErrorMessage("series is too long (max 150)");
				errorList.add(err);
			}
		}
		if(isValid){
			book.setSeries(series);
		}

		//isPartFlg (max 1 chars)
		isValid = true;
		Character isPartFlg =  'F';
		if(!isEmpty(bookInput.getIsPartFlg())){

			if (bookInput.getIsPartFlg().length() > 1) {
				isValid = false;
				err = new AppError();
				err.setErrorMessage("isPartFlg is too long (max 1)");
				errorList.add(err);
			}
		}
		if(isValid){
			if (!"F".equals(bookInput.getIsPartFlg()) && !"T".equals(bookInput.getIsPartFlg())){
				isValid = false;
				err = new AppError();
				err.setErrorMessage("isPartFlg is expected only T or F");
				errorList.add(err);
			}
		}
		if(isValid){
			isPartFlg = bookInput.getIsPartFlg().charAt(0);
			book.setIsPartFlg(isPartFlg);
		}

		//number [0 , 999999]
		isValid = true;
		Integer number = null;
		if(!isEmpty(bookInput.getNumber())){

			try {
				number = Integer.parseInt(bookInput.getNumber());
				if (number.compareTo(new Integer(0)) < 0) {
					isValid = false;
					err = new AppError();
					err.setErrorMessage("number is negative");
					errorList.add(err);
				}
				if (number.compareTo(new Integer(999999)) > 0) {
					isValid = false;
					err = new AppError();
					err.setErrorMessage("number is too big (max 999999)");
					errorList.add(err);
				}
			} catch (Exception e) {
				isValid = false;
				err = new AppError();
				err.setErrorMessage("number is not Integer");
				errorList.add(err);
			}

		}
		if(isValid){
			book.setNumber(number);
		}

		//totalVolume [0 , 999999]
		isValid = true;
		Integer totalVolume = null;
		if(!isEmpty(bookInput.getTotalVolume())){

			try {
				totalVolume = Integer.parseInt(bookInput.getTotalVolume());
				if (totalVolume.compareTo(new Integer(0)) < 0) {
					isValid = false;
					err = new AppError();
					err.setErrorMessage("totalVolume is negative");
					errorList.add(err);
				}
				if (totalVolume.compareTo(new Integer(999999)) > 0) {
					isValid = false;
					err = new AppError();
					err.setErrorMessage("totalVolume is too big (max 999999)");
					errorList.add(err);
				}
			} catch (Exception e) {
				isValid = false;
				err = new AppError();
				err.setErrorMessage("totalVolume is not Integer");
				errorList.add(err);
			}

		}
		if(isValid){
			book.setTotalVolume(totalVolume);
		}

		//publishYear [0 , 9999]
		isValid = true;
		Integer publishYear = null;
		if(!isEmpty(bookInput.getPublishYear())){

			try {
				publishYear = Integer.parseInt(bookInput.getPublishYear());
				if (publishYear.compareTo(new Integer(0)) < 0) {
					isValid = false;
					err = new AppError();
					err.setErrorMessage("getPublishYear is negative");
					errorList.add(err);
				}
				if (publishYear.compareTo(new Integer(9999)) > 0) {
					isValid = false;
					err = new AppError();
					err.setErrorMessage("getPublishYear is too big (max 9999)");
					errorList.add(err);
				}
			} catch (Exception e) {
				isValid = false;
				err = new AppError();
				err.setErrorMessage("getPublishYear is not Integer");
				errorList.add(err);
			}

		}
		if(isValid){
			book.setPublishYear(publishYear);
		}

		//editionDisp (max 20 chars)
		isValid = true;
		String editionDisp = "";
		if(!isEmpty(bookInput.getEditionDisp())){

			editionDisp = bookInput.getEditionDisp();
			if (editionDisp.length() > 20) {
				isValid = false;
				err = new AppError();
				err.setErrorMessage("editionDisp is too long (max 20)");
				errorList.add(err);
			}
		}
		if(isValid){
			book.setEditionDisp(editionDisp);
		}

		//editionInfo (max 150 chars)
		isValid = true;
		String editionInfo = "";
		if(!isEmpty(bookInput.getEditionInfo())){

			editionInfo = bookInput.getEditionInfo();
			if (editionInfo.length() > 150) {
				isValid = false;
				err = new AppError();
				err.setErrorMessage("editionInfo is too long (max 20)");
				errorList.add(err);
			}
		}
		if(isValid){
			book.setEditionInfo(editionInfo);
		}

		//isbn (max 20 chars)
		isValid = true;
		String isbn = "";
		if(!isEmpty(bookInput.getIsbn())){

			isbn = bookInput.getIsbn();
			if (isbn.length() > 20) {
				isValid = false;
				err = new AppError();
				err.setErrorMessage("isbn is too long (max 20)");
				errorList.add(err);
			}
		}
		if(isValid){
			book.setIsbn(isbn);
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

		//height [0 , 9999]
		isValid = true;
		Integer height = null;
		if (!isEmpty(bookInput.getHeight())) {

				try {
					height = Integer.parseInt(bookInput.getHeight());
					if (height.compareTo(new Integer(0)) < 0) {
						isValid = false;
						err = new AppError();
						err.setErrorMessage("height is negative");
						errorList.add(err);
					}
					if (height.compareTo(new Integer(9999)) > 0) {
						isValid = false;
						err = new AppError();
						err.setErrorMessage("height is too big (max 9999)");
						errorList.add(err);
					}
				} catch (Exception e) {
					isValid = false;
					err = new AppError();
					err.setErrorMessage("height is not Integer");
					errorList.add(err);
				}
		}
		if(isValid){
			book.setHeight(height);
		}

		//width [0 , 9999]
		isValid = true;
		Integer width = null;
		if (!isEmpty(bookInput.getWidth())) {

				try {
					width = Integer.parseInt(bookInput.getWidth());
					if (width.compareTo(new Integer(0)) < 0) {
						isValid = false;
						err = new AppError();
						err.setErrorMessage("width is negative");
						errorList.add(err);
					}
					if (width.compareTo(new Integer(9999)) > 0) {
						isValid = false;
						err = new AppError();
						err.setErrorMessage("width is too big (max 9999)");
						errorList.add(err);
					}
				} catch (Exception e) {
					isValid = false;
					err = new AppError();
					err.setErrorMessage("width is not Integer");
					errorList.add(err);
				}
		}
		if(isValid){
			book.setWidth(width);
		}

		//depth [0 , 9999]
		isValid = true;
		Integer depth = null;
		if (!isEmpty(bookInput.getDepth())) {

				try {
					depth = Integer.parseInt(bookInput.getDepth());
					if (depth.compareTo(new Integer(0)) < 0) {
						isValid = false;
						err = new AppError();
						err.setErrorMessage("depth is negative");
						errorList.add(err);
					}
					if (depth.compareTo(new Integer(9999)) > 0) {
						isValid = false;
						err = new AppError();
						err.setErrorMessage("depth is too big (max 9999)");
						errorList.add(err);
					}
				} catch (Exception e) {
					isValid = false;
					err = new AppError();
					err.setErrorMessage("depth is not Integer");
					errorList.add(err);
				}
		}
		if(isValid){
			book.setDepth(depth);
		}

		//weight [0 , 9999]
		isValid = true;
		Integer weight = null;
		if (!isEmpty(bookInput.getWeight())) {

				try {
					weight = Integer.parseInt(bookInput.getWeight());
					if (weight.compareTo(new Integer(0)) < 0) {
						isValid = false;
						err = new AppError();
						err.setErrorMessage("weight is negative");
						errorList.add(err);
					}
					if (weight.compareTo(new Integer(9999)) > 0) {
						isValid = false;
						err = new AppError();
						err.setErrorMessage("weight is too big (max 9999)");
						errorList.add(err);
					}
				} catch (Exception e) {
					isValid = false;
					err = new AppError();
					err.setErrorMessage("weight is not Integer");
					errorList.add(err);
				}
		}
		if(isValid){
			book.setWeight(weight);
		}
	}

	public Boolean hasErrors(){
		return !errorList.isEmpty();
	}

	public Boolean noErrors(){
		return errorList.isEmpty();
	}

	private boolean isEmpty(String str){
		return (str == null || str.length() == 0);
	}

}
