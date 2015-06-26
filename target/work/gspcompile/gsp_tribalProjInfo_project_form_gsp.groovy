import uk.bos.app.tribal.Person
import  uk.bos.app.tribal.Project
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_tribalProjInfo_project_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/project/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: project, field: 'name', 'error'))
printHtmlPart(1)
invokeTag('textField','g',9,['name':("name"),'pattern':(project.constraints.name.matches),'required':(""),'value':(project?.name)],-1)
printHtmlPart(2)
expressionOut.print(hasErrors(bean: project, field: 'code', 'error'))
printHtmlPart(3)
invokeTag('textField','g',18,['name':("code"),'pattern':(project.constraints.code.matches),'required':(""),'value':(project?.code)],-1)
printHtmlPart(2)
expressionOut.print(hasErrors(bean: project, field: 'techLead', 'error'))
printHtmlPart(4)
invokeTag('select','g',27,['id':("techLead"),'name':("techLead.id"),'from':(techLeads),'optionKey':("id"),'required':(""),'value':(project?.techLead?.id),'class':("many-to-one")],-1)
printHtmlPart(2)
expressionOut.print(hasErrors(bean: project, field: 'projectManager', 'error'))
printHtmlPart(5)
invokeTag('select','g',36,['id':("projectManager"),'name':("projectManager.id"),'from':(managers),'optionKey':("id"),'required':(""),'value':(project?.projectManager?.id),'class':("many-to-one")],-1)
printHtmlPart(2)
expressionOut.print(hasErrors(bean: project, field: 'deliveryDate', 'error'))
printHtmlPart(6)
invokeTag('datePicker','g',44,['name':("deliveryDate"),'precision':("day"),'value':(project?.deliveryDate)],-1)
printHtmlPart(2)
expressionOut.print(hasErrors(bean: project, field: 'currentPhase', 'error'))
printHtmlPart(7)
invokeTag('select','g',54,['name':("currentPhase"),'from':(uk.bos.app.tribal.ProjectPhase?.values()),'keys':(uk.bos.app.tribal.ProjectPhase.values()*.name()),'required':(""),'value':(project?.currentPhase?.name())],-1)
printHtmlPart(2)
expressionOut.print(hasErrors(bean: project, field: 'priority', 'error'))
printHtmlPart(8)
invokeTag('field','g',59,['name':("priority"),'type':("number"),'min':("1"),'value':(project.priority),'required':("")],-1)
printHtmlPart(9)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1434814563605L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
