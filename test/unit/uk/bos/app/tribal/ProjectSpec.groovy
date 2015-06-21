package uk.bos.app.tribal

import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(Project)
class ProjectSpec extends Specification {

	def setup() {
		mockDomain(Person)
		List<Person> techLeads = []
		List<Person> managers = []
		techLeads << new Person(name: "Bosco", surname: "Ferrao", position: Position.TECH_LEAD)
		techLeads << new Person(name: "Tania", surname: "Rebeiro", position: Position.TECH_LEAD)
		techLeads << new Person(name: "Rapid", surname: "Fire", position: Position.TECH_LEAD)
		managers << new Person(name: "Yoyo", surname: "For Baby", position: Position.PROJECT_MANAGER)
		managers << new Person(name: "Francis", surname: "Xavier", position: Position.PROJECT_MANAGER)
		managers << new Person(name: "Remi", surname: "Martins", position: Position.PROJECT_MANAGER)
		new Project(
				name: "Sample project",
				code: "AAA",
				techLead: techLeads[0],
				projectManager: managers[0],
				deliveryDate: new Date().parse('yyyy/MM/dd', '2016/12/1'),
				currentPhase: ProjectPhase.BRIEFING,
				priority: 1
				).save(failOnError: true)
		new Project(
				name: "Bos sample2 project",
				code: "ABC",
				techLead: techLeads[1],
				projectManager: managers[1],
				deliveryDate: new Date().parse('yyyy/MM/dd', '2015/7/2'),
				currentPhase: ProjectPhase.DEVELOPMENT,
				priority: 2
				).save(failOnError: true)
		new Project(
				name: "Third sample project",
				code: "BOS",
				techLead: techLeads[2],
				projectManager: managers[2],
				deliveryDate: new Date().parse('yyyy/MM/dd', '2015/9/1'),
				currentPhase: ProjectPhase.QA,
				priority: 3
				).save(flush: true, failOnError: true)
	}

	void "Project name cannot be null or blank"() {
		given:
		Project project = new Project(name: null)
		Project blankProject = new Project(name: "")
		when:
		project.validate()
		blankProject.validate()
		then:
		project.errors.getFieldError("name").rejectedValue == project.name
		blankProject.errors.getFieldError("name").rejectedValue == blankProject.name
	}

	void "Project name must be alphanumeric"() {
		given:
		Project project = new Project(name: "!@#%^&*()1A")
		Project projectWithAlphanumericName = new Project(name: "Aa2")
		when:
		project.validate()
		projectWithAlphanumericName.validate()
		then:
		project.errors.getFieldError("name").rejectedValue == project.name
		projectWithAlphanumericName.errors.getFieldError("name") == null
	}

	void "Project code cannot be null or blank"() {
		given:
		Project project = new Project(code: null)
		Project blankProject = new Project(code: "")
		when:
		project.validate()
		blankProject.validate()
		then:
		project.errors.getFieldError("code").rejectedValue == project.code
		blankProject.errors.getFieldError("code").rejectedValue == blankProject.code
	}

	void "Project code must be alphanumeric"() {
		given:
		Project project = new Project(code: "!@#%^&*()B2")
		Project projectWithAlphanumericCode = new Project(code: "Ab1")
		when:
		project.validate()
		projectWithAlphanumericCode.validate()
		then:
		project.errors.getFieldError("code").rejectedValue == project.code
		projectWithAlphanumericCode.errors.getFieldError("code") == null
	}

	void "Priority cannot be lower than number 1"() {
		given:
		Project project = new Project(priority: 0)
		when:
		project.validate()
		then:
		project.errors.getFieldError("priority").rejectedValue == 0
	}
}
