import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_tribalProjInfo_projectcreate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/project/create.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',5,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',5,[:],2)
printHtmlPart(1)
})
invokeTag('captureHead','sitemesh',6,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(5)
invokeTag('message','g',12,['code':("default.home.label")],-1)
printHtmlPart(6)
createClosureForHtmlPart(7, 2)
invokeTag('link','g',13,['class':("list"),'action':("index")],2)
printHtmlPart(8)
if(true && (flash.message)) {
printHtmlPart(9)
expressionOut.print(flash.message)
printHtmlPart(10)
}
printHtmlPart(11)
createTagBody(2, {->
printHtmlPart(12)
createTagBody(3, {->
printHtmlPart(13)
invokeTag('message','g',27,['error':(error)],-1)
printHtmlPart(14)
})
invokeTag('eachError','g',28,['bean':(project),'var':("error")],3)
printHtmlPart(15)
})
invokeTag('hasErrors','g',30,['bean':(project)],2)
printHtmlPart(11)
createTagBody(2, {->
printHtmlPart(16)
invokeTag('render','g',33,['template':("form")],-1)
printHtmlPart(17)
invokeTag('submitButton','g',37,['name':("create"),'class':("save"),'value':(message(code: 'default.button.create.label', default: 'Create'))],-1)
printHtmlPart(18)
})
invokeTag('form','g',39,['url':([resource: project, action: 'save'])],2)
printHtmlPart(19)
})
invokeTag('captureBody','sitemesh',41,[:],1)
printHtmlPart(20)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1435024812902L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
