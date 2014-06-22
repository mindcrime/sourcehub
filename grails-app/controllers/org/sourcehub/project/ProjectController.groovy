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
		Project project = projectService.createProject( params.projectName, params.projectDescription)
		
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
	
}
