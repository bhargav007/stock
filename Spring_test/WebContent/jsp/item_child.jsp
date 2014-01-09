<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="js/item.js"></script>

<form:form modelAttribute="Item" action="saveItem.action">
<table width="100%" class="table_frm table_frm1" cellpadding="0" cellspacing="0">

<tr>
	<th class="t1" colspan="2">
		<h1>Add Item.</h1>
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
    	<form:hidden path="item_id" id="id_item_id"/>
		<form:label path="item_name">Item Name.</form:label>
	</td>
	<td>	
			<form:input path="item_name" class="input_large" id="id_item_name" maxlength="40"/>
			<div class="clear"></div>
			 <form:errors path="item_name" cssClass="errorblock" element="span" cssStyle="height: auto;color: red;text-align: left;padding: 0px 0 0px;" /> 
	</td>
	</tr>

<tr>
    <td>	
		<form:label path="item_code">Item Code.</form:label>
	</td>
	<td>	
			<form:input path="item_code" class="input_large" id="id_item_code" maxlength="80"/>
			<div class="clear"></div>
			<form:errors path="item_code" cssClass="errorblock" element="span" cssStyle="height: auto;color: red;text-align: left;padding: 0px 0 0px;" />
	</td>
</tr>


<tr>
	<td>
		<form:label path="cat_id">Item Category.</form:label>
	</td>
	<td>
		<form:select path="cat_id" items="${cmap}" class="rounded" id="id_cat_id"  cssStyle="width:166px;" />
	</td>

</tr>


<tr>
    <td>	
		<form:label path="item_description">Item Description.</form:label>
	</td>
	<td>	
			<form:input path="item_description" class="input_large" id="id_item_description" maxlength="80"/>
			<div class="clear"></div>
			<form:errors path="item_description" cssClass="errorblock" element="span" cssStyle="height: auto;color: red;text-align: left;padding: 0px 0 0px;" />
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






