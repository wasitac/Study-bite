var linkSplit = window.location.href.split("/");
var linkConcated = linkSplit[0] + "//" + linkSplit[2] + "/" + linkSplit[3] + "/" + linkSplit[4] + "/" + linkSplit[5] + "/" + linkSplit[6];

document.querySelectorAll(".courseBar").forEach((link) => {
	if (link.href === window.location.href || link.href === linkConcated) {

    link.classList.add("border-bottom", "border-primary", "border-2");
    link.classList.remove("link-secondary");
    const parent = document.querySelector(".border-primary img");
    var image = parent.src;
    console.log("image : " + image);
       
    var srcSplit = image.split(".");
    var concated = image;
    
    if(srcSplit[0].slice(-1) !== "c")
        	 concated = srcSplit[0] + "c." + srcSplit[1];
    
    console.log("concated : " + concated);      
    parent.src = concated;          
    }
});