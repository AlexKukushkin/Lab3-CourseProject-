package servlets.patient_servlets.patient_ticket_servlets;

import db.dao.DoctorDAO;
import services.patient_services.PatientService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class TicketSpecializationServlet extends HttpServlet {

    PatientService patientService = new PatientService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/ticket_specialization.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        List<String> specializations;

        int idMedCenter = Integer.parseInt(req.getParameter("idMedCenter"));
        HttpSession session = req.getSession(true);
        session.setAttribute("idMedCenter", idMedCenter);

        specializations = patientService.getDoctorSpecialization(idMedCenter);

        req.setAttribute("specializations", specializations);
        req.getRequestDispatcher("/ticket_specialization.jsp").forward(req, resp);
    }
}