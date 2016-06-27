<%@ page contentType="text/html" isELIgnored="false" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ include file="/WEB-INF/jsp/include/header.jsp" %>

<c:set var="tableDataYes">
	<td class="text-success"><spring:message code="index.tablecontent.true"/></td>
</c:set>
<c:set var="tableDataNo">
	<td class="text-danger"><spring:message code="index.tablecontent.false"/></td>
</c:set>

<div class="row">
	<div class="col-xs-12">
	
		<h1><spring:message code="index.title"/></h1>
	
		<table class="table">
			<thead>
				<tr>
					<th><spring:message code="index.tableHeader.name"/></th>
					<th><spring:message code="index.tableHeader.palindrome"/></th>
					<th><spring:message code="index.tableHeader.authorised"/></th>
					<th><spring:message code="index.tableHeader.enabled"/></th>
					<th><spring:message code="index.tableHeader.colours"/></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${people}" var="person">
					<tr>
						<td><a href="update/${person.id}">${person.fullName}</a></td>
						${person.palindrome ? tableDataYes : tableDataNo}
						${person.authorised ? tableDataYes : tableDataNo}
						${person.enabled ? tableDataYes : tableDataNo}
						<td>			
							<c:forEach var="colour" items="${person.favouriteColours}" varStatus="status">
								${colour.name}<c:if test="${!status.last}">,&nbsp;</c:if>
							</c:forEach>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>

<%@ include file="/WEB-INF/jsp/include/footer.jsp" %>