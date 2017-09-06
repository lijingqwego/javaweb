package cn.com.demo.dto;

import java.util.List;

import cn.com.demo.po.ExaPaperAnswer;
import cn.com.demo.po.ExaPaperInfo;

/**
 * ExaPaperInfoµÄÀ©Õ¹Àà
 * @author Administrator
 *
 */
public class ExtendExaPaperInfo extends ExaPaperInfo {
	
	private Long question_num;
	private Long question_score;
	private Long total_score;
	
	private List<ExaPaperAnswer> exaPaperAnswers;
	
	public Long getQuestion_num() {
		return question_num;
	}

	public void setQuestion_num(Long question_num) {
		this.question_num = question_num;
	}

	public Long getQuestion_score() {
		return question_score;
	}

	public void setQuestion_score(Long question_score) {
		this.question_score = question_score;
	}

	public Long getTotal_score() {
		return total_score;
	}

	public void setTotal_score(Long total_score) {
		this.total_score = total_score;
	}

	public List<ExaPaperAnswer> getExaPaperAnswers() {
		return exaPaperAnswers;
	}

	public void setExaPaperAnswers(List<ExaPaperAnswer> exaPaperAnswers) {
		this.exaPaperAnswers = exaPaperAnswers;
	}

	@Override
	public String toString() {
		return "ExtendExaPaperInfo [exaPaperAnswers=" + exaPaperAnswers + "]";
	}
	
	
}
