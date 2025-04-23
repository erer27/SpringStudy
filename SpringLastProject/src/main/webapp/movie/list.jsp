<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.page-link{
  cursor: pointer;
}
</style>
</head>
<body>
<!-- ****** Breadcumb Area Start ****** -->
    <div class="breadcumb-area" style="background-image: url(../img/bg-img/breadcumb.jpg);">
        <div class="container h-100">
            <div class="row h-100 align-items-center">
                <div class="col-12">
                    <div class="bradcumb-title text-center">
                        <h2>부산 맛집 목록</h2>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="breadcumb-nav">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="#"><i class="fa fa-home" aria-hidden="true"></i></a></li>
                            <li class="breadcrumb-item active" aria-current="page"></li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
    </div>
    <!-- ****** Breadcumb Area End ****** -->

    <!-- ****** Archive Area Start ****** -->
    <section class="archive-area section_padding_80" id="listApp">
        <div class="container">
            <div class="row">
                <div class="text-center">
                  <input type=text class="form-control">
                </div>
                <!-- Single Post -->
                <div class="col-12 col-md-6 col-lg-4" v-for="vo in list">
                    <div class="single-post wow fadeInUp" data-wow-delay="0.1s">
                        <!-- Post Thumb -->
                        <div class="post-thumb">
                            <img src="#" alt="">
                        </div>
                        <!-- Post Content -->
                        <div class="post-content">
                            <div class="post-meta d-flex">
                                <div class="post-author-date-area d-flex">
                                    <!-- Post Author -->
                                    <div class="post-author">
                                        <a href="#">{{vo.address}}</a>
                                    </div>
                                    
                                </div>
                                
                            </div>
                            <a href="#">
                                <h4 class="post-headline">{{vo.name}}</h4>
                            </a>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </section>
    <script>
    let listApp=Vue.createApp({
    	// 멤버변수 => Model => 변경시에는 바로 View(JSP)에 적용
    	data(){
    		return {
    		   
    		}
    	},
    	// VM => ViewModel => 변수를 변경하는 역할 
    	// MVVM : 필수로 면접 
    	mounted(){
    	
    	},
    	// 사용자 정의 함수 정의 => 이벤트 
    	methods:{
    	}
    }).mount("#listApp")
    </script>
</body>
</html>