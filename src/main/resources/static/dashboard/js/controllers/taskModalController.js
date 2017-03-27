
angular.module('dbmotion').controller('taskModalController', ['$scope', '$location', '$http', 'globalService', '$rootScope', 'restClient',
    function ($scope, $location, $http, global, $rootScope, restClient) {
        $scope.taskText = '';
        $scope.dueDate ='';
        $scope.$on('showTaskModal', function(data,events){
            $scope.employeeID = events.employeeID;
            $('#taskModal').modal('toggle');
        });
        $scope.assignTask = function(){
            console.log('sending task to: ' + $scope.employeeID);
            restClient.assignTask($scope.employeeID, $scope.taskText, $scope.dueDate)
            .then(function(){
                console.log('success sending task');
            }).catch(function(err){
                console.log(err);
            })
        }
    }
]);