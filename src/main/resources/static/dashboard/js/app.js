
var dbmotion = angular.module('dbmotion', ['ui.router','ngFileUpload','ui.select', 'ngSanitize', 'google.places']);




dbmotion.config(function($stateProvider, $urlRouterProvider) {
    $urlRouterProvider.otherwise("/employees");
    $stateProvider
        .state('login', {
            url: "/login",
            controller:'loginController',
            templateUrl: "views/login.html"
        })
        .state('employees', {
            url: '/employees',
            templateUrl: 'views/employees.html',
            controller:'employeesController'
        })
        .state('oneEmployee', {
            url: "/employee",
            controller:'oneEmployeeController',
            templateUrl: "views/employee.html"
        })
        .state('addProfessional', {
            url: "/addpro",
            controller:'addProController',
            templateUrl: "views/addpro.html"
        })

});

dbmotion.controller('leftMenuController',  function($scope,$http, globalService, $state) {

});



dbmotion.controller('modalController', function($scope, $http) {
//			$scope.pro = {};
//			$scope.pro.companyinfo = {};
//			$scope.pro.contactinfo = {};
//			$scope.pro.geo = {};
//			$scope.pro.credit = {};
//
//			$scope.addpro = function() {
//				$http.post('/professionals/',$scope.pro)
//				.then(function(data){
//					if (data.data.status === 'Ok'){
//
//					}else{
//
//					}
//				}, function(err){
//
//				});
//			}
});

