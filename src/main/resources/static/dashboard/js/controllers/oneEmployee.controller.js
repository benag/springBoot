dbmotion.controller('oneEmployeeController', function($scope, $http, $state, globalService, restClient, $rootScope) {


     $scope.show = false;

     $scope.assign = function(index){
        $rootScope.$broadcast('showTaskModal',{employeeID: $scope.employee.employees[index].id})
     };

     $scope.sendReport = function(){
        var bossId = $scope.employee.boss.id;
        $rootScope.$broadcast('showReportModal',{bossId: bossId})
     }

     $scope.addSubordinate = function(){
        $rootScope.$broadcast('showSubordinateModal');
     }

    $scope.back = function(){
        $state.go('employees');
    }

    $scope.formatDates = function(){
        for (var i = 0; i < $scope.employee.tasks.length; i++){
            var task = $scope.employee.tasks[i];
            task.dueDate = new Date(task.dueDate);
            task.dueDate = task.dueDate.toISOString();
            task.dueDate = task.dueDate.split('T')[0];
        }
    }

    $scope.init = function(){
        $scope.employee = globalService.employee;
        $scope.formatDates();
        restClient.getBoss($scope.employee.id)
        .then(function(manager){
            $scope.employee.boss = manager;
            $scope.show = true;
        })
    }
});