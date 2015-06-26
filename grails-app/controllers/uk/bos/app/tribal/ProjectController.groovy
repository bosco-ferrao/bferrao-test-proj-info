package uk.bos.app.tribal

import org.springframework.web.servlet.ModelAndView

class ProjectController {

	ProjectService projectService

	def index() {
		[projects: projectService.findAllProjects()]
	}

	def create() {
		[
			project  : new Project(),
			techLeads: Person.findAllByPosition(Position.TECH_LEAD),
			managers : Person.findAllByPosition(Position.PROJECT_MANAGER)
		]
	}

	private def validateProject(Project project, String checkType) {
		if (!project.validate()) {
			//			project.errors.allErrors.each {
			//				println it
			//			}
			flash.message = 'The field(s) Name or Code are not unique across projects.'
			return false
		}
		return true
	}

	def save() {
		Project project1 = new Project(params);
		if(validateProject(project1, 'create')) {
			Project project = projectService.createProject(params)
			if (project) {
				flash.message = "Project $project.name created sucessfuly."
				redirect(action: "index")
			} else {
				redirect(action: "create")
			}
		} else {
			return new ModelAndView("create", [ project : project1,
				techLeads: Person.findAllByPosition(Position.TECH_LEAD),
				managers : Person.findAllByPosition(Position.PROJECT_MANAGER)
			])
		}
	}

	def show(Long id) {
		[project: projectService.findProjectById(id)]
	}

	def delete(Long id) {
		projectService.deleteProject(id)
		flash.message = "Project $id removed sucessfuly."
		redirect(action: "index")
	}

	def edit(Long id) {
		[
			project  : projectService.findProjectById(id),
			techLeads: Person.findAllByPosition(Position.TECH_LEAD),
			managers : Person.findAllByPosition(Position.PROJECT_MANAGER)
		]
	}

	def update() {
//		Project project1 = new Project(params);
//		if(validateProject(project1, 'edit')) {
			Project project = projectService.updateProject(params)
			if (project) {
				flash.message = "Project $project.name updated sucessfuly."
				redirect(action: "show", id: project.id)
			} else {
				redirect(action: "edit", id: project.id)
			}
//		} else {
//			redirect(action: "edit", id: project1.id)
//		}
	}
}
