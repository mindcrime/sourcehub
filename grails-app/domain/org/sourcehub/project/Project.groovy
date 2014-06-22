package org.sourcehub.project

class Project 
{
	String name
	String description
		
	static constraints=
	{
		name( nullable:false, maxSize:2048)
		description( nullable:false, maxSize:5048 )
	}
	
	static hasMany = [troveCategories:String, tags:String, languages:String]
	
}
