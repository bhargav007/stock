
function onchoosing(id,salaryPerDay) {
	var indexValue=$("#att_mode_"+id+" option:selected").val();
	if(parseInt(indexValue)==3){
		$("#hour_"+id).css({"display": "inline"});
	}else{
		$("#hour_"+id).val("");
		$("#hour_"+id).css({"display": "none"});
	}
	
	if(parseInt(indexValue)==0){
		//alert("Please select Attendance Mode.!");
		$("#calc_"+id).val(parseFloat(0.0));
	}
	if(parseInt(indexValue)==1){
		//alert("salary for full day :- "+salaryPerDay);
		$("#calc_"+id).val(parseFloat(salaryPerDay));
	}
	if(parseInt(indexValue)==2){
		//alert("salary for Half day :- "+parseFloat(salaryPerDay/2));
		$("#calc_"+id).val(parseFloat(salaryPerDay/2));
	}
	
}
function claculateSalaryForHour(id,salaryPerDay) {
	
	var a=$("#h_"+id).val();
	//alert("value : -"+a.length);
	if(a.length<=0){
		alert("please enter hours .!");
		return;
	}else{
		if(parseInt(a)>0 && parseInt(a)<9){
			//alert("salary for Hour :- "+parseFloat(salaryPerDay*a/8));
			$("#calc_"+id).val(parseFloat(salaryPerDay*a/8));
		}else{
			alert("Hours value must be between 1-8 .!");
			return;
		}
		
	}
}

function save_working_detail(workerid){
	var fullday="",halfday="",hour="";
	var indexValue=$("#att_mode_"+workerid+" option:selected").val();
	if(parseInt(indexValue)==0){
		alert("Please select Attendance Mode.!");
		return;
	}
	if(parseInt(indexValue)==1){
		var fullday="true";
	}
	if(parseInt(indexValue)==2){
		var halfday="true";
	}
	if(parseInt(indexValue)==3){
		var hour=$("#h_"+workerid).val();
		if(hour.length<=0){
			alert("please enter hours .!");
			return;
		}else{
			if(parseInt(hour)>0 && parseInt(hour)<9){
				
			}else{
				alert("Hours value must be between 1-8 .!");
				return;
			}
		}
	}
	
	
	//alert("hour : - "+hour);
	var calculated_salary=$("#calc_"+workerid).val();
	//alert("calculated_salary : - "+calculated_salary);
	var deduction=$("#deduction_"+workerid).val();
	//alert("deduction : - "+deduction);
	var working_date=$("#id_working_date").val();
	//alert("working_date : - "+working_date);
	
	
	if (halfday.length <= 0)
		halfday="false";
	if (fullday.length <= 0)
		fullday="false";
	if (hour.length <= 0){
		hour="false";
	}
	if (calculated_salary.length <= 0)
		calculated_salary="0";
	if(deduction.length <= 0 ){
		deduction="0";
	}
	$.ajax({
		url: "save_working_detail.action",
		data: "worker_id=" + workerid+"&working_date=" + working_date+"&fullday=" + fullday+"&halfday=" + halfday+"&hour=" + hour+"&calculated_salary=" + calculated_salary+"&deduction=" + deduction,
		success: function(response){
			alert(response);
		}
	});  
}

function checkForRadio(id,basic_salary){
	//alert("basic_salary : - "+basic_salary);
	var radioGroupName="r_"+id;
	var hourvalue=$("#hour_"+id).val();
	if(parseFloat(hourvalue)>9){
		$("#hour_"+id).val("");
		alert("Hours value is between 1-8 Only..!");
		return;
	}
	
	if(parseFloat(hourvalue)>=1){
		var r=confirm("Do you really want to Calculate Salary by choosing Hour..?");
		if (r==true){
		  $("input[name="+radioGroupName+"]").attr('checked',false);
		 // alert("basic_salary : - "+basic_salary);
		 // alert("hourvalue : - "+hourvalue);
		  var calculated=parseFloat((basic_salary*hourvalue)/8);
		  $("#calculated_salary_"+id).val(calculated);
		}
		else{
			$("#hour_"+id).val("");
		  	return;
		 }
	}else{
		$("#hour_"+id).val("");
	}
}

function getOnlyNumber(hr_id){
	$("#"+hr_id).keydown(function (event) {getNumber(event)});
}



function getNumber(event){
	var num = event.keyCode;
    if ((num > 95 && num < 106) || (num > 36 && num < 41) || num == 9 ) {
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

function checkForHour(id,basic_salary){
	
	var hour=$("#hour_"+id).val();
alert(hour);
	var radioGroupName="r_"+id;
	if(parseInt(hour)>=1){
		var r=confirm("Do you really want to Calculate Salary by choosing FullDay or HalfDay..?");
		if (r==true){
			$("#hour_"+id).val("");
			var rates = document.getElementsByName(radioGroupName);
			var rate_value;
			for(var i = 0; i < rates.length; i++){
			    if(rates[i].checked){
			        rate_value = rates[i].value;
			        //alert(rate_value);
			        if(rate_value == 'H'){
			        	//alert("h selected");
			        	$("#calculated_salry_"+id).val(parseFloat(basic_salary));	
			        }else{
			        	$("#calculated_salry_"+id).val(parseFloat((basic_salary*4)/8));
			        }
			    }
			}
		}else{
			return;
		}
	}
		else{
			//alert("else");
			var rates = document.getElementsByName(radioGroupName);
			var rate_value;
			for(var i = 0; i < rates.length; i++){
			    if(rates[i].checked){
			        rate_value = rates[i].value;
			       // alert("rate_value : - "+ rate_value);
			        if(rate_value == 'F'){
			        	/* var a=parseFloat(basic_salary)*4;
			        	var b=a/8;
			        	alert("salary Half :- "+parseFloat(b));
			        	alert("salary :- "+parseFloat(basic_salary)); */
			        	$("#calculated_salary_"+id).val(parseFloat(basic_salary));	
			        }else if(rate_value == 'H'){
			        	 var a=parseFloat(basic_salary)*4;
			        	var b=a/8;
			        	alert("salary :- "+parseFloat(b)); 
			        	$("#calculated_salary_"+id).val(b);
			        }
			    }
			}
			return;
		 }
	}



/*
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

*/