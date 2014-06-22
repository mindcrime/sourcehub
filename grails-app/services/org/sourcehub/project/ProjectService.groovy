package org.sourcehub.project

class ProjectService 
{
	public Project createProject( final String projectName, final String projectDescription )
	{
		Project project = new Project();
		project.name = projectName;
		project.description = projectDescription;
		
		project.save(flush:true);
		
		return project;
	}
	
	public Project findById( Long id )
	{
		Project project = Project.findById( id );
		
		return project;
	}
	
	public List<Project> findAllProjects()
	{
		List<Project> projects = Project.executeQuery( "select project from Project as project" );
		
		return projects;
	}
	
}
