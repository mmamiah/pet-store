
var petStoreModule = angular.module('petStore', []);

petStoreModule.config(['$httpProvider', function($httpProvider) {
    //Enable cross domain calls
    $httpProvider.defaults.useXDomain = true;

    //Remove the header used to identify ajax call  that would prevent CORS from working
    delete $httpProvider.defaults.headers.common['X-Requested-With'];
}]);

// Services
petStoreModule.service('PetStoreService', ['$http', '$rootScope', '$q', PetStoreService]);

// Controllers
petStoreModule.controller('userCtrl', ['$scope', 'PetStoreService', function($scope, petStoreService){
  petStoreService.loadPets()
  .then(function(promiseData){
    $scope.pets = promiseData;
  });
  $scope.firstName = "Marc";
  $scope.lastName = "Mamiah";
}]);

petStoreModule.controller('petCtrl', ['$scope', 'PetStoreService', function($scope, petStoreService){
  $scope.$on(StoreKeys.petsLoadedKey, function(event, args){
    $scope.petSum = args.length;
  });
}]);

petStoreModule.controller('petInfoDetailsCtrl', ['$scope', '$http', 'PetStoreService', function($scope, $http, petStoreService){
  $scope.$on(StoreKeys.petsLoadedKey, function(event, args){
    $scope.pets = args;
  });

  $scope.hiddenRows = [];

  $scope.shouldHide = function(index){
    return $scope.hiddenRows.indexOf(index) > -1;
  }

  $scope.deletePet = function(id, index){
   $http.delete('http://127.0.0.1:8080/pet/' + id)
    .success(function (data, status, headers) {
      $scope.hiddenRows.push(index);
      alert("Pet #" + id + ",  has been deleted");
    })
    .error(function (data, status, header, config) {
      alert("Cannot delete Pet #" + id);
    });
 };
}]);

petStoreModule.controller('storeInfoCtrl', ['$scope', '$http', 'PetStoreService', function($scope, $http, petStoreService){
  petStoreService.loadPetUsages()
    .then(function(promiseData){
      $scope.petUsages = promiseData;
    });
  petStoreService.loadPetGroups()
    .then(function(promiseData){
      $scope.petGroups = promiseData;
    });
  petStoreService.loadPetTypes()
    .then(function(promiseData){
      $scope.petTypes = promiseData;
    });

  $scope.$on(StoreKeys.petsLoadedKey, function(event, args){
    $scope.pets = args;
  });

  // from: application/x-www-form-urlencoded
  $scope.formData = {};
  $scope.processForm = function(){
    var serializedData =  JSON.stringify($scope.formData) ;

    $http({
      method: 'POST',
      url: 'http://127.0.0.1:8080/pet/',
      data: serializedData,
      headers: {'Content-Type': 'application/json'}
    }).then(function(result) {
          alert("Pet Saved");
          $scope.formData = [];
       }, function(data, status) {
           alert( "failure message: " + JSON.stringify({data: data}) + ", Status: " + status);
     });
  }
}]);
