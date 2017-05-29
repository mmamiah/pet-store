
var petStoreModule = angular.module('petStore', []);
petStoreModule.controller('userCtrl', function($scope){
  $scope.firstName = "Marc";
  $scope.lastName = "Mamiah";
});

petStoreModule.controller('petCtrl', function($scope){

  $scope.petSum = 20;

});
