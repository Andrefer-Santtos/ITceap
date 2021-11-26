var i = setInterval(function () {
    
    clearInterval(i);
    document.getElementById("loading").style.display = "none";
    document.getElementById("formulario").style.display = "inline";
    document.getElementById("div-footer").style.display = "inline";

}, 3000);

