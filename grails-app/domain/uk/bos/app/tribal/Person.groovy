package uk.bos.app.tribal

class Person {

	Long id
	String name
	String surname
	Position position

	static constraints = {
		id nullable: true
		name nullable: false, blank: false, size: 1..50
		surname nullable: false, blank: false, size: 1..50
		position nullable: false
	}

	@Override
	String toString() {
		return "$name $surname"
	}
}
