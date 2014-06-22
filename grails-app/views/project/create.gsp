<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>SourceHub</title>
	</head>
	<body>
		<div class="starter-template">
		
			<g:form controller="project" action="save" method="POST">
				<label for="projectName">Name:</label><g:textField name="projectName"/>
				<br />
				<label for="projectDescription">Description:</label><g:textField name="projectDescription"/>
				<br />
				<g:submitButton name="Submit"/>
			</g:form>
		
		
		</div>
	</body>
</html>