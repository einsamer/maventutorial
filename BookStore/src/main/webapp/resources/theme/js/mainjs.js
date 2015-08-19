/**
 * Einsamer javascript
 */

var order = 0;

$(document).ready(function() {
	$(".bookrow").click(function() {
		$(".bookrow").removeClass("redrow")
		$(this).addClass("redrow");

		var url = $(this).find(".bookimgurl").val();

		$("#img-show").attr("src", url);
	});

	setInterval(runSlider, 6000);

});

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