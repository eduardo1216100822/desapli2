package dao;

import java.util.List;
import model.Client;

public interface ClientDAO {
	void createClient(Client student);
	Client readClient(Long id);
	List<Client> readAllClients();
	void updateClient(Client client);
	void deleteClient(Long id);
	
}