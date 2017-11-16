package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Client;

public class ClientDAOImpl implements ClientDAO {
	
	private Connection connection;
	private Statement statemet;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	
	public ClientDAOImpl() {
		getConnection();
	}
	
	public Connection getConnection() {
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/client","postgres","1234");
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}
	

	@Override
	public void createClient(Client client) {
		
		if(connection!=null) {
			try {
				preparedStatement = connection.prepareStatement("INSERT INTO clients (name, home,phone,celphone,mail) values(?,?,?,?,?);");
				preparedStatement.setString(1, client.getName());
				preparedStatement.setString(2, client.getHome());
				preparedStatement.setInt(3, client.getPhone());
				preparedStatement.setInt(4, client.getCelphone());
				preparedStatement.setString(5, client.getMail());
				preparedStatement.execute();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public Client readClient(Long id) {
		
		Client client = null;
		
		if(connection!=null) {
			try {
				preparedStatement = connection.prepareStatement("Select * from clients WHERE id = ?;");
				preparedStatement.setLong(1, id);
				resultSet = preparedStatement.executeQuery();
				
				if(resultSet.next()) {
					client = new Client(resultSet.getLong(1),resultSet.getString(2),resultSet.getString(3),resultSet.getInt(4),resultSet.getInt(5), resultSet.getString(6));
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return client;
	}

	@Override
	public List<Client> readAllClients() {
		List<Client> clients = new ArrayList<Client>();
		
		if(connection!=null) {
			try {
				preparedStatement = connection.prepareStatement("Select * from clients;");
				resultSet = preparedStatement.executeQuery();
				
				while(resultSet.next()) {
					
					Client client = new Client(resultSet.getLong(1),resultSet.getString(2),resultSet.getString(3),resultSet.getInt(4), resultSet.getInt(5), resultSet.getString(6));
					clients.add(client);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return clients;
	}

	@Override
	public void updateClient(Client client) {
		// if(connection!=null) {
		try {
			preparedStatement = connection.prepareStatement("UPDATE clients set name = ?, home =?, phone= ?,celphone=?,mail = ? WHERE id = ?;");
			preparedStatement.setString(1, client.getName());
			preparedStatement.setString(2, client.getHome());
			preparedStatement.setInt(3, client.getPhone());
			preparedStatement.setInt(4, client.getCelphone());
			preparedStatement.setString(5, client.getMail());
			preparedStatement.setLong(6, client.getId());
			preparedStatement.execute();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
	

	@Override
	public void deleteClient(Long id) {
		if(connection!=null) {
		try {
			preparedStatement = connection.prepareStatement("DELETE FROM clients WHERE id = ?;");
			preparedStatement.setLong(1, id);
			preparedStatement.execute();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
	}	
}
