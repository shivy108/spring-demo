<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class='container'>
	<h1>Add Todo</h1>
	<form:form method="post" modelAttribute="todo">
		<form:hidden path="id" />
		<fieldset class='form-group'>
			<form:label path='desc'>Description</form:label>
			<form:input path="desc" name="desc" type='text' class='form-control'
				required="required" />
			<form:errors path="desc" cssClass="text-warning"></form:errors>
		</fieldset>

		<fieldset class='form-group'>
			<form:label path='targetDate'>targetDate</form:label>
			<form:input path="targetDate" name="desc" type='text'
				class='form-control' required="required" />
			<form:errors path="targetDate" cssClass="text-warning"></form:errors>
		</fieldset>

		<input type='submit' class='btn btn-success'>

	</form:form>
</div>
<%@ include file="common/footer.jspf"%>