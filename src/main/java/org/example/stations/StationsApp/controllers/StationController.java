package org.example.stations.StationsApp.controllers;

import org.example.stations.StationsApp.models.Journey;
import org.example.stations.StationsApp.models.Stations;
import org.example.stations.StationsApp.services.StationService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author Levantosina
 */

@Controller
@RequestMapping("/stations")
public class StationController {

    private final StationService stationService;

    public StationController(StationService stationService) {
        this.stationService = stationService;
    }

    @GetMapping("/page/{pageNumber}")
    public String getOnePage(Model model, @PathVariable("pageNumber") int currentPage,
                             @RequestParam("sortField") String sortField,
                             @RequestParam("sortDir") String sortDir) {
        Page<Stations> page = stationService.getStations(currentPage, sortField, sortDir);

        pagination(model,page,currentPage);
        sorting(model,sortField,sortDir);

        return "stations/index";
    }

    @GetMapping
    public String index(Model model){

        return getOnePage(model,1,"fid","asc");
    }

    private void pagination(Model model, Page<Stations> page, int currentPage) {
        long totalPages = page.getTotalPages();
        long totalItems = page.getTotalElements();
        List<Stations>journeyList = page.getContent();
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("totalItems", totalItems);
        model.addAttribute("station", journeyList);

    }
    private void sorting(Model model,String sortField,String sortDir){
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

    }
}




