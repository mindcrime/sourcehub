package org.sourcehub.project

import org.sourcehub.user.User

class ProjectService 
{
	public Project createProject( final String projectName, final String projectDescription, final User owner )
	{
		Project project = new Project();
		project.name = projectName;
		project.description = projectDescription;
		project.owner = owner;
		
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
	
	public List<Project> findProjectsByOwner( final User owner )
	{
		List<Project> projects = new ArrayList<Project>();
		
		List<Project> results = Project.executeQuery( "select project from Project as project where project.owner = :owner", [owner:owner] );
		
		if( results != null )
		{
			projects.addAll( results );
		}
		
		return projects;
	}
}
