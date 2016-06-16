        var app = angular.module('todoListApp',[]);

        app.controller('todoListController',['$scope', function($scope){

            $scope.categorias = [
            {nome: 'Afazeres domesticos', lista: ['Cozinhar', 'Limpar a Casa', 'Programar']},
            {nome:'Saude', lista:['Ir ao medico', 'Fazer exame', 'Ficar de jejum 12h']},
            {nome:'Afazeres profissionais', lista:['Preencher formulario', 'Limpar a Empresa', 'Programar']}];

            $scope.novoToDo = "";

            $scope.addList = function(indice, value){
                $scope.categorias[indice].lista.push(value);
                $scope.value = "";
            };

            $scope.removeList = function(index,indexPai){
                $scope.categorias[indexPai].lista.splice(index, 1);
            };

            $scope.updateList = function(index,indexPai){
                $scope.categorias[indexPai].lista.splice(index, 1);
            };
       }]);