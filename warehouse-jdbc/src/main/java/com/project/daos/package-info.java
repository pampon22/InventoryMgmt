package com.project.daos;

/**
*Controllers: determine that I need to talk to the database. all it cares about is directing us to the right place
* addArtist()
* deleteArtist()
* findArtistById()
* findALlArtist()
*/

/**
*Service: in charge of the business logic. this actually gets us to the right spot. actually make sure it is valid query
* validation()
* addArtist() 
* 
*/


/** 
* DAOs: do the dirty work of talking to the database. we write the `select statements`, etc. in here
*  addArtist()
*  deleteArtist()
*  	have different DAOs for talking to different databases. MySQLDAO, MongoDBDAO, etc
*/