package isro.chat.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import isro.chat.*;
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String contextPath = "";
	String filepath="";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Set response content type
		contextPath = request.getContextPath();
		response.sendRedirect(contextPath + "/Login.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		contextPath = request.getContextPath();		
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		filepath = request.getServletContext().getAttribute("FILES_DIR")+File.separator;
	
		FileInputStream checkUserStream = null;
		BufferedReader br = null;
		boolean success = false;
		boolean userMark = false;
		//USERNAME VALIDATION
		int uservalue =0;
		if(username.length()>0 && password.length()>0)
		{
			success =true;
		}
		if(success)
		{
		String checkUser="";
	//	boolean userMark = false;
		try{
			checkUserStream = new FileInputStream(filepath+"UserNames.txt");
			br = new BufferedReader(new InputStreamReader(checkUserStream));
		
			while((checkUser=br.readLine())!=null){
				uservalue++;
				if(username.equals(checkUser)){
					//System.out.println("Username already exist");
					userMark = true;
					break;
				}
			}
			checkUserStream.close();
			checkUserStream = null;
			br.close();
			br=null;
			String userpass="";
			int  count=0;
			if(userMark){
				checkUserStream = new FileInputStream(filepath+"User.passwords");
				br = new BufferedReader(new InputStreamReader(checkUserStream));
			
				while(count<uservalue){
					userpass=br.readLine();
					count++;
				}
				checkUserStream.close();
				checkUserStream = null;
				br.close();
				br=null;
				if(userpass.equals(password)){
					out.write("Authorized user : " + username);
					//send him to chat
					CreateSession(username,request,response);
				}
				else{
					response.sendRedirect(contextPath + "/Login.jsp?PC=t");
				}
			}else{
				response.sendRedirect(contextPath + "/Login.jsp?EC=t");
			}
			
		}catch(Exception e){
			response.sendRedirect(contextPath + "/Login.jsp");
		}
		}else{
			response.sendRedirect(contextPath + "/Login.jsp?R=t");
		}
		
		//out.write("\tSex : " + sex+"<br/>");
	}

	private void CreateSession(String username, HttpServletRequest request, HttpServletResponse response) {
		String nickname = request.getParameter("username");
		nickname = nickname.trim().toLowerCase();
		String sex = "m";
		if (sex.length() > 0)
		{
			sex = sex.trim().toLowerCase();
		}
		if ((nickname != null && nickname.length() > 3 && nickname.indexOf(" ") == -1) && (sex != null && (sex.equals("m") || sex.equals("f") ) ))
		{
			try
			{
				//ChatRoomList rooms = new ChatRoomList();
				
			//	boolean chatterexists = roomlist.chatterExists(nickname);
				
				//System.out.println(chatterexists);
			//	if (chatterexists)
				//{
				//	response.sendRedirect(contextPath + "/login.jsp?d=t&n="+nickname);
				//}
				//else
			//	{
					HttpSession session = request.getSession(true);
					int timeout = 1800; // 30 minutes
					String t = getServletContext().getInitParameter("sessionTimeout"); // gets Minutes
					if (t != null)
					{
						try
						{
							timeout = Integer.parseInt(t);
							timeout = timeout * 60;
							System.out.println(timeout);
						}
						catch (NumberFormatException nfe)
						{							
						}
					}
					session.setMaxInactiveInterval(timeout);
					session.setAttribute("username", nickname);
					ChatRoomList roomlist = (ChatRoomList)getServletContext().getAttribute("chatroomlist");
					System.out.println("HELLO: "  + roomlist.getRoomList());
					// Because Chatter objects are stored in room.
					// So before user selects any room he is added to a temporary room "StartUp"
					ChatRoom chatRoom = roomlist.getRoom("StartUp"); 
					nickname = nickname.toLowerCase();
					Chatter chatter = null;
					if ("m".equals(sex))
					{
						sex = "Male";
					}
					else
					{
						sex = "Female";
					}
					System.out.println("1session : " + session +"\n chatRoom : " + chatRoom + "\n chatter : " + chatter );
					
					chatter = new Chatter(nickname, sex, new java.util.Date().getTime());
					chatRoom.addChatter(chatter);
					System.out.println("2session : " + session +"\n chatRoom : " + chatRoom + "\n chatter : " + chatter );
					response.sendRedirect(contextPath + "/listrooms.jsp");

				}
			//}
			catch(Exception exception)
			{
				System.out.println("Exception thrown in LoginServlet: " + exception.getMessage());
				exception.printStackTrace();
				try {
					response.sendRedirect(contextPath + "/Login.jsp");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		else
		{
			try {
				response.sendRedirect(contextPath + "/Login.jsp?ic=t");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	private void validate(String username, String password) {
		// TODO Auto-generated method stub
		
	}

}
