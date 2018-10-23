package br.com.exemplo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;



/**
 * Servlet implementation class OlaMundo
 */
@WebServlet(name= "mostrarOlaMundo", urlPatterns= {"/exemplo", "/oi", "/ola"})
public class OlaMundo extends HttpServlet {
	
	@Resource(name="jdbc/web-aluno")
	private DataSource dataSource;
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
	
		Connection con = null;
		try {
			con = dataSource.getConnection();
		PrintWriter out = response.getWriter();
		
		// escreve o texto no navegador de internet
		
		out.println("<html>");
		out.println("<body>");
		out.println("Ol&aacute; mundo!");
		out.println("</body>");
		out.println("</html>");
	}catch (Exception e) {
		e.printStackTrace();}
	}
	
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OlaMundo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
