package edu.muc.jxd.vo;

/**
 * Created by Simon on 2016/6/1. 这个YiCharcter可以转为HBaseVO
 */
public class YiCharcter {
	// 返回ID
	private String id;

	// rowkey
	private String rowkey;

	// 释义
	private String meaning;

	// 图像的地址
	private String imgUrl;

	// 文字的返回结果id

	public YiCharcter() {

	}

	public YiCharcter(String weidu, String jingdu, String id, String imgUrl) {
		this.rowkey = "X+" + weidu + "," + "Y+" + jingdu;
		this.id = id;
		this.meaning = Dictionary.dic.get(id);
		this.imgUrl = imgUrl;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRowkey() {
		return rowkey;
	}

	public void setRowkey(String rowkey) {
		this.rowkey = rowkey;
	}

	public String getMeaning() {
		return meaning;
	}

	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
}
