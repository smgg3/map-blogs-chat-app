package isro.chat.servlet;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String contextPath;
	String filepath="";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		filepath = request.getServletContext().getAttribute("FILES_DIR")+File.separator;
	
		FileInputStream checkUserStream = null;
		BufferedReader br = null;
		boolean success = false;
		boolean userMark = false;
		//USERNAME VALIDATION
		if(username.length()>0 && password.length()>0 && confpassword.length()>0 && email.length()>0)
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
				if(username.equals(checkUser)){
					System.out.println("Username already exist");
					userMark = true;
				}
			}
			checkUserStream.close();
			validate(username,password,confpassword,email,sex,response,userMark);
		}catch(Exception e){
			writeUserInfo(username,password,email,sex);
			response.sendRedirect(contextPath + "/login.jsp");
		}
		}else{
			response.sendRedirect(contextPath + "/register.jsp?R=t");
		}
		
	//	out.write("\tUsername : " + nickname+"<br/>");
	//	out.write("\tPassword : " + password+"<br/>");
		//out.write("\tSex : " + sex+"<br/>");
	}
	void validate(String username, String password, String confpassword, String email, String sex, HttpServletResponse response, boolean userMark){
		try{
		if(userMark){
			System.out.println(userMark);
			response.sendRedirect(contextPath + "/register.jsp?U=t&user="+username);
			}
		else if(!(password.equals(confpassword))|| password==null){
			response.sendRedirect(contextPath + "/register.jsp?U=&PC=t");
		}else if(!(checkEmail(email)) || email==null){
			response.sendRedirect(contextPath + "/register.jsp?U=&PC=&EC=t");
		}else if(sex==null){
			response.sendRedirect(contextPath + "/register.jsp?U=&PC=&EC=&S=t");
		
		}
		else{
			writeUserInfo(username,password,email,sex);
			response.sendRedirect(contextPath + "/Login.jsp?success=t");
		}
		}catch(Exception e ){
			
		}
	}
	void writeUserInfo(String username,String password,String email,String sex)
	{
		try{
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
	System.out.println("Successfully added user : ");
	}catch(Exception e){
			
	}
	}
	boolean checkEmail(String email){
		if(email!=null)
			return true;
		else
			return false;
	}
}
