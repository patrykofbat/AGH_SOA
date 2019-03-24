$(document).ready(function() {
   $('#btn-click').on('click', function(e) {
       $.ajax({
           url: 'https://api.exchangeratesapi.io/latest?base=PLN',
           success: function(response) {
                console.log(response);
           }
       })
   })
});