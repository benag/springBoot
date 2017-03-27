dbmotion.controller('employeesController', function($scope, $http,$state, $q, globalService, restClient) {
    $scope.page = 0;
    $scope.limit = 10;
    $scope.pros =[];

    $scope.nextButton = false;

    $scope.add = function(){

    };

    $scope.oneEmployee = function(index){
        globalService.employee = $scope.employees[index];
        $state.go('oneEmployee');
    };

    $scope.next = function(){
        $scope.page++;

    };
    $scope.last = function(){
        $scope.page--;

    };

    $scope.init = function(){
        restClient.getEmployees($scope.page,$scope.limit)
        .then(function(data){
            $scope.$applyAsync(function(){
                $scope.employees = data;
                if (data.length >= 10){
                    $scope.nextButton = true;
                }
            })
        }).catch(function(err){
            alert('error');
        })
    }
});