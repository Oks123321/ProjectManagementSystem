package ua.goit.dev6.repository;

import ua.goit.dev6.config.DatabaseManagerConnector;
import ua.goit.dev6.model.DeveloperDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DeveloperRepository implements Repository<DeveloperDao> {
    private final DatabaseManagerConnector manager;
    private final static String INSERT = "INSERT INTO developer (first_name, last_name, age, gender) VALUES(?, ?, ?, ?)";

    public DeveloperRepository(DatabaseManagerConnector manager) {
        this.manager = manager;
    }

    @Override
    public DeveloperDao save(DeveloperDao entity) {
        try (Connection connection = manager.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT)) {
            statement.setString(1, entity.getFirst_name());
            statement.setString(2, entity.getLast_name());
            statement.setInt(3, entity.getAge());
            statement.setString(4, entity.getGender().name());
            statement.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
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
        return null;
    }
}
