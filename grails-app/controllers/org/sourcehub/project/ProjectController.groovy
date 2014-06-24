package org.sourcehub.project

class ProjectController 
{
	def scaffold = false
	def projectService
	
	def create = 
	{
		[];
	}
	
	def save =
	{
		Project project = projectService.createProject( params.projectName, params.projectDescription, session.user )
		
		redirect( controller:'project', action:'view', id:project.id)	
	}
	
	def view =
	{
		Project project = projectService.findById( Long.parseLong(params.id));
		
		[project:project];	
	}
	
	def list =
	{
		List<Project> projects = projectService.findAllProjects();
		
		[projects:projects];
	}
	
	def edit =
	{
		[]
	}
	
	def update =
	{
		Project project = null;
		
		redirect( controller:'project', action:'view', id:project.id)
	}
	
	def listUserOwned =
	{
		// List the projects owned by this user
		List<Project> projects = projectService.findProjectsByOwner( session.user )
		[projects:projects]
	}
	

	def createRelease =
	{
		List<Project> availableProjects = projectService.findProjectsByOwner( session.user );
		
		[availableProjects:availableProjects];
	}	
	
	def saveRelease =
	{
		println "Params: ${params}";
		
		ProjectRelease release = projectService.createRelease( params.projectId, 
															   params.version,
															   params.releaseNotes );
														   
		redirect( controller:"project", action:"view", id:params.projectId );												   
														   
	}
}
