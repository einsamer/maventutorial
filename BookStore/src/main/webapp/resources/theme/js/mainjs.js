/**
 * Einsamer
 * javascript
 */
$(document).ready(function() {
	$(".bookrow").click(function() {
		$(".bookrow").removeClass("redrow")
		$(this).addClass("redrow");
		
		var url = $(this).find(".bookimgurl").val();
		
		$("#img-show").attr("src",url);
	});
})