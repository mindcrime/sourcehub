<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>SourceHub</title>
	</head>
	<body>
		<div class="starter-template">
			
			<g:form controller="project" action="saveRelease" method="POST">
				<label>Select Project:</label>
				<g:select name="projectId" from="${availableProjects}" optionKey="id" optionValue="name" />
				<br />
				<label for="version">Version: </label><g:textField name="version"/>
				<br />
				<label for="version">Release Notes:</label><g:textField name="releaseNotes"/>		
				
				<g:submitButton name="Submit"/>
			</g:form>
		</div>
	</body>
</html>