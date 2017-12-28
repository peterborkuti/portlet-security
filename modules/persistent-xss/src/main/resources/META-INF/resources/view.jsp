<%@ include file="/init.jsp" %>

<portlet:actionURL name="addEntry" var="addEntryURL"></portlet:actionURL>

<aui:form action="<%= addEntryURL %>" name="<portlet:namespace />fm" method="post">
	<aui:fieldset>
		<aui:input name="message"></aui:input>
	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit"></aui:button>
	</aui:button-row>
</aui:form>

<%
String message = portletPreferences.getValue("message", "No message");
%>

<p>
	<b>Message:<%= message %></b>
</p>