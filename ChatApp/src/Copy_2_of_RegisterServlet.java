

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class Copy_2_of_RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String contextPath;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Copy_2_of_RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		contextPath = request.getContextPath();
		response.sendRedirect(contextPath + "/register.jsp");	
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
		String confpassword = request.getParameter("confpassword");
		String email = request.getParameter("email");
		String sex = request.getParameter("sex");
		String filepath = request.getServletContext().getAttribute("FILES_DIR")+File.separator;
	
		
		//USERNAME VALIDATION
		String checkUser="";
		FileInputStream checkUserStream = new FileInputStream(filepath+"UserNames.txt");
		char ch;boolean userMark = false;
		if(checkUserStream != null){
		do{
			ch = (char) checkUserStream.read();
			if(ch=='\n'){
				System.out.println(checkUser + "-->" + checkUser.equals(username) );
				if (userMark = checkUser.equals(username)){
					break;
				}
				checkUser = "";
				}
			checkUser = checkUser + ch;
			}while((int)ch !=-1);
		}
		checkUserStream.close();
		
		if(userMark){
			System.out.println(userMark);
			response.sendRedirect(contextPath + "/register.jsp?U=&PC=");
			}
		else{
			FileOutputStream usernameStream = new FileOutputStream(filepath+"UserNames.txt",true);
			FileOutputStream passwordStream = new FileOutputStream(filepath+"User.passwords",true);
			FileOutputStream userDetailsStream = new FileOutputStream(filepath+"UserDetails.txt",true);
			for(int i=0;i<username.length();i++){
				usernameStream.write(username.charAt(i));
			}
			
			for(int i=0;i<password.length();i++){
					passwordStream.write(password.charAt(i));
				
				}
			
			for(int i=0;i<username.length();i++){
				userDetailsStream.write(username.charAt(i));
				}
			userDetailsStream.write(' ');
			for(int i=0;i<email.length();i++){
				userDetailsStream.write(email.charAt(i));
				}
			userDetailsStream.write(' ');
			userDetailsStream.write(sex.charAt(0));
		
			userDetailsStream.write('\n');
			usernameStream.write('\n');
			passwordStream.write('\n');
			
			usernameStream.close();
			passwordStream.close();
			userDetailsStream.close();
		}
	//	out.write("\tUsername : " + nickname+"<br/>");
	//	out.write("\tPassword : " + password+"<br/>");
		//out.write("\tSex : " + sex+"<br/>");
	}

}
