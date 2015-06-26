import uk.bos.app.tribal.Project
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_tribalProjInfo_projectshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/project/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',6,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',7,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(6)
invokeTag('message','g',12,['code':("default.home.label")],-1)
printHtmlPart(7)
createClosureForHtmlPart(8, 2)
invokeTag('link','g',13,['class':("list"),'action':("index")],2)
printHtmlPart(9)
createClosureForHtmlPart(10, 2)
invokeTag('link','g',14,['class':("create"),'action':("create")],2)
printHtmlPart(11)
expressionOut.print(project.name)
printHtmlPart(12)
if(true && (flash.message)) {
printHtmlPart(13)
expressionOut.print(flash.message)
printHtmlPart(14)
}
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(15)
createClosureForHtmlPart(16, 3)
invokeTag('link','g',25,['class':("edit"),'action':("edit"),'resource':(project)],3)
printHtmlPart(17)
invokeTag('actionSubmit','g',26,['class':("delete"),'action':("delete"),'value':("Delete"),'onclick':("return confirm('Are you sure?');")],-1)
printHtmlPart(18)
})
invokeTag('form','g',28,['url':([resource: project, action: 'delete']),'method':("DELETE")],2)
printHtmlPart(19)
if(true && (project?.name)) {
printHtmlPart(20)
invokeTag('fieldValue','g',34,['bean':(project),'field':("name")],-1)
printHtmlPart(21)
}
printHtmlPart(22)
if(true && (project?.code)) {
printHtmlPart(23)
invokeTag('fieldValue','g',41,['bean':(project),'field':("code")],-1)
printHtmlPart(21)
}
printHtmlPart(22)
if(true && (project?.techLead)) {
printHtmlPart(24)
expressionOut.print(project?.techLead)
printHtmlPart(21)
}
printHtmlPart(22)
if(true && (project?.projectManager)) {
printHtmlPart(25)
expressionOut.print(project?.projectManager)
printHtmlPart(21)
}
printHtmlPart(22)
if(true && (project?.deliveryDate)) {
printHtmlPart(26)
invokeTag('formatDate','g',60,['format':("yyyy-MM-dd"),'date':(project?.deliveryDate)],-1)
printHtmlPart(27)
}
printHtmlPart(22)
if(true && (project?.currentPhase)) {
printHtmlPart(28)
invokeTag('fieldValue','g',68,['bean':(project),'field':("currentPhase")],-1)
printHtmlPart(21)
}
printHtmlPart(22)
if(true && (project?.priority)) {
printHtmlPart(29)
invokeTag('fieldValue','g',75,['bean':(project),'field':("priority")],-1)
printHtmlPart(21)
}
printHtmlPart(30)
})
invokeTag('captureBody','sitemesh',80,[:],1)
printHtmlPart(31)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1434820414649L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
