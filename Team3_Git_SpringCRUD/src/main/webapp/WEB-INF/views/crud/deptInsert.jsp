<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script>
	$(function() {
		$('#deptnoBtn').click(function() {
			var deptno = $('#deptno').val();
			$.ajax({ 
				type : "get",
				url : "deptnoCheck.htm",
				data : "deptno=" + deptno,
				success : function(data) {					
					//서버 {"menu",list}   //data > {}					
					var deptlist;
					$.each(data.list, function(index, value){
						//console.log(index + " / " + value);
						deptlist = index;
					});
					if(deptlist!=null){	
						$('#deptnoChkSpan').empty();
						$('#deptnoChkSpan').append("이미 부서번호가 존재합니다.");
					} else {
						$('#deptnoChkSpan').empty();
						$('#deptnoChkSpan').append("입력하신 부서번호를 사용 가능합니다.");
					}
				}
			});  // ajax 종료 
		});
		
		  	 
		
		$('#btnsumbit').click(function() {
			var _param = {deptno:$("#deptno").val(), dname:$("#dname").val(), loc:$("#loc").val()};
			var _data = JSON.stringify(_param); //jsonString으로 변환	  
			$.ajax({
	   			  type : "post",
	   			  url : "ajaxInsert.htm",
	   			  cache: false,
	   			  dataType: "json",
	   			  data:_data,  
	   			  processData: false,
	   			  contentType: "application/json; charset=utf-8",
	   			  success : function(data, status){
	   				  location.href="index.htm";
	   				  	 			   	  
	   			  },
	   			  error: function(request, status, error){
	   				console.log("code : " +  request.statusText  + "\r\nmessage : " + request.responseText);
	   			 }
	   		});
			
		});		
	});
</script>
</head>
<body>
	<div style="margin-top: 70px;"></div>
	<form action="" method="post">
		<div align="center">
			<table width="600" border="0" cellpadding="10">
				<tr align="center" bgcolor="#dddddd" height="50">
					<td colspan="2"><font size="4" color="#082249" face="arial">
							<b> Department 정보 추가 </b>
					</font></td>
				</tr>
				<tr>
					<td width="25%" align="center"><b>부서 번호</b></td>
					<td><input type="text" size="40" id="deptno" name="deptno"
						maxlength="10" value=""> <input type="button" id="deptnoBtn" class="btn btn-secondary"
						value="중복 확인" />&nbsp;&nbsp;<span id="deptnoChkSpan"></span></td>
				</tr>
				<tr>
					<td width="25%" align="center"><b>부서 이름</b></td>
					<td><input type="text" size="40" id="dname" name="dname" maxlength="60" value="">
					</td>
				</tr>
				<tr>
					<td width="25%" align="center"><b>부서 위치</b></td>
					<td><input type='text' size="40" cols="50" class="box2"
						id="loc" name="loc" value=""></td>
				</tr>
				<tr bgcolor="#dddddd">
					<td colspan="2" align="center" class="c2"><input type="button"
						class="btn btn-secondary" value="추가" id="btnsumbit">&nbsp;&nbsp;&nbsp;
						<input type="button" class="btn btn-secondary" value="취소"
						onClick="location.href='deptList.htm'"></td>
				</tr>

			</table>
		</div>
		<hr>

	</form>
</body>
</html>