

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionServlet2
 */
@WebServlet("/SessionServlet2")
public class SessionServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);
		if(session==null){
			out.println("No session information available!!");
		}else{
			Enumeration e = session.getAttributeNames();
			out.println("<table><tr><td>Session Info Name</td><td>Session Info Value</td></tr>");
			while(e.hasMoreElements()){
				String name= e.nextElement().toString();
				String value = session.getAttribute(name).toString();
				out.println("<tr><td>"+name+"</td><td>"+value+"</td>");
			}
			out.println("</table>");
		}
		
	
		long l1 = session.getCreationTime();
		long l2 = session.getLastAccessedTime();
		int i = session.getMaxInactiveInterval();
		
		out.println("<h1>creation time is:" + new Date(l1)+"</h1>");
		out.println("<h1>Last accessed time is:" + new Date(l2)+"</h1>");
		out.println("<h1>MAx inactive interval is:" + i+"</h1>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
