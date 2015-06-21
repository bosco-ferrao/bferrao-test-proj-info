package uk.bos.app.tribal

import grails.transaction.Transactional
import org.codehaus.groovy.grails.web.binding.DataBindingUtils

class PersonService {
    /**
     * Removes person if no foreign keys
     * @param id
     */
    @Transactional
    void deletePerson(Long id) {
        Person person = Person.get(id)
        person.delete()
    }
}
