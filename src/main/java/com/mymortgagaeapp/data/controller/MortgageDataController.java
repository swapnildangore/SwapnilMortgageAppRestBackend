package com.mymortgagaeapp.data.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mymortgagaeapp.data.model.MortgageApplication;

/**
 * 
 * @author Swapnil Dangore
 */
@RestController
@RequestMapping(path="/mortgageApplications")
public class MortgageDataController {

	@Autowired
	List<MortgageApplication> applicationList;
	
	@GetMapping
	public ResponseEntity<List<MortgageApplication>> getAllApplications() {
		System.out.println("********* getAllApplications ");
		return ResponseEntity.ok().body(applicationList);
	}
	
	@PostMapping
    public MortgageApplication createEmployee(@RequestBody MortgageApplication app) {
		applicationList.add(app);
        return app;
    }
}


