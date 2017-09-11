package cn.com.demo.po;

public class ExamDetail {
	
	private String question_no;
	private String question_type;
	private String choose_key;
	private String right_key;
	
	private String isRight;

	public String getQuestion_no() {
		return question_no;
	}

	public void setQuestion_no(String question_no) {
		this.question_no = question_no;
	}

	public String getQuestion_type() {
		return question_type;
	}

	public void setQuestion_type(String question_type) {
		switch (question_type) {
		case "1":
			this.question_type="单选题";
			break;
		case "2":
			this.question_type="多选题";
			break;
		case "3":
			this.question_type="判断题";
			break;
		}
	}

	public String getChoose_key() {
		return choose_key;
	}

	public void setChoose_key(String choose_key) {
		this.choose_key = choose_key;
	}

	public String getRight_key() {
		if(right_key.equals(choose_key)){
			setIsRight("yes");
		}else{
			setIsRight("no");
		}
		return right_key;
	}

	public void setRight_key(String right_key) {
		this.right_key = right_key;
	}

	public String getIsRight() {
		return isRight;
	}

	public void setIsRight(String isRight) {
		this.isRight=isRight;
	}

}
