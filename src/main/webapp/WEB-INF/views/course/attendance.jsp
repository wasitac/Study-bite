<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="../common/config.jsp"%>
<title>출결 현황</title>
</head>
<body>
	<div class="w-25">
        <%@ include file="../common/leftbar.jsp"%>
    </div>
    <div id="container" class="mainview container mt-5 min-vh-100 w-50">
        <%@ include file="../common/courseTitle.jsp"%>
        <%@ include file="../common/courseBar.jsp"%>
        <div class="my-1 text-left">
            <h3 class="blue600 info">나의 출결 현황</h3>
        </div>
        <div>
            <table class="table table-hover">
                <thead>
                    <tr class="bg-white500">
                        <th>주차</th>
                        <th>1</th>
                        <th>2</th>
                        <th>3</th>
                        <th>4</th>
                        <th>5</th>
                        <th>6</th>
                        <th>7</th>
                    </tr>
                </thead>
                <tbody class="table-group-divider">
                    <tr>
                        <td>출석</td>
                        <c:forEach var="userCourse" items="${userCourses}">
                            <td><c:choose>
                                    <c:when test="${not empty userCourse.date}"> O </c:when>
                                    <c:otherwise> - </c:otherwise>
                                </c:choose></td>
                        </c:forEach>
                    </tr>
                </tbody>
            </table>
            <div class="my-1 text-end">
                <h4 class="blue600 info">출석률 : ${attPercentage}%</h4>
            </div>
        </div>
        <%@ include file="../common/footer.jsp"%>
    </div>
    <div class="w-25">
        <%@ include file="../common/rightbar.jsp"%>
    </div>
    <script src="${resPath}/js/courseBar.js"></script>
</body>
</html>