
dbmotion.factory('globalService',function($rootScope, $http, $q) {
    return {
        login: null,
        user: {},
        getSettings: function(){
            let _this = this;
            return $q(function(resolve, reject) {
                $http.get('/settings')
                .then(function(data){
                    _this.settings = data.data.payload;
                    resolve();
                }).catch(function(err){
                    reject();
                })
            });

        },
        getRoles: function() {
            let _this = this;
            return $q(function(resolve, reject) {
                $http.get('/services')
                .then(function(data){
                    _this.services = data.data.payload;
                    resolve();
                }).catch(function(err){
                    reject();
                })
            });
        }
    }
});