package org.sourcehub.user


class UserService 
{

	public User findUserByUserId( final String userId )
	{
		def user = User.executeQuery( "select user from User as user where user.userId = ?", [userId] );
		return user.get(0);
	}
	
	public User findUserByUserIdAndPassword( final String userId, final String password )
	{
		def user = User.findByUserIdAndPassword( userId, password );
		return user;
	}
	
	public void updateUser( final User user )
	{
		if( !user.save() )
		{
			log.error( "Updating user: ${user.userId} FAILED");
			// user.errors.allErrors.each { p rintln it };
		}
	}

	public Role findRoleByName( final String name )
	{
		println "searching for AccountRole named ${name}";
		
		List<Role> roles = Role.executeQuery( "select role from Role as role where role.name = :name", [name:name]);
		
		Role role = null;
		if( roles.size == 1 )
		{
			role = roles[0];
		}

		println "returning role ${role}";
		return role;
	}
	
	public Role createRole( Role role )
	{
		
		println "UserService.createRole() - about to create role: ${role.toString()}";
	
		if( !role.save(flush: true))
		{
			role.errors.each { println it };
			throw new RuntimeException( "couldn't create Role: ${role.toString()}" );
		}
		
		println "returning role: ${role}";
		return role;
	}
		
}