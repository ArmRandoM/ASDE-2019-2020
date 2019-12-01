package it.unical.asde.slotmachineservice.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.unical.asde.slotmachineservice.model.GameStatus;

/* Right now we are missing the DAO, we have the DTO, we have the object that we
 * want to save but we are missing a class that is responsible for saving the o-
 * -bject.
 * The CrudRepository interface that has to be extent allows to save and access 
 * data from the database, this is very powerful.
 * The CrudRepository interface takes two parameters:
 * 1. the type of the entity that we are mapping (in this case the GameStatus).
 * 2. the type of the Id (in this case String).
 * This is very convenient because by writing this code we have a lot of method 
 * already implemented.
 * At this point this is a component of Spring, because it is saved here but it
 * is better to say that it is a Spring component. There is a dedicated Spring 
 * component called @Repository. 
 * @Repository is for annotating classes that have access to the database. 
 * Basically we didn't write any code, we are extending a Spring interface.
 * When we use this CRUD Repository if we use some specific convention on the 
 * name we can add some extra method for querying the database very easly.
 */


@Repository
public interface GameStatusDAO extends CrudRepository<GameStatus, String> {

	/* We can define specific queries, for example we can select all the ins-
	 * tances of GameStatus that have a specific amount of coins.
	 * By default there is findById. 
	 * Once we follow a specific convention on the name of the method it will 
	 * work without implementing the method.
	 * Here we add a method without implementing it, we follow a naming conven-
	 * tion and HIBERNATE defines for us the right SQL query.
	 */
	List<GameStatus> findByCoins(Integer coins);
	
}
