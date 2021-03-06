<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="main">
<title>Add new Project</title>
</head>

<body>
	<div class="nav" role="navigation">
		<ul>
			<li><a class="home" href="${createLink(uri: '/')}"><g:message
						code="default.home.label" /></a></li>
			<li><g:link class="list" action="index">List of the projects</g:link></li>
		</ul>
	</div>

	<div id="create-project" class="content" role="main">
		<h1>Add new Project</h1>
		<g:if test="${flash.message}">
			<div class="message" role="status">
				${flash.message}
			</div>
		</g:if>
		<g:hasErrors bean="${project}">
			<ul class="errors" role="alert">
				<g:eachError bean="${project}" var="error">
					<li><g:message error="${error}" /></li>
				</g:eachError>
			</ul>
		</g:hasErrors>
		<g:form url="[resource: project, action: 'save']">
			<fieldset class="form">
				<g:render template="form" />
			</fieldset>
			<fieldset class="buttons">
				<g:submitButton name="create" class="save"
					value="${message(code: 'default.button.create.label', default: 'Create')}" />
			</fieldset>
		</g:form>
	</div>
</body>
</html>
