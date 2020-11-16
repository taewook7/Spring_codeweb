<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../includes/header.jsp" %>
	
	
	
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">Board Register</h1>
		</div>
		<!--  end col-lg-12 -->
	</div>
	<!--  end row -->
	
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">Board Modify Page</div>
				<!-- end panel-heading -->
				
				<div class="panel-body">
						<!-- 조회페이지에서는 그다지 필요하지않아서 주석처리함 -->
					<form role="form" action="/board/modify"  method="post"> 
						
<!-- 						319p,346p -->
						<input type="hidden" name="pageNum" value='<c:out value="${cri.pageNum}"/>'>
						<input type="hidden" name="amount" value='<c:out value="${cri.amount}"/>'>
						<input type="hidden" name="type" value='<c:out value="${cri.type }"/>'>
						<input type="hidden" name="keyword" value='<c:out value="${cri.keyword }"/>'>
					
						<div class="form-group">
							<label>Bno</label>
							<input class="form-control" name="bno" value='<c:out value="${board.bno}"/>' readonly="readonly">
						</div>
					
					
						<div class="form-group">
							<label>Title</label>	
							<input class="form-control" name="title" value='<c:out value="${board.title}"/>'>
						<!-- end form-group -->							
						</div>
						
						
<!-- 						textarea 태그에는 value= 이라고 안해도됨 혼동하지말기 -->
						<div class="form-group">
							<label>Text area</label>
							<textarea class="form-control" rows="3" name="content"><c:out value="${board.content}"/></textarea>
						</div>						
						
						<div class="form-group">
							<label>Writer</label>
							<input class="form-control" name="writer" readonly="readonly" 
							value='<c:out value="${board.writer}"/>'   >
						</div>
						
						<div class="form-group" hidden="">
							<label>RegDate</label>
							<input class="form-control" name='regDate' value='<fmt:formatDate pattern="yyyy/MM/dd" 
							value="${board.regdate}" />' readonly="readonly" >
						</div>
						
						<div class="form-group" hidden="">
							<label>Update Date</label>
							<input class="form-control" name='updateDate' value='<fmt:formatDate pattern="yyyy/MM/dd"
							value="${board.updateDate}" />' readonly >
						</div>
						
						
						
							<button type="submit" data-oper='modify' class="btn btn-default">Modify</button>
							
							<button type="submit" data-oper='remove' class="btn btn-danger">Remove</button>
							
							<button type="submit" data-oper="list" class="btn btn-info">List</button>
						
<!-- 						<button type="submit" class="btn btn-default">Submit Button</button> -->
<!-- 						<button type="reset" class="btn btn-default">Reset Button</button> -->
 					</form> 
				</div>
			</div>
		</div>
	</div>
	


	

<script type="text/javascript">
$(document).ready(function() {
	  var formObj = $("form");
	  $('button').on("click", function(e){
	    e.preventDefault(); 
	    var operation = $(this).data("oper");
	    console.log(operation);
	    if(operation === 'remove'){
	      formObj.attr("action", "/board/remove");
		} else if (operation ==='list') {
			// move to list
			
// 			266p 목록리스트로 가는처리 변경
		formObj.attr("action","/board/list").attr("method","get");
// 		321p 페이지랑 ,amount 변수 추가   347p  키워드,목록 추가 
		var pageNumTag = $("input[name='pageNum']").clone();
		var amountTag = $("input[name='amount']").clone();
		var keywordTag = $("input[name='keyword']").clone();
		var typeTag = $("input[name='type']").clone();
		
			formObj.empty();
// 			321p 폼객체에 위에 추가한 변수2개 추가	
			formObj.append(pageNumTag);
			formObj.append(amountTag);
			formObj.append(keywordTag);
			formObj.append(typeTag);
// 			self.location="/board/list";
// 			return;
		}
		formObj.submit();
	});
});

</script>



<%@ include file="../includes/footer.jsp" %>








