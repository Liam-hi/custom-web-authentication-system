async function readInput(){
    var userName = document.getElementById("userName").value;
    var passWord = document.getElementById("passWord").value;
    const Http = new XMLHttpRequest();
    const url="http://localhost:8081/api/login/create/?userName=" + userName + "&passWord=" + passWord;
    Http.open("GET", url);
    Http.send();

    const response = await fetch(url);
    const data = await response.json();
    var json = JSON.stringify(data);

    document.getElementById("demo").innerHTML = json;

    if (json == 'false') {
      window.alert("incorrect password");

    }

    else {
      location.replace("rahimian.io")
    }
  }