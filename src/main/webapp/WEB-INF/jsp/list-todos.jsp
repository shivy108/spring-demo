<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
	Hi ${name},Here are the list of your todos:
	<h1>Your Todos</h1>
	<table class='table table-striped'>
		<caption>Your Todos are</caption>
		<thead>
			<tr>
				<th>Description</th>
				<th>Target Date</th>
				<th>Is it Done?</th>
				<th>Update</th>
				<th>Delete</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${todos}" var="todo">
				<tr>
					<td>${todo.desc}</td>
					<td><fmt:formatDate value="${todo.targetDate}" /></td>
					<td>${todo.done}</td>
					<td><a class="btn btn-success" type="button"
						href='/update-todo?id=${todo.id}'>Update</a>
					<td><a class='btn btn-warning' type='button'
						href='/delete-todo?id=${todo.id}'>Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>


	</table>
	<div>
		<a class='btn' href="/add-todo">Add Todo</a>

	</div>
</div>
<%@ include file="common/footer.jspf"%>