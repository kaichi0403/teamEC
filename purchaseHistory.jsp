<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/textStyle.css">
<link rel="stylesheet" type="text/css" href="./css/formStyle.css">
<link rel="stylesheet" type="text/css" href="./css/table.css">
<title>商品購入履歴一覧画面</title>
</head>
<body>
	<div id="header">
		<jsp:include page="header.jsp" />
	</div>
	<div id="main">
		<div id="top">
			<p>商品購入履歴一覧画面</p>
		</div>
		<div>
			<s:if test="dto != null">

				<table class="horizon">
					<tr>
						<th>商品名</th>
						<th>ふりがな</th>
						<th>商品画像</th>
						<th>発売会社名</th>
						<th>発売年月日</th>
						<th>値段</th>
						<th>個数</th>
						<th>合計金額</th>
						<th>宛先名前</th>
						<th>宛先住所</th>
					</tr>
					<s:iterator value="dto">
						<tr>
							<td><s:property value="productName" /></td>
							<td><s:property value="productNameKana" /></td>
							<td><img
								src='<s:property value="imageFilePath"/><s:property value="imageFileName"/>' /></td>
							<td><s:property value="releaseCompany" /></td>
							<td><s:property value="releaseDate" /></td>
							<td><s:property value="Price" /><span>円</span></td>
							<td><s:property value="productCount" /><span>個</span></td>
							<td><s:property value="price * productCount" /><span>円</span></td>
							<td><s:property value="familyName" /><span> </span>
							<s:property value="firstName" /></td>
							<td><s:property value="userAddress" /></td>
						</tr>
					</s:iterator>
				</table>

				<s:form action="DeletePurchaseHistoryAction">
					<input type="hidden" name="deleteFlg" value="1">
					<s:submit class="submit_btn" value="履歴削除" />
				</s:form>
			</s:if>
			<s:else>
				<div id="message">
					<p>商品購入情報がありません。</p>
				</div>
			</s:else>
		</div>
	</div>
</body>
</html>