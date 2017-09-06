package cn.com.demo.po;

import java.util.Date;

public class ExaminationInfo {
	private String examination_info_no;
	private String examination_no;
	private String examination_user;
	private Long right_num;
	private Long error_num;
	private Long score;
	private Long examination_length;
	private Date start_time;
	private Date end_time;

	public String getExamination_info_no() {
		return examination_info_no;
	}

	public void setExamination_info_no(String examination_info_no) {
		this.examination_info_no = examination_info_no;
	}

	public String getExamination_no() {
		return examination_no;
	}

	public void setExamination_no(String examination_no) {
		this.examination_no = examination_no;
	}

	public String getExamination_user() {
		return examination_user;
	}

	public void setExamination_user(String examination_user) {
		this.examination_user = examination_user;
	}

	public Long getRight_num() {
		return right_num;
	}

	public void setRight_num(Long right_num) {
		this.right_num = right_num;
	}

	public Long getError_num() {
		return error_num;
	}

	public void setError_num(Long error_num) {
		this.error_num = error_num;
	}

	public Long getScore() {
		return score;
	}

	public void setScore(Long score) {
		this.score = score;
	}

	public Long getExamination_length() {
		return examination_length;
	}

	public void setExamination_length(Long examination_length) {
		this.examination_length = examination_length;
	}

	public Date getStart_time() {
		return start_time;
	}

	public void setStart_time(Date start_time) {
		this.start_time = start_time;
	}

	public Date getEnd_time() {
		return end_time;
	}

	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}

}