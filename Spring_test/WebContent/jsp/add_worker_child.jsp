<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="js/addWorker.js"></script>

<form:form modelAttribute="Add_Worker" action="saveWorker.action" >
<table width="100%" class="table_frm table_frm1" cellpadding="0" cellspacing="0">

<tr>
	<th class="t1" colspan="2">
		<h1>Add Worker Details</h1>
	</th>
</tr>

<tr height="0px">
	<td colspan="2" height="0px" style="padding: 0 0 0 10px;">
		<c:if test="${not empty msg}">
			<div id=m Style="height: auto; color :${clr}; text-align: center; padding: 10px 0 10px 0px;font: -moz-field;">
				<c:out value="${msg}" />
			</div>
		</c:if>
	</td>
</tr>


	


<tr>
    <td>	
    	<form:hidden path="worker_id" id="id_worker_id"/>
		<form:label path="worker_name">Worker Name.</form:label>
	</td>
	<td>	
			<form:input path="worker_name" class="input_large" id="id_worker_name" maxlength="40"/>
			<div class="clear"></div>
			 <form:errors path="worker_name" cssClass="errorblock" element="span" cssStyle="height: auto;color: red;text-align: left;padding: 0px 0 0px;" /> 
	</td>
	</tr>

<tr>
    <td>	
		<form:label path="address">Address.</form:label>
	</td>
	<td>	
			<form:input path="address" class="input_large" id="id_address" maxlength="80"/>
			<div class="clear"></div>
			<form:errors path="address" cssClass="errorblock" element="span" cssStyle="height: auto;color: red;text-align: left;padding: 0px 0 0px;" />
	</td>
	</tr>
	
<tr>
	<td>
		<form:label path="contact">Contact.</form:label>
		</td>
	<td>	
			<form:input path="contact" class="input_large" id="id_contact" maxlength="80" />
			<a href="#" class="tooltip" style="padding-left: 0px;"> <img
										src="images/question_mark.gif" width="18" height="18"
										style="vertical-align: text-bottom;"> <span> <b></b>
											Please Enter Only Positive Numbers..!! </span> </a>
			<div class="clear"></div>
			
			<form:errors path="contact" cssClass="errorblock" element="span" cssStyle="height: auto;color: red;text-align: left;padding: 0px 0 0px;" />
	</td>
</tr>

<tr>
	<td>
		<form:label path="licenceNo">LicenceNo.</form:label>
		</td>
	<td>	
			<form:input path="licenceNo" class="input_large" id="id_licenceNo" maxlength="25"/>
			<div class="clear"></div>
			<form:errors path="licenceNo" cssClass="errorblock" element="span" cssStyle="height: auto;color: red;text-align: left;padding: 0px 0 0px;" />
	</td>
</tr>

<tr>
	<td>
		<form:label path="salary_per_day">Salary Per Day.</form:label>
	</td>
	<td>	
			<form:input path="salary_per_day" class="input_large" id="id_salary_per_day"  maxlength="9" />
			<a href="#" class="tooltip" style="padding-left: 0px;"> <img
										src="images/question_mark.gif" width="18" height="18"
										style="vertical-align: text-bottom;"> <span> <b></b>
											Please Enter Only Positive Numbers..!! </span> </a>
			<div class="clear"></div>
			 <form:errors path="salary_per_day" cssClass="errorblock" element="span" cssStyle="height: auto;color: red;text-align: left;padding: 0px 0 0px;" /> 
	</td>
</tr>
<tr>
	<td>
			<form:label path="is_delete">Active.</form:label>
		</td>
	<td>	
			<form:checkbox path="is_delete" id="id_is_delete" />
	</td>
</tr>

</table>
	
	<div class="in_box"  style="text-align:center;">
    				<button type="submit" class="mn_btn" >Save</button>
    			<input type="button" class="mn_btn" value="Clear" onclick="clearValue();" />
    	</div>
</form:form>






