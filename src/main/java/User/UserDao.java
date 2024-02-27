package User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
	
	 private static final String URL = "jdbc:mysql://localhost:3306/jeetpauth?characterEncoding=latin1";
	    private static final String USERNAME = "root";
	    private static final String PASSWORD = "seif2001";

	    private Connection getConnection() throws SQLException, ClassNotFoundException {
	    	Class.forName("com.mysql.jdbc.Driver"); 
	        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
	    }

	    public List<UserBean> getAllUsers() throws ClassNotFoundException {
	        List<UserBean> users = new ArrayList<>();
	        String query = "SELECT * FROM users";
	        try (Connection connection = getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(query);
	             ResultSet resultSet = preparedStatement.executeQuery()) {
	            while (resultSet.next()) {
	                UserBean user = new UserBean();
	                System.out.println(user);
	                user.setId(resultSet.getInt("id"));
	                user.setUsername(resultSet.getString("username"));
	                user.setEmail(resultSet.getString("email"));
	                System.out.println(user);
	                users.add(user);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return users;
	    }

	    public UserBean getUserById(int id) {
	        String query = "SELECT * FROM users WHERE id=?";
	        try (Connection connection = getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	            preparedStatement.setInt(1, id);
	            try (ResultSet resultSet = preparedStatement.executeQuery()) {
	                if (resultSet.next()) {
	                    UserBean user = new UserBean();
	                    user.setId(resultSet.getInt("id"));
	                    user.setUsername(resultSet.getString("username"));
	                    user.setEmail(resultSet.getString("email"));
	                    return user;
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        return null;
	    }

	    public void addUser(UserBean user) {
	        String query = "INSERT INTO users (username, email) VALUES (?, ?)";
	        try (Connection connection = getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	            preparedStatement.setString(1, user.getUsername());
	            preparedStatement.setString(2, user.getEmail());
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    }

	    public void updateUser(UserBean user) {
	        String query = "UPDATE users SET username=?, email=? WHERE id=?";
	        try (Connection connection = getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	            preparedStatement.setString(1, user.getUsername());
	            preparedStatement.setString(2, user.getEmail());
	            preparedStatement.setInt(3, user.getId());
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    }

	    public void deleteUser(int id) {
	        String query = "DELETE FROM users WHERE id=?";
	        try (Connection connection = getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	            preparedStatement.setInt(1, id);
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    }
}
