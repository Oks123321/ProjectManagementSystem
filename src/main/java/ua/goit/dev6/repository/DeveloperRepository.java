package ua.goit.dev6.repository;

import ua.goit.dev6.command.Developer;
import ua.goit.dev6.config.DatabaseManagerConnector;
import ua.goit.dev6.model.DeveloperDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeveloperRepository implements Repository<DeveloperDao> {
    private final DatabaseManagerConnector manager;
    private final static String INSERT = "INSERT INTO developers (first_name, last_name, age, gender) VALUES(?, ?, ?, ?)";
    private final static String FIND_ALL = "SELECT id, first_name, last_name, age, gender FROM developers";
    private final static String DELETE_BY_ID = "DELETE FROM developers WHERE id = ?";
    private final static String SELECT_MAX_ID = "SELECT max(id) AS maxId FROM developers";

    public DeveloperRepository(DatabaseManagerConnector manager) {
        this.manager = manager;
    }

    @Override
    public long save(DeveloperDao developerDao) {
        try (Connection connection = manager.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT)) {
            statement.setString(1, developerDao.getFirst_name());
            statement.setString(2, developerDao.getLast_name());
            statement.setInt(3, developerDao.getAge());
            statement.setString(4, developerDao.getGender().name());
            statement.executeUpdate();
            long id;
            try (ResultSet rs = connection.prepareStatement(SELECT_MAX_ID).executeQuery()) {
            rs.next();
            id = rs.getLong("maxId");
        }
        return id;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    @Override
    public void delete(DeveloperDao entity) {

    }

    @Override
    public DeveloperDao findById(int id) {
        return null;
    }

    @Override
    public List<DeveloperDao> findAll() {
        try (Connection connection = manager.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_ALL)) {
            List<DeveloperDao> result = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                DeveloperDao developerDao = new DeveloperDao();
                developerDao.setId(resultSet.getLong("id"));
                developerDao.setFirst_name(resultSet.getString("first_name"));
                developerDao.setLast_name(resultSet.getString("last_name"));
                developerDao.setAge(resultSet.getInt("age"));
                developerDao.setGender(DeveloperDao.Gender.valueOf(resultSet.getString("gender")));

                result.add(developerDao);
            }
            return result;
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return null;

    }
}

