<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
	<meta charset="utf-8">

	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css" type="text/css">

	<title>
		<s:message code="application.title" />
	</title>
</head>
<body>

	<div class="dataFrame largeFrame">
		<table>
			<tr>
				<td class="dataColl">
					<a href="org.html">
						<s:message code="menu.item.org" />
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

	<div class="dataFrame largeFrame">
		<h1>
			<s:message code="userListPage.header.title" />
		</h1>

		<table border="1" class="dataTable">
			<tr>
				<th class="dataColl">
					<s:message code="grid.common.id.header" />
				</th>
				<th class="dataColl">
					<s:message code="orgListPage.orgGrid.name.header" />
				</th>
				<th class="dataColl">
					<s:message code="orgListPage.orgGrid.password.header" />
				</th>
				<th class="dataColl">
					<s:message code="orgListPage.orgGrid.createdEventsCount.header" />
				</th>
				<th class="dataColl">
					<s:message code="orgListPage.orgGrid.goingToVisit.header" />
				</th>
				<th class="dataColl">
					<s:message code="grid.common.actions.header" />
				</th>
			</tr>

			<c:forEach items="${orgList}" var="org">
				<tr>
					<td class="dataColl">
						${org.orgId}
					</td>
					<td class="dataColl">
						${org.name}
					</td>
					<td class="dataColl">
						${org.password}
					</td>
					<td class="dataColl">
						${org.eventCount}
					</td>
					<td class="dataColl">
						<ul>
							<c:forEach items="${org.goingToVisit}" var="goingEvent">
								<li>
									${goingEvent.eventInfo}
								</li>
							</c:forEach>
						</ul>
					</td>

					<td class="actionsColl dataColl">
						<c:url value="update-org.html" var="update_url">
							<c:param name="orgId" value="${org.orgId}" />
						</c:url>

						<a href="${update_url}">
							<s:message code="grid.common.actions.updateAction" />
						</a>

						&nbsp;&nbsp;

						<c:url value="delete-org.html" var="delete_url">
							<c:param name="orgId" value="${org.orgId}" />
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

		<div class="dataFrame shortFrame">
			<h1>
				<s:message code="orgListPage.saveOrgForm.title" />
			</h1>

			<spring:form action="save-org.html" method="post" modelAttribute="org">
				<spring:hidden path="orgId" />

				<s:message code="orgListPage.saveUserForm.name.label" />
				<br />
				<spring:input path="name" />

				<br />
				<br />

				<s:message code="orgListPage.saveOrgForm.password.label" />
				<br />
				<spring:input path="password" />

				<br />
				<br />
				<input type="submit" name="login_btn" value="<s:message code="common.buttons.save" />" />

			</spring:form>
		</div>
	</div>
</body>
</html>