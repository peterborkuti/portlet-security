<%@ include file="/init.jsp" %>

<portlet:renderURL var="viewURL">
    <portlet:param name="param2" value="hello"></portlet:param>
</portlet:renderURL>

<a href="<%= viewURL %>">Click here</a>

<liferay-util:include page="/included.jsp" servletContext="<%= application %>" >
	<liferay-util:param name="param1" value="1" />
</liferay-util:include>