
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <script type="application/javascript" src="/js/jquery-1.9.1.js">
    </script>
  </head>
  <body>
    <input type="text" id="s" oninput="f()"/>
    <div id="res"></div>
    <script type="application/javascript">
        f = function(request, response) {
            if ($("#s").val().length > 0)
                $.ajax({
                    url: "/search",
                    data: {"q": $("#s").val()},
                    dataType: "json",
                    success: function(resp){
                        if (resp.results.length > 0) {
                            $("#res").text("Yes results.");
                            for (var i = 0; i < resp.results.length; i++) {
                                $("#res").append("<li>" + resp.results[i] + "</li>");
                            }
                        } else {
                            $("#res").text("No results.");
                        }
                    }
                })
            else
                $("#res").text("");
        }
    </script>
  </body>
</html>
