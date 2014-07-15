/**
 * Configure routes of reports module.
 */
define(['angular', './controllers', 'ui-bootstrap', 'ng-table'], function(angular) {
  'use strict';

  var mod = angular.module('report.routes', ['report.services', 'common', 'report.controllers', 'ui.bootstrap', 'ngTable']);

  mod.config(['$routeProvider', function($routeProvider) {
    $routeProvider.when('/', {
        templateUrl: '/assets/javascripts/report/report.html',
        controller: 'ReportCtrl'
    });
  }]);
});
