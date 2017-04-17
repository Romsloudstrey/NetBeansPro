/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {
    $("#pagetbl").hide();
    $("#pgnm").on('keyup', function () {
        var texts = $("#pgnm").val();
        $.ajax({
            url: "PageController?action=search",
            type: "POST",
            data: {
                texts: texts
            },
            dataType:'text',
            success: function (result) {
                window.alert("result");
                  console.log(result);
            }
        });
    });
});