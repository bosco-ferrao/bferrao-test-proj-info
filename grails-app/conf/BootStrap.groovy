import uk.bos.app.tribal.Person
import uk.bos.app.tribal.Position
import uk.bos.app.tribal.Project
import uk.bos.app.tribal.ProjectPhase

class BootStrap {

    def init = { servletContext ->
        List<Person> techLeads = []
        List<Person> managers = []
        List<Project> projects = []
        techLeads << new Person(name: "Bosco", surname: "Ferrao", position: Position.TECH_LEAD).save()
        techLeads << new Person(name: "Tania", surname: "Rebeiro", position: Position.TECH_LEAD).save()
        techLeads << new Person(name: "Rapid", surname: "Fire", position: Position.TECH_LEAD).save()
        managers << new Person(name: "Yoyo", surname: "For Baby", position: Position.PROJECT_MANAGER).save()
        managers << new Person(name: "Francis", surname: "Xavier", position: Position.PROJECT_MANAGER).save()
        managers << new Person(name: "Remi", surname: "Martins", position: Position.PROJECT_MANAGER).save()
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
                name: "Bos sample2 project",
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
    def destroy = {
    }
}
