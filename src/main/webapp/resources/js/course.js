var context = window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));

function goToNews(e, courseId){
 	e.stopPropagation();
 	location.href = context + '/course/' + courseId + '/news/add';
 };
 
function goToQna(e, courseId){
 	e.stopPropagation();
 	location.href = context + '/course/' + courseId + '/qna';
 };
 