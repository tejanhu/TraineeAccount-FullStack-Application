'use strict';
accountApp.service('dataService', function() {
    var the_service = this;

    var data = {};
    the_service.getData = function(){
        return the_service.data;
    }
    the_service.setData = function(requestData){
        the_service.data = requestData;
    }

});