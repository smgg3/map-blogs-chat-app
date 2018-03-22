<!-- Written by Sravani Murakonda (murakondasravani64@gmail.com) -->
<%-- Written by Sravani Murakonda (murakondasravani64@gmail.com) --%>

<%@ page isErrorPage="true" import="java.io.PrintWriter" %>
<HTML>
<HEAD>
<TITLE>Error Occurred</TITLE>
<META http-equiv="pragma" content="no-cache">
<meta name="Author" content="Sravani Murakonda (murakondasravani64@gmail.com)">	
<LINK rel="stylesheet" href="<%=request.getContextPath()%>/chat.css" type="text/css">
</HEAD>
<BODY bgcolor="#FFFFFF">
<h2>Some error occurred</h2>
<pre>
<%
if (exception != null)
{
	//System.out.println("Exception: " +exception.getMessage());
	out.write("<span class=\"error\">Exception: " +exception.getMessage() + "</span><br>");
	exception.printStackTrace( new PrintWriter(out));
}
%>
</pre>
<p>Report to
<%
String admin = null;
if ( ( admin = application.getInitParameter("adminEmail") ) != null )
{
	out.write("<a href=\"mailto:" + admin + "\">" + admin + "</a>");
}

else
{
	out.write("administrator of this web site");
}
%>.
</BODY>
</HTML>
