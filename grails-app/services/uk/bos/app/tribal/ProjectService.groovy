package uk.bos.app.tribal

import grails.transaction.Transactional
import org.codehaus.groovy.grails.web.binding.DataBindingUtils

class ProjectService {

    /**
     * Creates project. Updates priorities of other projects if needed.
     * @param params
     * @return
     */
    @Transactional
    Project createProject(Map params) {
        Project project = new Project()
        DataBindingUtils.bindObjectToInstance(project, params, [], ["id"], null)
        updatePriority(project, 1)
        Integer projectCount = Project.count()
        if (project.priority > projectCount) {
            project.priority = projectCount + 1
        }
        return project.save(flush: true)
    }

    /**
     * Returns chosen Project.
     * @param id
     * @return
     */
    @Transactional(readOnly = true)
    Project findProjectById(Long id) {
        return Project.get(id)
    }

    /**
     * Returns all Projects.
     * @return
     */
    @Transactional(readOnly = true)
    List<Project> findAllProjects() {
        List<Project> projects = Project.withCriteria { order("priority", "asc") }
        return projects
    }

    /**
     * Updates project. In case of priority's change the order of existing projects is preserved.
     * @param params
     * @return updated project.
     */
    @Transactional
    Project updateProject(Map params) {
        Project project = Project.get(params.id as Long)
        if (project) {
            Integer newPriority = params.priority as Integer
            if (project.priority != newPriority) {
                int min = Math.min(newPriority, project.priority)
                int max = Math.max(newPriority, project.priority)
                List<Project> projects = Project.withCriteria {
                    ge("priority", min)
                    le("priority", max)
                    order("priority", min == newPriority ? "desc" : "asc")
                }
                project = projects[0]
                int i = 1
                while (i < projects.size() && project.priority != newPriority) {
                    if (project.priority < newPriority) {
                        projects[0].priority += 1
                        projects[i].priority -= 1
                    } else {
                        projects[0].priority -= 1
                        projects[i].priority += 1
                    }
                    i++
                }
            }
            DataBindingUtils.bindObjectToInstance(project, params, [], ["id", "priority"], null)
            project.save(flush: true)
        }
    }

    /**
     * Removes project and updates priorities of other projects in order to fix undesired gaps.
     * @param id
     */
    @Transactional
    void deleteProject(Long id) {
        Project project = Project.get(id)
        project.delete()
        updatePriority(project, 0)
    }

    protected void updatePriority(Project project, int offset) {
        if (!project) {
            return
        }
        List<Project> projects = Project.withCriteria {
            ge("priority", project.priority)
            order("priority")
        }
        projects.eachWithIndex {
            Project p, int i -> p.priority = project.priority + i + offset
        }
    }

}
