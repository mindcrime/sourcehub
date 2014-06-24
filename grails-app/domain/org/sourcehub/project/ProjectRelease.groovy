package org.sourcehub.project

class ProjectRelease 
{
	Long id;
	Project project
	String releaseNotes
	String releaseVersion
	Date dateCreated
	
	static belongsTo = Project
}
