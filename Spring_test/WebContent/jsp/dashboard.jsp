<%@include file="header.jsp" %>

 <style type="text/css">
#flotcontainer {
    width: 300px;
    height: 250px;
    text-align: left;
}
</style>
 
 
 

  <!-- Start Main cont -->
  <div id="cont_holder"> 
    <!-- Start dashboard -->
    <div id="dashboard">
      <div class="clear"></div>
      <div class="m_desk"> 
        <!-- Box 1 -->
        <div class="dash_box">
          <div class="dash_header">
            <h1>Leave Summary</h1>
            <a href="#">View all</a> </div>
          <div class="dash_mid_cont">
          	<%-- <table width="90%" class="table_frm table_frm1" cellpadding="0" cellspacing="0">
				<c:set var="str" value="${fn:split(availableAndTotalLeaves, '@@')}" />
					<tr>
						<th>Total</th>
							<td>
								<input type="hidden" value="${str[1]}" id="totalquota">${str[1]}
							</td>
							
						<th>Available</th>
							<td>
								<input type="hidden" value="${str[0]}" id="availablequota">${str[0]}
							</td>
						
						<th>Used</th>
							<td>
									<input type="hidden" value="${str[1] - str[0]}" id="usedquota">${str[2]}
							</td>
					</tr>
					
					<tr>
						<th colspan="2">Basic Holiday Quota</th>
							<td colspan="4">
								${basic_holiday_quota}
							</td>
					</tr>
					<tr>
						<th colspan="2">Forwaded Days</th>
							<td colspan="4">
								${forwaded_days}
							</td>
					</tr>
					<tr>
						<th colspan="2">Other Adjustment</th>
							<td colspan="4">
								${other_Adjustment}
							</td>
					</tr>
					
			</table> --%>
          </div>
        </div>
        <!-- Box 1 --> 
        <!-- Box 2 -->
        <div class="dash_box">
          <div class="dash_header">
            <h1>All Leave2</h1>
            <a href="#">View all</a> </div>
          <div class="dash_mid_cont"> 
          
          	<%--  <table width="90%" class="table_frm table_frm1" cellpadding="0" cellspacing="0">
					
					<c:forEach var="map" items="${AllLeaves}">
						<c:forEach var="entry" items="${map}">
						
						<tr>
							<th>Date</th>
							<td>${entry.key}</td>
							
							<th>Status</th>
							<td>${entry.value}</td>
							
						</tr>
					
						
						
						</c:forEach>
					</c:forEach>
				</table> --%>
          
          </div>
        </div>
        <!-- Box 2 --> 
        <!-- Box 3 -->
        <div class="dash_box">
          <div class="dash_header">
            <h1>Tasks3</h1>
            <a href="#">View all</a> </div>
          <div class="dash_mid_cont">
          
          		<div>
					<span id="showInteractive"></span>
				</div>
				<div id="flotcontainer"></div>
			 	<!--  <div id="legendPlaceholder"></div>
				<div id="flotcontainer"></div> -->
          </div>
        </div>
        <!-- Box 3 --> 
        <!-- Box 4 -->
       <div class="dash_box">
          <div class="dash_header">
            <h1>Tasks4</h1>
            <a href="#">View all</a> </div>
          <div class="dash_mid_cont"> 
          
         
          
          </div>
        </div>
        <!-- Box 4 --> 
        <!-- Box 5 -->
        <div class="dash_box">
          <div class="dash_header">
            <h1>Tasks</h1>
            <a href="#">View all</a> </div>
          <div class="dash_mid_cont"> </div>
        </div>
        <!-- Box 5 --> 
        <!-- Box 6 -->
        <div class="dash_box">
          <div class="dash_header">
            <h1>Upcoming Leaves</h1>
            <a href="#">View all</a> </div>
          <div class="dash_mid_cont">
          
          <%-- 
          <table width="90%" class="table_frm table_frm1" cellpadding="0" cellspacing="0">
					
					<c:forEach var="entry" items="${upcomingLeaves}">
						<c:set var="str" value="${fn:split(entry, '@@')}" />
						<tr>
							<th style="width: auto;">Date</th>
							<td style="width: auto;">${str[0]}</td>
							
								<th style="width: auto;">Leave For</th>
								<c:if test="${fn:startsWith(str[1], 'first')}">
	   								<td style="width: auto;">First Half</td>
								</c:if>
								<c:if test="${fn:startsWith(str[1], 'second')}">
	   								<td style="width: auto;">Second Half</td>
								</c:if>
								<c:if test="${fn:startsWith(str[1], 'full')}">
	   								<td style="width: auto;">Full Half</td>
								</c:if>
								
								<th style="width: auto;">Leave</th>
								<td style="width: auto;">${str[2]}</td>
								
								<c:choose>
									<c:when test="${str[3] != '-'}">
										<th class="center_class" style="width: auto;">Miscellaneous Leave Name</th>
	   									<td class="center_class" style="width: auto;">${str[3]}</td>
									</c:when>
									<c:otherwise>
										<th class="center_class" style="width: auto;" >Miscellaneous Leave Name</th>
		   								<td class="center_class" style="width: auto;"> - </td>
									</c:otherwise>
								</c:choose>
								
								
						</tr>
						
					</c:forEach>
				</table> --%>
          
          
          
          </div>
        </div>
        <!-- Box 6 --> 
        
      </div>
    </div>
    <!-- End dashboard --> 
  </div>
  
  <!-- End Main cont -->
<%@include file="footer.jsp" %>
