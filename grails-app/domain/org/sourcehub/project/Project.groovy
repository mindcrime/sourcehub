package org.sourcehub.project

import org.sourcehub.user.User

class Project 
{
	Long id
	String name
	String description
	User owner
	Date dateCreated
		
	static constraints=
	{
		name( nullable:false, maxSize:2048)
		description( nullable:false, maxSize:5048 )
		owner( nullable:true)
	}
	
	static hasMany = [releases:ProjectRelease, troveCategories:String, tags:String, languages:String]
	static mapping =
	{
		releases lazy: false
	}
}
