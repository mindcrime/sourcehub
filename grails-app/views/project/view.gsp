<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>SourceHub</title>
	</head>
	<body>
		<div class="starter-template">
		
			<div class="row">
				
				<div class="col-md-8">
					<label for="projectName">Name: </label> <span id="projectName">${project.name}</span>
					<br />
					<label for="projectDescription">Description: </label> <span id="projectDescription">${project.description}</span>
				</div>
				<div class="col-md-4">
				 <!--  edit button goes here  -->
				 <g:link controller="project" action="edit">
						<button type="button" class="btn btn-lg btn-default">Edit Project</button>
					</g:link>
				</div>
			</div>
			<div class="row">
				<h3>Recent Releases</h3>
				<ul>
				<g:each in="${project.releases}" var="release">
					<li>${release.releaseVersion} - ${release.releaseNotes}</li>
				</g:each>
				</ul>
			</div>
		</div>
	</body>
</html>