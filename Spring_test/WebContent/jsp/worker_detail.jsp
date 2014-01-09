<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@include file="header.jsp" %>
<script type="text/javascript">



function generate_working_detail(){
	
		var working_date= $("#id_working_date").val();
		
	 	$.ajax({
		type: "POST",
		url: "generate_working_detail.action",
		data: "working_date=" + working_date,
		
		success: function(response){
			$('#working_detail').html("");
			$('#working_detail').html(response);
		},
		error: function(xhr,err){
		}
	}); 
}

$(function() {
		 
		 
	$( "#id_working_date" ).datepicker({
		dateFormat: 'dd-mm-yy',
		changeYear: true,
		changeMonth: true,
		yearRange: '1990:+2'
	});
	$('#id_working_date').datepicker().datepicker('setDate', 'today');
});
</script>
<div id="cont_holder" style="min-width: 1024px;">
	
	<div class="middle">
	<form:form modelAttribute="Add_Worker_Detail" >
	<center>
				<div style="padding: 10px 0;">
				
					<div class="input_box">
						<b>Date Of Working :-</b> 
						&nbsp;&nbsp;
						<form:input path="working_date" maxlength="11" class="input_medium tb_disable" readonly="true" id="id_working_date" />
						&nbsp;&nbsp;
						<input type="button" value="Generate" class="mn_btn" id="id_Generate" onclick="generate_working_detail();"/>			
						<div class="clear"></div>
									
					</div>
								<div class="clear"></div>
					<br><br>
				  <div id="working_detail">
				  
					<%-- <%@include file="worker_detail_response.jsp"%> --%>
				</div>  
				</div>
			</center>
	</form:form>
	</div>
</div>
<%@include file="footer.jsp" %>