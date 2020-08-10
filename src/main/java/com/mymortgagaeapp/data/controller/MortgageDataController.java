package com.mymortgagaeapp.data.controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mymortgagaeapp.data.exception.ResourceNotFoundException;
import com.mymortgagaeapp.data.model.MortgageApplication;

/**
 * 
 * @author Swapnil Dangore
 */
@RestController
@RequestMapping(path="/mortgageApplications")
public class MortgageDataController {

	@Autowired
	Set<MortgageApplication> applicationList;
	
	@GetMapping
	public ResponseEntity<Set<MortgageApplication>> getAllApplications() {
		return ResponseEntity.ok().body(applicationList);
	}
	
	@GetMapping("{mortgageid}")
	public ResponseEntity<MortgageApplication> getApplication(@PathVariable(value = "mortgageid") String mortgageid) throws ResourceNotFoundException {
		Optional<MortgageApplication> optionaltemp = applicationList.stream().filter(appElement->mortgageid.equals(appElement.getMortgageId())).findFirst();
		if(!optionaltemp.isPresent()) {
			throw new ResourceNotFoundException("Application not found for this id :: " + mortgageid);
		}
		return ResponseEntity.ok().body(applicationList.stream().filter(appElement->mortgageid.equals(appElement.getMortgageId())).findFirst().get());
	}
	
	@PostMapping
    public MortgageApplication createApplication(@RequestBody @Validated MortgageApplication app) {
		applicationList.add(app);
		return app;
	}
	@PutMapping("{mortgageid}")
    public MortgageApplication updateApplication(@PathVariable(value = "mortgageid") String mortgageid,@RequestBody @Validated MortgageApplication app) {
		
		Optional<MortgageApplication> optionaltemp = applicationList.stream().filter(appElement->mortgageid.equals(appElement.getMortgageId())).findFirst();
		if(optionaltemp.isPresent()) {
			MortgageApplication temp = optionaltemp.get();
			temp.setVersion(app.getVersion());
			temp.setOfferId(app.getOfferId());
			temp.setProductId(app.getProductId());
			temp.setCreatedDate(app.getCreatedDate());
			temp.setOfferDate(app.getOfferDate());
			temp.setOfferExpired(app.isOfferExpired());
			
		}else {
			applicationList.add(app);
		}
        return app;
    }
}


