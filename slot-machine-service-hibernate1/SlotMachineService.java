package it.unical.asde.slotmachineservice.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.unical.asde.slotmachineservice.model.Bet;
import it.unical.asde.slotmachineservice.model.BetResult;
import it.unical.asde.slotmachineservice.model.GameStatus;
import it.unical.asde.slotmachineservice.repositories.GameStatusDAO;

/* In this service there are two methods. 
 * 1. The first method is for betting, that gets the bet object which contains
 * 	  the amount of coins to bet and the user that made the bet, then there are
 * 	  some operations, and finally is returned the result that they have been 
 * 	  computed. In this case what we want is that the amount of coins is stored
 * 	  in the database essentially. When we bet we update the data in the databa-
 *	  -se and we return the new amount. 
 */

@Service
public class SlotMachineService {
	
	/* Here we add a private GameStatusDAO field and we annotate it with @Auto-
	 * -wired because we have to inject it.
	 * In this case we want to define the code in order to make the data persis-
	 * sted.
	 */
	@Autowired
	private GameStatusDAO gameStatusDAO;

	public final static int SLOTS = 3;
	public final static int VALUES = 3;
	public final static int INITIAL_COINS = 200;
	
	/* In the bet method we first get the coins of a certain user finded by
	 * Id. At the end we want to modify the user with the amount of coins after
	 * the bet. 
	 * Basically we change the implementation of the bet method so one player is 
	 * betting:
	 * 1. the betting player is bet.getUser().
	 * 2. bet.getBet() gives us the number of coins to bet.
	 * 3. gameStatus.getCoins() gives us the number of coins that the user alrea-
	 * 	  dy has.
	 * 4. we execute the random computation of the slots;
	 * 5. according of the result of the slots computation we update the amount 
	 *    of the coins of the user.
	 * 6. we deleting the old gameStatus and we put a new GameStatus;
	 * 7. we returns the bet result.
	 * In this case we should also synchronize this method in order to avoid 
	 * the inconsistences. 
	 */
	public synchronized BetResult bet(Bet bet) {
		String user = bet.getUser();
		GameStatus gameStatus = gameStatusDAO.findById(user).get();
		int betting = bet.getBet();
		int coins = gameStatus.getCoins();
		Random rand = new Random();
		ArrayList<Integer> slots = new ArrayList<Integer>();
		for(int i=0;i < SLOTS;i++) {
			slots.add(rand.nextInt(VALUES));
		}
		
		if((slots.get(0) == slots.get(1)) && (slots.get(1) == slots.get(2))) {
			coins += (betting*9);
		} else {
			coins -= betting;
		}
		
		gameStatusDAO.deleteById(user);
		gameStatusDAO.save(new GameStatus(user, coins));
			
		return new BetResult(coins, slots);
		
		
	}
	
	/* Here we are initializing the game and the user can be already there or not 
	 * now we can check in the repository if the user exists and so on.
	 * In this case we are defining two query (so this is not very correct unless
	 * we synchronize the method).
	 * Here we are checking if the username is already in the database and if it 
	 * is, we will find it and we will return it.
	 * These methods are already provided by the Spring interface.
	 * In this case if the object is not in the database we want to create a new 
	 * instance (in this case a new instance of GameStatusDao).
	 * In this case we can just return the saving because the saving will just re-
	 * -turn the object.
	 * This method is used everytime we go on the slot machine page, now it is chec-
	 * king if the user is already playing then it is already in the database other-
	 * wise it create a new instance.
	 * It try to find the GameStatus by id (which is the username) and if exists an 
	 * instance then the method will return it otherwise it means that we have a 
	 * new player and we define e new GameStatus with an initial amount of coins.
	 */
	public synchronized GameStatus initGame(String username) {
		
		if(gameStatusDAO.existsById(username)) {
			return gameStatusDAO.findById(username).get();
		}
		return gameStatusDAO.save(new GameStatus(username, INITIAL_COINS));
		
	}
	
}
