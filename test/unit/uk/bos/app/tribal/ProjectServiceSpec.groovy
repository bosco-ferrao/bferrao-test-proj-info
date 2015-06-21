package uk.bos.app.tribal

import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(ProjectService)
class ProjectServiceSpec extends Specification {

	List<Person> techLeads
	List<Person> managers
	List<Project> projects

	def setup() {
		mockDomains(Project, Person)
		techLeads = []
		managers = []
		projects = []
		techLeads << new Person(name: "Bosco", surname: "Ferrao", position: Position.TECH_LEAD)
		techLeads << new Person(name: "Tania", surname: "Rebeiro", position: Position.TECH_LEAD)
		techLeads << new Person(name: "Abadee", surname: "De Vielers", position: Position.TECH_LEAD)
		managers << new Person(name: "Sandy", surname: "Ferns", position: Position.PROJECT_MANAGER)
		managers << new Person(name: "Francis", surname: "Xavier", position: Position.PROJECT_MANAGER)
		managers << new Person(name: "Remi", surname: "Nair", position: Position.PROJECT_MANAGER)
		projects << new Project(
				name: "Sample project",
				code: "AAA",
				techLead: techLeads[0],
				projectManager: managers[0],
				deliveryDate: new Date().parse('yyyy/MM/dd', '2016/7/1'),
				currentPhase: ProjectPhase.BRIEFING,
				priority: 1
				).save(failOnError: true, flush: true)
		projects << new Project(
				name: "Bos Sample2 project",
				code: "ABC",
				techLead: techLeads[1],
				projectManager: managers[1],
				deliveryDate: new Date().parse('yyyy/MM/dd', '2016/8/2'),
				currentPhase: ProjectPhase.DEVELOPMENT,
				priority: 2
				).save(failOnError: true, flush: true)
		projects << new Project(
				name: "Third sample project",
				code: "BOS",
				techLead: techLeads[2],
				projectManager: managers[2],
				deliveryDate: new Date().parse('yyyy/MM/dd', '2015/9/1'),
				currentPhase: ProjectPhase.QA,
				priority: 3
				).save(flush: true, failOnError: true)
	}

	void "Create project with priority greater than number of projects"() {
		when:
		Project mockProject = service.createProject([
			name          : "Mock project",
			code          : "WWW",
			techLead      : techLeads[0],
			projectManager: managers[0],
			deliveryDate  : new Date(),
			currentPhase  : ProjectPhase.DEVELOPMENT,
			priority      : 5
		])
		then:
		mockProject.priority == 4
		projects[0].priority == 1
		projects[1].priority == 2
		projects[2].priority == 3
	}

	void "Create project with priority value (1) which is currently used"() {
		when:
		Project mockProject = service.createProject([
			name          : "Mock project",
			code          : "YYY",
			techLead      : techLeads[0],
			projectManager: managers[0],
			deliveryDate  : new Date(),
			currentPhase  : ProjectPhase.DEVELOPMENT,
			priority      : 1
		])
		then:
		mockProject.priority == 1
		projects[0].priority == 2
		projects[1].priority == 3
		projects[2].priority == 4
	}

	void "Create project with priority value (3) which is currently used"() {
		when:
		Project mockProject = service.createProject([
			name          : "Mock project",
			code          : "ZZZ",
			techLead      : techLeads[0],
			projectManager: managers[0],
			deliveryDate  : new Date(),
			currentPhase  : ProjectPhase.DEVELOPMENT,
			priority      : 3
		])
		then:
		projects[0].priority == 1
		projects[1].priority == 2
		mockProject.priority == 3
		projects[2].priority == 4
	}

	void "Update project with priority value greater than number of projects"() {
		when:
		service.updateProject([
			id      : 1,
			priority: 4
		])
		then:
		projects[0].priority == 3
		projects[1].priority == 1
		projects[2].priority == 2
	}

	void "Update project with priority(1) value which is currently used(2)"() {
		when:
		service.updateProject([
			id      : 1,
			priority: 2
		])
		then:
		projects[0].priority == 2
		projects[1].priority == 1
		projects[2].priority == 3
	}

	void "Update projects with priority(1) value which is currently used(1)"() {
		when:
		service.updateProject([
			id      : 1,
			priority: 1
		])
		then:
		projects[0].priority == 1
		projects[1].priority == 2
		projects[2].priority == 3
	}

	void "Fix gaps in priority values after deletion of the project in the middle"() {
		when:
		service.deleteProject(projects[1].id)
		projects.remove(1)
		then:
		projects[0].priority == 1
		projects[1].priority == 2
	}

	void "Fix gaps in priority values after deletion of the project with priority 1"() {
		when:
		service.deleteProject(projects.first().id)
		projects.remove(0)
		then:
		projects[0].priority == 1
		projects[1].priority == 2
	}

	void "Remove the last element."() {
		when:
		service.deleteProject(3)
		projects.remove(projects.last())
		then:
		Project.get(3) == null
		projects[0].priority == 1
		projects[1].priority == 2
	}

	void "List of the projects should be ordered by priorities"() {
		given:
		List<Integer> priorities = [1, 2, 3]
		when:
		List<Project> projects = service.findAllProjects()
		then:
		projects[0].priority == priorities[0]
		projects[1].priority == priorities[1]
		projects[2].priority == priorities[2]
	}
}
