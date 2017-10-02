var xhr = new XMLHttpRequest();
var resposta;
var perguntas;

function carregarPerguntas() {

    perguntas = document.getElementById("perguntas");

    xhr.open("get", "UsuarioController?acao=VERPERGUNTAS", true);
    xhr.send(null);
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
            resposta = JSON.parse(xhr.responseText);
            var texto = "";
            
            for (var a = 0; a < resposta.length; a++) {

                texto += "<form action=\"UsuarioController\" method=\"post\">";
                texto += "<input name=\"acao\" id=\"" + resposta[a].id + "\" type=\"text\" value=\"\" readonly=\"readonly\" style=\"display: none\">";
                texto += "<input type=\"text\" name=\"id\" value=\"" + resposta[a].id + "\" readonly=\"readonly\" style=\"display: none\">";
                texto += "<span>Período: "+resposta[a].periodo+"</span><br>";
                texto += "<span>Matéria: "+resposta[a].materia+"</span><br>";
                texto += "<span>Data Postagem: "+resposta[a].dataPostagem+"</span><br>";
                texto += "<span>Última alteração: ";
                if(resposta[a].dataUltimaPostagem !== undefined)
                    texto += resposta[a].dataUltimaPostagem;
                texto += "</span><br>";
                texto += "<span>Autor: "+resposta[a].nomeUsuario+"</span><br>";
                texto += "<span>Pergunta:</span><br>";
                texto += "<textarea id=\"" + resposta[a].id + "\" name=\"textopergunta\" readonly=\"\">" + resposta[a].textoPergunta+ "</textarea>";
                texto += "<a onclick=\"document.getElementById('" + resposta[a].id + "').removeAttribute('readonly')\" href=\"#pergunta" + resposta[a].id + "\">"+resposta[a].editar+"</a><br>";
                
                if(resposta[a].editar !== "")
                texto += "<input type=\"submit\" value=\"" + resposta[a].editar + "\" onmouseover=\"document.getElementById('" + resposta[a].id + "').value = '" + resposta[a].editar + "pergunta'\">";
                
                if(resposta[a].excluir !== "")
                texto += "<input type=\"submit\" value=\"" + resposta[a].excluir + "\" onmouseover=\"document.getElementById('" + resposta[a].id + "').value = '" + resposta[a].excluir + "pergunta'\">";
                
                texto += "<input type=\"submit\" value=\"Ver Pergunta\" onmouseover=\"document.getElementById('" + resposta[a].id + "').value = 'verperguntaerespostas'\">";
                texto += "</form><br><br>";
            }
            
            perguntas.innerHTML = texto;
        }
    };
}

function chamaLink(){
    
    var tagLink = document.getElementById("link");
    var json;

    xhr.open("get", "IndexController", false);
    xhr.send(null);

    if (xhr.readyState === 4 && xhr.status != 200) {
        xhr.open("get", "IndexController", false);
        xhr.send(null);
        
        json = JSON.parse(xhr.responseText);

        tagLink.href = json[0];
        tagLink.innerHTML = json[1];
        
    }else{
        json = JSON.parse(xhr.responseText);
        
        if(json[0] === "login.jsp"){
            tagLink.href = json[0];
        }else{
            tagLink.href = "usuario/" + json[0];
        }
        tagLink.innerHTML = json[1];
    }
}

function init(){
    
    chamaLink();
    carregarPerguntas();
}

onload = init;