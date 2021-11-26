function update(){
	   //Exibe ou esconde o modal
    document
        .querySelectorAll("#modal")[0]//acha o modal via DOM
        .classList.toggle("hide");//muda a class do modal

    //Bloquear o scroll do body qnd o modal estiver na tela
    document
        .querySelector("body")//acha o body via DOM
        .classList.toggle("hideScroll");//muda a class do body

    //Habilitar scroll pro modal, caso "estoure" o tamanho da tela
    document.querySelectorAll("#modal")[0]
        .classList.toggle("addScroll");//2 - habilitar scroll no modal
    
	
}

function create(){
	    //Exibe ou esconde o modal
    document
        .querySelectorAll("#modal")[1]//acha o modal via DOM
        .classList.toggle("hide");//muda a class do modal

    //Bloquear o scroll do body qnd o modal estiver na tela
    document
        .querySelector("body")//acha o body via DOM
        .classList.toggle("hideScroll");//muda a class do body

    //Habilitar scroll pro modal, caso "estoure" o tamanho da tela
    document
        .querySelectorAll("#modal")[1]//1 - achar o modal via DOM
        .classList.toggle("addScroll");//2 - habilitar scroll no modal
    
	
}

function del(){
	    //Exibe ou esconde o modal
    document
        .querySelectorAll("#modal")[2]//acha o modal via DOM
        .classList.toggle("hide");//muda a class do modal

    //Bloquear o scroll do body qnd o modal estiver na tela
    document
        .querySelector("body")//acha o body via DOM
        .classList.toggle("hideScroll");//muda a class do body

    //Habilitar scroll pro modal, caso "estoure" o tamanho da tela
    document
        .querySelectorAll("#modal")[2]//1 - achar o modal via DOM
        .classList.toggle("addScroll");//2 - habilitar scroll no modal
    
	
}

document.querySelectorAll("button")[0].addEventListener('click', ()=>{
    var objeto = {
		"id" : document.querySelectorAll("select")[0].selectedIndex + 1,
        "img" : document.querySelectorAll("input")[0].value,
        "nome" : document.querySelectorAll("input")[1].value,
		"predio":document.querySelectorAll("input")[2].value,
		"sala": document.querySelectorAll("input")[3].value,
		"quantidade": document.querySelectorAll("input")[4].value
    }

    var cabecalho = {
        method: "PUT",
        body: JSON.stringify(objeto),
        headers:{
            "Content-type":"application/json"
        }
    }

    fetch("http://localhost:8080/updatepredioc", cabecalho)
        .then(res => res.json())
        .then(res => {
            localStorage.setItem("logado",JSON.stringify(res));
			window.location="/predioc";
            window.alert("Salvo com sucesso! ");
        })
        .catch(err => {
            window.alert("Deu ruim");
        });
    
});


document.querySelectorAll("button")[1].addEventListener('click', ()=>{
    var objeto = {
        "img" : document.querySelectorAll("input")[5].value,
        "nome" : document.querySelectorAll("input")[6].value,
		"predio":document.querySelectorAll("input")[7].value,
		"sala": document.querySelectorAll("input")[8].value,
		"quantidade": document.querySelectorAll("input")[9].value
    }

    var cabecalho = {
        method: "POST",
        body: JSON.stringify(objeto),
        headers:{
            "Content-type":"application/json"
        }
    }

    fetch("http://localhost:8080/savepredioc", cabecalho)
        .then(res => res.json())
        .then(res => {
            localStorage.setItem("logado",JSON.stringify(res));
			window.location="/predioc";
            window.alert("Atualizado com sucesso! ");
        })
        .catch(err => {
            window.alert("Deu ruim");
        });
    
});

document.querySelectorAll("button")[2].addEventListener('click', ()=>{
    var objeto = {
        "id" : document.querySelectorAll("select")[1].selectedIndex + 1
    }

    var cabecalho = {
        method: "DELETE",
        body: JSON.stringify(objeto),
        headers:{
            "Content-type":"application/json"
        }
    }

    fetch("http://localhost:8080/deletepredioc", cabecalho)
        .then(res => res.json())
        .then(res => {
            localStorage.setItem("logado",JSON.stringify(res));
			window.location="/predioc";
            window.alert("Deletado com sucesso! ");
        })
        .catch(err => {
            window.alert("Deu ruim");
        });
    
});


