"use strict";

(function () {

    function TraineeDal (dal) {

        this.getTrainees = function () {
            return dal.http.GET("rest/trainee/json");
        };

        this.saveTrainee = function (traineeToSave) {
            return dal.http.POST("rest/trainee/json", traineeToSave);
        };

        this.updateTrainee = function (traineeToUpdate) {
            return dal.http.PUT("rest/trainee/json/", traineeToUpdate);
        };

        this.deleteTrainee = function (traineeToDelete) {
            return dal.http.DELETE("/rest/trainee/json/", traineeToDelete);
        };
    }

    angular.module("traineeApp").service("traineeDal", ["dal", TraineeDal]);
}());