'use strict';

/* App Module */

var app = angular.module('myapp', ['ui.bootstrap', 'ngRoute']);

app.config(['$routeProvider', function($routeProvider) {
	  $routeProvider.
	      when('/page1', {templateUrl: 'partials/page1.html',   controller: "Page1Controller"}).
	      when('/page2', {templateUrl: 'partials/page2.html',   controller: "Page2Controller"}).
	      otherwise({redirectTo: '/page1'});
	}]);

