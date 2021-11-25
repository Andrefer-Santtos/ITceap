function logar(){
    var objeto = {
        "email" : document.getElementById("email").value,
        "senha" : document.getElementById("senha").value
    }

    var cabecalho = {
        method: "POST",
        body: JSON.stringify(objeto),
        headers:{
            "Content-type":"application/json"
        }
    }

    fetch("http://localhost:8080/loginadmin", cabecalho)
        .then(res => res.json())
        .then(res => {
            localStorage.setItem("logado",JSON.stringify(res));
            window.alert("Login Realizado com sucesso! ");
        })
        .catch(err => {
            window.alert("Deu ruim");
        });
    

}