import uk.bos.app.tribal.Project
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_tribalProjInfo_projectedit_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/project/edit.gsp" }
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
createTagBody(3, {->
printHtmlPart(2)
expressionOut.print(project.name)
})
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
invokeTag('message','g',13,['code':("default.home.label")],-1)
printHtmlPart(7)
createClosureForHtmlPart(8, 2)
invokeTag('link','g',14,['class':("list"),'action':("index")],2)
printHtmlPart(9)
createClosureForHtmlPart(10, 2)
invokeTag('link','g',15,['class':("create"),'action':("create")],2)
printHtmlPart(11)
expressionOut.print(project?.name)
printHtmlPart(12)
if(true && (flash.message)) {
printHtmlPart(13)
expressionOut.print(flash.message)
printHtmlPart(14)
}
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(15)
invokeTag('render','g',26,['template':("form")],-1)
printHtmlPart(16)
invokeTag('actionSubmit','g',30,['class':("save"),'action':("update"),'value':("Update")],-1)
printHtmlPart(17)
})
invokeTag('form','g',32,['url':([resource: project, action: 'update']),'method':("PUT")],2)
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(18)
createTagBody(3, {->
printHtmlPart(19)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(20)
expressionOut.print(error.field)
printHtmlPart(21)
}
printHtmlPart(22)
invokeTag('message','g',37,['error':(error)],-1)
printHtmlPart(23)
})
invokeTag('eachError','g',38,['bean':(project),'var':("error")],3)
printHtmlPart(24)
})
invokeTag('hasErrors','g',40,['bean':(project)],2)
printHtmlPart(25)
})
invokeTag('captureBody','sitemesh',42,[:],1)
printHtmlPart(26)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1434939972523L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
