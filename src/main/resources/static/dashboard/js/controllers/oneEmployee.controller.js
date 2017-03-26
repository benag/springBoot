dbmotion.controller('oneEmployeeController', function($scope, $http, $state, globalService) {
    $scope.employee = globalService.employee;

    $scope.back = function(){
        $state.go('employees');
    }
});