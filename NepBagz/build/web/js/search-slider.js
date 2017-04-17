/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {
     $("#pagetbl").hide();
    $("#bagtbl").hide();
    $("#slidertbl").hide();

         $("#slnm").keyup(function (event) {
        var text = $("#slnm").val();
                   $.get('${pageContext.request.contextPath}/searchslider', {text: text}, function (result) {
                        if (result !== null) {
                 $("#pagetbl").hide();
                $("#bagtbl").hide();
                                $("#slidervalues").find("tr:gt(0)").remove();
                                var table1 = $("#slidervalues");
                                $.each(result, function (key, value) {
                                         var rowNew = $("<tr><td></td><td></td><td></td><td></td><td></td></tr>");
                                            rowNew.children().eq(0).text(value['sid']);
                                            rowNew.children().eq(1).text(value['slidername']);
                                            rowNew.children().eq(2).text(value['location']);
                                            rowNew.children().eq(3).text(value['imageName']);
                                            rowNew.appendTo(table1);
                                });
                 $("#slidertbl").show();   
                            }
                    });
//                          code for showing table div       
      });      
});


