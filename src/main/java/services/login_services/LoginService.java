//package services.login_services;
//
//import db.dao.PatientDAO;
//import org.apache.log4j.Logger;
//import pojo.User;
//import services.authorization_services.AuthorizationServiceImpl;
//import servlets.authorization_servlets.AuthServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//
//public class LoginService {
//
//    private static final Logger logger = Logger.getLogger(AuthServlet.class);
//    AuthorizationServiceImpl authorizationService = new AuthorizationServiceImpl();
//    PatientDAO patientDAO = new PatientDAO();//todo servuice
//
//    public void sortUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
//
//        HttpSession currentSession = request.getSession();
//        Boolean isAuth = (Boolean) currentSession.getAttribute("isAuth");
//
//        String role;
//        int userId;
//
//        if (isAuth == null) {
//            isAuth = false;
//        }
//
//        if (isAuth) {
//            role = (String) currentSession.getAttribute("role");
//        } else {
//            String login = request.getParameter("inputLogin");
//            String password = request.getParameter("inputPassword");
//            User user = authorizationService.auth(login, password);
//            role = user.getRole();
//
//            userId = authorizationService.getUserID(login, password); //todo user id poluchat' iz user
//            currentSession.setAttribute("userID", userId);
//
//            try {
//                int patientId = patientDAO.getPatientID(Integer.valueOf(userId));
//                currentSession.setAttribute("patientID", patientId);
//            } catch (PatientDAO.PatientDAOException e) {
//                logger.error("This is Error : " + e.getMessage());
//            }
//        }
//
//        if (!"false".equals(role)){
//            currentSession.setAttribute("isAuth", true);
//            currentSession.setAttribute("role", role);
//            switch (role) {
//                case "admin":
//                    response.sendRedirect("/web/admin_main");
//                    break;
//                case "doctor":
//                    response.sendRedirect("/web/doctor_main");
//                    break;
//                case "patient":
//                    response.sendRedirect("/web/patient_main");
//                    break;
//                default:
//                    response.sendRedirect("/web");
//            }
//        } else {
////            currentSession.setAttribute("isAuth", false);//todo НУЖНО ЛИ
//            response.sendRedirect("/web");
//        }
//    }
//}