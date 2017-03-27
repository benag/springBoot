dbmotion.controller('oneEmployeeController', function($scope, $http, $state, globalService) {

    $scope.show = false;
    $scope.init = function(){
        $scope.employee = globalService.employee;
        for (var i = 0; i < $scope.employee.tasks.length; i++){
            var task = $scope.employee.tasks[i];
            task.dueDate = new Date(task.dueDate);
            task.dueDate = task.dueDate.toISOString();
            task.dueDate = task.dueDate.split('T')[0];


        }
        $scope.show = true;
    }

    $scope.back = function(){
        $state.go('employees');
    }
});