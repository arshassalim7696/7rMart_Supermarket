package utilities;

import com.github.javafaker.Faker;

public class FakerUtility {
public String getFakeFirstname()
{
	Faker faker = new Faker();
 return faker.name().firstName();
}
public String getFakerLastName()
{
	Faker faker = new Faker();
	 return faker.name().lastName();
}
}
