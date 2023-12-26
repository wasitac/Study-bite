/**
 * 알림 유형에 따라 다른 요청을 보내기 위해 작성됨.
 * category
 	1: 강의공지
 	2: 질의응답
 	3: 전체공지
 	이지홍
 */
 function path(category, courseId, id){
    var context = window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
 
 	if(category == 1)
 		location.href = "http://localhost:8080/studybite/course/" + courseId + "/qna/" + id;
 	else if(category == 2)
 		location.href = "http://localhost:8080/studybite/course/" + courseId + "/news/" + id; 	
 	else
 		location.href = "http://localhost:8080/studybite/notice/" + id;
 	
}