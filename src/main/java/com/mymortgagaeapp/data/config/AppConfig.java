package com.mymortgagaeapp.data.config;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.mymortgagaeapp.data.model.MortgageApplication;

/**
 * 
 * @author Swapnil Dangore
 */
@Configuration
public class AppConfig {

	@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
	public List<MortgageApplication> applicationList(){
		MortgageApplication app = new MortgageApplication();
		
		List<MortgageApplication> appList = new ArrayList<>();
		
		app.setMortgageId("M1");
		app.setVersion("1");
		app.setOfferId("OI-1");
		app.setProductId("B1");
		app.setCreatedDate("2020-08-08");
		app.setOfferDate("2020-08-08");
		app.setOfferExpired(false);
		
		appList.add(app);
		
		return  appList;
	}
}
