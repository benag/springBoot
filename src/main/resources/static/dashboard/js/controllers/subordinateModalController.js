
angular.module('dbmotion').controller('subordinateModalController', ['$scope', '$location', '$http', 'globalService', '$rootScope', 'restClient',
    function ($scope, $location, $http, globalService, $rootScope, restClient) {

        $scope.user = {};
        $scope.user.firstName = '';
        $scope.user.lastName = '';
        $scope.selectedWorker = '';
        $scope.showManager = false;
        $scope.showEmployee = false;
        $scope.managers = [];
        $scope.employees = [];



        $scope.$on('showSubordinateModal', function(data,events){
           $scope.showManager = false;
           $scope.showEmployee = false;
           $scope.managers = [];
           $scope.employees = [];
           $scope.employee = globalService.employee;
           $('#subordinateModal').modal('toggle');
        });

        $scope.ShowDropDown = function(){
            if($scope.selectedWorker === 'Manager'){
                $scope.getManagers();
            }else{
                $scope.getEmployees();
            }
        }

        $scope.chooseSubWorker = function(worker){
            $scope.selectedWorker = worker;
            $scope.ShowDropDown();
        }

        $scope.getManagers = function(){
            console.log('getting managers');
            restClient.getEmployees()
            .then(function(data){
                var allEmployees = data;
                for (var i =0 ;i < allEmployees.length; i++){
                    if (allEmployees[i].position === 'manager'){
                        $scope.managers.push(allEmployees[i]);
                    }
                }
                $scope.showManager = true;
            }).catch(function(err){
                console.log(err);
            })
        }

        $scope.getEmployees = function(){
            console.log('adding employee: ' );
            restClient.getEmployees()
            .then(function(data){
                var allEmployees = data;
                for (var i =0 ;i < allEmployees.length; i++){
                    if (allEmployees[i].position === 'employee'){
                        $scope.employees.push(allEmployees[i]);
                    }
                }
                $scope.showEmployee = true;
            }).catch(function(err){
                console.log(err);
            })
        }

        $scope.chooseManager = function(index) {
            console.log('adding subordinate manager: ' );
            restClient.addSubordinateManager($scope.employee.id, $scope.managers[index].id)
            .then(function(){
                $scope.employees = data.data;
                $scope.showEmployee = true;
            }).catch(function(err){
                console.log(err);
            })
        }

         $scope.chooseEmployee = function(index) {
            console.log('adding subordinate employee: ' );
            restClient.addSubordinateEmployee($scope.employee.id, $scope.employees[index].id )
            .then(function(){
                $scope.employees = data.data;
                $scope.showEmployee = true;
            }).catch(function(err){
                console.log(err);
            })
        }

    }
]);