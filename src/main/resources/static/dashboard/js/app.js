
var dbmotion = angular.module('dbmotion', ['ui.router','720kb.datepicker','ui.select', 'ngSanitize',]);




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

});

dbmotion.controller('leftMenuController',  function($scope,$http, globalService, $state) {

});



dbmotion.controller('modalController', function($scope, $http) {

});

