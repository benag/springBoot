dbmotion.factory('uploadService',function($rootScope, $http, $q, Upload) {
    return {
        uploadFiles: function(data){
            return $q(function(resolve, reject) {
                var uploadProgress = Upload.upload({
                    url: '/fileupload',
                    data: data
                });
                uploadProgress.then(function (response) {
                    if (response.data.status === 'Ok'){
                        resolve();
                    }else{
                        reject();
                    }
                }, function (response) {
                    if (response.status > 0) {
                        //$scope.errorMsg = response.status + ': ' + response.data;
                    }
                }, function (evt) {
                    //$scope.file.progress = Math.min(100, parseInt(100.0 *
                    //    evt.loaded / evt.total));
                });
            });
        }
    }

});
