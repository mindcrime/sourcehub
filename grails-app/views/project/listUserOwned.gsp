<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>SourceHub</title>
	</head>
	<body>
		<div class="starter-template">
		
			<ul>
			<g:each in="${projects}" var="project">
				<li><a href="#">${project.name}</a></li>
			</g:each>
			</ul>
			
		</div>
	</body>
