package uk.bos.app.tribal

class Project {

	static belongsTo = [Person]
	
	static final ALPHANUMERIC_CONSTRAINT = "[A-Za-z0-9 ]+"
	static transients = ['ALPHANUMERIC_CONSTRAINT']

	Long id
	String name
	String code
	Person techLead
	Person projectManager
	Date deliveryDate
	ProjectPhase currentPhase
	Integer priority

	static constraints = {
		name nullable: false, blank: false, matches: ALPHANUMERIC_CONSTRAINT
		code nullable: false, blank: false, matches: ALPHANUMERIC_CONSTRAINT
		techLead nullable: false
		projectManager nullable: false
		deliveryDate nullable: false
		currentPhase nullable: false
		priority nullable: false, min: 1
	}
}
