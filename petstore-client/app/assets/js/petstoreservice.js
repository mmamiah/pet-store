
function PetStoreService($http, $rootScope, $q){
    // To fix the serialization issue
    $http.defaults.headers.post["Content-Type"] = "application/x-www-form-urlencoded";
    var psService = initService($http, $rootScope, $q);
   return psService;
}

function initService($http, $rootScope, $q){
   return {
     loadPets: function(){
        var deferred = $q.defer();
        var broadcast = this.broadCastPetsLoaded;
        $http.get("http://127.0.0.1:8080/pet")
        .success(function(response, status){
          deferred.resolve(response);
          broadcast(response);
        });
        return deferred.promise;
     },
     loadPetUsages: function(){
         var deferred = $q.defer();
         $http.get("http://127.0.0.1:8080/pet/petusages")
         .success(function(response, status){
           deferred.resolve(response);
         });
         return deferred.promise;
     },
     loadPetGroups: function(){
         var deferred = $q.defer();
         $http.get("http://127.0.0.1:8080/pet/petgroups")
         .success(function(response, status){
           deferred.resolve(response);
         });
         return deferred.promise;
     },
     loadPetTypes: function(){
         var deferred = $q.defer();
         $http.get("http://127.0.0.1:8080/pet/pettypes")
         .success(function(response, status){
           deferred.resolve(response);
         });
         return deferred.promise;
     },
     broadCastPetsLoaded: function(pets){
       $rootScope.$broadcast(StoreKeys.petsLoadedKey, pets);
     }
   }
}
