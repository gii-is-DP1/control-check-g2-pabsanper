package org.springframework.samples.petclinic.feeding;

import org.springframework.samples.petclinic.pet.PetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import antlr.collections.List;

import java.util.Map;

import javax.validation.Valid;

import org.ehcache.shadow.org.terracotta.offheapstore.paging.OffHeapStorageArea.Owner;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class FeedingController {
    private static final String VIEWS_FEEDING_CREATE_OR_UPDATE_FORM = "feedings/createOrUpdateFeedingForm";

	

	@Autowired
    PetService petService;
    @Autowired
    FeedingService feedingService;
    @GetMapping(value = "/feeding/create")
	public String initCreationForm(Map<String, Object> model) {
		Feeding feeding = new Feeding();
		model.put("feeding", feeding);
        model.put("pets", petService.getAllPets());
        model.put("feedingTypes", feedingService.getAllFeedingTypes());
		return VIEWS_FEEDING_CREATE_OR_UPDATE_FORM;
	}
    @PostMapping(path="/save")
    public String save(@Valid Feeding feeding, BindingResult result, ModelMap modelMap) {
        if (result.hasErrors()) {
			return VIEWS_FEEDING_CREATE_OR_UPDATE_FORM;
		}
		else {
			
			//feedingService.save(feeding);
			
			return "redirect:/owners/";
		}
	}
}

