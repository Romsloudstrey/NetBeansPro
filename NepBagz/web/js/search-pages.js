/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 /* global index, array */

$(document).ready(function () {
            //var result;
             $("#pagetbl").hide();
            $("#bagtbl").hide();
                 $("#pgnm").keyup(function (event) {
                var text = $("#pgnm").val();
                           $.get('${pageContext.request.contextPath}/searchpage', {text:text}, function (result) {
                        if(result){
                        $("#bagtbl").hide(); 
                        $("#slidertbl").hide();
                                        $("#searchvalues").find("tr:gt(0)").remove();
                                        var table1 = $("#searchvalues");
                                        $.each(result, function (key, value) {
                                                 var rowNew = $("<tr><td></td><td></td><td></td><td></td></tr>");
                                                    rowNew.children().eq(0).text(value['pageId']);
                                                    rowNew.children().eq(1).text(value['pageName']);
                                                    rowNew.children().eq(2).text(value['pageDescription']);
                                                    rowNew.children().eq(3).text(value['imgName']);
                                                    rowNew.appendTo(table1);
                                        });
                         $("#pagetbl").show();  
                                    }
                            });
//                          code for showing table div       
              });      
        });


