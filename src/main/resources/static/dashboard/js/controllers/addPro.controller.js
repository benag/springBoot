dbmotion.controller('addProController', function($scope, $http, $state, uploadService, globalService) {
    $scope.pro = {};
    $scope.pro.companyInfo = {};
    $scope.pro.companyInfo.geo ={};
    $scope.pro.contactInfo = {};
    $scope.pro.credit = {};
    $scope.file ='img/cat.jpg';
    $scope.contactfile ='img/cat.jpg';
    $scope.contractfile ='img/cat.jpg';
    $scope.roles = globalService.services;
    $scope.pro.serviceCondition = '';
    $scope.pro.paymentCondition = '';
    $scope.serviceConditions = globalService.settings.serviceConditions;
    $scope.paymentConditions = globalService.settings.paymentConditions;
    $scope.statuses = globalService.settings.statuses;
    $scope.addressObj = {};



    $scope.loadFiles = function(files) {
        $scope.file = files[0];
    };
    $scope.loadContactFiles = function(files) {
        $scope.contactfile = files[0];
    };
    $scope.loadContractFiles = function(files) {
        $scope.contractfile = files[0];
    };


    $scope.uploadFiles = function(data){

        uploadService.uploadFiles({proId: data.data.payload._id,uploadedFile: $scope.file,contractFile:$scope.contractfile})
        .then(function(){
            alert('Pro was added');
        })
        .catch(function(err){
            alert(err);
        });


        //
        //if ($scope.file || $scope.contractfile) {
        //    $scope.file.upload = Upload.upload({
        //        url: '/fileupload',
        //        data: {proId: data.data.payload._id,uploadedFile: $scope.file,contractfile:$scope.contractfile}
        //    });
        //    $scope.file.upload.then(function (response) {
        //        if (response.data.status === 'Ok'){
        //            alert("Professional has been added");
        //        }else{
        //            alert("There was error uploading img");
        //        }
        //    }, function (response) {
        //        if (response.status > 0)
        //            $scope.errorMsg = response.status + ': ' + response.data;
        //    }, function (evt) {
        //        $scope.file.progress = Math.min(100, parseInt(100.0 *
        //            evt.loaded / evt.total));
        //    });
        //}
    };
    $scope.addpro = function() {
        var proAddress  = $scope.addressObj;
        $scope.pro.companyInfo.geo.address = proAddress.formatted_address;
        //var proAddress  = $scope.pro.companyInfo.geo.address;
        $scope.pro.companyInfo.geo.lt = proAddress.geometry.location.lat();
        $scope.pro.companyInfo.geo.ln = proAddress.geometry.location.lng();
        $http.post('/professional/',{user:$scope.pro})
        .then(function(data){
            if (data.data.status === 'Ok'){
                //alert("Professional has been added");
                if ($scope.file || $scope.contractfile) {
                    $scope.uploadFiles(data);
                }else{
                    alert('Pro was added');
                }

            }else{
                alert("There was error saving professional");
            }
        }, function(err){
        });
    };
    $scope.back = function() {
        $state.go('professionals');
    }

});