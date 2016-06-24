var app = angular.module('todoListApp', []);

app.factory('Service', Service);

Service.$inject= ['$http'];

function Service($http){
  function list(callback){
    $http({
			method : 'GET',
			url : '/api/rest/ToDo/item'
		}).success(function (response) {
		  callback(response, true);
		}).error(function (response) {
			callback(response, false);
		});
  }
  return {
    list: list,
    nomeAplicacao:""
  };
  
  function save(data, callback) {
		var url = '/api/rest/ToDo/item';
		item = {
			descricao : $scope.descricao
		};
		$http.post(url, item).success(function (response) {
		  callback(response, true);
		}).error(function (response) {
			callback(response, false);
		});
    
  }
  return { save : save };
}


app.controller('TodoListController', TodoListController);

TodoListController.$inject = ['$scope', 'Service'];

function TodoListController($scope, Service) {

	$scope.list = list;
	$scope.save = save;
	$scope.remove = remove;
	$scope.list();
	$scope.mensagem = "";

	function list() {
		Service.list(function (response, success){
		  if (success){
		    $scope.itens = response;
		    $scope.mensagem = 'Sucesso';
		  } else $scope.mensagem = 'Herro';
		});
	}

	function save() {
    Service.save(function (response, ))
	}

	function remove(id) {
		var url = 'api/rest/ToDo/item/'+id;
		$http.delete(url).success(function(){
		  $scope.mensagem= "Removeu";
		  $scope.list();
		}).error(function(){
		  $scope.mensagem="Falhou";
	});
		
}

}