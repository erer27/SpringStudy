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
			<div class="col-md-3" v-for="vo in recipe_list">
			    <div class="thumbnail">
			      <a href="#">
			        <img :src="'https://www.menupan.com'+vo.poster" style="width:230px;height:250px">
			        <div class="caption">
			          <p>{{vo.name}}</p>
			        </div>
			      </a>
			    </div>
			  </div>
		</div>
		<div style="height: 10px"></div>
		<div class="row">
			<div class="text-center">
				<input type=button class="btn-sm btn-danger" value="이전" @click="prev()">
				{{curpage}} page / {{totalpage}} pages
				<input type=button class="btn-sm btn-danger" value="다음" v-on:click="next()">
			</div>
		</div>
	</div>
	<script>
		let app=Vue.createApp({
			data(){
				return{
					food_list:[],
					curpage:1,
					totalpage:0
				}
			},
			mounted(){
				this.dataRecv()
			},
			methods:{
	    		prev:function(){
	    			this.curpage=this.curpage>1?this.curpage-1:this.curpage
	    			this.dataRecv()
	    		},
	    		next(){
	    			this.curpage=this.curpage<this.totalpage?this.curpage+1:this.curpage
	    			this.dataRecv()
	    		},
	    		dataRecv(){
	    			axios.get('http://localhost:8080/web/food/list_vue.do',{
			    		   params:{
			    			   page:this.curpage
			    		   }
			    	   }).then(response=>{
			    		   console.log(response.data)
			    		   this.recipe_list=response.data.list
			    		   this.curpage=response.data.curpage
			    		   this.totalpage=response.data.totalpage
			    	   })
	    		}
	    		
	       }
		}).mount(".container")
	</script>
</body>
</html>