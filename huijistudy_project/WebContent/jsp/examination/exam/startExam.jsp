<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.js"></script>
<script type="text/javascript">
$(function(){
	var option1List=new Array();
	var option2List=new Array();
	var option3List=new Array();
	/*提交试卷*/
	$("#btn_post_paper").click(function() { 
		$("#option1:checked").each(function() { 
			option1List.push($(this).attr("name"),$(this).val()+"$");
		});
		var name="";
		$("#option2:checked").each(function() { 
			if(name!=$(this).attr("name")){
				option2List.push(",@"+$(this).attr("name")+"@");
				name=$(this).attr("name");
			}
			option2List.push($(this).val());
		});
		$("#option3:checked").each(function() { 
			option3List.push($(this).attr("name"),$(this).val()+"$");
		});
		/* alert(option1List.toString());
		alert(option2List.toString());
		alert(option3List.toString());
		alert($("#exam_info_no").val()); */
		$.ajax({
			type: "post", 
			url: "${pageContext.request.contextPath}/exam/submitPaper.action", 
			data: {
				'single':option1List.toString()+",",
				'multi':","+option2List.toString(),
				'judge':option3List.toString()+",",
				'examination_info_no':$("#exam_info_no").val()
			},
			success: function(result) { 
				//confirm("正确数量："+result[0]+"道\n"+"错误数量："+result[1]+"道\n"+"总分："+result[2]+"分");
				//alert(result);
				$("#result").modal();
				$("#right_num").text("正确数量："+result[0]+"道");
				$("#error_num").text("错误数量："+result[1]+"道");
				$("#sum_score").text("总分："+result[2]+"分");
			} 
		});
	});
	
	
	
	/**************************计时器****************************/
	var intDiff = parseInt($("#len").val())*60;
	//alert(initDiff);
	function timer(intDiff){
		window.setInterval(function(){
		var day=0,
			hour=0,
			minute=0,
			second=0;//时间默认值		
		if(intDiff > 0){
			day = Math.floor(intDiff / (60 * 60 * 24));
			hour = Math.floor(intDiff / (60 * 60)) - (day * 24);
			minute = Math.floor(intDiff / 60) - (day * 24 * 60) - (hour * 60);
			second = Math.floor(intDiff) - (day * 24 * 60 * 60) - (hour * 60 * 60) - (minute * 60);
		}else{
			$('#divs').html('考试时间到!').css({color:"red"});
			//当倒计时结束，则自动提交该表单
			$("#btn_post_paper").click();
		}
		if (minute <= 9) minute = '0' + minute;

		if (second <= 9) second = '0' + second;
		$('#hour_show').html('<s id="h"></s>'+hour+'时');

		$('#minute_show').html('<s></s>'+minute+'分');

		$('#second_show').html('<s></s>'+second+'秒');

		intDiff--;

		}, 1000);

	} 
	
	$(function(){

		timer(intDiff);

	});	
	
});
</script>
<script type="text/javascript">
/*返回试卷列表*/
function returnPaperList(){
	var url="${pageContext.request.contextPath}/exam/paperList.action";
	window.location.href=url;
}
/*查看考试明细*/
function findExamDetail(examination_info_no){
	var url="${pageContext.request.contextPath}/exam/examResult.action?examination_info_no="+examination_info_no;
	window.location.href=url;
}
</script>
<div id="content">
	<div id="content-header">
		<div id="breadcrumb">
			<a href="#" title="Go to Home" class="tip-bottom"><i
				class="icon-home"></i> Home</a> <a href="#">Student pages</a> <a
				href="#" class="current">Info</a>
		</div>
		<input type="hidden" id="exam_info_no" value="${examination_info_no}">
		<div id="divs" style="position:fixed;z-index:99999;top: 100px;right: 80px;">
	            <span style="color: #FF0000" id="countDownTime">考试时间：</span>
	            <span  id="hour_show"></span>
	            <span  id="minute_show"></span>
	            <span  id="second_show"></span>
         </div>
		<h2 align="center">${exaPaper.examination_name }</h2>
		<h5 align="center">（考试时长：${exaPaper.exam_length}分钟,&nbsp;&nbsp;试卷总分：${sumScore}分 ）</h5>
		<input type="hidden" id="len" value="${exaPaper.exam_length}"/>
	</div>
	<div class="container-fluid">
		<hr>
		<div class="row-fluid">
			<div class="span12"></div>
			
			<!-- start -->
			<div>
			<c:set var="flag" value="1"></c:set>
			<c:forEach items="${exaPaper.extendExaPaperInfos}" var="exaPaperInfo" varStatus="vs">
					<c:if test="${exaPaperInfo.question_type==1 }">
					  <c:if test="${flag==1 }">
						<h4>一、单选题（共${exaPaperInfo.question_num }题,每题${exaPaperInfo.question_score}分,共${exaPaperInfo.total_score }分）</h4>
						<c:set var="flag" value="2"></c:set>
					  </c:if>
						<div class="control-group">
							<label class="control-label">${vs.count}、${exaPaperInfo.question_name }</label>
							<c:forEach items="${exaPaperInfo.exaPaperAnswers}" var="answer">
								<div class="controls">
									<label><input id="option1" type="radio" name="${exaPaperInfo.examination_id}" value="${answer.answer_num }"/>${answer.answer_content }</label>
								</div>
							</c:forEach>
						</div>
					</c:if>
					<c:if test="${exaPaperInfo.question_type==2 }">
					  <c:if test="${flag==2 }">
						<h4>二、多选题（共${exaPaperInfo.question_num }题,每题${exaPaperInfo.question_score}分,共${exaPaperInfo.total_score }分）</h4>
						<c:set var="flag" value="3"></c:set>
					  </c:if>
						<div class="control-group">
							<label class="control-label">${vs.count}、${exaPaperInfo.question_name }</label>
							<c:forEach items="${exaPaperInfo.exaPaperAnswers}" var="answer">
								<div class="controls">
									<label><input id="option2" type="checkbox" name="${exaPaperInfo.examination_id}" value="${answer.answer_num }" />${answer.answer_content }</label>
								</div>
							</c:forEach>
						</div>
					</c:if>
					<c:if test="${exaPaperInfo.question_type==3 }">
					  <c:if test="${flag==3 }">
						<h4>三、判断题（共${exaPaperInfo.question_num }题,每题${exaPaperInfo.question_score}分,共${exaPaperInfo.total_score }分）</h4>
					 	<c:set var="flag" value="0"></c:set>
					  </c:if>
					<div class="control-group">
						<label class="control-label">${vs.count}、${exaPaperInfo.question_name }</label>
						<c:forEach items="${exaPaperInfo.exaPaperAnswers}" var="answer">
							<div class="controls">
								<label><input id="option3" type="radio" name="${exaPaperInfo.examination_id}" value="${answer.answer_num }" />${answer.answer_content }</label>
							</div>
						</c:forEach>
					</div>
				</c:if>
			</c:forEach>
				<div class="form-actions">
					<button id="btn_post_paper" class="btn btn-success">交卷</button>
				</div>
			</div>
			<!-- end -->
			<!-- Modal -->  
			<div id="result" class="modal hide fade in" style="display: none; ">
		        <div class="modal-header">
		            <a class="close" data-dismiss="modal">×</a>
		            <h3>考试结果信息</h3>
		        </div>
		        <div class="modal-body">
		            <h4 id="right_num"></h4>
		            <h4 id="error_num"></h4>
		            <h4 id="sum_score"></h4>
		        </div>
		        <div class="modal-footer">
		            <a onclick="javascript:findExamDetail(${examination_info_no})" class="btn" data-dismiss="modal">查看考试明细</a>
		            <a onclick="javascript:returnPaperList()" class="btn" data-dismiss="modal">关闭</a>
		        </div>
		    </div>
			<!-- end -->
		</div>
	</div>
</div>
