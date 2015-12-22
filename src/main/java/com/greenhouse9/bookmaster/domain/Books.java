package com.greenhouse9.bookmaster.domain;

public class Books {

	/**
	 * ID
	 */
	private Long id;

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
	private Character isPartFlg;

	/**
	 * 巻数
	 */
	private Integer number;

	/**
	 * 総巻数
	 */
	private Integer totalVolume;

	/**
	 * 発行年
	 */
	private Integer publishYear;

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
	private Integer pages;

	/**
	 * 縦(mm)
	 */
	private Integer height;

	/**
	 * 横(mm)
	 */
	private Integer width;

	/**
	 * 幅(mm)
	 */
	private Integer depth;

	/**
	 * 重量(g)
	 */
	private Integer weight;

	/**
	 * IDを取得します。
	 * @return ID
	 */
	public Long getId() {
		return id;
	}

	/**
	 * IDを設定します。
	 * @param id ID
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 書籍コードを取得します。
	 * @return 書籍コード
	 */
	public String getBookCode() {
		return bookCode;
	}

	/**
	 * 書籍コードを設定します。
	 * @param bookCode 書籍コード
	 */
	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}

	/**
	 * 名称を取得します。
	 * @return 名称
	 */
	public String getName() {
		return name;
	}

	/**
	 * 名称を設定します。
	 * @param name 名称
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 名称２を取得します。
	 * @return 名称２
	 */
	public String getName2() {
		return name2;
	}

	/**
	 * 名称２を設定します。
	 * @param name2 名称２
	 */
	public void setName2(String name2) {
		this.name2 = name2;
	}

	/**
	 * 名称かなを取得します。
	 * @return 名称かな
	 */
	public String getKanaName() {
		return kanaName;
	}

	/**
	 * 名称かなを設定します。
	 * @param kanaName 名称かな
	 */
	public void setKanaName(String kanaName) {
		this.kanaName = kanaName;
	}

	/**
	 * 著者名を取得します。
	 * @return 著者名
	 */
	public String getAuthorName() {
		return authorName;
	}

	/**
	 * 著者名を設定します。
	 * @param authorName 著者名
	 */
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	/**
	 * 発行所を取得します。
	 * @return 発行所
	 */
	public String getPublisher() {
		return publisher;
	}

	/**
	 * 発行所を設定します。
	 * @param publisher 発行所
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	/**
	 * 版型を取得します。
	 * @return 版型
	 */
	public String getPaperSize() {
		return paperSize;
	}

	/**
	 * 版型を設定します。
	 * @param paperSize 版型
	 */
	public void setPaperSize(String paperSize) {
		this.paperSize = paperSize;
	}

	/**
	 * シリーズを取得します。
	 * @return シリーズ
	 */
	public String getSeries() {
		return series;
	}

	/**
	 * シリーズを設定します。
	 * @param series シリーズ
	 */
	public void setSeries(String series) {
		this.series = series;
	}

	/**
	 * 巻数本フラグを取得します。
	 * @return 巻数本フラグ
	 */
	public Character getIsPartFlg() {
		return isPartFlg;
	}

	/**
	 * 巻数本フラグを設定します。
	 * @param isPartFlg 巻数本フラグ
	 */
	public void setIsPartFlg(Character isPartFlg) {
		this.isPartFlg = isPartFlg;
	}

	/**
	 * 巻数を取得します。
	 * @return 巻数
	 */
	public Integer getNumber() {
		return number;
	}

	/**
	 * 巻数を設定します。
	 * @param number 巻数
	 */
	public void setNumber(Integer number) {
		this.number = number;
	}

	/**
	 * 総巻数を取得します。
	 * @return 総巻数
	 */
	public Integer getTotalVolume() {
		return totalVolume;
	}

	/**
	 * 総巻数を設定します。
	 * @param totalVolume 総巻数
	 */
	public void setTotalVolume(Integer totalVolume) {
		this.totalVolume = totalVolume;
	}

	/**
	 * 発行年を取得します。
	 * @return 発行年
	 */
	public Integer getPublishYear() {
		return publishYear;
	}

	/**
	 * 発行年を設定します。
	 * @param publishYear 発行年
	 */
	public void setPublishYear(Integer publishYear) {
		this.publishYear = publishYear;
	}

	/**
	 * 版表示を取得します。
	 * @return 版表示
	 */
	public String getEditionDisp() {
		return editionDisp;
	}

	/**
	 * 版表示を設定します。
	 * @param editionDisp 版表示
	 */
	public void setEditionDisp(String editionDisp) {
		this.editionDisp = editionDisp;
	}

	/**
	 * 版情報を取得します。
	 * @return 版情報
	 */
	public String getEditionInfo() {
		return editionInfo;
	}

	/**
	 * 版情報を設定します。
	 * @param editionInfo 版情報
	 */
	public void setEditionInfo(String editionInfo) {
		this.editionInfo = editionInfo;
	}

	/**
	 * ISBNを取得します。
	 * @return ISBN
	 */
	public String getIsbn() {
		return isbn;
	}

	/**
	 * ISBNを設定します。
	 * @param isbn ISBN
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	/**
	 * ページ数を取得します。
	 * @return ページ数
	 */
	public Integer getPages() {
		return pages;
	}

	/**
	 * ページ数を設定します。
	 * @param pages ページ数
	 */
	public void setPages(Integer pages) {
		this.pages = pages;
	}

	/**
	 * 縦(mm)を取得します。
	 * @return 縦(mm)
	 */
	public Integer getHeight() {
		return height;
	}

	/**
	 * 縦(mm)を設定します。
	 * @param height 縦(mm)
	 */
	public void setHeight(Integer height) {
		this.height = height;
	}

	/**
	 * 横(mm)を取得します。
	 * @return 横(mm)
	 */
	public Integer getWidth() {
		return width;
	}

	/**
	 * 横(mm)を設定します。
	 * @param width 横(mm)
	 */
	public void setWidth(Integer width) {
		this.width = width;
	}

	/**
	 * 幅(mm)を取得します。
	 * @return 幅(mm)
	 */
	public Integer getDepth() {
		return depth;
	}

	/**
	 * 幅(mm)を設定します。
	 * @param depth 幅(mm)
	 */
	public void setDepth(Integer depth) {
		this.depth = depth;
	}

	/**
	 * 重量(g)を取得します。
	 * @return 重量(g)
	 */
	public Integer getWeight() {
		return weight;
	}

	/**
	 * 重量(g)を設定します。
	 * @param weight 重量(g)
	 */
	public void setWeight(Integer weight) {
		this.weight = weight;
	}

}
