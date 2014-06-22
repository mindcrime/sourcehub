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
					<li>
						<g:link controller="project" action="view" id="${project.id}">${project.name}</g:link>
					</li>
				</g:each>
			</ul>
		</div>
	</body>
</html>