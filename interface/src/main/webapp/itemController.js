
app.controller('ItemController', ['$http', '$scope', 'ProductService', function ($http, $scope, ProductService) {
        $scope.product = {productId: '',
            productAttributes: [],
            images: []};
        $scope.comments = '';
        $scope.firstImage = '';
        $scope.share = 'resources/images/share-icon.png';
        $scope.fav = 'resources/images/fav-icon.png';

        $scope.getProductDetail = function (id) {
            ProductService.getProductDetail(id)
                    .then(
                            function (response) {
                                console.debug(response);
                                $scope.product = response;
                                if ($scope.product.images.length > 0) {
                                    $scope.firstImage = "data:image/png;base64," + $scope.product.images[0].content;
                                    for (var i = 0; i < $scope.product.images.length; i++) {
                                        $scope.product.images[i].content = "data:image/png;base64," + $scope.product.images[i].content;
                                    }
                                }
                            },
                            function (errResponse) {
                                console.error('Error while fetching');
                                console.error(errResponse);
                            }
                    );
        };

        $scope.setFirstImage = function (content) {

            $scope.firstImage = content;

        };

        $scope.getProductDetail(2);
    }]);