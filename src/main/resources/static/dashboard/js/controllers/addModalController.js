
angular.module('dbmotion').controller('addModalController', ['$scope', '$location', '$http', 'globalService', '$rootScope', 'restClient',
    function ($scope, $location, $http, global, $rootScope, restClient) {


        $scope.user = {};
        $scope.user.firstName = '';
        $scope.user.lastName = '';
        $scope.$on('showAddModal', function(data,events){
           $('#addModal').modal('toggle');
        });

        $scope.addManager = function(){
            console.log('adding manager: ' + $scope.bossID);
            restClient.addManager($scope.user.firstName , $scope.user.lastName)
            .then(function(){
                console.log('success sending report');
            }).catch(function(err){
                console.log(err);
            })
        }
    }
]);