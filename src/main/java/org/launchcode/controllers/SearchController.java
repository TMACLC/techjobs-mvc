package org.launchcode.controllers;

import org.launchcode.models.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("search")
public class SearchController {

    @RequestMapping(value = "")

    public String search(Model model) {
        model.addAttribute("columns", ListController.columnChoices);
        model.addAttribute("searchType", "all");
        return "search";
    }
     @RequestMapping(value = "/results")

     public String search (Model model, @RequestParam String searchTerm,@RequestParam String searchType) {

         ArrayList<HashMap<String, String>> jobs;

         if (searchType.equals("all")) {

             jobs = JobData.findByValue(searchTerm);

         } else {
             jobs = JobData.findByColumnAndValue(searchType, searchTerm);

         }

         model.addAttribute("columns", ListController.columnChoices);
         model.addAttribute("jobs", jobs);
         model.addAttribute("searchType", searchType);

         return "search";
     }
     }
    // TODO #1 above - Create handler to process search request and display results
    //see code example in stack overflow question 30380498 re: how to overload controller method using javaspring




