<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</style>
<script src="https://unpkg.com/vue@3/dist/vue.global.js"></script>
<script src="https://unpkg.com/axios/dis/axios.min.js"></script>
</head>
<body>
		<h3 class="text-center">수정</h3>
			<form method="post" action="update_ok.do" id="frm">
				<table class="table">
					<tr>
						<th width=20%>이름</th>
						<td width=80%>
							<input type=text name=name size=15 class="input-sm" value="${vo.name }" required
								ref="name" v-model="name"/>
							<input type="hidden" name=no value="${vo.no }">
						</td>
					</tr>
					<tr>
						<th width=20%>제목</th>
						<td width=80%>
							<input type=text name=subject size=30 class="input-sm" value="${vo.subject }"
							ref="subject" v-model="subject"/>
						</td>
					</tr>
					<tr>
						<th width=20%>내용</th>
						<td width=80%>
							<textarea rows="10" cols="45" name=content v-model="content" ref="content">${vo.content }</textarea>
						</td>
					</tr>
					<tr>
						<th width=20%>비밀번호</th>
						<td width=80%>
							<input type="password" name=pwd size=10 class="input-sm" v-model="pwd"/>
						</td>
					</tr>
					<tr>
						<td colspan="2" class="text-center">
							<input type=submit value="글쓰기" class="btn-sm btn-success"/>
							<input type=button value=취소 class="btn-sm btn-info" onclick="javascript:history.back()">
						</td>
					</tr>
				</table>
			</form>
</body>
</html>