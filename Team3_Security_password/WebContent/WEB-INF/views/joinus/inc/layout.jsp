<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script type="text/javascript">
	$(function() {
		$('#btnCheckUid').click(function() {
			$.ajax({
				type : "post",
				url : "idcheck.htm",
				data : {
					"userid" : $('#userid').val()
				},
				success : function(data) {
					if (data.result == "fail") {
						alert('중복된 아이디 입니다.');
						$('#userid').focus();
					} else {
						alert('사용가능한 아이디 입니다.');
					}
				}
			});
		});
	});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!-- title 영역 -->
<tiles:insertAttribute name="title" />
<!-- css  영역 -->
<link href='<tiles:getAsString name="css" />' type="text/css"
	rel="stylesheet" />
</head>
<body>
	<!-- Header  영역 (공통 inc) -->
	<tiles:insertAttribute name="header" />
	<!-- visual 영역 -->
	<tiles:insertAttribute name="visual" />
	<div id="main">
		<div class="top-wrapper clear">
			<!-- Content 영역 -->
			<tiles:insertAttribute name="content" />
			<!-- aside 영역 -->
			<tiles:insertAttribute name="aside" />
		</div>
	</div>

	<!-- Footer 영역 -->
	<tiles:insertAttribute name="footer" />
</body>
</html>
