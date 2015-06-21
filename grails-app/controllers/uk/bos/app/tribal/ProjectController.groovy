package uk.bos.app.tribal

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

	def save() {
		Project project = projectService.createProject(params)
		if (project) {
			flash.message = "Project $project.name created sucessfuly."
			redirect(action: "index")
		} else {
			redirect(action: "create")
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
		Project project = projectService.updateProject(params)
		if (project) {
			flash.message = "Project $project.name updated sucessfuly."
			redirect(action: "show", id: project.id)
		} else {
			redirect(action: "edit", id: project.id)
		}
	}
}
