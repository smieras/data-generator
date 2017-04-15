package nl.mierasmade.values;

import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;
@Component
public class StateAbbrevation implements FakerValue {

private static final String NAME = "State Abbrevation";
	
	private Faker faker;

	@Override
	public void setFaker(Faker faker) {
		this.faker = faker;
	}
	
	@Override
	public String getValue() {
		return faker.address().stateAbbr();				
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