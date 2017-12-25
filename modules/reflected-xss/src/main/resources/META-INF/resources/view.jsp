<%@ include file="/init.jsp" %>

<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>

<%
String paramValue = ParamUtil.getString(request, "exampleParam");
%>

<portlet:renderURL var="viewURL">
    <portlet:param name="mvcPath" value="/view.jsp"></portlet:param>
    <portlet:param name="exampleParam" value="hello"></portlet:param>
</portlet:renderURL>

<p>
	<a href="<%= viewURL %>">Click here</a>
</p>

:<%= paramValue %>:
