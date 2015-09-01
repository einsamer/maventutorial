/**
 * 
 */

bookApp.controller("bookCtrl", function($scope, $http){
	
		var url = "http://localhost:8080/BookStore/book/search?key=";
		
		$scope.nav_listbook = function(){
			$http.get(url)
			.success(function(response){
				$scope.books = response;
			});
		}
		$scope.nav_listbook();
	
});
bookMONApp.controller("bookMongoCtrl", function($scope, $http) {
	
	//$scope.bookname = bookname;
	
	var url = "http://localhost:8080/BookStore/book/listbooksmongo";
	
	$scope.nav_listbook = function(){
		$http.get(url)
		.success(function(response){
			$scope.books = response;
		});
	}
	$scope.nav_listbook();
	
})
;