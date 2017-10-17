package db.dao;

import org.apache.log4j.Logger;
import pojo.Ticket;
import db.ConnectionManagerPostgreSQL;
import db.IConnectionManager;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class TicketDAO implements IAbstractDAO <Ticket> {
    public static class TicketDAOException extends Exception {

    }

    private static IConnectionManager manager;
    private static final Logger logger = Logger.getLogger(TicketDAO.class);

    static {
        manager = ConnectionManagerPostgreSQL.getInstance();
    }

    @Override
    public List<Ticket> getAll() throws TicketDAOException {
        List<Ticket> ticketList = new ArrayList<>();
        logger.info("Log for getAll Tickets");

        Statement statement = null;

        try {
            statement = manager.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT tk.*" +
                    "FROM ticket tk LEFT JOIN patient pt ON pt.id_patient = tk.patient_id");
            while (resultSet.next()) {
                Ticket ticket = new Ticket(
                        resultSet.getInt("id_ticket"),
                        resultSet.getInt("patient_id"),
                        resultSet.getInt("doctor_id"),
                        resultSet.getInt("medcenter_id"),
                        resultSet.getString("day_patient"),
                        resultSet.getString("time_patient"),
                        resultSet.getString("date_patient"));
                ticketList.add(ticket);
            }
            System.out.println(ticketList);
        } catch (SQLException e) {
            logger.error("This is Error : " + e.getMessage());
            throw new TicketDAOException();
        }
        return ticketList;
    }

    @Override
    public Ticket getByID(int id) throws TicketDAOException {
        PreparedStatement statement = null;
        logger.info("Log for get Ticket by ID");

        try {
            statement = manager.getConnection().prepareStatement("SELECT * FROM ticket WHERE id_ticket = ? ");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return new Ticket(
                    resultSet.getInt("id_ticket"),
                    resultSet.getInt("patient_id"),
                    resultSet.getInt("doctor_id"),
                    resultSet.getInt("medcenter_id"),
                    resultSet.getString("date_patient"),
                    resultSet.getString("day_patient"),
                    resultSet.getString("time_patient"));
        } catch (SQLException e) {
            logger.error("This is Error : " + e.getMessage());
            throw new TicketDAOException();
        }
    }

    private PreparedStatement getUpdateStatement() throws SQLException {
        return manager.getConnection().prepareStatement(
                "UPDATE ticket SET patient_id = ?, doctor_id = ?, medcenter_id = ?, " +
                        "time_patient = ?, date_patient = ?, day_patient = ? WHERE id_ticket = ? ");
    }

    @Override
    public void update(Ticket ticket) throws TicketDAOException {
        PreparedStatement statement = null;
        try {
            statement = getUpdateStatement();
            statement.setInt(1, ticket.getIdTicket());
            statement.setString(2, ticket.getPatientTime());
            statement.setString(3, ticket.getPatientDate());
            statement.setString(4, ticket.getPatientDay());
            statement.setInt(5, ticket.getIdPatient());
            statement.setInt(6, ticket.getIdDoctor());
            statement.setInt(7, ticket.getIdMedCenter());
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error("This is Error : " + e.getMessage());
            throw new TicketDAOException();
        }
    }

    @Override
    public void updateAll(List<Ticket> ticketList) throws TicketDAOException {
        PreparedStatement statement = null;
        try {
            statement = getUpdateStatement();
            for (Ticket ticket : ticketList) {
                statement.setInt(1, ticket.getIdTicket());
                statement.setString(2, ticket.getPatientTime());
                statement.setString(3, ticket.getPatientDate());
                statement.setString(4, ticket.getPatientDay());
                statement.setInt(5, ticket.getIdPatient());
                statement.setInt(6, ticket.getIdDoctor());
                statement.setInt(7, ticket.getIdMedCenter());
                statement.addBatch();
            }
            statement.executeBatch();
        } catch (SQLException e) {
            logger.error("This is Error : " + e.getMessage());
            throw new TicketDAOException();
        }
    }

    @Override
    public void deleteByID(int id) throws TicketDAOException {
        PreparedStatement statement = null;
        try {
            statement = manager.getConnection().prepareStatement(
                    "DELETE ticket WHERE id_ticket = ? ");
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error("This is Error : " + e.getMessage());
            throw new TicketDAOException();
        }
    }

    private PreparedStatement getInsertStatement() throws SQLException {
        return manager.getConnection().
                prepareStatement("INSERT INTO ticket (id_ticket, time_patient, date_patient, day_patient, patient_id, doctor_id, medcenter_id)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?) ");
    }

    @Override
    public void insertOne(Ticket ticket) throws TicketDAOException {
        PreparedStatement statement = null;
        try {
            statement = getInsertStatement();
            statement.setInt(1, ticket.getIdTicket());
            statement.setString(2, ticket.getPatientTime());
            statement.setString(4, ticket.getPatientDay());
            statement.setDate(3, new java.sql.Date(new SimpleDateFormat("yyyy-mm-dd").parse(ticket.getPatientDate()).getTime()));
            statement.setInt(5, ticket.getIdPatient());
            statement.setInt(6, ticket.getIdDoctor());
            statement.setInt(7, ticket.getIdMedCenter());
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error("This is Error : " + e.getMessage());
            throw new TicketDAOException();
        } catch (ParseException e) {
            logger.error("This is Error : " + e.getMessage());
        }
    }

    @Override
    public void insertAll(List<Ticket> ticketList) throws TicketDAOException {
        PreparedStatement statement = null;
        try {
            statement = getInsertStatement();
            for (Ticket ticket : ticketList) {
                statement.setInt(1, ticket.getIdTicket());
                statement.setString(2, ticket.getPatientTime());
                statement.setString(4, ticket.getPatientDay());
                statement.setDate(3, new java.sql.Date(new SimpleDateFormat("yyyy-mm-dd").parse(ticket.getPatientDate()).getTime()));
                statement.setInt(5, ticket.getIdPatient());
                statement.setInt(6, ticket.getIdDoctor());
                statement.setInt(7, ticket.getIdMedCenter());
                statement.addBatch();
            }
            statement.executeBatch();
        } catch (SQLException e) {
            logger.error("This is Error : " + e.getMessage());
            throw new TicketDAOException();
        } catch (ParseException e) {
            logger.error("This is Error : " + e.getMessage());
        }
    }
}
