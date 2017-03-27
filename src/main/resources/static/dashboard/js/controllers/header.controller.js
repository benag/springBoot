dbmotion.controller('headerController',  function($scope,$http, globalService, $state, $rootScope) {
    $rootScope.$on('login',function(){
        $scope.member = globalService.user.firstName;
    });
    $scope.logout = function(){
        globalService.login = false;
        globalService.user = {};
        $state.go('login');
    };
    $scope.goEmployees = function() {
        $state.go('employees');
    };

//			if (globalService.user.firstName === undefined || globalService.user.firstName === ''){
//				$scope.member = 'user';
//			}else{
//				$scope.member = globalService.user.firstName;
//			}
});