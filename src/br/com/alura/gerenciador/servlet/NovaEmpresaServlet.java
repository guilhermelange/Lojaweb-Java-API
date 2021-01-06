package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

//Utilizando o loadOnStartup=1 a classe é instanciada já no Startup do Tomcat, consequentemente ele executará o contrutor da classe. Stonks!
//@WebServlet(urlPatterns="/oi", loadOnStartup=1)

//@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomeEmpresa = request.getParameter("nome");
		String dataEmpresa = request.getParameter("data");
		
		
		Date dataAbertura = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataAbertura = sdf.parse(dataEmpresa);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		Empresa empresa = new Empresa();	
		empresa.setNome(nomeEmpresa);
		empresa.setDataAbertura(dataAbertura);
		
		Banco banco = new Banco();
		banco.adiciona(empresa);
		
		request.setAttribute("empresa", empresa.getNome());
		
		response.sendRedirect("listaEmpresas");
		
//		PrintWriter out = response.getWriter();
//		out.println("<html><body>Empresa "+ nomeEmpresa +" Cadastrada.</body></html>");
		

//		
////		Chamar o JSP.
//		RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas");
//		rd.forward(request, response);
	}

}
