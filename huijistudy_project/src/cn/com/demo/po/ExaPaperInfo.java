package cn.com.demo.po;

import java.util.Date;

public class ExaPaperInfo {
	private String examination_id;
	private String examination_no;
	private String question_no;
	private Long question_type;
	private Long question_xh;
	private String question_name;
	private Long question_nscore;
	private String right_key;
	private Date create_time;
	private Date update_time;
	
	public String getExamination_id() {
		return examination_id;
	}
	public void setExamination_id(String examination_id) {
		this.examination_id = examination_id;
	}
	public String getExamination_no() {
		return examination_no;
	}
	public void setExamination_no(String examination_no) {
		this.examination_no = examination_no;
	}
	public String getQuestion_no() {
		return question_no;
	}
	public void setQuestion_no(String question_no) {
		this.question_no = question_no;
	}
	public Long getQuestion_type() {
		return question_type;
	}
	public void setQuestion_type(Long question_type) {
		this.question_type = question_type;
	}
	
	public Long getQuestion_xh() {
		return question_xh;
	}
	public void setQuestion_xh(Long question_xh) {
		this.question_xh = question_xh;
	}
	public String getQuestion_name() {
		return question_name;
	}
	public void setQuestion_name(String question_name) {
		this.question_name = question_name;
	}
	public Long getQuestion_nscore() {
		return question_nscore;
	}
	public void setQuestion_nscore(Long question_nscore) {
		this.question_nscore = question_nscore;
	}
	public String getRight_key() {
		return right_key;
	}
	public void setRight_key(String right_key) {
		this.right_key = right_key;
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
	@Override
	public String toString() {
		return "ExaPaperInfo [examination_id=" + examination_id + ", examination_no=" + examination_no
				+ ", question_no=" + question_no + ", question_type=" + question_type + ", question_xh=" + question_xh
				+ ", question_name=" + question_name + ", question_nscore=" + question_nscore + ", right_key="
				+ right_key + ", create_time=" + create_time + ", update_time=" + update_time + "]";
	}
	
	
	
	
}
