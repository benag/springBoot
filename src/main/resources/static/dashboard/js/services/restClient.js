
dbmotion.factory('restClient',function($rootScope, $http, $q) {

        var getEmployees = function(page,limit) {
            return $q(function(resolve, reject) {
                $http.get('/api/employees/')
                .then(function(data){
                    console.log(data.data);
                    resolve(data.data);
                }, function(err){
                    reject(data.data);
                });
            });
        }
        var assignTask = function(employeeIndex, taskText, dueDate) {
            return $q(function(resolve, reject) {
                $http.put('/api/employees/task',{employeeId:employeeIndex, taskText:taskText, dueDate: dueDate })
                .then(function(data){
                    console.log(data.data);
                    resolve(data.data);
                }, function(err){
                    reject(data.data);
                });
            });

        }
        var sendReport = function(employeeIndex, reportText) {
            return $q(function(resolve, reject) {
                $http.put('/api/employees/report',{employeeId:employeeIndex, reportText:reportText })
                .then(function(data){
                    console.log(data.data);
                    resolve(data.data);
                }, function(err){
                    reject(data.data);
                });
            });

        }
        return {
            getEmployees:  getEmployees,
            assignTask: assignTask,
            sendReport: sendReport
        }



});