
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

function handleitem(itemid)
{
	//alert("sds : - "+workerid);
	$("#id_item_id").val(itemid);
	$.ajax({
		type: "POST",
		url: "selectItemForEdit.action",
		data: "item_id=" + itemid,
		success: function(response){
			
			$('#edittem').html("");
			$('#edittem').html(response);
		},
		error: function(xhr,err){}
		});

}





function clearValue()
{
	
	$('#id_is_delete').attr('checked', false);
	
	$("#id_item_id").val(0);
	
	$("#id_cat_id").val(0);
	
	$("#id_item_name").val("");
	$("#id_item_name").text("");
	
	$("#id_item_code").val("");
	$("#id_item_code").text("");
	
	$("#id_item_description").val("");
	$("#id_item_description").text("");
	
	
}

