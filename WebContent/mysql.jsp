<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="ja">
<head>

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>ユーザー管理</title>
</head>
<body>


<s:form action="KousinAction">
<label>--------------<s:text name = "ユーザーデータ"/>--------------</label>
		<table>
			<tr>
				<th><s:text name="ID"/></th>

				<th>　　　<s:text name="パスワード"/></th>
			</tr>
	<s:iterator value="selectList">
			<tr>
				<td>　　　　<s:property value="id" /></td>

				<td>　　　　　<s:property value="password" /></td>
			</tr>
	</s:iterator>
			</table>
			<s:submit value="表示"/>
</s:form>
<br>

<s:iterator value="ans">
		<p><font color="#ff0000"><s:property value="ans" /></font></p>
		</s:iterator>


     <!--ユーザー検索のAction先  -->
		<s:form action="SelectAction">
		<h2>ユーザー検索</h2>
		<p>ユーザーID：　
			<s:textfield label="ID1" name="idse" placeholder="ユーザーIDを入力してください"  size="25" />
		</p>
		<s:submit value="完了" />
		<s:iterator value="myid">
		<p>　　　　　　ID:　　<font color="#ff0000"><s:property value="myid" /></font></p>
		</s:iterator>
		<s:iterator value="mypass">
		<p>PASSWORD:　　<font color="#ff0000"><s:property value="mypass" /></font></p>
		</s:iterator>

     	</s:form>

     	<!-- 新規登録のACTION先 -->
		<s:form action="MySQLAddAction">
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


		<s:form action="UpdateAction">
		<h2>パスワード更新</h2>
		<p></p>
		<p>ユーザーID：　　

			<s:textfield label="ID3" name="idup" placeholder="ユーザーIDを入力してください"  size="25" />
		</p>
		<p>新規パスワード：
			<s:password label="パスワード2" name="passwordup" placeholder="パスワードを入力してください"  size="25" />
		</p>

		<s:submit value="完了" />
		</s:form>


		<s:form action="DeleteAction">
		<h2>ユーザー削除</h2>
		<p></p>

		<p>ユーザーID：
			<s:textfield label="ID4" name="idde" placeholder="ユーザーIDを入力してください"  size="25" />
		</p>
		<s:submit value="完了" />
		</s:form>
		</body>
		</html>