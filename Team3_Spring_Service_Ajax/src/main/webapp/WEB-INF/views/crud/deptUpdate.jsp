<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dept CRUD</title>
</head>
<body>
<div style="margin-top:70px;"></div>
<form action="deptUpdate.htm" method="post"> 
 <div align="center"> 
    <table width="600" border="0"  cellpadding="10"> 
        <tr align="center" bgcolor="#dddddd" height="50"> 
            <td colspan="2"> 
                <font size="4" color="#082249" face="arial"> 
                <b> 
                Department 정보 수정
                </b> 
                </font> 
            </td> 
        </tr> 
        <tr> 
            <td width="25%" align="center" > 
                <b>부서 번호</b> 
            </td> 
            <td> 
                <input type="text" size="40"  name="deptno" maxlength="10" value="${param.deptno}" readonly>
            </td> 
        </tr>     
        <tr> 
            <td width="25%" align="center"> 
                <b>부서 이름</b> 
            </td> 
            <td> 
                <input type="text" size="40" name="dname" maxlength="60" value="${param.dname}" > 
            </td> 
        </tr> 
        <tr> 
            <td width="25%" align="center"> 
                <b>부서 위치</b> 
            </td> 
            <td> 
                <input type='text' size="40" cols="50" class="box2" name="loc" value="${param.loc}">
            </td> 
        </tr> 
        <tr bgcolor="#dddddd"> 
            <td colspan="2" align="center" class="c2"> 
                <input type="submit" class="btn btn-secondary" value="수정" id="btnsumbit" >&nbsp;&nbsp;&nbsp;
                <input type="button" class="btn btn-secondary" value="취소"  onClick="location.href='deptList.htm'"> 
             
            </td> 
        </tr> 
     
    </table> 
 </div> 
 <hr>

</form> 

</body>
</html>