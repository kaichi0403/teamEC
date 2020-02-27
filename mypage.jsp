<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/table.css">
<link rel="stylesheet" type="text/css" href="./css/formStyle.css">
<link rel="stylesheet" type="text/css" href="./css/textStyle.css">
<title>マイページ画面</title>
</head>
<body>
	<div id="header">
		<jsp:include page="header.jsp" />
	</div>
	<div id="main">
		<div id="top">
			<p>マイページ画面</p>
		</div>
		<div>
			<table class="vertical">
				<tr>
					<th><label>姓</label></th>
					<td><s:property value="dto.familyName" /></td>
				</tr>
				<tr>
					<th><label>名</label></th>
					<td><s:property value="dto.firstName" /></td>
				</tr>
				<tr>
					<th><label>ふりがな</label></th>
					<td><s:property value="dto.familyNameKana" /><span> </span> <s:property
							value="dto.firstNameKana" /></td>
				</tr>
				<tr>
					<th><label>性別</label></th>
					<s:if test="dto.sex==0">
						<td>男性</td>
					</s:if>
					<s:else>
						<td>女性</td>
					</s:else>
				</tr>
				<tr>
					<th><label>メールアドレス</label></th>
					<td><s:property value="dto.email" /></td>
				</tr>
			</table>
			<s:form action="PurchaseHistoryAction">
				<s:submit class="submit_btn" value="購入履歴" />
			</s:form>
		</div>
	</div>
</body>
</html>