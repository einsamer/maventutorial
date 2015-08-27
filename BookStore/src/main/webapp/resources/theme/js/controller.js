/**
 * 
 */

bookApp.controller("bookCtrl", function($scope, $http){
		$scope.cons = "";
	
		var url = "http://localhost:8080/BookStore/book/search?key=";
		
		$scope.nav_listbook = function(){
			$http.get(url)
			.success(function(response){
				$scope.books = response;
			});
		}
		$scope.nav_listbook();
	
});