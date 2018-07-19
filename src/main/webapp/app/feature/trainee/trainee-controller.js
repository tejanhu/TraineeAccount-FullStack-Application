(function() {

    var TraineeController =  function(dataService, $state) {
        
    	var vm = this;

        vm.trainees = [
            {'id': '1', 'firstName': 'Jarad','secondName': 'Huggard',
                'subject':['Java:5',
                    'SQL:5',
                    'JavaScript:5']},
            {'id': '2', 'firstName': 'Daryl','secondName': 'Conway',
                'subject':
                    ['Java:5',
                    'SQL:5',
                    'JavaScript:5']},
            {'id': '3', 'firstName': 'Benny','secondName': 'Wong',
                'subject':['Java:5',
                    'SQL:5',
                    'JavaScript:5']},
            {'id': '4', 'firstName': 'Sam','secondName': 'Kirk',
                'subject':['Java:5',
                    'SQL:5',
                    'JavaScript:5']},
            {'id': '5', 'firstName': 'Oliver','secondName': 'Loades',
                'subject':['Java:5',
                    'SQL:5',
                    'JavaScript:5']},
            {'id': '6', 'firstName': 'George','secondName': 'Timbrell',
                'subject':['Java:5',
                    'SQL:5',
                    'JavaScript:5']},
            {'id': '7', 'firstName': 'Ekaterina','secondName': 'Genova',
                'subject':['Java:5',
                    'SQL:5',
                    'JavaScript:5']},
            {'id': '8', 'firstName': 'Nawid','secondName': 'Mujadidi',
                'subject':['Java:5',
                    'SQL:5',
                    'JavaScript:5']},
            {'id': '9', 'firstName': 'Syed','secondName': 'Ahmed',
                'subject':['Java:5',
                    'SQL:5',
                   'JavaScript:5']},
            {'id': '10', 'firstName': 'Christopher','secondName': 'Darrall',
                'subject':['Java:5',
                    'SQL:5',
                    'JavaScript:5']},
            {'id': '11', 'firstName': 'Adam','secondName': 'Afzal',
                'subject':['Java:5',
                    'SQL:5',
                    'JavaScript:5']}
        ];


        vm.showTrainee = function(data){
            // console.log(vm.trainees);
            console.log("passing trainee function")
            console.log(data);
            vm.selectedTrainee = data;
            dataService.setData(data);
            $state.go("viewTrainee", {obj: vm.selectedTrainee});
        }

        vm.selectedTrainee = dataService.getData();

    };

    angular.module('accountApp').controller('traineeController',  ['dataService','$state',TraineeController]);
}());