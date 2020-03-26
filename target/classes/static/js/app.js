/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var apiclient = apiclient;
var app = (function(){
    var _createTable = function(data){
        $("#countries > tbody").empty();
        data.map(function (c){
            $("#countries > tbody").append(
                     "<tr> <td>" +
                c.country +
                "</td>" +
                "<td>" +
                c.deaths +
                "</td> " +
                "<td>" +
                c.confirmed +
                "</td> " +
                "<td>" +
                c.recovered +
                "</td>" +
                "</tr>"
                );
        });
    };
    
    return {
        init: function() {
            apiclient.getStatistics().then(function(data){
            _createTable(data);});
        }        
    };
    
})();
