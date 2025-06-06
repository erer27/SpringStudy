<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</style>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/quill@2.0.3/dist/quill.snow.css" rel="stylesheet" />
<script src="https://cdn.jsdelivr.net/npm/quill@2.0.3/dist/quill.js"></script>
</head>
<body>
		<h3 class="text-center">답변하기</h3>
			<form method="post" action="reply_ok.do">
				<table class="table">
					<tr>
						<th width=20%>이름</th>
						<td width=80%>
							<input type=text name=name size=15 class="input-sm" required/>
							<input type="hidden" name="pno" value="${no }">
						</td>
					</tr>
					<tr>
						<th width=20%>제목</th>
						<td width=80%>
							<input type=text name=subject size=30 class="input-sm"/>
						</td>
					</tr>
					<tr>
						<th width=20%>내용</th>
						<td width=80%>
							<textarea rows="10" cols="45" name=content></textarea>
						</td>
					</tr>
					<tr>
						<th width=20%>비밀번호</th>
						<td width=80%>
							<input type="password" name=pwd size=10 class="input-sm"/>
						</td>
					</tr>
					<tr>
						<td colspan="2" class="text-center">
							<input type=submit value="답변" class="btn-sm btn-success"/>
							<input type=button value=취소 class="btn-sm btn-info" onclick="javascript:history.back()">
						</td>
					</tr>
				</table>
			</form>
</body>
</html>