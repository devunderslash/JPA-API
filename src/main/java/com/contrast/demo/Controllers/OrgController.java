package com.contrast.demo.Controllers;

import com.contrast.demo.Entities.Application;
import com.contrast.demo.Entities.Organisation;
import com.contrast.demo.RESTRepo.OrgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class OrgController {

    @Autowired
    private OrgRepository orgRepository;


    @GetMapping("/organisations/{id}/applications")
    public Iterable<Organisation> retrieveApps(@PathVariable long id) {

        Iterable<Organisation> appList = orgRepository.findApplications(id);

        return appList;
    }

    @GetMapping("/organisations/{id}/applications?query={name}")
    public Iterable<Organisation> retrieveAppsPartial(@PathVariable long id, @RequestParam("query") String name ) {

        List<Organisation> appListQueryResult = orgRepository.findApplicationPartial(id, name);

        return appListQueryResult;
    }

    @GetMapping("/organisations/{id}/applications?query={name}&order={sort}")
    public Iterable<Organisation> retrieveAppsPartialSort(@PathVariable long id, @RequestParam("query") String name, @RequestParam("order") String sort) {

        //TODO - Move to Util Class as Sort Method
        String sortOrder = "asc";

        if(sort.equals("'name desc'"))
            sortOrder = "desc";


        Iterable<Organisation> appListQueryResult = orgRepository.findApplicationPartialSort(id, name, sortOrder);

        return appListQueryResult;
    }

    @GetMapping("/organisations/{id}/applications?order={sort}")
    public Iterable<Organisation> retrieveAppsSort(@RequestParam("order") long id, String sort) {

        Iterable<Organisation> appListQueryResult = orgRepository.findApplicationSort(id, sort);

        return appListQueryResult;
    }



}
