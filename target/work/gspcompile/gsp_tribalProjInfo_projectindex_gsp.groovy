import uk.bos.app.tribal.Project
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_tribalProjInfo_projectindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/project/index.gsp" }
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
createClosureForHtmlPart(7, 2)
invokeTag('link','g',14,['class':("create"),'action':("create")],2)
printHtmlPart(8)
expressionOut.print(createLink(uri: '/person'))
printHtmlPart(9)
if(true && (flash.message)) {
printHtmlPart(10)
expressionOut.print(flash.message)
printHtmlPart(11)
}
printHtmlPart(12)
loop:{
int i = 0
for( project in (projects) ) {
printHtmlPart(13)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(14)
createTagBody(3, {->
expressionOut.print(fieldValue(bean: project, field: "priority"))
})
invokeTag('link','g',40,['action':("show"),'id':(project.id)],3)
printHtmlPart(15)
createTagBody(3, {->
expressionOut.print(fieldValue(bean: project, field: "name"))
})
invokeTag('link','g',42,['action':("show"),'id':(project.id)],3)
printHtmlPart(15)
expressionOut.print(fieldValue(bean: project, field: "code"))
printHtmlPart(15)
expressionOut.print(fieldValue(bean: project, field: "techLead"))
printHtmlPart(15)
expressionOut.print(fieldValue(bean: project, field: "projectManager"))
printHtmlPart(15)
invokeTag('formatDate','g',46,['format':("yyyy-MM-dd"),'date':(project.deliveryDate)],-1)
printHtmlPart(15)
expressionOut.print(fieldValue(bean: project, field: "currentPhase"))
printHtmlPart(16)
i++
}
}
printHtmlPart(17)
})
invokeTag('captureBody','sitemesh',53,[:],1)
printHtmlPart(18)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1434820617269L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
