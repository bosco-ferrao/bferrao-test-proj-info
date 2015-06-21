<%@ page import="uk.bos.app.tribal.Project" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <title>Show project</title>
</head>

<body>
<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="list" action="index">List of the projects</g:link></li>
        <li><g:link class="create" action="create">Add the new project</g:link></li>
    </ul>
</div>

<div id="show-project" class="content" role="main">
    <h1>Project ${project.name}</h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <g:form url="[resource: project, action: 'delete']" method="DELETE">
        <fieldset class="buttons">
            <g:link class="edit" action="edit" resource="${project}">Edit</g:link>
            <g:actionSubmit class="delete" action="delete" value="Delete" onclick="return confirm('Are you sure?');"/>
        </fieldset>
    </g:form>
    <ol class="property-list project">
        <g:if test="${project?.name}">
            <li class="fieldcontain">
                <span id="name-label" class="property-label">Name</span>
                <span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${project}"
                                                                                        field="name"/></span>
            </li>
        </g:if>
        <g:if test="${project?.code}">
            <li class="fieldcontain">
                <span id="code-label" class="property-label">Code</span>
                <span class="property-value" aria-labelledby="code-label"><g:fieldValue bean="${project}"
                                                                                        field="code"/></span>
            </li>
        </g:if>
        <g:if test="${project?.techLead}">
            <li class="fieldcontain">
                <span id="techLead-label" class="property-label">Tech Lead</span>
                <span class="property-value" aria-labelledby="techLead-label">${project?.techLead}</span>
            </li>
        </g:if>
        <g:if test="${project?.projectManager}">
            <li class="fieldcontain">
                <span id="projectManager-label" class="property-label">Project Manager</span>
                <span class="property-value" aria-labelledby="projectManager-label">${project?.projectManager}</span>
            </li>
        </g:if>
        <g:if test="${project?.deliveryDate}">
            <li class="fieldcontain">
                <span id="deliveryDate-label" class="property-label">Delivery Date</span>
                <span class="property-value" aria-labelledby="deliveryDate-label">
                    <g:formatDate format="yyyy-MM-dd" date="${project?.deliveryDate}"/>
                </span>
            </li>
        </g:if>
        <g:if test="${project?.currentPhase}">
            <li class="fieldcontain">
                <span id="currentPhase-label" class="property-label">Current Phase</span>
                <span class="property-value" aria-labelledby="currentPhase-label">
                    <g:fieldValue bean="${project}" field="currentPhase"/></span>
            </li>
        </g:if>
        <g:if test="${project?.priority}">
            <li class="fieldcontain">
                <span id="priority-label" class="property-label">Priority</span>
                <span class="property-value" aria-labelledby="priority-label">
                    <g:fieldValue bean="${project}" field="priority"/></span>
            </li>
        </g:if>
    </ol>
</div>
</body>
</html>
