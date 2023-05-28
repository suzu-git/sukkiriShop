<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>スッキリ商店</title>
</head>
<body>
<p>以下を入力してください。</p>
<form action="/sukkiriShop/RegisterServlet" method="post">
ユーザID:<input type="text" name="userId"><br>
パスワード:<input type="password" name="pass"><br>
メールアドレス:<input type="text" name="mail"><br>
姓名:<input type="text" name="name"><br>
年齢:<input type="text" name="age"><br>
<input type="submit" value="登録"><br>
</form>
</body>
</html>

<%-- 必要作業： --%>