<%@ page contentType="text/html" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ include file="/WEB-INF/jsp/include/header.jsp" %>

<spring:message code="edit.submit" var="submit"/>

<div class="row">
	<div class="col-xs-12">

		<h1><spring:message code="edit.title" arguments="${person.fullName}" /></h1>
		
		<form:form method="POST" commandName="person">
			<h2><spring:message code="edit.person.userDetails" /></h2>
		
			<div class="checkbox">
			    <label>
			      <form:checkbox path="authorised" /> <spring:message code="edit.person.authorised" />
			    </label>
			 </div>
		
			 <div class="checkbox">
			    <label>
			      <form:checkbox path="enabled" /> <spring:message code="edit.person.enabled" />
			    </label>
			 </div>
		
			<h2><spring:message code="edit.person.favouriteColour"/></h2>
		
			<c:forEach var="colour" items="${allColours}">
				<div class="checkbox">
					<label>
						<form:checkbox path="favouriteColours" value="${colour.id}" /> ${colour.name}
				    </label>
				 </div>
			</c:forEach>
		
			<input type="submit" value="${submit}" class="btn btn-primary" />
			<a class="btn btn-default" href="${pageContext.request.contextPath}"><spring:message code="edit.cancel" /></a>
		</form:form>
	</div>
</div>

<%@ include file="/WEB-INF/jsp/include/footer.jsp" %>
