<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <!-- CSS body中央 -->
        <style type="text/css">
        body {text-align: center;
        }
        </style>
<title>新規登録</title>
</head>
<body>


<s:iterator value="ans">
<p><font color="#ff0000"><s:property value="ans" /></font></p>
		</s:iterator>



	<s:form action="NewAction1">
		<h2>新規登録</h2>
		<p></p>
		<p>ユーザーID：
			<s:textfield label="ID2" name="idnew" placeholder="ユーザーIDを入力してください"  size="25" />
		</p>
		<p>パスワード：
			<s:password label="パスワード1" name="passwordnew" placeholder="パスワードを入力してください"  size="25" />
		</p>
		<s:submit value="完了" />

		</s:form>

	<li>
	 <li><h5><a href = login.jsp> <button>戻る   </button></h5></a><br>
</html>
