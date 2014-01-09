<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<script src="js/addWorker_detail.js"></script>

 <div id="cont_holder">
 		
 		<table width="100%" class="table_frm table_frm1" cellpadding="0" cellspacing="0">
			<tr>
				<th class="t1" colspan="5">
					<center><h1>Worker's Attendance</h1></center>
					<br>
				</th>
			</tr>
			<tr>
				<th class="center_class">Worker Name</th>
				<th class="center_class">Attendance Mode </th>
				<th class="center_class">Calculated Salary</th>
				<th class="center_class">Deduction</th>
				<th class="center_class">Save</th>
			</tr>	
			<c:forEach var="entry" items="${detail_map}">
				<tr>
					<td class="center_class">${fn:split(entry.key, '@@')[1]}</td>
					<td class="center_class">
					<%-- <c:out value="bhargav_${entry.value.hour }"></c:out> --%>
					<c:choose>
						<c:when test="${entry.value.fullday == true}">
							<select id="att_mode_${entry.value.worker_id}" class="rounded_small" onblur="onchoosing('${entry.value.worker_id}','${fn:split(entry.key, '@@')[2]}');" onchange="onchoosing('${entry.value.worker_id}','${fn:split(entry.key, '@@')[2]}');">
								<option value=0>-</option>
								<option value=1 selected="selected">Fullday</option>
								<option value=2>Halfday</option>
								<option value=3>Hour</option>
							</select>
							&nbsp;
							<div id="hour_${entry.value.worker_id }" style="display: none">
								&nbsp;Enter Hour :- &nbsp;<input type="text" id="h_${entry.value.worker_id }" class="input_small" maxlength="2" style="width: 50px;" value="0" onkeydown="getOnlyNumber('h_${entry.value.worker_id }');" onblur="claculateSalaryForHour('${entry.value.worker_id }','${fn:split(entry.key, '@@')[2]}');">
							</div>
						</c:when>
						<c:when test="${entry.value.halfday == true}">
							<select id="att_mode_${entry.value.worker_id}" class="rounded_small" onblur="onchoosing('${entry.value.worker_id}','${fn:split(entry.key, '@@')[2]}');" onchange="onchoosing('${entry.value.worker_id}','${fn:split(entry.key, '@@')[2]}');">
								<option value=0>-</option>
								<option value=1 >Fullday</option>
								<option value=2 selected="selected">Halfday</option>
								<option value=3>Hour</option>
							</select>
							&nbsp;
							<div id="hour_${entry.value.worker_id }" style="display: none">
								&nbsp;Enter Hour :- &nbsp;<input type="text" id="h_${entry.value.worker_id }" class="input_small" maxlength="2" style="width: 50px;" value="0" onkeydown="getOnlyNumber('h_${entry.value.worker_id }');" onblur="claculateSalaryForHour('${entry.value.worker_id }','${fn:split(entry.key, '@@')[2]}');">
							</div>
						</c:when>
							
						<c:when test="${fn:contains(entry.value.hour,'1') or fn:contains(entry.value.hour,'2') or fn:contains(entry.value.hour,'3') or fn:contains(entry.value.hour,'4') or fn:contains(entry.value.hour,'5') or fn:contains(entry.value.hour,'6') or fn:contains(entry.value.hour,'7') or fn:contains(entry.value.hour,'8')}">
							<select id="att_mode_${entry.value.worker_id}" class="rounded_small" onblur="onchoosing('${entry.value.worker_id}','${fn:split(entry.key, '@@')[2]}');" onchange="onchoosing('${entry.value.worker_id}','${fn:split(entry.key, '@@')[2]}');">
								<option value=0>-</option>
								<option value=1 >Fullday</option>
								<option value=2 >Halfday</option>
								<option value=3 selected="selected">Hour</option>
							</select>
							&nbsp;
							<div id="hour_${entry.value.worker_id }" style="display: inline;">
								&nbsp;Enter Hour :- &nbsp;<input type="text" id="h_${entry.value.worker_id }" class="input_small" maxlength="2" style="width: 50px;" value="${entry.value.hour}" onkeydown="getOnlyNumber('h_${entry.value.worker_id }');" onblur="claculateSalaryForHour('${entry.value.worker_id }','${fn:split(entry.key, '@@')[2]}');">
							</div>		
								
						</c:when>
						<c:otherwise>
							<select id="att_mode_${entry.value.worker_id}" class="rounded_small" onblur="onchoosing('${entry.value.worker_id}','${fn:split(entry.key, '@@')[2]}');" onchange="onchoosing('${entry.value.worker_id}','${fn:split(entry.key, '@@')[2]}');">
								<option value=0 selected="selected">-</option>
								<option value=1 >Fullday</option>
								<option value=2>Halfday</option>
								<option value=3>Hour</option>
							</select>
							&nbsp;
							<div id="hour_${entry.value.worker_id }" style="display: none">
								&nbsp;Enter Hour :- &nbsp;<input type="text" id="h_${entry.value.worker_id }" class="input_small" maxlength="2" style="width: 50px;" value="0" onkeydown="getOnlyNumber('h_${entry.value.worker_id }');" onblur="claculateSalaryForHour('${entry.value.worker_id }','${fn:split(entry.key, '@@')[2]}');">
							</div>
						</c:otherwise>
					</c:choose>
					</td>
					<%-- 
					
					<td class="center_class">
						<select id="att_mode_${entry.value.worker_id}" onblur="onchoosing('${entry.value.worker_id}','${fn:split(entry.key, '@@')[2]}');" onchange="onchoosing('${entry.value.worker_id}','${fn:split(entry.key, '@@')[2]}');">
									<option value=0>-</option>
									<option value=1 >Fullday</option>
									<option value=2>Halfday</option>
									<option value=3>Hour</option>
						</select>
						&nbsp;<div id="hour_${entry.value.worker_id }" style="display: none">
						&nbsp;Enter Hour :- &nbsp;<input type="text" id="h_${entry.value.worker_id }" maxlength="2" style="width: 50px;" value="0" onkeydown="getOnlyNumber('h_${entry.value.worker_id }');" onblur="claculateSalaryForHour('${entry.value.worker_id }','${fn:split(entry.key, '@@')[2]}');">
						</div> --%>
					
					<td class="center_class"><input type="text" class="input_small" id="calc_${entry.value.worker_id }" maxlength="4" style="width: 50px;" value="${entry.value.calculated_salary}" disabled="disabled">&nbsp;In Rs.</td>
					<td class="center_class"><input type="text" class="input_small" id="deduction_${entry.value.worker_id }" maxlength="4" style="width: 50px;" value="${entry.value.deduction}" >&nbsp;In Rs.</td>
					<td class="center_class" style="text-align: center;">
						<input type="button" value="Save" class="mn_btn" id="id_save" onclick="save_working_detail('${entry.value.worker_id}');"/>
					</td>
				</tr>
			</c:forEach>				
		</table>
	</div>
