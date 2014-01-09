
function getNumber(event){
	var num = event.keyCode;
    if ((num > 95 && num < 106) || (num > 36 && num < 41) || num == 9) {
        return;
    }
    if (event.shiftKey || event.ctrlKey || event.altKey) {
        event.preventDefault();
    } else if (num != 46 && num != 8) {
        if (isNaN(parseInt(String.fromCharCode(event.which)))) {
            event.preventDefault();
        }
    }
}
$(function() {
	
//	$("#id_contact").keydown(function (event) {getNumber(event)});
//	$("#id_salary_per_day").keydown(function (event) {getNumber(event)});

});

function handleCategory(catid)
{
	//alert("sds : - "+workerid);
	$("#id_cat_id").val(catid);
	$.ajax({
		type: "POST",
		url: "selectCategoryForEdit.action",
		data: "cat_id=" + catid,
		success: function(response){
			
			$('#editcategory').html("");
			$('#editcategory').html(response);
		},
		error: function(xhr,err){}
		});

}





function clearValue()
{
	
	$('#id_is_delete').attr('checked', false);
	$("#id_cat_id").val(0);
	
	$("#id_cat_name").val("");
	$("#id_cat_name").text("");
	
	$("#id_cat_code").val("");
	$("#id_cat_code").text("");
	
	$("#id_cat_description").val("");
	$("#id_cat_description").text("");
	
	
}

