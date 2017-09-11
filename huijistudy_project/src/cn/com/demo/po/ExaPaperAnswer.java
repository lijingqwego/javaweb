package cn.com.demo.po;

import java.util.Date;

public class ExaPaperAnswer {
	private String examinati_list_id;
	private String examination_id;
	private Long question_num;
	private Long answer_num;
	private String answer_name;
	private String answer_content;
	private Long istrue;
	private String create_user;
	private Date create_time;
	private Date update_time;
	
	public String getExaminati_list_id() {
		return examinati_list_id;
	}
	public void setExaminati_list_id(String examinati_list_id) {
		this.examinati_list_id = examinati_list_id;
	}
	public String getExamination_id() {
		return examination_id;
	}
	public void setExamination_id(String examination_id) {
		this.examination_id = examination_id;
	}
	public Long getQuestion_num() {
		return question_num;
	}
	public void setQuestion_num(Long question_num) {
		this.question_num = question_num;
	}
	public Long getAnswer_num() {
		return answer_num;
	}
	public void setAnswer_num(Long answer_num) {
		this.answer_num = answer_num;
	}
	public String getAnswer_content() {
		return answer_content;
	}
	public void setAnswer_content(String answer_content) {
		this.answer_content = answer_content;
	}
	public Long getIstrue() {
		return istrue;
	}
	public void setIstrue(Long istrue) {
		this.istrue = istrue;
	}
	public String getCreate_user() {
		return create_user;
	}
	public void setCreate_user(String create_user) {
		this.create_user = create_user;
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
	
	public String getAnswer_name() {
		return answer_name;
	}
	public void setAnswer_name(String answer_name) {
		this.answer_name = answer_name;
	}
	@Override
	public String toString() {
		return "ExaPaperAnswer [examinati_list_id=" + examinati_list_id + ", examination_id=" + examination_id
				+ ", question_num=" + question_num + ", answer_num=" + answer_num + ", answer_content=" + answer_content
				+ ", istrue=" + istrue + ", create_user=" + create_user + ", create_time=" + create_time
				+ ", update_time=" + update_time + "]";
	}
	
}