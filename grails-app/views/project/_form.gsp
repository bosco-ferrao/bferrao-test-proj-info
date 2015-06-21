<%@ page import="uk.bos.app.tribal.Person; uk.bos.app.tribal.Project" %>

<div class="fieldcontain ${hasErrors(bean: project, field: 'name', 'error')} required">
    <label for="name">
        Name
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="name" pattern="${project.constraints.name.matches}" required=""
                 value="${project?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: project, field: 'code', 'error')} required">
    <label for="code">
        Code
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="code" pattern="${project.constraints.code.matches}" required=""
                 value="${project?.code}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: project, field: 'techLead', 'error')} required">
    <label for="techLead">
        Tech Lead
        <span class="required-indicator">*</span>
    </label>
    <g:select id="techLead" name="techLead.id" from="${techLeads}" optionKey="id" required=""
              value="${project?.techLead?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: project, field: 'projectManager', 'error')} required">
    <label for="projectManager">
        Project Manager
        <span class="required-indicator">*</span>
    </label>
    <g:select id="projectManager" name="projectManager.id" from="${managers}" optionKey="id"
              required="" value="${project?.projectManager?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: project, field: 'deliveryDate', 'error')} required">
    <label for="deliveryDate">
        Delivery Date
        <span class="required-indicator">*</span>
    </label>
    <g:datePicker name="deliveryDate" precision="day" value="${project?.deliveryDate}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: project, field: 'currentPhase', 'error')} required">
    <label for="currentPhase">
        Current Phase
        <span class="required-indicator">*</span>
    </label>
    <g:select name="currentPhase" from="${uk.bos.app.tribal.ProjectPhase?.values()}"
              keys="${uk.bos.app.tribal.ProjectPhase.values()*.name()}" required=""
              value="${project?.currentPhase?.name()}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: project, field: 'priority', 'error')} required">
    <label for="priority">Priority<span class="required-indicator">*</span></label>
    <g:field name="priority" type="number" min="1" value="${project.priority}" required=""/>
</div>

