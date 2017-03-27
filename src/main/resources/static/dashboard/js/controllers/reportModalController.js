
angular.module('dbmotion').controller('reportModalController', ['$scope', '$location', '$http', 'globalService', '$rootScope',
    function ($scope, $location, $http, global, $rootScope) {
        $scope.taskText = '';
        $scope.dueDate ='';
        $scope.$on('showTaskModal', function(data,events){
            var id = events.id;
            $('#myModal').modal('toggle');
        });

    }
]);