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

@WebServlet("/PatientInfo.html")
public class PatientInfoServlet extends HttpServlet
{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        Model model = ModelFactory.getModel();
        model.holdPatient();

        int patientIndex = Integer.parseInt(request.getParameter("index"));
        List<String> infolist = model.storeSinglePatientnotJSON(patientIndex);
//        List<String> details = model.storetextAllPatientnotJSON();

        request.setAttribute("info",infolist);

        ServletContext context = getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/detailsList.jsp");
        dispatch.forward(request,response);
    }
}
