<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inicio</title>
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

	<section class="gallery-container">

		<div class="gallary">
			<center>
				<table>
					<thead>
						<tr>
							<th>PROGRAMACIÓN</th>
							<th>ASIGNATURAS</th>
							<th>COLEGIOS</th>
							<th>PROFESORES</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>
								<center>
									<a href="<%=request.getContextPath()%>/all"
										class="ov-btn-grow-spin" title="PROGRAMACIÓN DE CLASES"> <svg
											class="w-6 h-6" fill="none" color="black"
											stroke="currentColor" viewBox="0 0 24 24"
											xmlns="http://www.w3.org/2000/svg" width="200" height="200">
											<path stroke-linecap="round" stroke-linejoin="round"
												stroke-width="2"
												d="M12 8v4l3 3m6-3a9 9 0 11-18 0 9 9 0 0118 0z"></path></svg>
									</a>
								</center>

							</td>
							<td>
								<center>
									<a href="<%=request.getContextPath()%>/alla"
										class="ov-btn-grow-spin" title="ADMINISTRAR ASIGNATURAS">
										<svg class="w-6 h-6" fill="none" color="black"
											stroke="currentColor" viewBox="0 0 24 24"
											xmlns="http://www.w3.org/2000/svg" width="200" height="200">
											<path stroke-linecap="round" stroke-linejoin="round"
												stroke-width="2"
												d="M12 6.253v13m0-13C10.832 5.477 9.246 5 7.5 5S4.168 5.477 3 6.253v13C4.168 18.477 5.754 18 7.5 18s3.332.477 4.5 1.253m0-13C13.168 5.477 14.754 5 16.5 5c1.747 0 3.332.477 4.5 1.253v13C19.832 18.477 18.247 18 16.5 18c-1.746 0-3.332.477-4.5 1.253"></path></svg>
									</a>
								</center>
							</td>
							<td>
								<center>
									<a href="<%=request.getContextPath()%>/allc"
										class="ov-btn-grow-spin" title="ADMINISTRAR COLEGIOS"> <svg
											class="w-6 h-6" fill="none" color="black"
											stroke="currentColor" viewBox="0 0 24 24"
											xmlns="http://www.w3.org/2000/svg" width="200" height="200">
											<path stroke-linecap="round" stroke-linejoin="round"
												stroke-width="2"
												d="M8 14v3m4-3v3m4-3v3M3 21h18M3 10h18M3 7l9-4 9 4M4 10h16v11H4V10z"></path></svg>
									</a>
								</center>
							</td>
							<td>
								<center>
									<a href="<%=request.getContextPath()%>/allp"
										class="ov-btn-grow-spin" title="ADMINISTRAR PROFESORES"> <svg
											class="w-6 h-6" fill="none" color="black"
											stroke="currentColor" viewBox="0 0 24 24"
											xmlns="http://www.w3.org/2000/svg" width="200" height="200">
											<path d="M12 14l9-5-9-5-9 5 9 5z"></path>
											<path
												d="M12 14l6.16-3.422a12.083 12.083 0 01.665 6.479A11.952 11.952 0 0012 20.055a11.952 11.952 0 00-6.824-2.998 12.078 12.078 0 01.665-6.479L12 14z"></path>
											<path stroke-linecap="round" stroke-linejoin="round"
												stroke-width="2"
												d="M12 14l9-5-9-5-9 5 9 5zm0 0l6.16-3.422a12.083 12.083 0 01.665 6.479A11.952 11.952 0 0012 20.055a11.952 11.952 0 00-6.824-2.998 12.078 12.078 0 01.665-6.479L12 14zm-4 6v-7.5l4-2.222"></path></svg>
									</a>
								</center>
							</td>
						</tr>
					</tbody>
				</table>
			</center>

		</div>

	</section>
</body>
<style>
body {
  background: linear-gradient(115deg, rgba(0, 29, 61, 0.6), rgba(0, 53, 102, 0.9)),
    center/cover url("https://cdn.andro4all.com/andro4all/2022/01/Las-8-mejores-aplicaciones-para-estudiantes-universitarios.jpg") no-repeat;
   margin:0px;
overflow-x:hidden !important;
font-family:var(--primaryfont);
background-color:var(--lite);
padding-bottom: 220px;
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

.gallery-container {
    display: flex;
    justify-content: center;
    border-color: black;
    margin-top: 250px;

  }

  /*making the gallery flex and also adding wrap to make it a litle bit responsive */

  .gallary {
    width: 100%;
    display: flex;
    justify-content: center;
    align-items: center;
    flex-wrap: wrap;
    gap: 20px;
  }

/* styling the images */
th {
	color: white;
	font-size: 25px;
}

td {
	width: 250px;
	height: 250px;
	object-fit: cover;
	border-radius: 10px;
	background: white;
	justify-content: center;
	border-bottom: solid 5px gray;
	border-right: solid 5px gray;
	
}

td:hover {
	width: 250px;
	height: 250px;
	object-fit: cover;
	border-radius: 10px;
	background: white;
	justify-content: center;
	border-top: solid 5px gray;
	border-left: solid 5px gray;
	border-bottom: solid 0px gray;
	border-right: solid 0px gray;
}

/*** ESTILOS BOTÓN GROW SPIN ***/
.ov-btn-grow-spin {
  background: #fff; /* color de fondo */
  color: #4741d7; /* color de fuente */
  padding: 16px 20px;
  border-radius: 10px; /* redondear bordes */
  position: relative;
  z-index: 1;
  overflow: hidden;
  display: inline-block;
}
.ov-btn-grow-spin:hover {
  color: #fff;/* color de fuente hover */
}
.ov-btn-grow-spin::after {
  content: "";
  background:var(--primary); /* color de fondo hover */
  position: absolute;
  z-index: -1;
  padding: 20px 20px;
  display: block;
  left: 0;
  right: 0;
  top: 0;
  bottom: 0;
  transform: scale(0, 0) rotate(-180deg);
  transition: all 0.3s ease;
}
.ov-btn-grow-spin:hover::after {
  transition: all 0.3s ease-out;
  transform: scale(1, 1) rotate(0deg);
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