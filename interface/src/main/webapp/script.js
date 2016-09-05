// Code goes here
var $contextPath = "http://localhost:8080/interface/api/";
var app = angular.module('myApp', ['ngMaterial', 'cl.paging']);
app.controller('MyCtrl', ['$http', '$scope',
    function ($http, $scope) {
        $scope.sections = [];
        $scope.initCarousel = [{}];
        $scope.currentPage = 0;

        $scope.paging = [{
                total: 1,
                current: 1,
                align: 'center start'
            }];

        $scope.initCarousel = function () {

            for (var i = 0; i < $scope.sections.length; i++) {
                var section = $scope.sections[i];
                $scope.initCarousel[section.id] = 0;
                $('#section' + section.id)
                        .jcarousel({});

                /*
                 Pagination initialization
                 */
                var totalPage = section.countProducts / 3;
                $scope.paging[section.id] = {
                    total: totalPage,
                    current: 1,
                    align: 'center start'
                };
            }
        }

        $scope.page = function (section) {
            
            var initCarouselIndex = $scope.initCarousel[section.id];
            var page = $scope.paging[section.id].current;
            if (initCarouselIndex > 0 && page != initCarouselIndex) {
                $scope.initCarousel[section.id] = page;
                var index = (page - 1) * 3;
                var max = index + 3;
                $http.get($contextPath + 'Products/sections/1/1/' + index + '/' + max + '/' + section.id)
                        .then(
                                function (response) {
                                    var data = response.data;
                                    
                                    for (var j = 0; j < $scope.sections.length; j++) {
                                        if($scope.sections[j].id == section.id) {
                                            $scope.sections[j] = data;
                                            console.debug(data)
                                            var sec = $scope.sections[j];
                                            var content = '<ul>';

                                            for (var i = 0; i < sec.productList.length; i++) {
                                                if (sec.productList[i] != undefined) {
                                                    content += '\<li>\n\
<img src="data:image/png;base64,' + sec.productList[i].images[0].content + '"  style="width:600px !important;height:400px !important" alt="">\n\
' + sec.productList[i].images[0].name + '</li>';
                                                }
                                            }
                                            $('#section' + sec.id).html(content);
                                            return;
                                        }
                                    }
                                    
                                    
//                                    for (var j = 0; j < $scope.sections.length; j++) {
//                                        var sec = $scope.sections[j];
//                                        if (sec.id == section.id) {
//                                            var content = '<ul>';
//
//                                            for (var i = 0; i < sec.productList.length; i++) {
//                                                if (sec.productList[i] != undefined) {
//                                                    content += '\<li>\n\
//<img src="data:image/png;base64,' + sec.productList[i].images[0].content + '"  style="width:600px !important;height:400px !important" alt="">\n\
//' + sec.productList[i].images[0].name + '</li>';
//                                                }
//                                            }
//                                            $('#section' + sec.id).html(content);
//                                            console.debug($('#section' + sec.id))
//                                        }
//
//                                    }


                                },
                                function (errResponse) {
                                    console.error('Error while getting dashboard');
                                }
                        );
            }
            $scope.initCarousel[section.id] = page;
        }

        $scope.getSections = function () {

            $http.get($contextPath + 'Products/sections/1/1/0/3')
                    .then(
                            function (response) {
                                var data = response.data;
                                $scope.sections = data;
                                $scope.initCarousel();
                            },
                            function (errResponse) {
                                console.error('Error while getting dashboard');
                            }
                    );
        };

        $scope.getSections();

    }]);


//        $scope.next = function (section) {
//            var index = parseInt($('#index' + section.id).val());
//            index += 1;
//            $('#index' + section.id).val(index);
//
//            var content = '<ul>';
//            for (var i = index; i < (index + 3); i++) {
//                if (section.productList[i] != undefined) {
//                    content += '\<li>\n\
//<img src="data:image/png;base64,' + section.productList[i].images[0].content + '"  style="width:600px !important;height:400px !important" alt="">\n\
//' + section.productList[i].images[0].name + '</li>';
//                }
//            }
//
//            content += '</ul>';
//            $('#section' + section.id).html(content);
//        }
//
//        $scope.prev = function (section) {
//            var index = parseInt($('#index' + section.id).val());
//            index -= 1;
//            $('#index' + section.id).val(index);
//
//            var content = '<ul>';
//            for (var i = index; i < (index + 3); i++) {
//                if (section.productList[i] != undefined) {
//                    content += '\<li>\n\
//<img src="data:image/png;base64,' + section.productList[i].images[0].content + '"  style="width:600px !important;height:400px !important" alt="">\n\
//' + section.productList[i].images[0].name + '</li>';
//                }
//            }
//
//            content += '</ul>';
//            $('#section' + section.id).html(content);
//        }
