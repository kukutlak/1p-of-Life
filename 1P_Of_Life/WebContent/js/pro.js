var myApp = angular.module('1PHomeApp', ['ngRoute']);

//  Force AngularJS to call our JSON Web Service with a 'GET' rather than an 'OPTION' 
//  Taken from: http://better-inter.net/enabling-cors-in-angular-js/
myApp.config(['$httpProvider', function ($httpProvider) {
    $httpProvider.defaults.useXDomain = true;
    delete $httpProvider.defaults.headers.common['X-Requested-With'];
}]);


myApp.controller('proCtrl', function($scope, $http){
    
    $scope.proList = null;
    $scope.selectedPro = null;
   
    $http.get('http://localhost:8080/1P_Of_Life/rest/problem/2')
        .success(function(data){
            $scope.proList = data.proList;
            $scope.selectedPro = $scope.proList[0].iD;
            
        })
        .error(function(data, statu, headers,config){
            alert("$http not received any data");
    
        });
});