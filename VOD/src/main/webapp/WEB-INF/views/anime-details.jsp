<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var ="context"><%=request.getContextPath()%></c:set>
<c:set var ="crawlingImage"><%="http://gjaischool-b.ddns.net:8086/crawlingImage"%></c:set>
<c:set var ="memberProfile"><%="http://gjaischool-b.ddns.net:8086/memberProfile"%></c:set>
<c:set var ="userPhoto"><%="resources/memberPhoto"%></c:set>


<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="Anime Template">
    <meta name="keywords" content="Anime, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>NeTupidia</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Oswald:wght@300;400;500;600;700&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Mulish:wght@300;400;500;600;700;800;900&display=swap"
    rel="stylesheet">    

    <!-- Css Styles -->
    <link rel="stylesheet" href="resources/css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="resources/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="resources/css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="resources/css/plyr.css" type="text/css">
    <link rel="stylesheet" href="resources/css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="resources/css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="resources/css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="resources/css/style.css" type="text/css">
</head>

<body>    
    <!-- Page Preloder -->
    <div id="preloder">
        <div class="loader"></div>
    </div>
	<!-- header -->
	<%@ include file="./header.jsp"%>
	
    <!-- Breadcrumb Begin -->
    <div class="breadcrumb-option">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="breadcrumb__links">
                        <a href="index.do"><i class="fa fa-home"></i> Home</a>
                       
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Breadcrumb End -->

    <!-- Anime Section Begin -->
    <section class="anime-details spad">
        <div class="container">
            <div class="anime__details__content">
                <div class="row">
                    <div class="col-lg-3">
                        <div class="anime__details__pic set-bg" data-setbg="${crawlingImage}/${movie.movie_img}.png">
                            <div class="comment"><i class="fa fa-comments"></i>&nbsp;${CommentsCnt}</div>
                            <div class="view"><i class="fa fa-eye"></i>&nbsp;${movie.movie_cnt}</div>
                            
                        </div>
                    </div>
                    <div class="col-lg-9">
                        <div class="anime__details__text">
                            <div class="anime__details__title">
                                <h3>${movie.movie_title}</h3>
                            </div>
                            <div class="anime__details__rating">
                                <div class="rating">
                                      <c:choose>
									     <c:when test = "${movie.movie_rating/2 >= 5}">
									           <a href="#"><i class="fa fa-star"></i></a>
									           <a href="#"><i class="fa fa-star"></i></a>
									           <a href="#"><i class="fa fa-star"></i></a>
									           <a href="#"><i class="fa fa-star"></i></a>
									           <a href="#"><i class="fa fa-star"></i></a>
									     </c:when>
									     <c:when test = "${movie.movie_rating/2 >= 4}">
									           <a href="#"><i class="fa fa-star"></i></a>
									           <a href="#"><i class="fa fa-star"></i></a>
									           <a href="#"><i class="fa fa-star"></i></a>
									           <a href="#"><i class="fa fa-star"></i></a>
									           <a href="#"><i class="fa fa-star-o"></i></a>
									         
									     </c:when>
									     <c:when test = "${movie.movie_rating/2 >= 3}">
									           <a href="#"><i class="fa fa-star"></i></a>
									           <a href="#"><i class="fa fa-star"></i></a>
									           <a href="#"><i class="fa fa-star"></i></a>
									           <a href="#"><i class="fa fa-star-o"></i></a>
									           <a href="#"><i class="fa fa-star-o"></i></a>
									     </c:when>
									     <c:when test = "${movie.movie_rating/2 >= 2}">
									           <a href="#"><i class="fa fa-star"></i></a>
									           <a href="#"><i class="fa fa-star"></i></a>
									           <a href="#"><i class="fa fa-star-o"></i></a>
									           <a href="#"><i class="fa fa-star-o"></i></a>
									           <a href="#"><i class="fa fa-star-o"></i></a>
									     </c:when>
									     <c:when test = "${movie.movie_rating/2 >= 1}">
									           <a href="#"><i class="fa fa-star"></i></a>
									           <a href="#"><i class="fa fa-star-o"></i></a>
									           <a href="#"><i class="fa fa-star-o"></i></a>
									           <a href="#"><i class="fa fa-star-o"></i></a>
									           <a href="#"><i class="fa fa-star-o"></i></a>
									     </c:when>
         								<c:otherwise>
									           <a href="#"><i class="fa fa-star-o"></i></a>
									           <a href="#"><i class="fa fa-star-o"></i></a>
									           <a href="#"><i class="fa fa-star-o"></i></a>
									           <a href="#"><i class="fa fa-star-o"></i></a>
									           <a href="#"><i class="fa fa-star-o"></i></a>
         								</c:otherwise>
                                      </c:choose>
                                </div>
                                <span>${movie.movie_participate} Votes</span>
                            </div>
                            <p>${movie.movie_content}</p>
                            <div class="anime__details__widget">
                                <div class="row">
                                    <div class="col-lg-12 col-md-12">
                                        <ul>
                                            <li><span>영화 유형 :</span> ${movie.movie_type}</li>
                                            <li><span>영화감독:</span>${movie.movie_director}</li>
                                            <li><span>영화 개봉날짜:</span> ${fn:substring(movie.movie_open_date,0,10)}&nbsp;&nbsp;개봉</li>
                                            <li><span>영화 러닝타임:</span>${movie.movie_runtime}</li>
                                            <li><span>영화 출연배우:</span>${movie.movie_actor}</li>
                                            <li><span>영화 제작 국가:</span>${movie.movie_country}</li>
                                            <%-- <li><span>영화 등급:</span>${movie.movie_age}</li> --%>
                                            <li><span>영화 평점:
                                            <div class="rating">
                                      <c:choose>
									     <c:when test = "${movie.movie_rating/2 >= 5}">
									           <a href="#"><i class="fa fa-star"></i></a>
									           <a href="#"><i class="fa fa-star"></i></a>
									           <a href="#"><i class="fa fa-star"></i></a>
									           <a href="#"><i class="fa fa-star"></i></a>
									           <a href="#"><i class="fa fa-star"></i></a>
									     </c:when>
									     <c:when test = "${movie.movie_rating/2 >= 4}">
									           <a href="#"><i class="fa fa-star"></i></a>
									           <a href="#"><i class="fa fa-star"></i></a>
									           <a href="#"><i class="fa fa-star"></i></a>
									           <a href="#"><i class="fa fa-star"></i></a>
									           <a href="#"><i class="fa fa-star-o"></i></a>
									         
									     </c:when>
									     <c:when test = "${movie.movie_rating/2 >= 3}">
									           <a href="#"><i class="fa fa-star"></i></a>
									           <a href="#"><i class="fa fa-star"></i></a>
									           <a href="#"><i class="fa fa-star"></i></a>
									           <a href="#"><i class="fa fa-star-o"></i></a>
									           <a href="#"><i class="fa fa-star-o"></i></a>
									     </c:when>
									     <c:when test = "${movie.movie_rating/2 >= 2}">
									           <a href="#"><i class="fa fa-star"></i></a>
									           <a href="#"><i class="fa fa-star"></i></a>
									           <a href="#"><i class="fa fa-star-o"></i></a>
									           <a href="#"><i class="fa fa-star-o"></i></a>
									           <a href="#"><i class="fa fa-star-o"></i></a>
									     </c:when>
									     <c:when test = "${movie.movie_rating/2 >= 1}">
									           <a href="#"><i class="fa fa-star"></i></a>
									           <a href="#"><i class="fa fa-star-o"></i></a>
									           <a href="#"><i class="fa fa-star-o"></i></a>
									           <a href="#"><i class="fa fa-star-o"></i></a>
									           <a href="#"><i class="fa fa-star-o"></i></a>
									     </c:when>
         								<c:otherwise>
									           <a href="#"><i class="fa fa-star-o"></i></a>
									           <a href="#"><i class="fa fa-star-o"></i></a>
									           <a href="#"><i class="fa fa-star-o"></i></a>
									           <a href="#"><i class="fa fa-star-o"></i></a>
									           <a href="#"><i class="fa fa-star-o"></i></a>
         								</c:otherwise>
                                      </c:choose>
                                </div>
                                <span>${movie.movie_participate} Votes</span>
                                </span></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-8 col-md-8">
                        <div class="anime__details__review">
                        
                            <div class="section-title">
                                <h5>Reviews</h5>
                            </div>
                           <c:forEach items="${CommentList}" var="Comment"> 
                            <div class="anime__review__item">
                                <div class="anime__review__item__pic">
                                  	<c:choose>
									     <c:when test = "${Comment.mb_profile ne '' and Comment.mb_profile ne null}">
                                    		<img src="${memberProfile}/${Comment.mb_profile}" alt="${Comment.mb_name} ( ${Comment.mb_id} ) 님의사진">
                                    	</c:when>
                                    	<c:otherwise>
                                    		<img src="${memberProfile}/memberProfile.jpg" alt="${Comment.mb_name} ( ${Comment.mb_id} ) 님의사진">
                                    	</c:otherwise>
                                    </c:choose>
                                </div>
                                <div class="anime__review__item__text">
                               		<h6>${Comment.mb_name}&nbsp;(&nbsp;${Comment.mb_id}&nbsp;)<span>&nbsp;&nbsp;&nbsp;${Comment.cmt_date}</span></h6>
                                    <p>${Comment.cmt_content}</p>
                                </div>
                            </div>
                        </c:forEach>
                        </div>
                        <div class="anime__details__form">
                            <div class="section-title">
                                <h5>Your Comment</h5>
                            </div>
                            <form  action="CommentWrite.do" method="post" >
                            	<input type="hidden" name="mb_id" value="${sessionScope.mb_id}">
                            	<input type="hidden" name="movie_seq" value="${movie.movie_seq}">
                                <textarea placeholder="Your Comment" name="cmt_content"></textarea>
                                <c:if test="${sessionScope.mb_id != null}">
                                	<button type="submit"><i class="fa fa-location-arrow"></i> Review</button>
                                </c:if>
                            </form>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-4">
                        <div class="anime__details__sidebar">
                            <div class="section-title">
                                <h5>you might like...</h5>
                            </div>
                            <div class="product__sidebar__view__item set-bg" data-setbg="resources/img/sidebar/tv-1.jpg">
                                <div class="ep">18 / ?</div>
                                <div class="view"><i class="fa fa-eye"></i> 9141</div>
                                <h5><a href="#">Boruto: Naruto next generations</a></h5>
                            </div>
                            <div class="product__sidebar__view__item set-bg" data-setbg="resources/img/sidebar/tv-2.jpg">
                                <div class="ep">18 / ?</div>
                                <div class="view"><i class="fa fa-eye"></i> 9141</div>
                                <h5><a href="#">The Seven Deadly Sins: Wrath of the Gods</a></h5>
                            </div>
                            <div class="product__sidebar__view__item set-bg" data-setbg="resources/img/sidebar/tv-3.jpg">
                                <div class="ep">18 / ?</div>
                                <div class="view"><i class="fa fa-eye"></i> 9141</div>
                                <h5><a href="#">Sword art online alicization war of underworld</a></h5>
                            </div>
                            <div class="product__sidebar__view__item set-bg" data-setbg="resources/img/sidebar/tv-4.jpg">
                                <div class="ep">18 / ?</div>
                                <div class="view"><i class="fa fa-eye"></i> 9141</div>
                                <h5><a href="#">Fate/stay night: Heaven's Feel I. presage flower</a></h5>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Anime Section End -->
		<!-- footer section -->
		<%@ include file="./footer.jsp"%>
		
          <!-- Search model Begin -->
          <div class="search-model">
            <div class="h-100 d-flex align-items-center justify-content-center">
                <div class="search-close-switch"><i class="icon_close"></i></div>
                <form class="search-model-form">
                    <input type="text" id="search-input" placeholder="Search here.....">
                </form>
            </div>
        </div>
        <!-- Search model end -->

        <!-- Js Plugins -->
        <script src="resources/js/jquery-3.3.1.min.js"></script>
        <script src="resources/js/bootstrap.min.js"></script>
        <script src="resources/js/player.js"></script>
        <script src="resources/js/jquery.nice-select.min.js"></script>
        <script src="resources/js/mixitup.min.js"></script>
        <script src="resources/js/jquery.slicknav.js"></script>
        <script src="resources/js/owl.carousel.min.js"></script>
        <script src="resources/js/main.js"></script>

    </body>

    </html>