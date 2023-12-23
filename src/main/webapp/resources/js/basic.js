var linkSplit = window.location.href.split("/");
var concated = linkSplit[0] + "//" + linkSplit[2] + "/" + linkSplit[3] + "/" + linkSplit[4];

document.querySelectorAll(".nav-link").forEach((link) => {
    if (link.href === window.location.href || link.href === concated) {
        link.classList.add("active");
        link.classList.remove("link-body-emphasis");
        link.setAttribute("aria-current", "page");
        
        const parent = document.querySelector(".active img");
        var image = parent.src;
        console.log("image : " + image);
        
        var srcSplit = image.split(".");
        var srcConcated = srcSplit[0] + "c." + srcSplit[1];
        console.log("srcConcated : " + srcConcated);   
        parent.src = srcConcated;
    }
});