
angular.module('dbmotion').controller('reportModalController', ['$scope', '$location', '$http', 'globalService', '$rootScope', 'restClient',
    function ($scope, $location, $http, global, $rootScope, restClient) {
        $scope.reportText = '';

        $scope.$on('showReportModal', function(data,events){
            $scope.bossID = events.bossId;
            $('#reportModal').modal('toggle');
        });
        $scope.sendReport = function(){
             console.log('sending report to: ' + $scope.bossID);
            restClient.sendReport($scope.bossID, $scope.reportText)
            .then(function(){
                console.log('success sending report');
            }).catch(function(err){
                console.log(err);
            })
        }
    }
]);