package isro.chat.servlet;
import java.io.File;

 import javax.servlet.ServletContext;
 import javax.servlet.ServletContextEvent;
 import javax.servlet.ServletContextListener;
 import javax.servlet.annotation.WebListener;
 @WebListener
 public class FileLocationContextListener implements ServletContextListener {
	// public static byte[][] keyfile=null;
 public void contextInitialized(ServletContextEvent servletContextEvent) {
 String rootPath = System.getProperty("catalina.home");
 ServletContext ctx = servletContextEvent.getServletContext();
 String relativePath = ctx.getInitParameter("details.dir");
 System.out.println(rootPath +" "+relativePath);
 File file = new File(rootPath + File.separator + relativePath);
 if(!file.exists()) file.mkdirs();
 System.out.println("File Directory created to be used for storing files");
 ctx.setAttribute("FILES_DIR_FILE", file);
 ctx.setAttribute("FILES_DIR", rootPath + File.separator + relativePath);
 System.out.println("Vikky");
 }

 public void contextDestroyed(ServletContextEvent servletContextEvent) {
 //do cleanup if needed
 }

 }