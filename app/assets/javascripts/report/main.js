/**
 * Manages all sub-modules so other RequireJS modules only have to import the package.
 */
define(['angular', './routes', './services', './controllers'], function(angular) {
  'use strict';

  return angular.module('report', ['ngRoute', 'report.routes', 'report.services', 'report.controllers']);
});
