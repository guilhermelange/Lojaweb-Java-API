package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.acao.Acao;

//@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String paramAcao = request.getParameter("acao");
		
//		HttpSession sessao = request.getSession();
//		boolean UsuarioNaoLogado = sessao.getAttribute("usuarioLogado") == null;
//		boolean AcaoProtegida = !(paramAcao.equals("Login") || paramAcao.equals("LoginForm"));
//		
//		if (AcaoProtegida && UsuarioNaoLogado) {
//			response.sendRedirect("entrada?acao=LoginForm");
//			return;
//		}
		
		String nomeDaClasse = "br.com.alura.gerenciador.acao." + paramAcao;
		
		String nome;
		try {
			Class<?> classe = Class.forName(nomeDaClasse);
			Acao action = (Acao) classe.newInstance();
			nome = action.executa(request, response);
		} catch (Exception e) {
			throw new ServletException(e);
		}
		
		
		String[] tipoEndereco = nome.split(":");
		if (tipoEndereco[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/"+tipoEndereco[1]);
			rd.forward(request, response);
		} else {
			response.sendRedirect(tipoEndereco[1]);
		}
		
		

//		String nome = null;
//		if (paramAcao.equals("ListaEmpresas")) {
//			ListaEmpresas acao = new ListaEmpresas();
//			nome = acao.executa(request, response);
//		}
//
//		if (paramAcao.equals("RemoveEmpresa")) {
//			RemoveEmpresa acao = new RemoveEmpresa();
//			nome = acao.executa(request, response);
//		}
//
//		if (paramAcao.equals("MostraEmpresa")) {
//			MostraEmpresa acao = new MostraEmpresa();
//			nome = acao.executa(request, response);
//		}
//
//		if (paramAcao.equals("AlteraEmpresa")) {
//			AlteraEmpresa acao = new AlteraEmpresa();
//			nome = acao.executa(request, response);
//		}
//
//		if (paramAcao.equals("NovaEmpresa")) {
//			NovaEmpresa acao = new NovaEmpresa();
//			nome = acao.executa(request, response);
//		}
//		
//		if (paramAcao.equals("NovaEmpresaForm")) {
//			NovaEmpresaForm acao = new NovaEmpresaForm();
//			nome = acao.executa(request, response);
//		}
	}

}
