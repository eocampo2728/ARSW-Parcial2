/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

apiclient = (function() {
    return {
        getAllCountries: function() {
            var promise=$.ajax({
                dataType: "json",
                url: "/countries",
            });
            return promise;
        }
    };
})();
