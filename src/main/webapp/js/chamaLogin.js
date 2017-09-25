onload = function () {

    var xhr = new XMLHttpRequest();
    var tagLink = document.getElementById("link");
    var json;

    xhr.open("get", "IndexController", false);
    xhr.send(null);

    if (xhr.status !== 200) {
        xhr.open("get", "../IndexController", false);
        xhr.send(null);

        json = JSON.parse(xhr.responseText);

        tagLink.href = json[0];
        tagLink.innerHTML = json[1];
    } else {

        json = JSON.parse(xhr.responseText);

        tagLink.href = "usuario/"+json[0];
        tagLink.innerHTML = json[1];
    }
};