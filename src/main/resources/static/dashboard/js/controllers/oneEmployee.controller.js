dbmotion.controller('oneEmployeeController', function($scope, $http, $state, globalService, restClient, $rootScope) {

     $scope.employee = globalService.employee;
     $scope.show = true;

     $scope.assign = function(index){
        $rootScope.$broadcast('showTaskModal',{employeeID: $scope.employee.employees[index].id})
     };

     $scope.sendReport = function(){
        var bossId = $scope.employee.boss.id;
        $rootScope.$broadcast('showReportModal',{bossId: bossId})
     }

    $scope.back = function(){
        $state.go('employees');
    }

    $scope.init = function(){
        restClient.getBoss($scope.employee.id)
        .then(function(manager){
            $scope.employee.boss = manager;
            $scope.show = true;
        })
    }
});