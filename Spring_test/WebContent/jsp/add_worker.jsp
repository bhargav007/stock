<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@include file="header.jsp" %>

<style type="text/css">
.tag {
font-family: Arial, sans-serif;
width: 200px;
position: relative;
top: 5px;
font-weight: bold;
text-transform: uppercase;
display: block;
float: left;
}
label {
display: inline;
}
.regular-checkbox {
display: none;
}
.regular-checkbox + label {
background-color: #fafafa;
border: 1px solid #cacece;
box-shadow: 0 1px 2px rgba(0,0,0,0.05), inset 0px -15px 10px -12px rgba(0,0,0,0.05);
padding: 9px;
border-radius: 3px;
display: inline-block;
position: relative;
}
.regular-checkbox + label:active, .regular-checkbox:checked + label:active {
box-shadow: 0 1px 2px rgba(0,0,0,0.05), inset 0px 1px 3px rgba(0,0,0,0.1);
}
.regular-checkbox:checked + label {
background-color: #e9ecee;
border: 1px solid #adb8c0;
box-shadow: 0 1px 2px rgba(0,0,0,0.05), inset 0px -15px 10px -12px rgba(0,0,0,0.05), inset 15px 10px -12px rgba(255,255,255,0.1);
color: #99a1a7;
}
.regular-checkbox:checked + label:after {
content: '\2714';
font-size: 14px;
position: absolute;
top: 0px;
left: 3px;
color: #99a1a7;
}
</style>
 <div id="cont_holder">
<%-- <form:form modelAttribute="Add_Worker">
	<div class="allowances">
		<div class="form_box">
			<table width="80%" class="table_frm" cellpadding="0" cellspacing="0">
					<tr>
						<th class="t1" colspan="4">
							<h1>User Details</h1>
						</th>
					</tr>
					<tr>
						<td  colspan="4">
							<c:if test="${not empty message}">
								<div id=msg	Style="height: auto; color :${clr}; text-align: center; padding: 10px 0 10px 0px;font: -moz-field;">
									<c:out value="${message}" />
								</div>
							</c:if>
						</td>
					</tr>
					<tr>
						<td >
							<div class="in_box">
								<div class="lable">
									<p><form:label path="worker_name">Worker Name</form:label></p>
								</div>
								<div class="input_box">
									<form:input maxlength="40" path="worker_name"
										class="input_large tb_disable" readonly="true" id="id_worker_name" />
									<div class="clear"></div>
									<form:errors path="worker_name" cssClass="errorblock" element="span"
										cssStyle="height: auto;color: red;text-align: left;padding: 0px 0 0px;" />
								</div>
								<div class="clear"></div>
							</div>
						</td>
						<td>
							<div class="in_box">
								<div class="lable">
									<p>
										<form:label path="address">Address</form:label>
									</p>
								</div>
								<div class="input_box">
									<form:textarea cols="10" path="address"
										class="textarea_medium tb_disable" readonly="true" id="id_address" />
									<div class="clear"></div>
									<form:errors path="address" cssClass="errorblock"
										element="span"
										cssStyle="height: auto;color: red;text-align: left;padding: 0px 0 0px;" />
								</div>
								<div class="clear"></div>
							</div>
						</td>
					</tr>
					<tr>
						<td>
							<div class="in_box">
								<div class="lable">
									<p><form:label path="contact">Contact</form:label></p>
								</div>
								<div class="input_box">
									<form:input maxlength="40" path="contact"
										class="input_large tb_disable" readonly="true" id="id_contact" />
									<div class="clear"></div>
									<form:errors path="contact" cssClass="errorblock" element="span" cssStyle="height: auto;color: red;text-align: left;padding: 0px 0 0px;" />
								</div>
								<div class="clear"></div>
							</div>
						</td>
						<td>
							<div class="in_box">
								<div class="lable">
									<p><form:label path="licenceNo">Licence No</form:label></p>
								</div>
								<div class="input_box">
									<form:input maxlength="30" path="licenceNo"
										class="input_medium tb_disable" readonly="true" id="id_licenceNo" />
									<div class="clear"></div>
									<form:errors path="licenceNo" cssClass="errorblock"
										element="span"
										cssStyle="height: auto;color: red;text-align: left;padding: 0px 0 0px;" />
								</div>
								<div class="clear"></div>
							</div>
						</td>
					</tr>
					<tr>
						
						<td>
							<div class="in_box">
								<div class="lable">
									<p>
										<form:label path="salary_per_day">salary_per_day</form:label>
									</p>
								</div>
								<div class="input_box">
									<form:input path="salary_per_day" maxlength="25"
										class="input_medium tb_disable" readonly="true" id="id_salary_per_day" />
									<div class="clear"></div>
									<form:errors path="salary_per_day" cssClass="errorblock" element="span"
										cssStyle="height: auto;color: red;text-align: left;padding: 0px 0 0px;" />
								</div>
								<div class="clear"></div>
							</div>
						</td>
						<td>
							
						</td>
					</tr>
				</table>
				<div class="in_box" style="text-align: center;">
					<input type="button" value="Edit" class="mn_btn" id="id_editbuttton" />
					<button type="submit" class="sub_btn_dis" id="id_subbuttton" disabled="disabled" >Save</button>
				</div>
				<div class="clear"></div>
			</div>
		</div>


	</form:form> --%>


	<br />
	
	
	<div id="editWorker" style="float: left;width: 40%;"> 
		<%@include file="add_worker_child.jsp" %>
	</div> 
	<div style="float: right;width: 55%;text-align: left;">
		<table width="100%" class="table_frm table_frm1" cellpadding="0" cellspacing="0">
			<tr>
				<th class="t1" colspan="7">
					<h1>List OF Available Workers.</h1>
				</th>
			</tr>
			<tr>
				<th class="center_class">Worker Name</th>
				<th class="center_class">Address</th>
				<th class="center_class">Contact</th>
				<th class="center_class">Licence No.</th>
				<th class="center_class">Salary Per Day</th>
				<th class="center_class">Active</th>
				<th class="center_class">Edit</th>
			</tr>	
			
			<c:choose>
				<c:when test="${not empty addWorker_map}">
					
						<tr>
							<td colspan="7" class="center_class" >
								<div id=addWorker_map Style="height: auto; color :${clr}; text-align: center; padding: 10px 0 10px 0px;font: -moz-field;">
									<c:out value="${addWorker_map}" />
								</div>
							</td>
						</tr>
				</c:when>
				<c:otherwise>
					
					<c:forEach var="entry" items="${Worker}">
				<c:set var="str" value="${fn:split(entry.value, '@@')}" />
				<tr>
					<td class="center_class">${str[0]}</td>
					<td class="center_class">${str[1]}</td>
					<td class="center_class">${str[2]}</td>
					<td class="center_class">${str[3]}</td>
					<td class="center_class">${str[4]}</td>
					
					<c:choose>
						<c:when test="${str[5] == true}">
							<td class="center_class"><input type="checkbox" id="id_${str[5]}" class="regular-checkbox" value="${str[5]}" checked="checked" disabled="disabled" >
							<label for="id_${str[5]}"></label>
							</td>
						</c:when>
						<c:otherwise>
							<td class="center_class"><input type="checkbox" id="id_${str[5]}" class="regular-checkbox" value="${str[5]}" disabled="disabled" >
							<label for="id_${str[5]}"></label></td>
						</c:otherwise>
					</c:choose> 
						
					
					
					<td align="center" style="text-align: center;">
						<button id="select" value="${entry.key}" onclick="handleAddWorker('${entry.key}')" class="img_btn">
							<img src="images/edit.png" width="16" alt="" />
						</button>
					</td>
				<tr>
			</c:forEach>
				</c:otherwise>
		</c:choose>	
			
			
		</table>
	</div>
	
	
	</div>
<%@include file="footer.jsp" %>