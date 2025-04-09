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
					<input type="button" value="한식" class="btn-success" @click="food('한식')"/>
					<input type="button" value="양식" class="btn-success" @click="food('양식')"/>
					<input type="button" value="중식" class="btn-success" @click="food('중식')"/>
					<input type="button" value="일식" class="btn-success" @click="food('일식')"/>
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
			<h3 class="text-center">{{type}}</h3>
			<div class="row">
			<div class="col-md-3" v-for="vo in food_list">
			    <div class="thumbnail">
			      <a :href="'../food/detail.do?fno='+vo.fno">
			        <img :src="'https://www.menupan.com'+vo.poster" style="width:230px;height:250px">
			        <div class="caption">
			          <p>{{vo.name}}</p>
			        </div>
			      </a>
			    </div>
			  </div>
		</div>
		</div>
		<div class="row">
			
		</div>
	</div>
	<script>
		let listApp=Vue.createApp({
			data(){
				return {
					food_list:[],
					curpage:1,
					totalpage:0,
					startPage:0,
					endPage:0,
					type:'한식'
				}
			},
			mounted(){
				this.dataRecv()
			},
			methods:{
				prev(){
					this.curpage=this.startPage-1
					this.dataRecv()
				},
				next(){
					this.curpage=this.endPage+1
					this.dataRecv()
				},
				pageChange(page){
					this.curpage=page
					this.dataRecv()
				},
				range(start,end){
					let arr=[]
					let len=end-start
					for(let i=0;i<=len;i++)
					{
						arr[i] = start
						start++;
					}
					return arr;
				},
				food(type){
					this.type=type
					this.curpage=1
					this.dataRecv()
				},
				dataRecv(){
					let_this=this
					axios.get("../food/list_vue.do",{
						params:{
							page:this.curpage,
							type:this.type
						}
					}).then(response=>{
						console.log(response)
						this.food_list=response.data.list;
						this.name=response.data.name
						this.curpage=response.data.curpage
						this.totalpage=response.data.totalpage
						this.startPage=response.data.startPage
						this.endPage=response.data.endPage
					}).catch(function(error){
						console.log(error.response)
					})
				}
			}
		}).mount(".container")
	</script>
</body>
</html>