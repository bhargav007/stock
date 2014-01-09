<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>TEST</title>
<link href="css/style.css" type="text/css" rel="stylesheet" />
<link href="css/jquery-ui-1.10.3.custom.css" type="text/css" rel="stylesheet" />
<link href="css/jquery-ui-1.10.3.custom.min.css" type="text/css" rel="stylesheet" />
<link rel="shortcut icon" type="image/x-icon" href="images/favicon.ico" />
<!--[if IE]><link rel="stylesheet" type="text/css" href="css/ie.css" /><![endif]-->
<script src="js/jquery-1.9.1.js"></script>
<script src="js/jquery-ui.js"></script>
<script src="js/jquery-ui-sliderAccess.js"></script>
<script src="js/jquery-ui-timepicker-addon.js"></script>
<script src="js/jquery-ui-timepicker-addon.min.js"></script>
<script src="js/menu.js"></script>
<link href="css/menu.css" type="text/css" rel="stylesheet" />
<script type="text/javascript">

ddsmoothmenu.init({
	mainmenuid: "smoothmenu1", //menu DIV id
	orientation: 'h', //Horizontal or vertical menu: Set to "h" or "v"
	classname: 'nav', //class added to menu's outer DIV
	//customtheme: ["#1c5a80", "#18374a"],
	contentsource: "markup" //"markup" or ["container_id", "path_to_menu_file"]
})
ddsmoothmenu.init({
	mainmenuid: "smoothmenu2", //Menu DIV id
	orientation: 'v', //Horizontal or vertical menu: Set to "h" or "v"
	classname: 'ddsmoothmenu-v', //class added to menu's outer DIV
	method: 'toggle', // set to 'hover' (default) or 'toggle'
	arrowswap: true, // enable rollover effect on menu arrow images?
	//customtheme: ["#804000", "#482400"],
	contentsource: "markup" //"markup" or ["container_id", "path_to_menu_file"]
})
</script>
</head>
<body>
<div id="wrapper"> 
  	<div id="header">
    	<div class="logo"> 
    		<a href="index.html"> 
    			<!-- <img src="images/bhargav.jpg" width="124" alt="" /> -->Go To Home 
    		</a> 
    	</div>
    	<div class="wc">
      		<p>Welcome, 
      			<span>
      				<c:out value="${sessionScope.username}"/>
      			</span>
      			<br />
        	<a href="logout.action">Logout</a></p>
    	</div>
  	</div>
  	
  	<div id="menu" >
 		<ul>
    		<li class="active"><a href="#">Dashboard</a></li>
    		<li><a href="add_worker.action">Add Worker</a></li>
    		<li><a href="add_worker_detail.action">Worker Detail</a></li>
    		<li><a href="onloadcategory.action">Category</a></li>
    		<li><a href="onloaditem.action">Items</a></li>
  		</ul>
 	</div>
</div>
 </body>
 </html>
 