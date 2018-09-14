<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<!-- 재훈 start DataTables 관련 -->

<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">
<script src="http://code.jquery.com/jquery-2.1.1.js"></script>

<!-- 재훈 end DataTables 관련 -->

<meta charset="UTF-8">
<title>Dept CRUD</title>

</head>
<body>
	<c:set var="deptlist" value="${requestScope.list}"></c:set>
	<div align=center>
		<hr color=green width=400>
		<h2>Dept List</h2>
		<hr color=green width=400>
		<br> <br>

		<table id="myTable">

			<thead>
				<tr>
					<th class="deptno">Deptno</th>
					<th class="dname">Dname</th>
					<th class="loc">Loc</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="n">
					<tr>
						<td class="deptno">${n.deptno}</td>
						<td class="dname">${n.dname}</td>
						<td class="loc">${n.loc}</td>
						<td><a
							href="deptUpdateForm.htm?deptno=${n.deptno}&dname=${n.dname}&loc=${n.loc}"
							class="btn btn-secondary">수정</a> <a
							href="deptDelete.htm?deptno=${n.deptno}"
							class="btn btn-secondary">삭제</a></td>
					</tr>
				</c:forEach>
			</tbody>
			<!-- 정원 start excel, pdf 다운로드 -->
			<a href="noticeExcel.htm" class="btn btn-secondary">Excel Download</a>
			<a href="noticePdf.htm" class="btn btn-secondary">PDF Download</a>
		</table>
	</div>
	<br>


	<!-- 재훈 start DataTables 관련  -->

	<script>
		$(document).ready(function() {
			$('#myTable').DataTable({
				"columnDefs" : [ {
					"width" : "15%",
					"targets" : 3
				} ]
			});
		});
	</script>

	<script type="text/javascript" charset="utf8"
		src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>

	<!-- 재훈 end DataTables 관련 -->

</body>
</html>