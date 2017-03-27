
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
        var sendReport = function(employeeId, reportText) {
            return $q(function(resolve, reject) {
                $http.put('/api/employees/report',{employeeId:employeeId, reportText:reportText })
                .then(function(data){
                    console.log(data.data);
                    resolve(data.data);
                }, function(err){
                    reject(data.data);
                });
            });

        }
        var getBoss = function(employeeId) {
            return $q(function(resolve, reject) {
                $http.get('/api/employees/' + employeeId + '/manager')
                .then(function(data){
                    console.log(data.data);
                    resolve(data.data);
                }, function(err){
                    reject(data.data);
                });
            });

        }
        var addManager = function(firstName, lastName) {
            return $q(function(resolve, reject) {
                $http.post('/api/employees/createManager',{firstName:firstName, lastName:lastName, position: 'manager'})
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
            sendReport: sendReport,
            getBoss: getBoss,
            addManager: addManager
        }

});