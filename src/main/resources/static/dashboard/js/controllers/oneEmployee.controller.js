dbmotion.controller('oneEmployeeController', function($scope, $http, $state, globalService, restClient, $rootScope) {
    $scope.employee = globalService.employee;

     $scope.assign = function(index){
        $rootScope.$broadcast('showTaskModal',{employeeID: $scope.employee.employees[index].id})
        //restClient.assignTask($scope.employee.employees[index], )
     };
    $scope.back = function(){
        $state.go('employees');
    }
});