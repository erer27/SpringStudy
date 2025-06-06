<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://unpkg.com/vue@3/dist/vue.global.js"></script>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<style type="text/css">
.container{
	margin-top: 50px;
}
.row{
	margin: 0px auto;
	width: 960px;
}
p{
	overflow:hidden;
	white-space:nowrap;
	text-overflow:ellipsis;
}
.page-btn:hover{
	cursor:pointer;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
				<div class=text-center>
					<input type="button" value="명소" class="btn-success" @click="seoul(1)"/>
					<input type="button" value=지연 class="btn-success" @click="seoul(2)"/>
					<input type="button" value="쇼핑" class="btn-success" @click="seoul(3)"/>
					<input type="button" value="음식" class="btn-success" @click="seoul(4)"/>
				</div>

				<div style="height: 10px"></div>
				<div class="row">
					<div class="text-center">
						<ul class="pagination">
							<li v-if="startPage>1"><a class="page-btn" @click="prev()">&lt;</a></li>
							<li v-for="i in range(startPage,endPage)" :class="i===curpage?'active':''"><a class="page-btn" @click="pageChange(i)">{{i}}</a></li>
							<li v-if="endPage<totalpage"><a class="page-btn" @click="next()">&gt;</a></li>
						</ul>
					</div>
				</div>
				<div style="height:10px"></div>
				<div class="row">
				
				</div>
				
		</div>
		<div class="row">
			<h3 class="text-center">{{title}}</h3>
			<div class="row">
			<div class="col-md-3" v-for="vo in seoul_list">
			    <div class="thumbnail">
			      <a :href="'../seoul/detail.do?no='+vo.no+'&type='+type">
			        <img :src="vo.poster" style="width:230px;height:250px">
			        <div class="caption">
			          <p>{{vo.title}}</p>
			        </div>
			      </a>
			    </div>
			  </div>
		</div>
		</div>
		<div class="row">
			
		</div>
	</div>
	<script src="list.js">
		
	</script>
</body>
</html>