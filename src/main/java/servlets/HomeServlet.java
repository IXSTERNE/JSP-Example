package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import jakarta.servlet.annotation.WebServlet;

@WebServlet(name = "HomeServlet", urlPatterns = {"/", "/home"})
public class HomeServlet extends HttpServlet {

	@Override
   	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
       	request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);
   	}
}
