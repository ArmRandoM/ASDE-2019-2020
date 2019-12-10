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
 * The CrudRepository is the preferred way to perform data access operations
 * becouse they are ready built by HIBERNATE.
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

	/* If we want to define a method that returns the set of GameStatus that
	 * have more fo 200 coins. We are following a naming convention in order
	 * to define a specialized query.
	 * Another thing that we can do in SQL is to order the instances using so-
	 * me property using OrderBy followed by the name of the column used in there
	 * ordering.
	 * Now we are getting all the GameStatus which have more than a given amount
	 * of coins and we are ordering the result with the name of the user, with
	 * a lexicographic order.
	 * By default the order is ascending if we want the descending oder we just
	 * add desc at the end.
	 */

	//Ascending order
	List<GameStatus> findByCoinsGreaterThanOrderByUser(Integer coins);

	//Descending order
	List<GameStatus> findByCoinsGreaterThanOrderByUserDesc(Integer coins);
}
