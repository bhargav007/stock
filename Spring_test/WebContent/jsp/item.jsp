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
	<br />
	<div id="edittem" style="float: left;width: 40%;"> 
		 <%@include file="item_child.jsp" %>
	</div> 
	<div style="float: right;width: 55%;text-align: left;">
		<table width="100%" class="table_frm table_frm1" cellpadding="0" cellspacing="0">
			<tr>
				<th class="t1" colspan="6">
					<h1>List OF Available Items.</h1>
				</th>
			</tr>
			<tr>
				<th class="center_class">Item Name</th>
				<th class="center_class">Item Code</th>
				<th class="center_class">Item Category</th>
				<th class="center_class">Item Description</th>
				<th class="center_class">Active</th>
				<th class="center_class">Edit</th>
			</tr>	
			
			<c:choose>
				<c:when test="${not empty item_map}">
					
						<tr>
							<td colspan="6" class="center_class" >
								<div id=category_map Style="height: auto; color :${clr}; text-align: center; padding: 10px 0 10px 0px;font: -moz-field;">
									<c:out value="${item_map}" />
								</div>
							</td>
						</tr>
				</c:when>
				<c:otherwise>
					
					<c:forEach var="entry" items="${imap}">
				<c:set var="str" value="${fn:split(entry.value, '@@')}" />
				<tr>
					<td class="center_class">${str[0]}</td>
					<td class="center_class">${str[1]}</td>
					<td class="center_class">${str[2]}</td>
					<td class="center_class">${str[3]}</td>
					
					<c:choose>
						<c:when test="${str[4] == true}">
							<td class="center_class"><input type="checkbox" id="id_${str[4]}" class="regular-checkbox" value="${str[4]}" checked="checked" disabled="disabled" >
							<label for="id_${str[4]}"></label>
							</td>
						</c:when>
						<c:otherwise>
							<td class="center_class"><input type="checkbox" id="id_${str[4]}" class="regular-checkbox" value="${str[4]}" disabled="disabled" >
							<label for="id_${str[4]}"></label></td>
						</c:otherwise>
					</c:choose> 
						
					
					
					<td align="center" style="text-align: center;">
						<button id="select" value="${entry.key}" onclick="handleitem('${entry.key}')" class="img_btn">
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