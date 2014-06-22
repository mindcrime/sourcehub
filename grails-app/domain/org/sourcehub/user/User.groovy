package org.sourcehub.user

import java.util.Date;


class User 
{
	String uuid;
	String userId;
	String password;
	String homepage;
	String fullName;
	String email;
	String bio;
	Date dateCreated;
	
	
	public User()
	{
		this.uuid = java.util.UUID.randomUUID().toString();
	}
	
	static constraints = {
		userId( size:3..100, unique:true )
		password( size:6..256 )
		homepage( url:true, nullable:true )
		dateCreated()
	}
	
	
    static hasMany = [ roles: Role, permissions: String ]

	
	static mapping = 
	{
		table 'uzer'
	}
}
