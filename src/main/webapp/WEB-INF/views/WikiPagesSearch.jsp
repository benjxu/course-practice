<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="http://getbootstrap.com/examples/jumbotron-narrow/jumbotron-narrow.css">
    <script src="http://cdn.static.runoob.com/libs/angular.js/1.4.6/angular.min.js"></script>
    <script src="https://cdn.bootcss.com/angular-ui-bootstrap/1.3.2/ui-bootstrap-tpls.js"></script>
</head>
<body>

<div ng-app="myApp" ng-controller="myCtrl">
    <div class="container">
        <div class="jumbotron">
            <div class="row">
                <div class="col-md-3"></div>
                <div class="col-md-6">
                    <input type="text" ng-model="selected"  uib-typeahead="n for n in suggestWords($viewValue)"
                           typeahead-loading="loadingLocations" typeahead-no-results="noResults" class="form-control" style="height:60px;font-size:20px">
                    <i ng-show="loadingLocations" class="glyphicon glyphicon-refresh"></i>
                </div>
                <div class="col-md-3">
                    <a class="btn btn-lg btn-success" href="#" role="button" ng-click="getPages()">Search</a>
                </div>
            </div>
        </div>

        <div class="row marketing">
            <h2>Search Result</h2>
            <table border="1" cellspacing="0">
                <thead>
                <tr>
                    <th>Title</th>
                    <th>Abstract</th>
                </tr>
                </thead>
                <tbody>
                <tr ng-repeat="page in records">
                    <td><a ng-href="{{page.url}}">{{page.title}}</a></td>
                    <td>{{page.abstracts}}</td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>

<script>
    var app = angular.module('myApp', ['ui.bootstrap']);
    app.controller('myCtrl', function($scope, $http) {
        $scope.searchword = "";
        $scope.words = [];
        $scope.getPages = function(){
            $http({
                method: "POST",
                url: "http://localhost:8080/wiki-pages/getPages.do",
                data: {word: $scope.selected}
            }).success(function (data){
                $scope.records = data;
            })
        };
        $scope.suggestWords = function(searchword) {
            return $http.post('/wiki-pages/suggestWord.do', {
                word: searchword
            })
                .then(function (response) {
                    $scope.words = response.data;
                    return response.data;
                });
        };
    });
</script>
</body>
</html>