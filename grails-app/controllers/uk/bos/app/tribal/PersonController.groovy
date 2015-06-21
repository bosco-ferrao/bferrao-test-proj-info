package uk.bos.app.tribal

class PersonController {
	static scaffold = true

	PersonService personService

	def delete(Long id) {
		try {
			personService.deletePerson(id)
			flash.message = "Person $id removed sucessfuly."
		}
		catch (Exception e) {
			log.error "Error: ${e.message}", e
			flash.message = "Person $id not deleted since it is there in a project."
		}

		redirect(action: "index")
	}
}
