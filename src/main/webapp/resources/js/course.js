/**
 * 
 */
 
 function goToNews(e, courseId){
 	e.stopPropagation();
 	location.href='/studybite/course/' + courseId + '/news/add';
 }
 
 function goToQna(e, courseId){
 	e.stopPropagation();
 	location.href='/studybite/course/' + courseId + '/qna';
 }
 