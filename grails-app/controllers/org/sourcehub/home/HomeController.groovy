package org.sourcehub.home

import org.sourcehub.project.ProjectRelease

class HomeController 
{
	def projectService
	
	def index = 
	{
		List<ProjectRelease> recentReleases = projectService.getRecentReleases();
		
		[recentReleases:recentReleases];
	}
	
	def about =
	{
		[]
	}
	
	def contact =
	{
		[]
	}
}
