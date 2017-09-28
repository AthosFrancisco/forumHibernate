var xhr = new XMLHttpRequest();

function init(){
    
    var tagLink = document.getElementById("link");
    var json;

    xhr.open("get", "IndexController", false);
    xhr.send(null);

    if (xhr.readyState === 4 && xhr.status != 200) {
        xhr.open("get", "../IndexController", false);
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

onload = init;