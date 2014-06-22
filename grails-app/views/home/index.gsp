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
        			<h1>Welcome to SourceHub</h1>
			
					<p class="lead">This might become "sourcehub.org" (or something else) -  a replacement for the now
					dormant freshmeat.net/freecode.com website.
					</p>
					
        		</div>
        	
        		<div class="col-md-4">
        		
        			
        			<shiro:notAuthenticated>
	        			<g:link controller="auth" action="login">
							<button type="button" class="btn btn-lg btn-default">Login</button>
						</g:link>
        				<br />
        				<g:link controller="project" action="create">
							<button type="button" class="btn btn-lg btn-default">Register</button>
						</g:link>
        				<br />
        			</shiro:notAuthenticated>
        		
        			<g:link controller="project" action="create">
						<button type="button" class="btn btn-lg btn-default">Create New Project</button>
					</g:link>
					<br />
					<g:link controller="project" action="create">
						<button type="button" class="btn btn-lg btn-default">My Projects</button>
					</g:link>
					<br />
					<g:link controller="project" action="createRelease">
						<button type="button" class="btn btn-lg btn-default">Announce Project Release</button>
					</g:link>
					
					<shiro:authenticated>
						<g:link controller="auth" action="signOut">
							<button type="button" class="btn btn-lg btn-warn">Logout</button>
						</g:link>
					</shiro:authenticated>
					
        		</div>
      		</div><!--  end "row" -->
		
			<div class="row">
				<hr />
				<b>New Releases...</b>
				
				<ul>
					<g:each in="${releases}" var="release">
						<li></li>
					</g:each>
				</ul>
			</div>
		
		</div>
		
	</body>
</html>