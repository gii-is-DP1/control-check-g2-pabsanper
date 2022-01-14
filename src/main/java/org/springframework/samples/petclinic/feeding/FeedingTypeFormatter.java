package org.springframework.samples.petclinic.feeding;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class FeedingTypeFormatter implements Formatter<FeedingType>{
    private final FeedingService feedinService;

	@Autowired
	public FeedingTypeFormatter(FeedingService feedingService) {
		this.feedinService = feedingService;
	}
	

    @Override
    public String print(FeedingType object, Locale locale) {
        return object.getName();
        
    }

    @Override
    public FeedingType parse(String text, Locale locale) throws ParseException {
        FeedingType ft = this.feedinService.getFeedingType(text);
		if(ft==null){
            throw new ParseException("type not found: " + text, 0);
        }
        else{
            return ft;
        }
    }
    
}
