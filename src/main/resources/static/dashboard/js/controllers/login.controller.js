dbmotion.controller('loginController',  function($scope,$http, globalService, $state, $rootScope) {
    if (globalService.login) $state.go('professionals');
    $scope.wrong = false;
    $scope.user = {
        username:'',
        password:'',
        role: 'client'
    };


    $scope.login= function(){
        $http.post('/login',{user:$scope.user})
        .then(function(data){
            if (data.data.status === 'Ok'){
                globalService.login = true;
                globalService.user = data.data.payload;
                $rootScope.$broadcast('login');
                $scope.$applyAsync(function(){globalService.user = data.data.payload;});
                globalService.getSettings().then(function(res) {
                    globalService.getRoles().then(function (resII) {
                        $state.go('employees');
                    }).catch(function (err) {
                        alert(err);
                    })
                });
            }else{
                $scope.wrong = true;
                globalService.user.login = false;
            }
        }, function(){
            globalService.user.login = false;
        });
    }
});