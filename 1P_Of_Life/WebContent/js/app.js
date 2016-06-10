var myApp = angular.module('1PHomeApp',['ngRoute']);
myApp.config(['$routeProvider', function($routeProvider){
    
    $routeProvider
        .when('\ChildInfo',{templateUrl:'ChildMaster.html'})
        .when('\left',{templateUrl:'leftPanel.html'})
        .when('\right', {templateUrl:'rightPanel.html'})
        
        .otherwise ({redirectTo:'/'});
    
}]);

myApp.controller('1PHomeController',function($scope,$timeout){
    
    $scope.x = 'Stu1';
    $scope.y= 'Stu2';
    $scope.Pname="fromController";
    
})



