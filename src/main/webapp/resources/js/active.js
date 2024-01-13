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
        var srcConcated = image;
        
        // 파일이름 끝에 c가 붙어있으면 추가하지 않고 그대로 사용 - 이지홍
        if(srcSplit[0].slice(-1) !== "c")
        	 srcConcated = srcSplit[0] + "c." + srcSplit[1];
        
        parent.src = srcConcated;
    }
});