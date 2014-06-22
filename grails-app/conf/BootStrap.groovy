import grails.util.Environment

import org.sourcehub.user.Role;
import org.sourcehub.user.User;

class BootStrap 
{
	def userService;
	

    def init = 
	{ servletContext ->
    
		switch( Environment.current )
		{
			case Environment.DEVELOPMENT:
				createRoles();
				createAdminUser();
				createSomeUsers();
				break;
			case Environment.PRODUCTION:
				log.info( "No special configuration required" );
				createRoles();
				createAdminUser();
				createSomeUsers();
				break;
		}
		
	}
    
	def destroy = 
	{
	}
	
	
	void createRoles()
	{
		
		println "Creating roles...";
		Role userRole = userService.findRoleByName( "user" );
		if( userRole != null )
		{
			println "Existing Role user found";
		}
		else
		{
			println "No existing Role user found, so creating now...";
			
		   userRole = new Role( name: "user" );
		   userRole.addToPermissions( "home:*" );		   
		   userRole = userService.createRole( userRole );
		   
		   if( !userRole )
		   {
			   println "Error creating userRole";
		   }

		}
		
		Role adminRole = userService.findRoleByName( "admin" );
		if( adminRole != null )
		{
			println "Existing Role admin found";
		}
		else
		{
			println "No existing Role admin found, so creating now...";
			
			adminRole = new Role( name: "admin" );
			
			adminRole.addToPermissions( "admin:*" );
						
			adminRole = userService.createRole( adminRole );
		
			if( !adminRole )
			{
				println "Error creating adminRole";
			}
			
		}

		
		
	}
	
	void createAdminUser()
	{
		
		Role userRole = userService.findRoleByName( "user" );
		
		if( userRole == null )
		{
			println "did not locate user role!";
		}
		
		
		Role adminRole = userService.findRoleByName( "admin" );
		if( adminRole == null )
		{
			println "did not locate admin role!";
		}
		
		if( !User.findByUserId( "admin" ))
		{
			log.info( "Fresh Database, creating ADMIN user" );
			def user = new User();
			
			user.userId = "admin";
			user.password = "secret";
			user.fullName = "Site Administrator";
			user.email = "admin@yourhost.com";
			user.bio = "";
			
			
			user.addToRoles( userRole );
			user.addToRoles( adminRole );
			
			if( !user.save() )
			{
				log.error( "Saving ADMIN user failed!");
			}
			
		}
		else
		{
			log.info( "Existing ADMIN user, skipping..." );
		}
		
	}
	
	
	void createSomeUsers()
	{
		Role userRole = userService.findRoleByName( "user" );
		
		if( userRole == null )
		{
			println "did not locate user role!";
		}
		
		
		Role adminRole = userService.findRoleByName( "admin" );
		if( adminRole == null )
		{
			println "did not locate admin role!";
		}
		
		
		if( !User.findByUserId( "prhodes" ))
		{
			log.info( "Fresh Database, creating PRHODES user" );
			def userPrhodes = new User();
				
			println "Could not find prhodes";
			println "Creating new prhodes user";
			userPrhodes = new User();
			userPrhodes.uuid = "abc123";
			userPrhodes.fullName = "Phillip Rhodes";
			userPrhodes.email = "motley.crue.fan@gmail.com";
			userPrhodes.userId = "prhodes";
			userPrhodes.password = "secret";
			userPrhodes.bio = "bio";
			 
			 
			userPrhodes.addToRoles( userRole );
			userPrhodes.addToRoles( adminRole );
			 
					
			if( !userPrhodes.save() )
			{
				log.error( "Saving PRHODES user failed!");
			}
			
		}
		else
		{
			log.info( "Existing PRHODES user, skipping..." );
		}
	
		for( int i = 0; i < 10; i++ )
		{
			if( !User.findByUserId( "testuser${i}" ))
			{
				
				log.info( "Fresh Database, creating TESTUSER ${i} user" );
				def user = new User();
				
				user = new User();
				user.fullName = "Test User${i}";
				user.email = "testuser${i}@example.com";
				user.userId = "testuser${i}";
				user.password = "secret";
				user.bio = "bio";
				 
				 
				user.addToRoles( userRole );
			   
				if( !user.save() )
				{
					log.error( "Saving TESTUSER ${i} user failed!");
					
					user.errors.allErrors.each { println it } 
					
				}
				
			}
			else
			{
				log.info( "Existing TESTUSER ${i} user, skipping..." );
			}
		}
	}
	
	
}
