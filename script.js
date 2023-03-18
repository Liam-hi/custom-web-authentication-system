async function readInput(){
    var userName = document.getElementById("userName").value;
    var passWord = document.getElementById("passWord").value;
    const response = await fetch("http://localhost:8081/api/createuser/add/?userName=" + userName + "&passWord=" + passWord);
    const data = await response.json();
    if (!response.ok) {
      const message = `An error has occured: ${response.status}`;
      throw new Error(message);
    }

    var json = JSON.stringify(data);
    document.getElementById("demo").innerHTML = json;
  
    if (json == 'false') {
     
    }
  
    else {
      location.replace("login.html")
    }
  
  }
  
  
  