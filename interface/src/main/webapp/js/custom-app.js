'use strict';

var mainApp = angular.module('mainApp', ['routeResolverServices', 'ngRoute',
    'ngMessages', 'ngMaterial', 'pascalprecht.translate', 'ngSanitize', 'cl.paging'])
        .config(function ($routeProvider, routeResolverProvider, $controllerProvider, $provide,
                $translateProvider) {

            var route = routeResolverProvider.route;

            mainApp.register = {
                controller: $controllerProvider.register,
                service: $provide.service
            };

            mainApp.controller = function (name, constructor) {
                $controllerProvider.register(name, constructor);
            };


            $routeProvider
                    .when('/product', route.resolve('product', 'product/'))

            $translateProvider.useStaticFilesLoader({
                prefix: 'languages/',
                suffix: '.json'
            });

            $translateProvider.preferredLanguage('es');



        });

/**
 * 
 * @param {type} element
 * @returns 
 */
function compileAngularElement(element) {
    var $div = $(element);
    // The parent of the new element
    var $target = $("[ng-view]");
    angular.element($target).injector().invoke(['$compile', function ($compile) {
            var $scope = angular.element($div).scope();
            $compile($div)($scope);
            // Finally, refresh the watch expressions in the new element
            $scope.$apply();
        }]);
}
