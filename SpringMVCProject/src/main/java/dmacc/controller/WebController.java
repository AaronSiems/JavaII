package dmacc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dmacc.beans.Coins;
import dmacc.repository.CoinRepository;

@Controller
public class WebController {
	@Autowired
	CoinRepository repo;

	@GetMapping("viewAll")
	public String viewAllCoinss(Model model) {
		model.addAttribute("coins", repo.findAll());
		return "results";
	}
	
	@GetMapping("/addCoin")
	public String addNewCoins(Model model) {
		Coins c = new Coins();
		model.addAttribute("newCoins", c);
		return "input";
	}
	
	@PostMapping("/addCoin")
	public String addNewCoins(@ModelAttribute Coins c, Model model) {
		repo.save(c);
		model.addAttribute("coins", repo.findAll());
		return "results";
	}
	
	@GetMapping("/edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Coins c = repo.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid coin Id:" + id));
		model.addAttribute("coin", c);
		return "update";
	}
	
	@PostMapping("/update/{id}")
	public String updateCoins(@PathVariable("id") long id, @Valid Coins c, BindingResult result, Model model) {
		if(result.hasErrors()) {
			c.setId(id);;
			return "update";
		}
		
		repo.save(c);
		model.addAttribute("coins", repo.findAll());
		return "results";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model) {
		Coins c = repo.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid coin Id:" + id));
	repo.delete(c);
	model.addAttribute("coins", repo.findAll());
	return "results";
	}
	
}
