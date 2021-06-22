<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>First Web Application</title>
</head>

<body>
	Hi ${name},Here are the list of your todos:
	<h1>Your Todos</h1>
	<table>
		<caption>Your Todos are</caption>
		<thead>
			<tr>
				<th>Description</th>
				<th>Target Date</th>
				<th>Is it Done?</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${todos}" var="todo">
				<tr>
					<td>${todo.desc}</td>
					<td>${todo.targetDate}</td>
					<td>${todo.done}</td>
				</tr>
			</c:forEach>
		</tbody>


	</table>
	<a href="/add-todo">Add Todo</a>

</body>

</html>