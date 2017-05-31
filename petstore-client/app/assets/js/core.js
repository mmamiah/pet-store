
var petStoreModule = angular.module('petStore', []);

petStoreModule.config(['$httpProvider', function($httpProvider) {
    //Enable cross domain calls
    $httpProvider.defaults.useXDomain = true;

    //Remove the header used to identify ajax call  that would prevent CORS from working
    delete $httpProvider.defaults.headers.common['X-Requested-With'];

    // $httpProvider.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded; charset=UTF-8';
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
    var dataObj = {
				name : $scope.formData.name,
				usage : $scope.formData.usage,
				petGroup : $scope.formData.petGroup,
				petType : $scope.formData.petType,
				color : $scope.formData.color,
				description : $scope.formData.description
		};
    var data =  'name=' + $scope.formData.name + '&usage=' + $scope.formData.usage + '&petGroup=' + $scope.formData.petGroup
            + '&petType=' + $scope.formData.petType + '&color=' + $scope.formData.color + '&description=' + $scope.formData.description;
    $http.post('http://127.0.0.1:8080/pet',  dataObj)
    .success(function(data) {
        if (!data.success) {
          // if not successful, bind errors to error variables
          $scope.errorName = data.errors.name;
          $scope.errorSuperhero = data.errors.superheroAlias;
          alert("Pet Not Saved");
        } else {
          // if successful, bind success message to message
          alert("Pet Saved");
          $scope.message = data.message;
        }
      })
      .error(function(data, status, headers, config) {
			     alert( "failure message: " + JSON.stringify({data: data}) + ", Status: " + status);
       });
  }
}]);
