package it.unical.asde.slotmachineservice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import it.unical.asde.slotmachineservice.model.GameStatus;
import it.unical.asde.slotmachineservice.repositories.GameStatusDAO;

/* In order to test the persistence we can use a JUnit test. To use JUnit with
 * Spring we use the class that is annotated with @SpringBootTest and automa-
 * tically we have all the beans. 
 * JUnit is a testing a framework for Java is automatically included if we crea-
 * te a new Spring project. 
 * JUnit is a way to test the application programmatically, without using prints
 * and so on. 
 */

@SpringBootTest
class SlotMachineServiceApplicationTests {
	
	// Here we can add the Spring Components.
	
	/* For example we can add the GameStatusDAO and we annotate it using
	 * @Autowired. We are adding a repository for saving the GameStatus to 
	 * check that the database can be used to save the GameStatus.
	 */
	@Autowired
	private GameStatusDAO repository;
	
	@Test
	void contextLoads() {
	}
	
	/* We define a test using the @Test annotation, in order to try to save
	 * a GameStatus.
	 * With the save method we save a GameStatus (for example a new GameSta-
	 * tus).
	 * Then we check that there is at least one GameStatus in the repository.
	 * In order to check something we defined some assertions. 
	 * We are actually executing SQL code, when we execute the save method HI-
	 * -BERNATE will be executed, HIBERNATE looks that we are saving an entity
	 * it looks at the definition of GameStatus, it finds that there is a pri-
	 * mary key, there is the coins column and it will create a SQL query for 
	 * saving it and it will execute the SQL query.
	 * Also in the count method HIBERNATE will execute a query, so in this ca-
	 * se we will execute two SQL queries.
	 * Now that we see that our implementation is working we can replace the imp-
	 * lementation of the service to make the application truly persistent.
	 */
	@Test
	public void databaseWorks() {
		repository.save(new GameStatus("ciccio", 200));
		assertEquals(2, repository.count());
		assertEquals(1, repository.findByCoins(200).size());
	}

}
