<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="js/category.js"></script>

<form:form modelAttribute="Category" action="saveCategory.action">
<table width="100%" class="table_frm table_frm1" cellpadding="0" cellspacing="0">

<tr>
	<th class="t1" colspan="2">
		<h1>Add Category.</h1>
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
    	<form:hidden path="cat_id" id="id_cat_id"/>
		<form:label path="cat_name">Category Name.</form:label>
	</td>
	<td>	
			<form:input path="cat_name" class="input_large" id="id_cat_name" maxlength="40"/>
			<div class="clear"></div>
			 <form:errors path="cat_name" cssClass="errorblock" element="span" cssStyle="height: auto;color: red;text-align: left;padding: 0px 0 0px;" /> 
	</td>
	</tr>

<tr>
    <td>	
		<form:label path="cat_code">Category Code.</form:label>
	</td>
	<td>	
			<form:input path="cat_code" class="input_large" id="id_cat_code" maxlength="80"/>
			<div class="clear"></div>
			<form:errors path="cat_code" cssClass="errorblock" element="span" cssStyle="height: auto;color: red;text-align: left;padding: 0px 0 0px;" />
	</td>
</tr>

<tr>
    <td>	
		<form:label path="cat_description">Category Description.</form:label>
	</td>
	<td>	
			<form:input path="cat_description" class="input_large" id="id_cat_description" maxlength="80"/>
			<div class="clear"></div>
			<form:errors path="cat_description" cssClass="errorblock" element="span" cssStyle="height: auto;color: red;text-align: left;padding: 0px 0 0px;" />
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






