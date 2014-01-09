
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
	
	$("#id_contact").keydown(function (event) {getNumber(event)});
	$("#id_salary_per_day").keydown(function (event) {getNumber(event)});

});

function handleAddWorker(workerid)
{
	//alert("sds : - "+workerid);
	$("#id_worker_id").val(workerid);
	$.ajax({
		type: "POST",
		url: "selectWorkerForEdit.action",
		data: "worker_id=" + workerid,
		success: function(response){
			
			$('#editWorker').html("");
			$('#editWorker').html(response);
		},
		error: function(xhr,err){}
		});

}





function clearValue()
{
	
	$('#id_is_delete').attr('checked', false);
	$("#id_worker_id").val(0);
	
	$("#id_worker_name").val("");
	$("#id_worker_name").text("");
	
	$("#id_address").val("");
	$("#id_address").text("");
	
	$("#id_contact").val("");
	$("#id_contact").text("");
	
	$("#id_licenceNo").val("");
	$("#id_licenceNo").text("");
	
	$("#id_salary_per_day").val("0");
	$("#id_salary_per_day").text("0");
	
}

