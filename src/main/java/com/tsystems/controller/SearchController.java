package com.tsystems.controller;

import com.google.gson.Gson;
import com.tsystems.service.api.SearchServiceAPI;
import com.tsystems.service.impl.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedList;

@Controller
public class SearchController {

    @Autowired
    private SearchServiceAPI searchService;

    @Autowired
    private StationService stationService;

    @PostMapping(path = "/search/result")
    public ModelAndView search(String from, String to, String from_date, String to_date) {
        ModelAndView modelAndView = new ModelAndView("show_search");
        modelAndView.addObject("searchList", searchService.getResultSearch(from, to, from_date, to_date));
        return modelAndView;
    }

    @ResponseBody
    @PostMapping(path = "/search/check")
    public String checkSearchStation(String station) {
        if (stationService.checkStation(station)) {
            return "";
        }
        return "No station";
    }

    @ResponseBody
    @PostMapping(path = "/search/autocomplete", produces = {"application/json; charset=UTF-8"})
    public String addAutocomplete() {
        LinkedList list = stationService.getListNameStations();
        Gson gson = new Gson();
        return gson.toJson(list);
    }
}
