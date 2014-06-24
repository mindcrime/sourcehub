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
	
	public ProjectRelease createRelease( final String projectId, final String version,
										 final String releaseNotes )
	{
		println "version: ${version}";
		
		Project theProject = this.findById( Long.parseLong( projectId ));
		
		ProjectRelease release = new ProjectRelease();
		release.project = theProject;
		release.releaseVersion = version;
		release.releaseNotes = releaseNotes;
		theProject.addToReleases( release );

		theProject.save(flush:true);
		
		return release;
	}
	
	// TODO: add pagination support, overrides for retrieving for specific date
	// ranges?
	public List<ProjectRelease> getRecentReleases()
	{
		
		List<ProjectRelease> recentReleases = ProjectRelease.executeQuery( "select release from ProjectRelease as release order by dateCreated desc", [max:10] );
		
		return recentReleases;
	}
	
}
