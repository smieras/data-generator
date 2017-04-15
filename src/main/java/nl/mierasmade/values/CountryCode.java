package nl.mierasmade.values;

import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;
@Component
public class CountryCode implements FakerValue  {

private static final String NAME = "Address First Name";
	
	private Faker faker;

	@Override
	public void setFaker(Faker faker) {
		this.faker = faker;
	}
	
	@Override
	public String getValue() {
		return faker.address().firstName();				
	}	
	
	@Override
	public String toString() {
		return NAME;
	}
	
	@Override
	public int compareTo(FakerValue other) {		
		return this.toString().compareTo(other.toString());
	}

}