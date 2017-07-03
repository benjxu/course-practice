<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <script src="http://cdn.static.runoob.com/libs/angular.js/1.4.6/angular.min.js"></script>
</head>
<body>

<div ng-app="myApp" ng-controller="myCtrl">
    <input ng-model="searchword" ng-change="suggestWords()">
    <button ng-click="getPages()">Search</button>
    <ul>
        <li ng-repeat="word in words">
            {{word}}
        </li>
    </ul>

    <h2>Search Result</h2>
    <table border="1" cellspacing="0">
        <thead>
        <tr>
            <th>Title</th>
            <th>Url</th>
            <th>Abstract</th>
        </tr>
        </thead>
        <tbody>
        <tr ng-repeat="page in records">
            <td>{{page.title}}</td>
            <td>{{page.url}}</td>
            <td>{{page.abstracts}}</td>
        </tr>
        </tbody>
    </table>
</div>

<script>
    var app = angular.module('myApp', []);
    app.controller('myCtrl', function($scope, $http) {
        $scope.searchword = "";
        $scope.words = [];
        $scope.getPages = function(){
            $http({
                method: "POST",
                url: "http://localhost:8080/wiki-pages/getPages.do",
                data: {word: $scope.searchword}
            }).success(function (data){
                $scope.records = data;
            })
        };
        $scope.suggestWords = function(){
            $http({
                method: "POST",
                url: "http://localhost:8080/wiki-pages/suggestWord.do",
                data: {word: $scope.searchword}
            }).success(function (data){
                $scope.words = data;
            })
        };
    });
</script>
</body>
</html>