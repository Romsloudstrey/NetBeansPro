/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 $(document).ready(function () {
                 $("#quantity").change(function () {
                var price = $("#price").val();
                var quantity= $("#quantity").val();
                var total=price *quantity;
                document.getElementById("totalprice").value= total;
                //document.getElementById("totalprice").setAttribute(total,price);
              });      
        });


