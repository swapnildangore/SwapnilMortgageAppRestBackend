package com.mymortgagaeapp.data.config;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Set;
import java.util.TreeSet;

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
	public Set<MortgageApplication> applicationList(){
		MortgageApplication app = new MortgageApplication();
		DateFormat fomat = new SimpleDateFormat("dd/MM/yyyy");
		fomat.setLenient(false);
		
		Set<MortgageApplication> appList = new TreeSet<>();
		
		app.setMortgageId("M1");
		app.setVersion("1");
		app.setOfferId("OI-1");
		app.setProductId("B1");
		try {
			app.setCreatedDate(fomat.parse("09/08/2020"));
			app.setOfferDate(fomat.parse("09/08/2020"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		app.setOfferExpired(false);
		
		appList.add(app);
		
		return  appList;
	}
}
