<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
	margin-top: 50px;
}
.row{
	margin: 0px auto;
	width: 700px;
}
</style>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
let fileIndex=0
$(function(){
	$('#addBtn').click(function(){
		$('#user-table tbody').append(
			'<tr id="f'+fileIndex+'">'
			+'<td width=30%> File '+(fileIndex+1)+'</td>'
			+'<td width=70%><input type=file size=20 name="files['+fileIndex+']"></td>'
			+'</tr>'
		)
		fileIndex++
	})
	
	$('#canBtn').click(function(){
		if(fileIndex>0)
		{
			$('#f'+(fileIndex-1)).remove()
			fileIndex--
		}
	})
})
</script>


</head>
<body>
	<div class="container">
		<h3 class="text-center">글쓰기</h3>
		<%--
			파일 업로드 : enctype="multipart/form-data"
				=> 프로토콜
		 --%>
		<div class="row">
			<form method="post" action="insert_ok.do" enctype="multipart/form-data">
			
				<table class="table">
					<tr>
						<th width=20%>이름</th>
						<td width=80%>
							<input type=text name=name size=15 class="input-sm" required/>
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
						<td colspan="2">
							<table class="table">
								<tr>
									<td class="text-right">
										<input type=button class="btn-xs btn-primary" value="추가" id="addBtn">
										<input type=button class="btn-xs btn-primary" value="취소" id="canBtn">
									</td>
								</tr>
							</table>
							<table class="table" id="user-table">
								<tbody>
									
								</tbody>
							</table>
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
							<input type=submit value="글쓰기" class="btn-sm btn-success"/>
							<input type=button value=취소 class="btn-sm btn-info" onclick="javascript:history.back()">
						</td>
					</tr>
				</table>
			</form>
			
		</div>
	</div>
	
<!-- Include stylesheet -->

<!-- Create the editor container -->

</body>
</html>