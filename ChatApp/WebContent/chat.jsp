<!-- Written by Sravani Murakonda (murakondasravani64@gmail.com) -->
<%-- Written by Sravani Murakonda (murakondasravani64@gmail.com) --%>

<%@ page session="true" import="isro.chat.ChatRoomList, isro.chat.ChatRoom" errorPage="error.jsp"%>
<%
	String nickname = (String)session.getAttribute("nickname");
	if (nickname != null && nickname.length() > 0)
	{
		ChatRoomList roomList = (ChatRoomList) application.getAttribute("chatroomlist");
		ChatRoom room = roomList.getRoomOfChatter(nickname);
		String roomname = room.getName();
%>
	
<HTML>
<HEAD>
<TITLE>S2R Chat - <%=nickname%> (<%=roomname%>) </TITLE>
<META name="Author" value="Sravani Murakonda (murakondasravani64@gmail.com)">
</HEAD>
<FRAMESET rows="80%,20%">
<FRAME SRC="displayMessages.jsp#current" name="MessageWin">
<FRAME SRC="sendMessage.jsp" name="TypeWin">
</FRAMESET>
<NOFRAMES>
<H2>This chat rquires a browser with frames support</h2>
</NOFRAMES>
</HTML>
<%
}
else
{
	response.sendRedirect("Login.jsp");
}
%>
