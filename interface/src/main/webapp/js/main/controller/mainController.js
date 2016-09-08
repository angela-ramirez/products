// create the controller and inject Angular's $scope
mainApp.controller('mainController', ['$http', '$scope',
    '$window', '$mdDialog', '$mdToast', '$location', function ($http, $scope,
            $window, $mdDialog, $mdToast, $location) {

        $scope.successTextAlert = "";
        $scope.fields = [];
        $scope.visibleFields = [];
        $scope.appReady = true;
        $scope.userLogin = "";

        $scope.switchBool = function (id) {
            var e = angular.element('#' + id);
            e.hide();
            //$scope[value] = !$scope[value];
        };
        $scope.showToast = function (msg) {
            // var pinTo = $scope.getToastPosition();
            $mdToast.show(
                    $mdToast.simple()
                    .textContent(msg)
                    .position("right")
                    .hideDelay(3000)
                    );
        };

        $scope.closeToast = function () {
            $mdToast.hide();
        };

        $scope.showMessage = function (msg, title) {
            var titleDefault = 'Confirmaci\u00f3n';
            if (title != "") {
                titleDefault = title;
            }


            $mdDialog.show(
                    $mdDialog.alert()
                    .parent(angular.element(document.querySelector('#user-container')))
                    .clickOutsideToClose(true)
                    .title(titleDefault)
                    .textContent(msg)
                    .ariaLabel('Alert Dialog Demo')
                    .ok('Aceptar')
                    //.targetEvent(ev)
                    );
        };

        $scope.goCalendar = function () {
            $window.sessionStorage.setItem("coachAssignedPlanSelected", null);
            $location.path("/calendar");
        };

        $scope.inFieldsArray = function (field, array) {
            var length = array.length;
            for (var i = 0; i < length; i++) {
                if (array[i].tableName == field.tableName && array[i].columnName == field.columnName)
                    return true;
            }
            return false;
        };

        $scope.calculateAge = function (birthday) { // birthday is a date
            if (birthday != null) {
                var ageDifMs = Date.now() - birthday.getTime();
                var ageDate = new Date(ageDifMs); // miliseconds from epoch
                return Math.abs(ageDate.getUTCFullYear() - 1970);
            }
        };
    }]);

mainApp.directive('stringToNumber', function () {
    return {
        require: 'ngModel',
        link: function (scope, element, attrs, ngModel) {
            ngModel.$parsers.push(function (value) {
                return '' + value;
            });
            ngModel.$formatters.push(function (value) {
                return parseFloat(value);
            });
        }
    };
});

mainApp.directive('schrollBottom', function () {
    return {
        scope: {
            schrollBottom: "="
        },
        link: function (scope, element) {
            scope.$watchCollection('schrollBottom', function (newValue) {
                if (newValue)
                {
                    $(element).scrollTop($(element)[0].scrollHeight);
                }
            });
        }
    };
});

function getDate() {
    var d = new Date();
    var ano = d.getFullYear();
    var mes = (d.getMonth() + 1);
    var dia = d.getDate();

    if (mes < 10) {
        mes = '0' + mes;
    }

    if (dia < 10) {
        dia = '0' + dia;
    }

    var fechaRecibo = ano + '-' + mes + '-' + dia;
    return fechaRecibo;
}

/**
 * Elimina espacios
 * @param {type} cadena
 * @returns {String}
 */
function trim(cadena) {
    return cadena.replace(/^\s+|\s+$/gm, '');
}