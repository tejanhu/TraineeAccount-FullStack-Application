"use strict";

(function () {


    function TraineeAccountService (traineeDal) {

        this.getTrainees = function()
        {
            return traineeDal.getTrainees();
        };

    }

    angular.module("traineeApp").service("traineeAccountService", ['traineeDal', TraineeAccountService]);

}());