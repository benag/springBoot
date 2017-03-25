dbmotion.controller('employeesController', function($scope, $http,$state, $q, globalService) {
    $scope.page = 0;
    $scope.limit = 10;
    $scope.pros =[];

    $scope.nextButton = false;
    $scope.updatepro = function(index){
        globalService.chosenPro = $scope.pros[index];
        $state.go('oneEmployee');

    };
    $scope.add = function(){
        //$('#myModal').modal('toggle');
        $state.go('addProfessional');
    };
    $scope.getEmployees = function(page,limit){
        return $q(function(resolve, reject) {
            $http.get('/api/employees/')
            .then(function(data){
                console.log(data.data);
                resolve(data.data);
            }, function(err){
                reject(data.data);
            });
        });
    };
    $scope.oneEmployee = function(index){
        globalService.employee = $scope.employees[index];
        $state.go('oneEmployee');
    }
    $scope.next = function(){
        $scope.page++;
        $scope.getPro($scope.page,$scope.limit)
            .then(function(data){
                if (data.data.status === 'Ok'){
                    $scope.pros = data.data.payload;
                    if (data.data.payload.length >= 10){
                        $scope.nextButton = true;
                    }
                }else{
                    alert('error');
                }
            }).catch(function(err){
                alert('error');
            })
    };
    $scope.last = function(){
        $scope.page--;
        $scope.getPro($scope.page,$scope.limit)
            .then(function(data){
                if (data.data.status === 'Ok'){
                    $scope.pros = data.data.payload;
                    if (data.data.payload.length >= 10){
                        $scope.nextButton = true;
                    }
                }else{
                    alert('error');
                }
            }).catch(function(err){
                alert('error');
            })
    };

    $scope.init = function(){
        $scope.getEmployees($scope.page,$scope.limit)
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