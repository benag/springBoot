
angular.module('dbmotion').controller('subordinateModalController', ['$scope', '$location', '$http', 'globalService', '$rootScope', 'restClient',
    function ($scope, $location, $http, globalService, $rootScope, restClient) {


        $scope.selectedEmployee = '';
        $scope.SelectedManager = '';
        $scope.selectedWorker = '';
        $scope.showManager = false;
        $scope.showEmployee = false;
        $scope.managers = [];
        $scope.employees = [];
        $scope.SelectSubordinateType = 'Select Subordinate Type';
        $scope.managerDropDown = 'Manager';
        $scope.employeeDropDown = 'Employee';



        $scope.$on('showSubordinateModal', function(data,events){
           $scope.showManager = false;
           $scope.showEmployee = false;
           $scope.SelectSubordinateType = 'Select Subordinate Type';
           $scope.managerDropDown = 'Manager';
           $scope.employeeDropDown = 'Employee';
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
            $scope.SelectSubordinateType = worker;
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
        $scope.chooseEmployee = function(index){
            $scope.selectedEmployee = $scope.employees[index].id;
            $scope.employeeDropDown = $scope.employees[index].firstName;

        }

        $scope.chooseManager = function(index){
            $scope.selectedManager = $scope.managers[index].id;
            $scope.managerDropDown = $scope.managers[index].firstName;
        }
        $scope.addSubWorker = function(){
            if ($scope.SelectSubordinateType === 'Manager'){
                $scope.addSubManager($scope.selectedManager);
            }else{
                $scope.addSubEmployee($scope.selectedEmployee);
            }
        }
        $scope.addSubManager = function(id) {
            console.log('adding subordinate manager: ' );
            restClient.addSubordinateManager($scope.employee.id, id)
            .then(function(){
                $scope.employees = data.data;
                $scope.showEmployee = true;
            }).catch(function(err){
                console.log(err);
            })
        }

         $scope.addSubEmployee = function(id) {
            console.log('adding subordinate employee: ' );
            restClient.addSubordinateEmployee($scope.employee.id, id )
            .then(function(){
                $scope.employees = data.data;
                $scope.showEmployee = true;
            }).catch(function(err){
                console.log(err);
            })
        }

    }
]);