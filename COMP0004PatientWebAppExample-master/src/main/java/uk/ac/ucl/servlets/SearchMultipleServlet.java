package uk.ac.ucl.servlets;

import uk.ac.ucl.model.Model;
import uk.ac.ucl.model.ModelFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/runsearchmultiple.html")
public class SearchMultipleServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Model model = ModelFactory.getModel();
        model.holdPatient();
        List<String> searchResult = model.searchMultiple(request.getParameter("searchRangeStart"),
                request.getParameter("searchRangeEnd"),request.getParameter("searchByAge"),
                request.getParameter("searchGender"),request.getParameter("searchCity"),
                request.getParameter("searchEthnicity"),request.getParameter("searchRace"));
        request.setAttribute("result", searchResult);

        ServletContext context = getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/searchMultipleResult.jsp");
        dispatch.forward(request, response);
    }
}
