<%@ page import="uk.bos.app.tribal.Project" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <title>Edit Project ${project.name}</title>
</head>

<body>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="list" action="index">List of the projects</g:link></li>
        <li><g:link class="create" action="create">Add the new project</g:link></li>
    </ul>
</div>

<div id="edit-project" class="content" role="main">
    <h1>Edit project ${project?.name}</h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <g:form url="[resource: project, action: 'update']" method="PUT">
        <fieldset class="form">
            <g:render template="form"/>
        </fieldset>
        <fieldset class="buttons">
            <g:actionSubmit class="save" action="update"
                            value="Update"/>
        </fieldset>
    </g:form>
    <g:hasErrors bean="${project}">
        <ul class="errors" role="alert">
            <g:eachError bean="${project}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>>
                    <g:message error="${error}"/></li>
            </g:eachError>
        </ul>
    </g:hasErrors>
</div>
</body>
</html>
