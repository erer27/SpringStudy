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
	width: 700px;
}
p{
	overflow:hidden;
	white-space:nowrap;
	text-overflow:ellipsis;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-3" v-for="vo in list">
			    <div class="thumbnail">
			      <a href="#">
			        <img :src="'https://www.menupan.com'+vo.poster"  style="width:230px;height:200px">
			        <div class="caption">
			          <p>{{vo.name}}</p>
			        </div>
			      </a>
			    </div>
			</div>
		</div>
	</div>
	<script>
		let app=Vue.createApp({
			data(){
				return {
					list:[]
				}
			},
			// 시작과 동시에 데이터 읽기
			mounted(){
				axios.get("../food/list_vue.do")
				.then(response=>{
					this.list=response.data
				})
			}
		}).mount(".container")
	</script>
</body>
</html>