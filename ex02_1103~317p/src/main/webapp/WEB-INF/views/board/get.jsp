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
				<div class="panel-heading">Board Register</div>
				<!-- end panel-heading -->
				
				<div class="panel-body">
				
						<!-- 조회페이지에서는 그다지 필요하지않아서 주석처리함 -->
<!-- 					<form role="form" action="/board/register"  method="post"> -->
						
						<div class="form-group">
							<label>Bno</label>
							<input class="form-control" name="bno" value='<c:out value="${board.bno}"/>' readonly="readonly">
						</div>
					
					
						<div class="form-group">
							<label>Title</label>	
							<input class="form-control" name="title" value='<c:out value="${board.title}"/>' readonly="readonly">
						<!-- end form-group -->							
						</div>
						
						
						
						
						
						
<!-- 						textarea 태그에는 value= 이라고 안해도됨 혼동하지말기 -->
						<div class="form-group">
							<label>Text area</label>
							<textarea class="form-control" readonly="readonly" rows="3" name="content"><c:out value="${board.content}"/></textarea>
						</div>						
						
						<div class="form-group">
							<label>Writer</label>
							<input class="form-control" name="writer" readonly="readonly" 
							value='<c:out value="${board.writer}"/>'   >
						</div>
						
						
<!-- 	직접 버튼에 링크를 처리하는 방식으로 사용하여 처리하였지만,나중에 다양한 상황을 처리하기 위해서 <form> 태그를 이용해 수정한다 -->
							<button data-oper="modify" class="btn btn-default">Modify</button>
							<button data-oper="list" class="btn btn-info">List</button>
						
							<form id='operForm' action="/board/modify" method="get">
								<input type='hidden' id='bno' name='bno' value='<c:out value="${board.bno}"/>'>
								<input type="hidden" name="pageNum" value="<c:out value='${cri.pageNum}' />">
								<input type="hidden" name="amount" value="<c:out value='${cri.amount}' />">
								
							</form>
<!-- 						<button type="submit" class="btn btn-default">Submit Button</button> -->
<!-- 						<button type="reset" class="btn btn-default">Reset Button</button> -->
<!-- 					</form> -->
				</div>
			</div>
		</div>
	</div>
	
	
<script type="text/javascript">
	$(document).ready(function(){
		var operForm=$("#operForm");
		$("button[data-oper='modify']").on("click",function(e){
			operForm.attr("action","/board/modify").submit();
		});
		
		$("button[data-oper='list']").on("click",function(e){
			operForm.find("#bno").remove();
			operForm.attr("action","/board/list")
			operForm.submit();
		});
	});
</script>
	
	
<%@ include file="../includes/footer.jsp" %>












