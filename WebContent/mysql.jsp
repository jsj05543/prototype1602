<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="ja">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ユーザー管理</title>
</head>
<body>



	<label>--------------<s:text name="ユーザー一覧" />--------------
	</label>
	<table>
		<tr>
			<th><s:text name="ID" /></th>

			<th><s:text name="パスワード" /></th>
		</tr>
		<s:iterator value="selectList">
			<tr>
				<td><s:property value="id" /></td>

				<td><s:property value="password" /></td>
			</tr>
		</s:iterator>
	</table>
	<br> --------------
	<s:text name="ユーザー情報操作" />
	--------------
	<br>
	<s:property value="notifyMessage"/>
	<br>

	<s:form action="MySQLAction">
		<s:select name="mode"
			list="#{'search':'検索','insert':'追加','update':'更新','delete':'削除' }" />
		<s:textfield label="ID" name="id" placeholder="ユーザーIDを入力してください"
			size="25" />
		<br>
		<s:textfield label="Password" name="password"
			placeholder="パスワードを入力してください" size="25" />
		<s:submit value="実行" />
	</s:form>

</body>
</html>