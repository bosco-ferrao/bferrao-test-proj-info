<%@ page import="uk.bos.app.tribal.Project" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <title>Projects list</title>
</head>

<body>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}">Home page</a></li>
        <li><g:link class="create" action="create">Add new Project</g:link></li>
        <li><a class="create" href="${createLink(uri: '/person')}">For Person</a></li>
    </ul>
</div>

<div id="list-project" class="content" role="main">
    <h1>List of the projects</h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <table>
        <thead>
        <tr>
        	<th>Priority</th>
            <th>Name</th>
            <th>Code</th>
            <th>Tech Lead</th>
            <th>Project Manager</th>
            <th>Delivery Date</th>
            <th>Current phase</th>
        </tr>
        </thead>
        <tbody>
        <g:each in="${projects}" status="i" var="project">
            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
            	<td><g:link action="show"
                            id="${project.id}">${fieldValue(bean: project, field: "priority")}</g:link></td>
                <td><g:link action="show"
                            id="${project.id}">${fieldValue(bean: project, field: "name")}</g:link></td>
                <td>${fieldValue(bean: project, field: "code")}</td>
                <td>${fieldValue(bean: project, field: "techLead")}</td>
                <td>${fieldValue(bean: project, field: "projectManager")}</td>
                <td><g:formatDate format="yyyy-MM-dd" date="${project.deliveryDate}"/></td>
                <td>${fieldValue(bean: project, field: "currentPhase")}</td>
            </tr>
        </g:each>
        </tbody>
    </table>
</div>
</body>
</html>
