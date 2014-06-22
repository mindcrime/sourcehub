package org.sourcehub.user

class Role 
{
    String name
	Date dateCreated
	
    static hasMany = [ users: User, permissions: String ]
    static belongsTo = User

    static constraints = 
	{
        name(nullable: false, blank: false, unique: true)
    }

	static mapping = {
		permissions lazy: false;
	}

	static fetchMode = [permissions:'eager'];
			
	public String toString()
	{
		return "id: ${id}, name: ${name}";
	}
	
	
}
