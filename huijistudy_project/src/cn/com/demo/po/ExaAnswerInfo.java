package cn.com.demo.po;

import java.math.BigDecimal;
import java.util.Date;

public class ExaAnswerInfo {
    private String answerId;

    private String questionNo;

    private Long answerNum;

    private String answerName;

    private Long istrue;

    private Date createTime;

    private Date uppdateTime;

    public String getAnswerId() {
        return answerId;
    }

    public void setAnswerId(String answerId) {
        this.answerId = answerId == null ? null : answerId.trim();
    }

    public String getQuestionNo() {
        return questionNo;
    }

    public void setQuestionNo(String questionNo) {
        this.questionNo = questionNo == null ? null : questionNo.trim();
    }

    public Long getAnswerNum() {
        return answerNum;
    }

    public void setAnswerNum(Long answerNum) {
        this.answerNum = answerNum;
    }

    public String getAnswerName() {
        return answerName;
    }

    public void setAnswerName(String answerName) {
        this.answerName = answerName == null ? null : answerName.trim();
    }

    public Long getIstrue() {
        return istrue;
    }

    public void setIstrue(Long istrue) {
        this.istrue = istrue;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUppdateTime() {
        return uppdateTime;
    }

    public void setUppdateTime(Date uppdateTime) {
        this.uppdateTime = uppdateTime;
    }
}