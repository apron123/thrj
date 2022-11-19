/*  ---------------------------------------------------
    Theme Name: Anime
    Description: Anime video tamplate
    Author: Colorib
    Author URI: https://colorib.com/
    Version: 1.0
    Created: Colorib
---------------------------------------------------------  */

//이미지를 처음 불러올때 처리하는기능

var api_key = "9d58f50eea3bc0cebe233c422bbef69e";
var base_url = "https://image.tmdb.org/t/p/w500/";
var key= "f9a5e15b3b0e1e90e656e39bf714f0a3";
var yesterday = ( d => new Date(d.setDate(d.getDate() -1)))(new Date); //어제 날짜 구하기
yesterday = yesterday.getFullYear()+""+(yesterday.getMonth()+1)+""+ yesterday.getDate();
var date = yesterday; //어제 날짜를 넣어 준다.
var apiUrl = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key="+key+"&targetDt="+date;
window.addEventListener('load', () => {
    const xhr = new XMLHttpRequest(); //리퀘스트 객체를 만든다.
    xhr.onreadystatechange = function(){
        if(xhr.readyState == 4 && xhr.status == 200){
            var jsonObj = JSON.parse(xhr.response); 
            var boxOfficeResult = jsonObj['boxOfficeResult'];
			var movieList = boxOfficeResult['dailyBoxOfficeList'];
            var searchUrl = "https://api.themoviedb.org/3/search/movie?api_key="+api_key+"&language=ko-Kr&page=1&include_adult=false&query="+movieList[0].movieNm;
            var searchUrl2 = "https://api.themoviedb.org/3/genre/movie/list?api_key="+api_key+"&language=ko";
       
            fetch(searchUrl)
            .then(res => res.json())
            .then(function(res){
            	
            	var overview=res.results[0].overview;
            	var backdrop_path=res.results[0].backdrop_path;
            	var mId=res.results[0].id;
            	var release_date=res.results[0].release_date;
            	var original_title=res.results[0].original_title;
            	var m_title=res.results[0].title;
            	var genre_ids=res.results[0].genre_ids;
            	
            	 fetch(searchUrl2)
                 .then(res2 => res2.json())
                 .then(function(res2){
                	 if(genre_ids[0]==res2.genres[0].id){
                	 
                	 	$('.movie_title').each(function() { //타이틀 로그
                	 		$(this).append("<h2 class='movie_title'>"+m_title+"</h2>");
                	 	});
                	 	
                	 	$('.movie_content').each(function() { //줄거리요약
                	 		$(this).css({'line-height':'1.2em','height':'1.6em'});
                	 		$(this).append("<p class='movie_content'>"+(overview.substr(0,38)+' ....')+"</p>");
                	 		
                	 	});
                	 	
                	 	$('.label').each(function() { //타이트 로그
                	 		$(this).append("<div class='label' id='boxofficeLabel'>"+res2.genres[0].name+"</div>");
                	 	});
                	 	
                	 	$('.hero__items').each(function() { //배경이미지
       						//var bg = $(this).data('setbg');
       						 $(this).css('background-image', 'url(' + base_url+backdrop_path + ')');
    					});
    				 }
                 }).catch(error => console.log(error));
            }).catch(error => console.log(error));
        }
    }
    xhr.open('GET', apiUrl, true);
    xhr.send();
});


'use strict';

(function ($) {

    /*------------------
        Preloader
    --------------------*/
    $(window).on('load', function () {
        $(".loader").fadeOut();
        $("#preloder").delay(200).fadeOut("slow");

        /*------------------
            FIlter
        --------------------*/
        $('.filter__controls li').on('click', function () {
            $('.filter__controls li').removeClass('active');
            $(this).addClass('active');
        });
        if ($('.filter__gallery').length > 0) {
            var containerEl = document.querySelector('.filter__gallery');
            var mixer = mixitup(containerEl);
        }
    });

    /*------------------
        Background Set
    --------------------*/
    $('.set-bg').each(function () {
        var bg = $(this).data('setbg');
        $(this).css('background-image', 'url(' + bg + ')');
    });

    // Search model
    $('.search-switch').on('click', function () {
        $('.search-model').fadeIn(400);
    });

    $('.search-close-switch').on('click', function () {
        $('.search-model').fadeOut(400, function () {
            $('#search-input').val('');
        });
    });

    /*------------------
		Navigation
	--------------------*/
    $(".mobile-menu").slicknav({
        prependTo: '#mobile-menu-wrap',
        allowParentLinks: true
    });

    /*------------------
		Hero Slider
	--------------------*/
    var hero_s = $(".hero__slider");
    hero_s.owlCarousel({
        loop: true,
        margin: 0,
        items: 1,
        dots: true,
        nav: true,
        navText: ["<span class='arrow_carrot-left'></span>", "<span class='arrow_carrot-right'></span>"],
        animateOut: 'fadeOut',
        animateIn: 'fadeIn',
        smartSpeed: 1200,
        autoHeight: false,
        autoplay: true,
        mouseDrag: false
    });

    /*------------------
        Video Player
    --------------------*/
    const player = new Plyr('#player', {
        controls: ['play-large', 'play', 'progress', 'current-time', 'mute', 'captions', 'settings', 'fullscreen'],
        seekTime: 25
    });

    /*------------------
        Niceselect
    --------------------*/
    $('select').niceSelect();

    /*------------------
        Scroll To Top
    --------------------*/
    $("#scrollToTopButton").click(function() {
        $("html, body").animate({ scrollTop: 0 }, "slow");
        return false;
     });

})(jQuery);