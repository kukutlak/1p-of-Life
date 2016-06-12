var myApp = angular.module('1PHomeApp',['ngRoute','ngMaterial', 'ngMessages', 'material.svgAssetsCache']);
myApp.config(['$routeProvider', function($routeProvider){
    
//    $routeProvider
//        .when('/childInfo',{templateUrl:'ChildMaster.html', controller='MasterDetailCtrl'})
//        .when('/left',{templateUrl:'leftPanel.html'})
//        .when('/right', {templateUrl:'rightPanel.html'})
//        
//        .otherwise ({redirectTo:'/'});
    
}]);

myApp.controller('1PHomeController',function($scope,$timeout){
    
    $scope.x = 'Stu1';
    $scope.y= 'Stu2';
    $scope.Pname="fromController";
    
})

angular
  .module('1PHomeApp')
  .config(function($mdIconProvider) {
    $mdIconProvider
      .defaultIconSet('img/icons/sets/core-icons.svg', 24);
  })
  .filter('keyboardShortcut', function($window) {
    return function(str) {
      if (!str) return;
      var keys = str.split('-');
      var isOSX = /Mac OS X/.test($window.navigator.userAgent);

      var seperator = (!isOSX || keys.length > 2) ? '+' : '';

      var abbreviations = {
        M: isOSX ? '' : 'Ctrl',
        A: isOSX ? 'Option' : 'Alt',
        S: 'Shift'
      };

      return keys.map(function(key, index) {
        var last = index == keys.length - 1;
        return last ? key : abbreviations[key];
      }).join(seperator);
    };
  })
  .controller('DemoBasicCtrl', function DemoCtrl($mdDialog) {
    this.settings = {
      printLayout: true,
      showRuler: true,
      showSpellingSuggestions: true,
      presentationMode: 'edit'
    };

    this.sampleAction = function(name, ev) {
      $mdDialog.show($mdDialog.alert()
        .title(name)
        .textContent('You triggered the "' + name + '" action')
        .ok('Great')
        .targetEvent(ev)
      );
    };
  });

