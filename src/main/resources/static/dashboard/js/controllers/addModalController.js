
angular.module('dbmotion').controller('addModalController', ['$scope', '$location', '$http', 'globalService', '$rootScope', 'restClient',
    function ($scope, $location, $http, global, $rootScope, restClient) {


        $scope.user = {};
        $scope.user.firstName = '';
        $scope.user.lastName = '';
        $scope.selectedWorker = '';
        $scope.workerType = 'Select Worker Type';


        $scope.$on('showAddModal', function(data,events){
           $('#addModal').modal('toggle');
        });

        $scope.addWorker = function(){
            if($scope.selectedWorker === 'Manager'){
                $scope.addManager();
            }else{
                $scope.addEmployee();
            }
        }
        $scope.chooseWorker = function(worker){
            $scope.workerType = worker;
            $scope.selectedWorker = worker;
        }
        $scope.addManager = function(){
            console.log('adding manager: ' + $scope.bossID);
            restClient.addManager($scope.user.firstName , $scope.user.lastName)
            .then(function(){
                console.log('success sending report');
            }).catch(function(err){
                console.log(err);
            })
        }
        $scope.addEmployee = function(){
            console.log('adding employee: ' );
            restClient.addEmployee($scope.user.firstName , $scope.user.lastName)
            .then(function(){
                console.log('success sending report');
            }).catch(function(err){
                console.log(err);
            })
        }
    }
]);