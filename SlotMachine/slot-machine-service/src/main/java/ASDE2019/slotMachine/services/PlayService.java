package ASDE2019.slotMachine.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Service;

import ASDE2019.slotMachine.model.Person;

@Service
public class PlayService {
	
	public Integer coinsGenerator(List<Integer> triple, Integer coinsNumber) {
		return (triple.get(0).equals(triple.get(1)) && triple.get(1).equals(triple.get(2)))? coinsNumber*9 : coinsNumber * -1;
	}
	
	public boolean goodBet(Integer coinsNumber, Integer coinsNumberRequired) {
		return coinsNumberRequired <= coinsNumber;
	}
	
	public ArrayList<Integer> play(String username, Integer coinsNumber, Map<String, Person> username_persons)
	{
		ArrayList<Integer> numbers = new ArrayList<>();
		
		if( goodBet(username_persons.get(username).getCoinsNumber(), coinsNumber))
		{
			Random r = new Random();
			for( int i = 0; i < 3; i++)
				numbers.add(r.nextInt(2));
					
			Integer userCoinsNumber = username_persons.get(username).getCoinsNumber();
			Integer coinsGenerated = coinsGenerator(numbers, coinsNumber);
			username_persons.get(username).setCoinsNumber(userCoinsNumber + coinsGenerated);
		}
		return numbers;
	}
}
