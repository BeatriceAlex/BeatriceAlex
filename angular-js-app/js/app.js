var app = angular.module('blog', [ ]);

app.controller('HomeController', ['$scope', '$http', function($scope, $http) {
  $scope.helloWorld = 'Aplicatii Web cu suport Java!';
//Persoana 
  $scope.persoane = [];
  $scope.keysPersoane = [];

  $scope.person = {};
  $scope.editPerson = {};



  $http.get('http://localhost:8080/persoana').then(
    function successCallback(response) {

    $scope.persoane = response;
	console.log($scope.persoane);
	
    $scope.keysPersoane = Object.keys(response.data[0]);

  });


  $scope.addPersoana = function(person) {
    $scope.persoane.data.push(person);
    $http.post('http://localhost:8080/persoana', person);
    $scope.person = {};
  };

  $scope.setUpdatePerson = function(person) {
    $scope.editPerson = person;
  };

  $scope.updatePerson = function() {
    $http.put('http://localhost:8080/persoana', $scope.editPerson);
    $scope.editPerson = {};
  };

  $scope.deletePersoana = function(id) {
    $http.delete('http://localhost:8080/persoana/' + id)
    .then(
      function successCallback(response) {
        /* code goes here */
      },
      function errorCallback(response) {
        angular.element('[data-id=' + id + ']').remove();
    });
  };

  $scope.myArray = ['Elem 1', 'Elem 2', 'Elem 3', 'Elem 4'];
  
  
  //Biblioteca
  $scope.Biblioteca = {};
  $scope.keys2 = [];

  $scope.book = {};
  $scope.editBook = {};
 $scope.keysBiblioteca=[];


  $http.get('http://localhost:8080/Biblioteca').then(
    function successCallback(response) {
    $scope.Biblioteca = response;
    $scope.keysBiblioteca = Object.keys(response.data[0]);
  });


  $scope.addBiblioteca = function(book) {
	  console.log("noua carte este:",book);
	  console.log("biblioteca este:",$scope.Biblioteca.data);
    $scope.Biblioteca.data.push(book);
	  console.log(" Noua biblioteca este:",$scope.Biblioteca.data);
    $http.post('http://localhost:8080/Biblioteca', book);
    $scope.book = {};
  };

  $scope.setUpdateBook = function(book) {
	  console.log("cartea este:",book);
    $scope.editBook = book;
	console.log("din nou cartea este:",book);
  };

  $scope.updateBook = function(editBook) {
    $http.put('http://localhost:8080/Biblioteca', $scope.editBook);
    $scope.editBook = {};
  };

  $scope.deleteBiblioteca = function(id) {
    $http.delete('http://localhost:8080/Biblioteca/' + id)
    .then(
      function successCallback(response) {
        /* code goes here */
      },
      function errorCallback(response) {
        angular.element('[data-id=' + id + ']').remove();
    });
  };

  $scope.myArray = ['Elem 1', 'Elem 2', 'Elem 3', 'Elem 4','Elem 5', 'Elem 6', 'Elem 7', 'Elem 8'];
  
  
  //Cos_cumparaturi
  $scope.Cos_cumparaturi = [];
  $scope.keysCos = [];

  $scope.cos = {};
  $scope.editCos = {};



  $http.get('http://localhost:8080/Cos_cumparaturi').then(
    function successCallback(response) {

    $scope.Cos_cumparaturi = response;
    $scope.keysCos = Object.keys(response.data[0]);
  });


  $scope.addCos_cumparaturi = function(cos) {
    $scope.Cos_cumparaturi.data.push(cos);
    $http.post('http://localhost:8080/Cos_cumparaturi', cos);
    $scope.cos = {};
  };

  $scope.setUpdateCos = function(cos) {
    $scope.editCos = cos;
  };

  $scope.updateCos = function() {
    $http.put('http://localhost:8080/Cos_cumparaturi', $scope.editCos);
    $scope.editCos = {};
  };

  $scope.deleteCos_cumparaturi = function(id) {
    $http.delete('http://localhost:8080/Cos_cumparaturi/' + id)
    .then(
      function successCallback(response) {
        /* code goes here */
      },
      function errorCallback(response) {
        angular.element('[data-id=' + id + ']').remove();
    });
  };

  $scope.myArray = ['Elem 1', 'Elem 2', 'Elem 3', 'Elem 4','Elem 5', 'Elem 6', 'Elem 7', 'Elem 8','Elem 9', 'Elem 10', 'Elem 11', 'Elem 12'];
  
  
  
  
   //Skittles
  $scope.Skittles = [];
  $scope.keysSk = [];

  $scope.skit = {};
  $scope.editSkit = {};



  $http.get('http://localhost:8080/Skittles').then(
    function successCallback(response) {

    $scope.Skittles = response;
    $scope.keysSk = Object.keys(response.data[0]);
  });


  $scope.addSkittles = function(skit) {
    $scope.Skittles.data.push(skit);
    $http.post('http://localhost:8080/Skittles', skit);
    $scope.skit = {};
  };

  $scope.setUpdateSkit = function(skit) {
    $scope.editSkit = skit;
  };

  $scope.updateSkit = function() {
    $http.put('http://localhost:8080/Skittles', $scope.editSkit);
    $scope.editSkit = {};
  };

  $scope.deleteSkittles = function(id) {
    $http.delete('http://localhost:8080/Skittles/' + id)
    .then(
      function successCallback(response) {
        /* code goes here */
      },
      function errorCallback(response) {
        angular.element('[data-id=' + id + ']').remove();
    });
  };

  $scope.myArray = ['Elem 1', 'Elem 2', 'Elem 3', 'Elem 4','Elem 5', 'Elem 6', 'Elem 7', 'Elem 8','Elem 9', 'Elem 10', 'Elem 11', 'Elem 12'];
}]);