define([ 'angular', 'common' ], function(angular) {
    'use strict';

    var mod = angular.module('report.services', [ 'common' ]);
    mod.factory('reportService', [ '$http', '$q', 'playRoutes', function($http, $q, playRoutes) {
        return {
            yourMethodHere : function() {
                return playRoutes; // this is only to prevent error messages of "not used"
            }
        };
    }]);
});
