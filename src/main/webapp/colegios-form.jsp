<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Insertar / Actualizar Colegios</title>
</head>
<body>
<header>
<div class="header">
<section>
<span class="cross parallelogram"><img src="https://xavia.com.co/wp-content/uploads/2020/09/Logo.png" class="logo skew-fix" alt="LOGO."></span>
</section>
<section>
<div class="top-tab">
<span>
<a href="#"><i class="fa fa-phone"></i> (+57)315-286-5392</a>
<a href="emailto:soporte@xavia.com.co"><i class="fa fa-envelope"></i>soporte@xavia.com.co</a>
</span>
</div>
<div class="topnav" id="myTopnav">
<a href="#"><img src="https://xavia.com.co/wp-content/uploads/2020/09/Logo.png" id="res_logo"></a>
<a class="active" href="index.jsp">Inicio</a>
<a class="active" href="<%=request.getContextPath()%>/all">Programación</a>
<a href="<%=request.getContextPath()%>/alla">Asignaturas</a>
<a href="<%=request.getContextPath()%>/allc">Colegios</a>
<a href="<%=request.getContextPath()%>/allp">Profesores</a>
<a href="javascript:void(0);" style="font-size:15px;" class="icon" onclick="myFunction()">&#9776;</a>
</div>
</section>
</div>
</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${colegios != null}">
					<form action="updatec" method="post" class="formulario">
				</c:if>
				<c:if test="${colegios == null}">
					<form action="insertc" method="post" class="formulario">
				</c:if>
				<caption>
					<h3>
						<c:if test="${colegios != null}"> EDITAR COLEGIO </c:if>
						<c:if test="${colegios == null}"> INSERTAR NUEVO COLEGIO </c:if>
					</h3>
				</caption>
				<c:if test="${colegios != null}">
					<input type="hidden" name="id" value="<c:out value='${colegios.id}' />" />
				</c:if>
				<fieldset class="form-group">
					<legend>DEPARTAMENTO</legend> 
					<input type="text" value="<c:out value='${colegios.departamento}' />" class="form-control" name="departamento" required="required">
				</fieldset>
				<fieldset class="form-group">
					<legend>NOMBRE COLEGIO</legend> 
					<input type="text" value="<c:out value='${colegios.nombre}' />" class="form-control" name="nombre" required="required">
				</fieldset>
				<br>
				<button type="submit" class="btn btn-info">Guardar</button>
				</form>
			</div>
		</div>
	</div>
</body>
<style>
body {
  background: linear-gradient(115deg, rgba(0, 29, 61, 0.6), rgba(0, 53, 102, 0.9)),
    center/cover url("https://cdn.andro4all.com/andro4all/2022/01/Las-8-mejores-aplicaciones-para-estudiantes-universitarios.jpg") no-repeat;
   margin:0px;
overflow-x:hidden !important;
font-family:var(--primaryfont);
background-color:var(--lite);
padding-bottom: 100px;
}
/*CUSTOM SCROLL BAR*/
*,html{
scroll-behavior: smooth;
}
*, *:after, *:before {
-webkit-box-sizing: border-box;
-moz-box-sizing: border-box;
box-sizing: border-box;
}
:root{
scrollbar-color: rgb(210,210,210) rgb(46,54,69) !important;
scrollbar-width: thin !important;
--white:#fff;
--black:#131417;
--primary:#96161f;
--primarylite:#fd242d;
--gray:#6d7175;
--dark:#232331;
--darklite:#364256;
--lite:#f8f9fa;
--primaryfont:'Roboto Condensed', sans-serif;
--secondaryfont:'Source Sans Pro', sans-serif;
}
::-webkit-scrollbar {
height: 12px;
width: 8px;
background: var(--dark);
}
::-webkit-scrollbar-thumb {
background: gray;
-webkit-box-shadow: 0px 1px 2px rgba(0, 0, 0, 0.75);
}
::-webkit-scrollbar-corner {
background: var(--dark);
}

/*DEFAULT*/
.title, .sub-title{
font-family:var(--secondaryfont);
}

a{
text-decoration:none;
}

li{
list-style:none;
}

a, input, textarea, select, button{
outline:none !important;
transition:0.5s;
}

fieldset{
border:0;
}

img{
max-width:100%;
min-width:100%;
}

em{
font-style:normal;
color:var(--primary);
}

.btn1, .btn2{
padding:20px 40px;
border-radius:40px;
text-align:center;
display:inline-block;
border:0;
}

.btn1{
background-color:var(--primary);
color:var(--white);
}

.btn1:hover{
background-color:var(--primarylite);
}

.btn2{
background-color:var(--dark);
color:var(--white);
}

.btn2:hover{
background-color:var(--darklite);
}

.title_header{
width:100%;
margin:2vh auto;
text-align:center;
color:var(--dark);
display:flex;
align-items:center;
justify-content:left;
}

.title_header section{
width:100%;
text-align:left;
}

.title_header section p{
font-weight:200;
}

.title_header .title{
font-size:2em;
color:var(--dark);
}

.title_header .sub-title{
font-size:1.5em;
color:var(--gray);
}

.border-shape {
background: var(--primary) none repeat scroll 0 0;
color: #fff;
display: block;
height: 3px;
left: 0;
margin: 20px auto;
position: relative;
right: 0;
text-align: center;
top: 0;
width: 80px;
}

.border-shape::before {
background: var(--primary) none repeat scroll 0 0;
bottom: 0;
content: "";
height: 1px;
left: 80px;
margin: 0 auto;
position: absolute;
text-align: center;
top: 1px;
width: 100%;
}

.border-shape::after {
background: var(--primary) none repeat scroll 0 0;
bottom: 0;
content: "";
height: 1px;
margin: 0 auto;
position: absolute;
right: 80px;
text-align: center;
top: 1px;
width: 100%;
}

.bg_overlay{
position:absolute;
top:0;
z-index:1;
background-color:rgba(1,1,1,0.7);
width:100%;
height:100%;
}

::-webkit-input-placeholder {
opacity: 1 !important;
}

:-moz-placeholder {
opacity: 1 !important;
}

::-moz-placeholder {
opacity: 1 !important;
}

:-ms-input-placeholder {  
opacity: 1 !important;
}

select{
-webkit-appearance: none;
-moz-appearance: none;
background-image: url("data:image/svg+xml;utf8,<svg fill='black' height='24' viewBox='0 0 24 24' width='24' xmlns='http://www.w3.org/2000/svg'><path d='M7 10l5 5 5-5z'/><path d='M0 0h24v24H0z' fill='none'/></svg>");
background-repeat: no-repeat;
background-position-x: 99%;
background-position-y: 10px;
border: 1px solid #dfdfdf;
border-radius: 2px;
margin-right: 4rem;
padding: 1rem;
padding-right: 4rem;
}

.half-column{
display:flex;
align-items:Center;
}

@media (max-width:1180px){
.half-column{
display:block;
}
}

@media (max-width:820px){
.btn1, .btn2{
padding:10px 15px;
}
.title_header{
width:100%;
display:block;
text-align:center;
}
.title_header .title{
font-size:1.3em;
}
.title_header section{
padding:0rem 0!important;
text-align:center;
margin:0 auto !important;
}
}


/*HEADER*/
header{
width:100%;
}

.header{
width:100%;
position:relative;
display:flex;
align-items:Center;
}

.header section{
width:100%;
overflow:hidden;
}

.header section:nth-child(1){
width:15%;
}

.cross {
background:var(--primary);
display:inline-block;
font-size:2em;
padding:.1em 2em;
text-decoration:none;
position:absolute;
left:-5%;
top:0;
display:flex;
align-items:center;
justify-content:center;
width:20%;
}

.parallelogram{
transform: skew(-20deg);
}

.skew-fix{
display:inline-block;
transform: skew(20deg);

}

.header .logo{
filter: brightness(0) invert(1);
padding:1rem 2rem;
}

.top-tab{
width:100%;
background-color:var(--dark);
display:flex;
align-items:center;
justify-content:Center;
padding:0.6rem 1rem;
padding-left:1rem;
}

.top-tab span{
width:100%;
text-align:left;
white-space:nowrap;
}

.top-tab span a{
margin:0 5px;
color:var(--white);
white-space:nowrap;
}

.top-tab span:nth-child(1) a .fa{
margin:0 40px;
}

@media (max-width:1120px){
.header section:nth-child(1){
display:none;
}
.cross {
position:static;
}
.header .logo{
width:100%;
}
.top-tab{
padding-left:0rem;
}
.top-tab span:nth-child(1){
display:none;
}
.top-tab span:nth-child(2){
display:flex;
align-items:center;
justify-content:Center;
}
}

/*NAV*/
.topnav {
overflow: hidden;
background-color: var(--white);
padding-left:0rem;
}

.topnav a {
float: left;
display: block;
color: var(--dark);
text-align: center;
padding: 14px 16px;
text-decoration: none;
font-size: 18px;
margin:10px 20px;
}

.active {
color: var(--primary);
}

.topnav .icon {
display: none;
}

.dropdown {
float: left;
overflow: hidden;
}

.dropdown .dropbtn {
font-size: 18px;    
border: none;
outline: none;
color: var(--dark);
padding: 14px 16px;
background-color: inherit;
font-family: inherit;
margin: 10px 20px;
}

.dropdown-content {
display: none;
position: absolute;
background-color: #f9f9f9;
min-width: 160px;
box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
z-index: 1;
border-top:2px solid var(--primary);
}

.dropdown-content a {
float: none;
color: black;
padding: 12px 16px;
text-decoration: none;
display: block;
text-align: left;
margin:0;
}

.topnav a:hover, .dropdown:hover .dropbtn {
background-color: #555;
color: white;
}

.dropdown-content a:hover {
background-color: #ddd;
color: black;
}

.dropdown:hover .dropdown-content {
display: block;
}

#res_logo{
display:none;
}

@media screen and (max-width: 1120px) {
#res_logo{
display:inline-block;
width:200px;
}
.topnav a:not(:first-child), .dropdown .dropbtn {
display: none;
}
.topnav a.icon {
float: right;
display: block;
}
}

@media screen and (max-width: 1120px) {
.topnav {
padding-left:0;
}
.topnav.responsive {position: relative;}
.topnav.responsive .icon {
position: absolute;
right: 0;
top: 0;
}
.topnav.responsive a {
float: none;
display: block;
text-align: left;
margin:0px;
}
.topnav.responsive #res_logo{
max-width:200px;
min-width:200px;
}
.topnav.responsive .dropdown {float: none;}
.topnav.responsive .dropdown-content {position: relative;}
.topnav.responsive .dropdown .dropbtn {
display: block;
width: 100%;
text-align: left;
margin:0px;
}
}
h3 {
	text-align: center;
	font-size: 25px;
	color: #ffffff;
}

fieldset {
	max-width: 700px;
	padding: 5px;
	border: 1px solid #FFFFFF;
}

legend {
	color: #ffffff;
	font-weight: bold;
	padding: 10px;
}

.formulario {
background-color:var(--dark);
	width: 700px;
	margin: 20px auto;
	padding: 20px;
	border-radius: 5px;
	text-align: center;
}

.formulario input {
	display: block;
}

.formulario input[type="text"], .formulario input[type="email"],
	.formulario input[type="number"], .formulario input[type="date"] {
	width: 100%;
	padding: 20px;
	margin-bottom: 20px;
	border-radius: 3px;
	border: 1px solid #226fc1;
	font-family: Arial, Helvetica, sans-serif;
	font-size: 16px;
}

.formulario input[type="text"]:focus, .formulario input[type="email"]:focus,
	.formulario input[type="number"]:focus , .formulario input[type="date"]:focus{
	border: 2px solid #4fb560;
}

.formulario button[type="submit"] {
	width: 200px;
	margin: 0 auto;
background:var(--primary);
	border: 1px solid #FFFFFF;
	color: #FFFFFF;
	padding: 10px;
	cursor: pointer;
	font-size: 16px;
	border-radius: 3px;
}

.formulario button[type="submit"]:hover {
	background: #FFFFFF;
	color: Green;
	font-size: 20px;
}

.titulo {
	background: #fff;
	width: 450px;
	margin: 20px auto;
	padding: 20px;
	border-radius: 5px;
	font-family: Arial, Helvetica, sans-serif;
	font-size: 16px;
	text-align: center;
}

.formulario input[type="checkbox"]{
	width: 100%;
	margin-bottom: 20px;
	border-radius: 3px;
	border: 1px solid #226fc1;
	font-family: Arial, Helvetica, sans-serif;
	font-size: 16px;
}

textarea {
	width: 100%;
	padding: 20px;
	margin-bottom: 20px;
	border-radius: 3px;
	border: 1px solid #226fc1;
	font-family: Arial, Helvetica, sans-serif;
	font-size: 16px;
}
</style>
<script type="text/javascript">
function myFunction() {
	  var x = document.getElementById("myTopnav");
	  if (x.className === "topnav") {
	    x.className += " responsive";
	  } else {
	    x.className = "topnav";
	  }
	}

</script>
</html>