package com.kristian.fi.controllers;

import com.kristian.fi.dataAcces.CustomerRepository;
import com.kristian.fi.dataAcces.CustomerSearch;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CustomerViewController {

    CustomerRepository crep = new CustomerRepository();
    CustomerSearch custSearcsong=new CustomerSearch();

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getFiveRandGenres(Model model){
        model.addAttribute("randomsArtists", crep.getFiveRandArtists());
        model.addAttribute("randomsSongs", crep.getFiveRandSongs());
        model.addAttribute("randomsGenres", crep.getFiveRandGenres());
        return "index";
    }

    @RequestMapping(value = "/search_it", method = RequestMethod.GET)
    public String getCustomerSongSearch(Model model,@RequestParam(value="searchForThis") String search){
        model.addAttribute("result", custSearcsong.getCustomerSearch(search));
        return "search_it";
    }




}
