package com.pawan.thNov;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller 
public class firstController {
	
	List<WatchlistItem> watchlistItems = new ArrayList<WatchlistItem>();
	Integer index = 1;

	@GetMapping("/watchlist")
	public ModelAndView showWatchlist() {
		
		String view = "watchlist";
		
			
		Map<String,Object> model = new HashMap<String,Object>();
		
		model.put("watchlistItems", watchlistItems);
		model.put("totalnumMovies", "15");
				
		
		return new ModelAndView(view,model);
	}
	
	@GetMapping("/watchlistItemForm")
	public ModelAndView showWatchlistItemForm(@RequestParam (required=false)Integer id) {
		
		String view = "watchlistItemForm";
		
		Map<String,Object> model = new HashMap<String,Object>();
		
		
		WatchlistItem watchlistItem = findWatchlistItem(id);
		
		if (watchlistItem == null) {
			model.put("watchlistItem", new WatchlistItem());
		} else {
			model.put("watchlistItem", watchlistItem);
		}
		
		
		
		return new ModelAndView(view,model);
	}
	
	private WatchlistItem findWatchlistItem(Integer id) {
		
		for (WatchlistItem item : watchlistItems) {
			
			if (item.getID().equals(id)) {
				return item;
			}
		}
		
		return null;
	}

	@PostMapping("/watchlistItemForm")
	public ModelAndView getWatchlistItem(@Valid WatchlistItem watchlistItem, 
			BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return new ModelAndView("watchlistItemForm");
		}
		
		WatchlistItem exisiting = findWatchlistItem(watchlistItem.getID());
		
		if (exisiting == null) {
			watchlistItem.setID(index++);
			watchlistItems.add(watchlistItem);
			
		}else {
			exisiting.setComment(watchlistItem.getComment());
			exisiting.setPriority(watchlistItem.getPriority());
			exisiting.setTitle(watchlistItem.getTitle());
			exisiting.setRating(watchlistItem.getRating());
			exisiting.setID(watchlistItem.getID());
		}
		
		
		
		RedirectView view = new RedirectView();
		
		view.setUrl("/watchlist");
		
		return new ModelAndView(view);
	}
}
