
document.querySelectorAll(".page-item").forEach((link) => {
	if (window.location.href === "http://localhost:8080/studybite/course/" + courseId + "/news") {

	const parent = document.querySelector(".page-item");
	var pageSrc = parent.href;
	
	var pageHref = document.getElementById("pagination").href;
	
	console.log("pageHref : " + pageHref);
	
	console.log("pageSrc : " + pageSrc);
	
	var pageSrcSplit = pageSrc.split("/");
	var pageSrcConcated = "/" + pageSrcSplit[0] + "/" + "course/${courseId}/news";
	
	console.log("pageSrcConcated : " + pageSrcConcated);
	
	parent.href = pageSrcConcated;
	     
    }
});