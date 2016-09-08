mainApp.service('ProductService', ['$http', '$q', function ($http, $q) {
        return {
            getProductDetail: function (id) {

                return $http.get($contextPath + 'Products/product/get/by/id/'+id+'/1/1')
                        .then(
                                function (response) {
                                    return response.data;
                                },
                                function (errResponse) {
                                    console.error('Error while getting the product detail');
                                    return $q.reject(errResponse);
                                }
                        );
            }
        };
    }]);