<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML>
  <HEAD>
    <TITLE>
      Secure chat Register
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
	 <META name="author" content="Sravani Murakonda (murakondasravani64@gmail.com)">
	</HEAD>
	<BODY bgcolor="#FFFFFF" onLoad="document.login.nickname.focus();">
	<%@ include file="/header.jsp" %>
    <TABLE width="40%" border="0" cellspacing="1" cellpadding="1" align="center">
	<%
      String U=request.getParameter("U");
      String PC=request.getParameter("PC");
      String EC = request.getParameter("EC");
		 if (U!=null && U.equals("t"))
          {
      %>
      <TR>
        <TD>
          <TABLE width="100%" border="0" cellspacing="1" cellpadding="1" align="center">
            <TR>
              <TD colspan="2" align="center">
                <SPAN class="error">User exists</SPAN><BR>
              </TD>
            </TR>
				<TR>
              <TD colspan="2">
                User Name  <B><%=PC%></B> has already been taken please select some other User Id.
              </TD>
            </TR>
          </TABLE>
        </TD>
      </TR>
      <%
        }
        else if (PC!=null && PC.equals("t"))
        {
      %>
      <TR>
        <TD colspan="2">
          <TABLE width="100%" border="0" cellspacing="1" cellpadding="1" align="center">
            <TR>
              <TD colspan="2" align="center">
                <SPAN class="error">Confirmation Password Wrong</SPAN>
              </TD>
            </TR>
				<TR>
              <TD colspan="2">
                <b>Sex</b> and <b>Nickname</b> must be entered and nickname must be atleast <b>4</b> characters long and must not contain any <b>space</b>.
              </TD>
            </TR>
          </TABLE>
        </TD>
      </TR>
      <%
        }
        else if (EC!=null && EC.equals("t"))
        {
      %>
       <TR>
        <TD colspan="2">
          <TABLE width="100%" border="0" cellspacing="1" cellpadding="1" align="center">
            <TR>
              <TD colspan="2" align="center">
                <SPAN class="error">Email Id is Not Valid</SPAN>
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
          <FORM name="register" method="post" action="RegisterServlet">
            <TABLE width="100%" border="0">
              <TR>
                <TD width="30%" class="white">
                  User name
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
                <TD width="30%" class="white">
                  Confirm Password
                </TD>
                <TD width="70%">
                  <INPUT type="password" name="confpassword" size="15">
                </TD>
              </TR>
          		<TR>
                <TD width="30%" class="white">
                  Email Id
                </TD>
                <TD width="70%">
                  <INPUT type="text" name="email" size="15">
                </TD>
              </TR>
              <TR>
                <TD width="30%" class="white">
                  Sex
                </TD>
                <TD width="70%">
                  <SELECT size="1" name="sex">
                    <OPTION value="m">
                      Male
                    </OPTION>
                    <OPTION value="f">
                      Female
                    </OPTION>
                  </SELECT>
                </TD>
              </TR>
              <TR>
                <TD>
                 &nbsp;  
                </TD>
                <TD>
                  <INPUT type="submit" name="Submit" value="submit">
                </TD>
              </TR>
            </TABLE>
          </FORM>
        </TD>
      </TR>
    </TABLE>
