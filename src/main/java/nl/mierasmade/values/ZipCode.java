package nl.mierasmade.values;

import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;
@Component
public class ZipCode implements FakerValue {

private static final String NAME = "Zip Code";
	
	private Faker faker;

	@Override
	public void setFaker(Faker faker) {
		this.faker = faker;
	}
	
	@Override
	public String getValue() {
		return faker.address().zipCode();				
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
