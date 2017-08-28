package cn.com.demo.po;

import java.util.Date;

public class ExaQuestions {
	private String questions_no; 
	private Long subject_no;
	private String questions_name;
	private String questions_desc;
	private Date create_time;
	private Date update_time;
	
	public String getQuestions_no() {
		return questions_no;
	}
	public void setQuestions_no(String questions_no) {
		this.questions_no = questions_no;
	}
	public Long getSubject_no() {
		return subject_no;
	}
	public void setSubject_no(Long subject_no) {
		this.subject_no = subject_no;
	}
	public String getQuestions_name() {
		return questions_name;
	}
	public void setQuestions_name(String questions_name) {
		this.questions_name = questions_name;
	}
	public String getQuestions_desc() {
		return questions_desc;
	}
	public void setQuestions_desc(String questions_desc) {
		this.questions_desc = questions_desc;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public Date getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}
	
	
}