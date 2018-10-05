<html>
<head>
    <script type="text/javascript">
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
              document.getElementById("cors_text").innerHTML =
              this.responseText;
            }
          };
          xhttp.open("GET", "http://localhost:8080/hello", true);
          xhttp.send();
    </script>
</head>

<body>
    <div id="cors_text">
        <h2>Before JS load</h2></div>
</body>
</html>