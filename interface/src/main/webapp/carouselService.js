var $contextPath = "http://localhost:8080/interface/api/";

var app = angular.module('myApp', ['ngMaterial', 'jkAngularCarousel']);

app.service('CarouselService', ['$http', '$q', function ($http, $q) {
        return {
            getSections: function () {

                return $http.get($contextPath + 'sections/1/1')
                        .then(
                                function (response) {
                                    return response.data.output;
                                },
                                function (errResponse) {
                                    console.error('Error while getting dashboard');
                                    return $q.reject(errResponse);
                                }
                        );
            }
        };
    }]);