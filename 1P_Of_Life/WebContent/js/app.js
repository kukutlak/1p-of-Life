var app = angular.module('1PHomeApp',['ngRoute']);
app.config(['$routeProvider', function($routeProvider){
    
    $routeProvider
        .when('\left',{templateUrl:'leftPanel.html'})
        .when('\right', {templateUrl:'rightPanel.html'})
        .otherwise ({redirectTo:'/'});
    
}]);

app.controller('1PHomeController',function($scope,$timeout){
    
    $scope.x = 'Stu1';
    $scope.y= 'Stu2';
    $scope.Pname="fromController";
    
})



