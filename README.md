Some source code for a first stab at a site to fill in the gap
left when Dice decided to (essentially) mothball Freecode.com 
(the old Freshmeat.net).

Some references:

* [http://freecode.com/](http://freecode.com/)
* [ESR blog post on a replacement](http://esr.ibiblio.org/?p=5948)
* [A Hacker News post](https://news.ycombinator.com/item?id=7925135)
* [The "Trove" Taxonomy](https://wiki.linuxfoundation.org/en/Osapa:SF/Freshmeat_Trove)
* [Description Of A Project - DOAP](https://github.com/edumbill/doap/wiki)
* [Friend Of A Friend - FOAF](http://www.foaf-project.org/)

License:

[Apache License v2](http://www.apache.org/licenses/LICENSE-2.0.html)

Deploy / Run:

You'll need Grails (2.2.3) installed and working (which implies a JVM as well).  You'll also need Postgresql.   Create a database
named "freshermeat" in Postgres.  You don't need to do anything to create tables, the app will do that when it starts up.  If you have
user authentication turned on, you'll need to edit DataSource.groovy and plug in the correct postgres username/password.  

After cloning this repo, creating the database, and (possibly) configuring a username/password in DataSource.groovy, you can run
the app by running "grails run-app" in the project base directory.   By default it will be available at http://localhost:8080/sourcehub

The bootstrap config creates a handful of test users, so you can login as something like testuser1 (or testuser2, and so on, up to testuser10) with password 'secret'.

---
Installing Grails:

If you do not have Grails already, here's how you set it up.

1. Download Grails 2.2.3.  The simplest way to do this is simply "wget -O grails-2.2.3.zip http://dist.springframework.org.s3.amazonaws.com/release/GRAILS/grails-2.2.3.zip"

2. unzip the grails distribution and put it somewhere convenient.  Example:
    unzip grails-2.2.3.zip
    sudo mv grails-2.2.3 /opt/

    Of course, you don't have to put it in /opt, you can put the grails distribution anywhere you like.

3. Add the grails "bin" directory to your path.  The easiest way to do this is to add a script to /etc/profiles.d/
that looks something like this:

    \#!/bin/bash                                                                     
    export PATH="/opt/grails-2.2.3/bin:$PATH"

    OR you could add the path to your .bashrc file (or corresponding file for whatever shell you happen to use)

4. Once the path is set, you know you're good to go if you can run the command "grails -version" and get output like

> Grails version: 2.2.3


