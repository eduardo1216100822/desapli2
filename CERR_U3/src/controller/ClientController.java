package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClientDAOImpl;
import model.Client;



/**
 * Servlet implementation class ClientController
 */
@WebServlet("/ClientController")
public class ClientController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Client client; //Creamos el objeto
	private List<Client> clients; //Lista de clientes
	private ClientDAOImpl clientDAO; //Modificamos la lista
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientController() {
        super();
        client = new Client();
        clients = new ArrayList<Client>();
        clientDAO = new ClientDAOImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("btn_save") != null) {
			client.setName(request.getParameter("name"));
			client.setHome(request.getParameter("home"));
			try {
			client.setPhone(Integer.parseInt(request.getParameter("phone")));
			client.setCelphone(Integer.parseInt(request.getParameter("celphone")));
			}catch(Exception e) {
				client.setPhone(1823456);
				client.setCelphone(0);
			}
			client.setMail(request.getParameter("mail"));
			if(client.getId()==0L) {
				clientDAO.createClient(client);
			} else {
				clientDAO.updateClient(client);
			}
			clients = clientDAO.readAllClients();
			request.setAttribute("clients", clients);
			request.getRequestDispatcher("client_list.jsp").forward(request, response);
		} else if (request.getParameter("btn_new") != null) {
			client = new Client();
			request.getRequestDispatcher("client_form.jsp").forward(request, response);
		}else if(request.getParameter("btn_edit")!=null) {
			try {
				Long id = Long.parseLong(request.getParameter("id"));
				client = clientDAO.readClient(id);
			}catch(Exception e) {
				client = new Client();
			}
			request.setAttribute("client", client);
			request.getRequestDispatcher("client_form.jsp").forward(request, response);
		}else if(request.getParameter("btn_delete")!=null) {
			try {
				Long id = Long.parseLong(request.getParameter("id"));
				clientDAO.deleteClient(id);
				clients = clientDAO.readAllClients();
			}catch(Exception e) {
				e.printStackTrace();
			}
			request.setAttribute("clients", clients);
			request.getRequestDispatcher("client_list.jsp").forward(request, response);
		}else {
			clients = clientDAO.readAllClients();
			request.setAttribute("clients", client);
			request.getRequestDispatcher("client_list.jsp").forward(request, response);
		}
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
