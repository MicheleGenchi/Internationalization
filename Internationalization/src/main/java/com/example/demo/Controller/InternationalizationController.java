package com.example.demo.Controller;

import java.beans.PropertyEditorSupport;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

public class InternationalizationController {
	
	@Autowired
//	@Qualifier("MessageSourceRB")
	MessageSource messageSource;
	

    @InitBinder
  	public void binder(WebDataBinder binder) {
    	//binder data format in base al formato locale della data
    	binder.registerCustomEditor(Timestamp.class,
		    new PropertyEditorSupport() {
		        public void setAsText(String value) {
		            try {
		            	Date localDate= DateFormat.getDateInstance(DateFormat.SHORT, Locale.getDefault()).parse(value);
		                //Date parsedDate = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(value);
		                setValue(new Timestamp(localDate.getTime()));
		            } catch (ParseException e) {
		                setValue(null);
		            }
		        }
		    });
    	
    	binder.registerCustomEditor(String.class,
    		    new PropertyEditorSupport() {
    		        public void translate(String value) {
   		            	String str = messageSource.getMessage(value, null, Locale.getDefault());
    	                setValue(new String(str));
    		        }
    		    });
    	
    }
}
