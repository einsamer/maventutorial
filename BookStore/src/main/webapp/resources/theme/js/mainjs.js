/**
 * Einsamer javascript
 */

var order = 0;

$(document).ready(function() {
	addStyle();
	changeLanguage();
});

function changeLanguage() {
		var crtUrl = $(location).attr("href");
		
		//checkURL();
		$(".local-lang").click(function() {
			var nextLang = $(this).attr("href");
			var crtHref = $(location).attr("href");
			var newUrl = checkURL(crtHref, nextLang);
			//alert(newUrl);
			$(location).attr("href",newUrl);
		});
}

function checkURL(crtHref, nextLang) {
	
	if( crtHref.indexOf("language") > 0 ){
		alert(crtHref.match(/(language=)(\w{2})(?:\w{1})?(.*)/));
		crtHref = crtHref.replace(/(language=)(\w{2})(?:\w{1})?(.*)/, '$1' + nextLang + '$3');
		alert(crtHref);
	} else {
		if (crtHref.indexOf("?")>0) {
			crtHref += "&language="+nextLang;
		} else {
			crtHref += "?language="+nextLang;
		}
	}
	
	return crtHref;
}


function addStyle() {
	// table row script
	$(".bookrow").click(function() {
		$(".bookrow").removeClass("redrow")
		$(this).addClass("redrow");

		var url = $(this).find(".bookimgurl").val();
		$("#img-show").attr("src", url);
	});

	setInterval(runSlider, 6000);

	// search script for button
	$("#search-btn").click(function() {
		var key = $("#search-box").val();
		if (key != "" && key != null) {
			searchJquery(key);
		}
	});
	// search script for key event
	$("#search-box").keyup(function() {
		var key = $("#search-box").val();
		searchJquery(key);
	})
}

function searchJquery(key) {
	$.ajax({
		url : "/BookStore/book/search",
		data : {
			key : key
		},
		type : "GET",
		dataType : "json",
		success : function(json) {
			getBookFromJSON(json);
			addStyle();
		},
		error : function(xhr, status, errorThrown) {
			alert("Sorry, there was a problem!");
			console.log("Error: " + errorThrown);
			console.log("Status: " + status);
			console.dir(xhr);
		},
	});

	function getBookFromJSON(json) {
		var line = "";
		$.each(json, function(index, element) {
			line += getBookLine(element);
		});
		console.log(line);
		$("#book-table").html(line);
	}
	// return single data row
	function getBookLine(element) {
		var str = "<tr class = 'bookrow'>";
		str += "<td>" + element.bookid
				+ "<input class = 'bookimgurl' type = 'hidden' value = '"
				+ element.bookimgurl + "'/></td>";
		str += "<td>" + element.bookauthor + "</td>";
		str += "<td>" + element.bookname + "</td>";
		str += "<td><a href='/BookStore/book/delete/" + element.bookid + "'>"
				+ "<button class='btn btn-info'>DELETE</button>" + "</a></td>";
		str += "<td><a href='/BookStore/book/update?" + "id=" + element.bookid
				+ "" + "&name=" + element.bookname + "" + "&author="
				+ element.bookauthor + "" + "&url=" + element.bookimgurl
				+ "'> "
				+ "<button class='btn btn-info'>EDIT</button> </a></td>";
		str += "</tr>";

		return str;
	}
}

function search(key) {
	var xmlhttp = new XMLHttpRequest();

	xmlhttp.open("GET", "/BookStore/book/search?key=" + key, true);
	xmlhttp.send();
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			alert(xmlhttp.responseText);
		}
	}
}

function runSlider() {
	var imgArr = [];
	imgArr[0] = "/BookStore/resources/images/header1-img.jpg";
	imgArr[1] = "/BookStore/resources/images/header2-img.jpg";
	imgArr[2] = "/BookStore/resources/images/header3-img.jpg";

	$("#img-slider").attr("src", imgArr[order]);
	order++;
	if (order == 3) {
		order = 0
	}
}