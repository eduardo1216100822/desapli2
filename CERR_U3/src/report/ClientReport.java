package report;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClientDAOImpl;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;


/**
 * Servlet implementation class clientController
 */
@WebServlet("/ClientReport")
public class ClientReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClientDAOImpl dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientReport() {
        super();
        // TODO Auto-generated constructor stub
        dao = new ClientDAOImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reportPath = "C:\\Users\\Eduardo\\eclipse-workspace\\CERR_U3\\src\\report\\client_report.jrxml";
		try {
			JasperReport report = JasperCompileManager.compileReport(reportPath);
			
			java.util.Map<String, Object> data = new HashMap();
			//data.put("Image", this.getServletContext().getRealPath("/")+"/images/helloWorld.jpg");
			JasperPrint print = JasperFillManager.fillReport(report, data, dao.getConnection());
			
			JasperExportManager.exportReportToPdfStream(print, response.getOutputStream());
			response.getOutputStream().flush();
			response.getOutputStream().close();
		} catch (Exception e) {
			e.printStackTrace();
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
