package com.greenhouse9.bookmaster.domain;

public class BooksInput {

	/**
	 * ID
	 */
	private String id;

	/**
	 * 書籍コード
	 */
	private String bookCode;

	/**
	 * 名称
	 */
	private String name;

	/**
	 * 名称２
	 */
	private String name2;

	/**
	 * 名称かな
	 */
	private String kanaName;

	/**
	 * 著者名
	 */
	private String authorName;

	/**
	 * 発行所
	 */
	private String publisher;

	/**
	 * 版型
	 */
	private String paperSize;

	/**
	 * シリーズ
	 */
	private String series;

	/**
	 * 巻数本フラグ
	 */
	private String isPartFlg;

	/**
	 * 巻数
	 */
	private String number;

	/**
	 * 総巻数
	 */
	private String totalVolume;

	/**
	 * 発行年
	 */
	private String publishYear;

	/**
	 * 版表示
	 */
	private String editionDisp;

	/**
	 * 版情報
	 */
	private String editionInfo;

	/**
	 * ISBN
	 */
	private String isbn;

	/**
	 * ページ数
	 */
	private String pages;

	/**
	 * 縦(mm)
	 */
	private String height;

	/**
	 * 横(mm)
	 */
	private String width;

	/**
	 * 幅(mm)
	 */
	private String depth;

	/**
	 * 重量(g)
	 */
	private String weight;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBookCode() {
		return bookCode;
	}

	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName2() {
		return name2;
	}

	public void setName2(String name2) {
		this.name2 = name2;
	}

	public String getKanaName() {
		return kanaName;
	}

	public void setKanaName(String kanaName) {
		this.kanaName = kanaName;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPaperSize() {
		return paperSize;
	}

	public void setPaperSize(String paperSize) {
		this.paperSize = paperSize;
	}

	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	public String getIsPartFlg() {
		return isPartFlg;
	}

	public void setIsPartFlg(String isPartFlg) {
		this.isPartFlg = isPartFlg;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getTotalVolume() {
		return totalVolume;
	}

	public void setTotalVolume(String totalVolume) {
		this.totalVolume = totalVolume;
	}

	public String getPublishYear() {
		return publishYear;
	}

	public void setPublishYear(String publishYear) {
		this.publishYear = publishYear;
	}

	public String getEditionDisp() {
		return editionDisp;
	}

	public void setEditionDisp(String editionDisp) {
		this.editionDisp = editionDisp;
	}

	public String getEditionInfo() {
		return editionInfo;
	}

	public void setEditionInfo(String editionInfo) {
		this.editionInfo = editionInfo;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getPages() {
		return pages;
	}

	public void setPages(String pages) {
		this.pages = pages;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getDepth() {
		return depth;
	}

	public void setDepth(String depth) {
		this.depth = depth;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

}
