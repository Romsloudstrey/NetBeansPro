/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {
     $("#pagetbl").hide();
    $("#bagtbl").hide();

         $("#bgnm").keyup(function (event) {
        var text = $("#bgnm").val();
                   $.get('${pageContext.request.contextPath}/searchbags', {text: text}, function (result) {
                        if (result !== null) {
                $("#pagetbl").hide();
                $("#slidertbl").hide();
                                $("#bagvalues").find("tr:gt(0)").remove();
                                var table1 = $("#bagvalues");
                                $.each(result, function (key, value) {
                                         var rowNew = $("<tr><td></td><td></td><td></td><td></td><td></td></tr>");
                                            rowNew.children().eq(0).text(value['bagId']);
                                            rowNew.children().eq(1).text(value['bagName']);
                                            rowNew.children().eq(2).text(value['imageName']);
                                            rowNew.children().eq(3).text(value['bagPrice']);
                    rowNew.children().eq(4).text(value['bagBrand']);
                                            rowNew.appendTo(table1);
                                });
                 $("#bagtbl").show();   
                            }
                    });
//                          code for showing table div       
      });      
});

