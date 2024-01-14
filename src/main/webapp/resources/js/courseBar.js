var linkSplit = window.location.href.split("/");
var linkConcated = linkSplit[0] + "//" + linkSplit[2] + "/" + linkSplit[3] + "/" + linkSplit[4] + "/" + linkSplit[5] + "/" + linkSplit[6];

document.querySelectorAll(".courseBar").forEach((link) => {
	if (link.href === window.location.href || link.href === linkConcated) {
	    link.classList.add("border-bottom", "border-primary", "border-2");
	    link.classList.remove("link-secondary");
	    
	    const parent = document.querySelector(".border-primary img");
	    var imagePath = parent.src;
	    
        if(imagePath.indexOf("c.png") == -1)
        	imagePath = imagePath.replace('.png', 'c.png');
        	
        parent.src = imagePath;       
    }
});