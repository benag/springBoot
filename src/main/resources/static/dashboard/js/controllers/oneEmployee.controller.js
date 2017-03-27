dbmotion.controller('oneEmployeeController', function($scope, $http, $state, globalService, restClient, $rootScope) {
     $scope.employee = globalService.employee;
     $scope.employee.boss = {id:2, firstName:'ben', lastName:'shakhal'};
     $scope.assign = function(index){
        $rootScope.$broadcast('showTaskModal',{employeeID: $scope.employee.employees[index].id})
        //restClient.assignTask($scope.employee.employees[index], )
     };
     $scope.sendReport = function(){
        var bossId = $scope.employee.boss.id;
        $rootScope.$broadcast('showReportModal',{bossId: bossId})
     }
    $scope.back = function(){
        $state.go('employees');
    }
});