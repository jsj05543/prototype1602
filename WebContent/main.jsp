<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>メイン</title>
<link href="jquery-ui-1.11.4.custom/external/jquery/jquery.js">
    <script src="jquery-ui-1.11.4.custom/external/jquery/jquery.js"></script>
   <script src="jquery-ui-1.11.4.custom/external/jquery/jquery.js"></script>
    <script>
    $(function() {
        $( "#sample-button" ).click(function() {
            alert("ok");

            alert("ok2");

        });
    });
    </script>
</head>
	<body>
<h3>地図</h3>
<p><iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d681.1080108083461!2d139.7670466314883!3d35.703734602949204!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x60188c18b82a5b79%3A0xf4b11fd9c5add54c!2z44CSMTEzLTAwMzQg5p2x5Lqs6YO95paH5Lqs5Yy65rmv5bO277yT5LiB55uu77yS4oiS77yR77ySIOW-oeiMtuODjuawtOWkqeelnuODk-ODqw!5e0!3m2!1sja!2sjp!4v1454376958330"
             width="700" height="600" frameborder="0" style="border:0" allowfullscreen></iframe></p>

 <li><a href = d3test.jsp> <button>D3   </button> </a></li>
 <li><a href = mysql.jsp>  <button>MySQL</button> </a></li>
 <li><a href = mongoTest.jsp>  <button>Mongo</button> </a></li>
 <input type="button" id="sample-button" value="OK" />

	</body>
</html>
