<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>

<p>Param1:<%= ParamUtil.getString(request, "param1") %>:</p>
<p>Param2:<%= ParamUtil.getString(request, "param2") %>:</p>