<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<%@ page errorPage="error.jsp" %>
<%
	String nickname = (String)session.getAttribute("nickname");
	System.out.println(nickname);
	if (nickname != null)
	{
		response.sendRedirect("listrooms.jsp");
	}
%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <HEAD>
    <TITLE>
      S2R Chat - Login
    </TITLE>
	 <META http-equiv="pragma" content="no-cache">
	 <meta name="Author" content="Sravani Murakonda (murakondasravani64@gmail.com)">	
	 <script language="JavaScript">
	 <!--
	 if(window.top != window.self)
	 {
		 window.top.location = window.location;
	 }
	 //-->
	 </script>
	 <LINK rel="stylesheet" href="<%=request.getContextPath()%>/chat.css">
	 <META name="author" content="vikky">
	</HEAD>
	<BODY bgcolor="#FFFFFF" onLoad="document.login.username.focus();">
	<%@ include file="/header.jsp" %>
    <TABLE width="40%" border="0" cellspacing="1" cellpadding="1" align="center">
     <%
 	   String success=request.getParameter("success");
  	  String user=request.getParameter("user");
      String pc=request.getParameter("PC");
      String ec = request.getParameter("EC");
      String s = request.getParameter("S");
      String r = request.getParameter("R");
		
          if (success!=null && success.equals("t"))
          {
      %>
      <TR>
        <TD>
          <TABLE width="100%" border="0" cellspacing="1" cellpadding="1" align="center">
            <TR>
              <TD colspan="2" align="center">
                <SPAN class="error">User Registred Successfully<BR>Please Login to Continue</SPAN><BR>
              </TD>
            </TR>
          </TABLE>
        </TD>
      </TR>
      <%
        }
        else if (pc!=null && pc.equals("t"))
        {
      %>
      <TR>
        <TD colspan="2">
          <TABLE width="100%" border="0" cellspacing="1" cellpadding="1" align="center">
            <TR>
              <TD colspan="2" align="center">
                <SPAN class="error">PASSWORD Wrong</SPAN>
              </TD>
            </TR>
				<TR>
              <TD colspan="2">
                <b>Username and password doesn't match</b> .
              </TD>
            </TR>
          </TABLE>
        </TD>
      </TR>
      <%
        }
        else if (r!=null && r.equals("t"))
        {
      %>
      <TR>
        <TD colspan="2">
          <TABLE width="100%" border="0" cellspacing="1" cellpadding="1" align="center">
            <TR>
              <TD colspan="2" align="center">
                <SPAN class="error">Empty fields</SPAN>
              </TD>
            </TR>
				<TR>
            </TR>
          </TABLE>
        </TD>
      </TR>
      <%
        }
        else if (ec!=null && ec.equals("t"))
        {
      %>
      <TR>
        <TD colspan="2">
          <TABLE width="100%" border="0" cellspacing="1" cellpadding="1" align="center">
            <TR>
              <TD colspan="2" align="center">
                <SPAN class="error">User not exist!!!</SPAN>
              </TD>
            </TR>
				<TR>
              <TD colspan="2">
             <blink>   <a href="register.jsp"><b>   Click to register</b></a></blink>
              </TD>
            </TR>
          </TABLE>
        </TD>
      </TR>
	   
      <%
        }
      %>
      <TR>
        <TD colspan="2" class="panel">
          <FORM name="login" method="post" action="LoginServlet">
            <TABLE width="100%" border="0">
              <TR>
                <TD width="30%" class="white">
                  Username
                </TD>
                <TD width="70%">
                  <INPUT type="text" name="username" size="15">
                </TD>
              </TR>
              <TR>
                <TD width="30%" class="white">
                  Password
                </TD>
                <TD width="70%">
                  <INPUT type="password" name="password" size="15">
                </TD>
              </TR>
              <TR>
                <TD>
                 &nbsp;  
                </TD>
                <TD>
                  <INPUT type="submit" name="Submit" value="Login">
                </TD>
              </TR>
            </TABLE>
          </FORM>
        </TD>
      </TR>
    </TABLE>
<body>
</body>
</html>
