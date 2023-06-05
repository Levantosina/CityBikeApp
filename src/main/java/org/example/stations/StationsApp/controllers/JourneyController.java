package org.example.stations.StationsApp.controllers;



import org.example.stations.StationsApp.models.Journey;


import org.example.stations.StationsApp.services.JourneyService;
import org.example.stations.StationsApp.util.JourneyValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Levantosina
 */
@Controller
@RequestMapping("/journey")
public class JourneyController {

    private final JourneyService journeyService;
    private final JourneyValidator journeyValidator;

    @Autowired
    public JourneyController(JourneyService journeyService, JourneyValidator journeyValidator) {
        this.journeyService = journeyService;

        this.journeyValidator = journeyValidator;
    }
        //return List of  journeys, sorted and paginated
    @GetMapping("/page/{pageNumber}")
    public String getOnePage(Model model,
                             @PathVariable("pageNumber") int currentPage,
                             @RequestParam("sortField") String sortField,
                             @RequestParam("sortDir") String sortDir,
                             @Param("keyword") String keyword) {
        Page<Journey> page= (Page<Journey>) journeyService.getListOfStations(currentPage,sortField,sortDir,keyword);
        pagination(model,page,currentPage);
         sorting(model,sortField,sortDir,keyword);

         return "journey/index";
    }
    @GetMapping
    public String index(Model model){

        return getOnePage(model,1,"id","asc",null);
    }

  //   here is list stations, clicking on which we get list of journeys
    @GetMapping("/show/page/{pageNumber1}")
    public String getListSt(Model model, @PathVariable("pageNumber1") int currentPage1) {
        Page<Journey> stationPage = journeyService.findOneStation(currentPage1);
        pagination(model,stationPage,currentPage1);
        return "journey/show";
    }


    @GetMapping("/show/page/{currentPage}/{id}")
    public String test(Model model,@PathVariable("id") String id,@PathVariable("currentPage") int currentPage){

        Page<Journey>list = journeyService.findTest(id);
        pagination(model,list,currentPage);

        return "journey/showStation";
    }
    //remove journey by departureStationName
    @DeleteMapping("/delete/{departureStationName}")
    public String deleteJourneyById(@PathVariable(name = "departureStationName", required = false) String departureStationName) {
        if (departureStationName != null) {
            journeyService.deleteJourneyById(departureStationName);
        }
        return "redirect:/journey";
    }
    //adding new journey
    @GetMapping("/add")
    public String showAddJourneyForm(Model model) {
        model.addAttribute("journey", new Journey());
        return "journey/new";
    }

    @PostMapping("/add")
    public String addJourney(@ModelAttribute("journey") Journey journey, BindingResult result) {

        journeyValidator.validate(journey,result);
        if(result.hasErrors()){
            return "journey/new";
        }
        journeyService.addJourney(journey);
        return "redirect:/journey";
    }

    //Pagination
    private void pagination(Model model, Page<Journey> page, int currentPage) {
        long totalPages = page.getTotalPages();
        long totalItems = page.getTotalElements();
        List<Journey> journeyList = page.getContent();
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("totalItems", totalItems);
        model.addAttribute("station", journeyList);

    }
    //Sorting
    private void sorting(Model model,String sortField,String sortDir,String keyword){
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
        model.addAttribute("keyword", keyword);
    }
    //Most popular departure stations
    @GetMapping("/mostPopular")
    private String mpDs(Model model){
        Page<Journey>mpDs = journeyService.getMostPopularDepartureStations();
        model.addAttribute("mpDs",mpDs);
        return "journey/mostPop";
    }
}


















