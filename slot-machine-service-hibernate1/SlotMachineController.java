package it.unical.asde.slotmachineservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.unical.asde.slotmachineservice.model.Bet;
import it.unical.asde.slotmachineservice.model.BetResult;
import it.unical.asde.slotmachineservice.model.GameStatus;
import it.unical.asde.slotmachineservice.model.UsernameSelectionDTO;
import it.unical.asde.slotmachineservice.services.SlotMachineService;

/* This controller has two methods, one for betting and one for starting the game.
 * All the two methods are delegating the implementation to the service.
 */

@RestController
public class SlotMachineController {

	
	@Autowired
	private SlotMachineService slotMachineService;
	
	@CrossOrigin
	@PostMapping("/bet")
	public BetResult bet(@RequestBody Bet bet) {
		return slotMachineService.bet(bet);
	}
	
	@CrossOrigin
	@PostMapping("/startGame")
	public GameStatus startGame(@RequestBody UsernameSelectionDTO usernameSelectionDTO) {
		return slotMachineService.initGame(usernameSelectionDTO.getUsername());
	}
	
}
