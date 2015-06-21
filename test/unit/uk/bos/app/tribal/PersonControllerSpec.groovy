package uk.bos.app.tribal

import java.sql.SQLException;

import grails.test.mixin.TestFor
import grails.test.mixin.TestMixin
import grails.test.mixin.domain.DomainClassUnitTestMixin
import spock.lang.Specification

@TestFor(PersonController)
class PersonControllerSpec extends Specification {

	void "Delete person from existing project"() {
		when:
		def mockPersonService = [deletePerson: {Long id -> throw new SQLException() }] as PersonService
		controller.personService = mockPersonService
		controller.delete 1
		then:
		flash.message == 'Person 1 not deleted since it is there in a project.'
	}

	void "Delete person from non-existing project"() {
		when:
		def mockPersonService = [deletePerson: {Long id -> return }] as PersonService
		controller.personService = mockPersonService
		controller.delete 3
		then:
		flash.message == 'Person 3 removed sucessfuly.'
	}
}
