///////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// Defines the javascript files that need to be loaded and their dependencies.
//
///////////////////////////////////////////////////////////////////////////////////////////////////////////
var $contextPath = "http://localhost:8080/interface/api/";
require.config({
    waitSeconds: 200,
    paths: {
        jquery: 'lib/jquery',
        jqueryCarousel: 'lib/jquery.jcarousel',
        angular: 'lib/angular.min',
        angularRoute: 'lib/angular-route.min',
        angularMessages: 'lib/angular-messages.min',
        angularAnimate: 'lib/angular-animate.min',
        angularTouch: 'lib/angular-touch.min',
        angularAria: 'lib/angular-aria.min',
        angularMaterial: 'lib/angular-material',
        angularTranslate: 'lib/angular-translate.min',
        angularTranslateConfig: 'lib/angular-translate-loader-static-files.min',
        paging: 'lib/paging',
        mainApp: "custom-app",
        mainController: "main/controller/mainController",
        app: "routeResolver",
        angularSanitize: 'lib/angular-sanitize',
        productService: "product/service/productService"
    },
    shim: {
        jquery: {
        },
        jqueryCarousel: {
            deps: ['jquery']
        },
        angular: {
            exports: "angular"
        },
        angularRoute: {
            exports: 'ngRoute',
            deps: ['angular']
        },
        angularAnimate: {
            exports: 'ngAnimate',
            deps: ['angular']
        },
        angularTouch: {
            exports: 'angularTouch',
            deps: ['angular']
        },
        angularMessages: {
            exports: 'ngMessages',
            deps: ['angular']
        },
        angularAria: {
            exports: 'ngAria',
            deps: ['angular']
        },
        angularMaterial: {
            exports: 'ngMaterial',
            deps: ['angular']
        },
        angularTranslate: {
            deps: ['angular']
        },
        paging: {
            deps: ['angular']
        },
        mainController: {
            deps: ['angular', 'mainApp']
        },
        angularTranslateConfig: {
            deps: ['angular', 'angularTranslate']
        },
        angularSanitize: {
            deps: ['angular']
        },
        productService: {
            deps: ['mainApp']
        },
        mainApp: {
            deps: ['jquery', 'jqueryCarousel', 'angular', 'angularMessages', 'angularRoute', 'angularAnimate',
                'angularAria','angularMaterial',
                'angularTranslate', 'angularSanitize', 'paging'
            ]
        },
        app: {
            deps: ['mainApp', 'mainController', 'angularTranslateConfig', 'productService'
            ] }
    }
});

require(['app'], function () {

    angular.bootstrap(document.getElementById('mainApp'), ['mainApp']);

});