package article.model;

import java.util.Date;

public class Article {

	private String article_no;
	private String writer_id;
	private String writer_name;
	private String title;
	private Date regdate;
	private Date moddate;
	private String read_cnt;
	private String content;
	
	public Article(String article_no, String writer_name, String title,	String read_cnt, Date regdate , Date moddate) {
		this.article_no = article_no;
		this.writer_name = writer_name;
		this.title = title;
		this.read_cnt = read_cnt;
	}
	
	


	public Article(String writer_id, String writer_name) {
		this.writer_id = writer_id;
		this.writer_name = writer_name;
	}




	public Article(String article_no, String writer_name, String title, String content) {
		this.article_no = article_no;
		this.writer_name = writer_name;
		this.title = title;
		this.content = content;
	}


	public Article() {

	}

	public String getArticle_no() {
		return article_no;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setArticle_no(String article_no) {
		this.article_no = article_no;
	}
	public String getWriter_id() {
		return writer_id;
	}
	public void setWriter_id(String writer_id) {
		this.writer_id = writer_id;
	}
	public String getWriter_name() {
		return writer_name;
	}
	public void setWriter_name(String writer_name) {
		this.writer_name = writer_name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public Date getModdate() {
		return moddate;
	}
	public void setModdate(Date moddate) {
		this.moddate = moddate;
	}
	public String getRead_cnt() {
		return read_cnt;
	}
	public void setRead_cnt(String read_cnt) {
		this.read_cnt = read_cnt;
	}

	

}
