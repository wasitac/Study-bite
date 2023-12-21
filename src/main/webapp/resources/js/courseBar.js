/**
 * 
 */
 
  document.querySelectorAll(".courseBar").forEach((link) => {
    if (link.href === window.location.href) {
        link.classList.add("border-bottom", "border-primary", "border-2");
        link.classList.remove("link-secondary");        
		var img = document.querySelector('.border-primary img');
		var src = img.src;
		var srcSplit = src.split(".");
		src = srcSplit[0]+"c."+srcSplit[1];
		img.setAttribute("src", src);
    }
    
});