package org.sourcehub.project

class ProjectRelease 
{
	Project project
	String releaseNotes
	String version
	
	static belongsTo = Project
}
