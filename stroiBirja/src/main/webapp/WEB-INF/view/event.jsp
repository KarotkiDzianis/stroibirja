<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
	<meta charset="utf-8">

	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css" type="text/css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/js/jquery-ui/jquery-ui.min.css" type="text/css">

	<title>
		<s:message code="application.title" />
	</title>
</head>
<body>

	<div class="dataFrame largeFrame">
		<table>
			<tr>
				<td class="dataColl">
					<a href="users.html">
						<s:message code="menu.item.users" />
					</a>
				</td>
				<td class="dataColl">
					<a href="events.html">
						<s:message code="menu.item.events" />
					</a>
				</td>
			</tr>
		</table>
	</div>

	<div class="dataFrame largeFrame leftFrame">
		<h1>
			<s:message code="eventListPage.header.title" />
		</h1>

		<table border="1" class="dataTable">
			<tr>
				<th class="dataColl">
					<s:message code="grid.common.id.header" />
				</th>
				<th class="dataColl">
					<s:message code="eventListPage.eventGrid.eventName.header" />
				</th>
				<th class="dataColl">
					<s:message code="eventListPage.eventGrid.eventDesc.header" />
				</th>
				<th class="dataColl">
					<s:message code="eventListPage.eventGrid.eventDate.header" />
				</th>
				<th class="dataColl">
					<s:message code="eventListPage.eventGrid.creator.header" />
				</th>
				<th class="dataColl">
					<s:message code="eventListPage.eventGrid.address.header" />
				</th>
				<th class="dataColl">
					<s:message code="grid.common.actions.header" />
				</th>
			</tr>

			<c:forEach items="${eventList}" var="event">
				<fmt:formatDate value="${event.date}" pattern="dd-MM-yyyy" var="eventDate"/>

				<tr>
					<td class="dataColl">
						<c:out value="${event.id}" />
					</td>
					<td class="dataColl">
						<c:out value="${event.name}" />
					</td>
					<td class="dataColl">
						<c:out value="${event.description}" />
					</td>
					<td class="dataColl">
						<c:out value="${eventDate}" />
					</td>
					<td class="dataColl">
						<c:out value="${event.createdBy}" />
					</td>
					<td class="dataColl">
						<table>
							<tr>
								<td>
									<s:message code="eventListPage.saveAddressForm.city.label" />
								</td>
								<td>
									${event.address.city}
								</td>
							</tr>
							<tr>
								<td>
									<s:message code="eventListPage.saveAddressForm.street.label" />
								</td>
								<td>
									${event.address.street}
								</td>
							</tr>
							<tr>
								<td>
									<s:message code="eventListPage.saveAddressForm.houseNo.label" />
								</td>
								<td>
									${event.address.houseNo}
								</td>
							</tr>
						</table>
					</td>

					<td class="actionsColl dataColl">
						<c:url value="update-event.html" var="update_url">
							<c:param name="event_id" value="${event.id}" />
						</c:url>

						<a href="${update_url}">
							<s:message code="grid.common.actions.updateAction" />
						</a>

						&nbsp;&nbsp;

						<c:url value="delete-event.html" var="delete_url">
							<c:param name="event_id" value="${event.id}" />
						</c:url>

						<a href="${delete_url}">
							<s:message code="grid.common.actions.deleteAction" />
						</a>
					</td>
				</tr>
			</c:forEach>
		</table>

		<br />
		<hr />
		<br />

		<spring:form action="save-event.html" method="post" modelAttribute="event">
			<div>
				<div class="dataFrame shortFrame leftFrame">
					<h1>
						<s:message code="eventListPage.saveEventForm.title" />
					</h1>
	
					<spring:hidden path="id" />
	
					<%-- <s:message code="eventListPage.saveEventForm.eventName.label" /> --%>
					Пользователь:
					<br />
					<spring:select path="createdBy" items="${userList}" itemValue="userName" itemLabel="userName" />
	
					<br />
					<br />
	
					<s:message code="eventListPage.saveEventForm.eventName.label" />
					<br />
					<spring:input path="name" />
	
					<br />
					<br />
	
					<s:message code="eventListPage.saveEventForm.eventDate.label" />
					<br />
					<spring:input path="date" id="event_date_picker" />
					
	
					<br />
					<br />
	
					<s:message code="eventListPage.saveEventForm.eventDesc.label" />
					<br />
					<spring:textarea path="description" cols="50" rows="5" />
	
					<br />
					<br />
					<input type="submit" name="login_btn" value="<s:message code="common.buttons.save" />" />
				</div>
	
				<div class="dataFrame shortFrame leftFrame">
					<h1>
						<s:message code="eventListPage.saveAddressForm.title" />
					</h1>
	
					<spring:hidden path="address.id" />
	
					<s:message code="eventListPage.saveAddressForm.city.label" />
					<br />
					<spring:input path="address.city" />
	
					<br />
					<br />
	
					<s:message code="eventListPage.saveAddressForm.street.label" />
					<br />
					<spring:input path="address.street" />
	
					<br />
					<br />
	
					<s:message code="eventListPage.saveAddressForm.houseNo.label" />
					<br />
					<spring:input path="address.houseNo" />
				</div>
			</div>
		</spring:form>
	</div>


	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery/jquery-3.1.1.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-ui/jquery-ui.min.js"></script>

	<script type="text/javascript">
		$( document ).ready(function() {
			$('#event_date_picker').datepicker({
				showOtherMonths: true,
				selectOtherMonths: true,
				dateFormat: "dd-mm-yy",
				showOn: "button",
				buttonImage: "${pageContext.request.contextPath}/resources/images/calendar-icon-24.png",
				buttonImageOnly: true,
				buttonText: "Select date"
		    });
		});		
	</script>
</body>
</html>
=======
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
	<meta charset="utf-8">

	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css" type="text/css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/js/jquery-ui/jquery-ui.min.css" type="text/css">

	<title>
		<s:message code="application.title" />
	</title>
</head>
<body>

	<div class="dataFrame largeFrame">
		<table>
			<tr>
				<td class="dataColl">
					<a href="users.html">
						<s:message code="menu.item.users" />
					</a>
				</td>
				<td class="dataColl">
					<a href="events.html">
						<s:message code="menu.item.events" />
					</a>
				</td>
			</tr>
		</table>
	</div>

	<div class="dataFrame largeFrame leftFrame">
		<h1>
			<s:message code="eventListPage.header.title" />
		</h1>

		<table border="1" class="dataTable">
			<tr>
				<th class="dataColl">
					<s:message code="grid.common.id.header" />
				</th>
				<th class="dataColl">
					<s:message code="eventListPage.eventGrid.eventName.header" />
				</th>
				<th class="dataColl">
					<s:message code="eventListPage.eventGrid.eventDesc.header" />
				</th>
				<th class="dataColl">
					<s:message code="eventListPage.eventGrid.eventDate.header" />
				</th>
				<th class="dataColl">
					<s:message code="eventListPage.eventGrid.creator.header" />
				</th>
				<th class="dataColl">
					<s:message code="eventListPage.eventGrid.address.header" />
				</th>
				<th class="dataColl">
					<s:message code="grid.common.actions.header" />
				</th>
			</tr>

			<c:forEach items="${eventList}" var="event">
				<fmt:formatDate value="${event.date}" pattern="dd-MM-yyyy" var="eventDate"/>

				<tr>
					<td class="dataColl">
						<c:out value="${event.id}" />
					</td>
					<td class="dataColl">
						<c:out value="${event.name}" />
					</td>
					<td class="dataColl">
						<c:out value="${event.description}" />
					</td>
					<td class="dataColl">
						<c:out value="${eventDate}" />
					</td>
					<td class="dataColl">
						<c:out value="${event.createdBy}" />
					</td>
					<td class="dataColl">
						<table>
							<tr>
								<td>
									<s:message code="eventListPage.saveAddressForm.city.label" />
								</td>
								<td>
									${event.address.city}
								</td>
							</tr>
							<tr>
								<td>
									<s:message code="eventListPage.saveAddressForm.street.label" />
								</td>
								<td>
									${event.address.street}
								</td>
							</tr>
							<tr>
								<td>
									<s:message code="eventListPage.saveAddressForm.houseNo.label" />
								</td>
								<td>
									${event.address.houseNo}
								</td>
							</tr>
						</table>
					</td>

					<td class="actionsColl dataColl">
						<c:url value="update-event.html" var="update_url">
							<c:param name="event_id" value="${event.id}" />
						</c:url>

						<a href="${update_url}">
							<s:message code="grid.common.actions.updateAction" />
						</a>

						&nbsp;&nbsp;

						<c:url value="delete-event.html" var="delete_url">
							<c:param name="event_id" value="${event.id}" />
						</c:url>

						<a href="${delete_url}">
							<s:message code="grid.common.actions.deleteAction" />
						</a>
					</td>
				</tr>
			</c:forEach>
		</table>

		<br />
		<hr />
		<br />

		<spring:form action="save-event.html" method="post" modelAttribute="event">
			<div>
				<div class="dataFrame shortFrame leftFrame">
					<h1>
						<s:message code="eventListPage.saveEventForm.title" />
					</h1>
	
					<spring:hidden path="id" />
	
					<%-- <s:message code="eventListPage.saveEventForm.eventName.label" /> --%>
					Пользователь:
					<br />
					<spring:select path="createdBy" items="${userList}" itemValue="userName" itemLabel="userName" />
	
					<br />
					<br />
	
					<s:message code="eventListPage.saveEventForm.eventName.label" />
					<br />
					<spring:input path="name" />
	
					<br />
					<br />
	
					<s:message code="eventListPage.saveEventForm.eventDate.label" />
					<br />
					<spring:input path="date" id="event_date_picker" />
					
	
					<br />
					<br />
	
					<s:message code="eventListPage.saveEventForm.eventDesc.label" />
					<br />
					<spring:textarea path="description" cols="50" rows="5" />
	
					<br />
					<br />
					<input type="submit" name="login_btn" value="<s:message code="common.buttons.save" />" />
				</div>
	
				<div class="dataFrame shortFrame leftFrame">
					<h1>
						<s:message code="eventListPage.saveAddressForm.title" />
					</h1>
	
					<spring:hidden path="address.id" />
	
					<s:message code="eventListPage.saveAddressForm.city.label" />
					<br />
					<spring:input path="address.city" />
	
					<br />
					<br />
	
					<s:message code="eventListPage.saveAddressForm.street.label" />
					<br />
					<spring:input path="address.street" />
	
					<br />
					<br />
	
					<s:message code="eventListPage.saveAddressForm.houseNo.label" />
					<br />
					<spring:input path="address.houseNo" />
				</div>
			</div>
		</spring:form>
	</div>


	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery/jquery-3.1.1.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-ui/jquery-ui.min.js"></script>

	<script type="text/javascript">
		$( document ).ready(function() {
			$('#event_date_picker').datepicker({
				showOtherMonths: true,
				selectOtherMonths: true,
				dateFormat: "dd-mm-yy",
				showOn: "button",
				buttonImage: "${pageContext.request.contextPath}/resources/images/calendar-icon-24.png",
				buttonImageOnly: true,
				buttonText: "Select date"
		    });
		});		
	</script>
</body>
</html>
>>>>>>> N commit from master
