package gmarques.androidservlet.servlet;

import java.io.IOException;

import javax.winstone.servlet.ServletException;
import javax.winstone.servlet.http.HttpServlet;
import javax.winstone.servlet.http.HttpServletRequest;
import javax.winstone.servlet.http.HttpServletResponse;

public class AndroidServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=utf-8");
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.getWriter().println("<h1>Hello World from servlet 333</h1>");

    }
}
