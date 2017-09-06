package cn.com.demo.po;

import java.util.Date;

public class ExaPaper {
    private String examination_no;

    private Long examination_type;

    private String examination_name;

    private String examination_content;

    private Long subject_no;

    private Long exam_length;

    private Long state;

    private String create_user;

    private Date create_time;

    private Date update_time;
    
    private Long sum_score;
    
    
    
	public String getExamination_no() {
		return examination_no;
	}

	public void setExamination_no(String examination_no) {
		this.examination_no = examination_no;
	}

	public Long getExamination_type() {
		return examination_type;
	}

	public void setExamination_type(Long examination_type) {
		this.examination_type = examination_type;
	}

	public String getExamination_name() {
		return examination_name;
	}

	public void setExamination_name(String examination_name) {
		this.examination_name = examination_name;
	}

	public String getExamination_content() {
		return examination_content;
	}

	public void setExamination_content(String examination_content) {
		this.examination_content = examination_content;
	}

	public Long getSubject_no() {
		return subject_no;
	}

	public void setSubject_no(Long subject_no) {
		this.subject_no = subject_no;
	}

	public Long getExam_length() {
		return exam_length;
	}

	public void setExam_length(Long exam_length) {
		this.exam_length = exam_length;
	}

	public Long getState() {
		return state;
	}

	public void setState(Long state) {
		this.state = state;
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

	public Long getSum_score() {
		return sum_score;
	}

	public void setSum_score(Long sum_score) {
		this.sum_score = sum_score;
	}

	@Override
	public String toString() {
		return "ExaPaper [examination_no=" + examination_no + ", examination_type=" + examination_type
				+ ", examination_name=" + examination_name + ", examination_content=" + examination_content
				+ ", subject_no=" + subject_no + ", exam_length=" + exam_length + ", state=" + state + ", create_user="
				+ create_user + ", create_time=" + create_time + ", update_time=" + update_time + ", sum_score="
				+ sum_score + "]";
	}
}