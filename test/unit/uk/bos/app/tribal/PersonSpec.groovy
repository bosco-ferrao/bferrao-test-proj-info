package uk.bos.app.tribal

import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(Person)
class PersonSpec extends Specification {

	void "Person's name or surname cannot be null or blank"() {
		given:
		List<Person> persons = [
			new Person(name: null, surname: null),
			new Person(name: "", surname: "")
		]
		when:
		persons[0].validate()
		persons[1].validate()
		then:
		persons[0].errors.getFieldError("name").rejectedValue == persons[0].name
		persons[0].errors.getFieldError("surname").rejectedValue == persons[0].surname
		persons[1].errors.getFieldError("name").rejectedValue == persons[1].name
		persons[1].errors.getFieldError("surname").rejectedValue == persons[1].surname
	}

	void "Person's name or surname cannot have more than 50 chars"() {
		given:
		Person person = new Person(name: "thisisthedayiwrotethiscodeletsgetreadytodoublecheckandthenbereadytosend",
		surname: "letsgetreadytodoublecheckandthenbereadytosendletsgetreadytodoublecheckandthenbereadytosend")
		when:
		person.validate()
		then:
		person.errors.getFieldError("name").rejectedValue == person.name
		person.errors.getFieldError("surname").rejectedValue == person.surname
	}

	void "Person must have position"() {
		given:
		Person person = new Person(position: null)
		when:
		person.validate()
		then:
		person.errors.getFieldError("position").rejectedValue == person.position
	}
}
