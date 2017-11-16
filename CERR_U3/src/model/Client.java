package model;

public class Client {
	private Long id;
	private String name;
	private String home;
	private int phone;
	private int celphone;
	private String mail;
	
	
	public Client(Long id, String name, String home, int phone, int celphone, String mail) {
		super();
		this.id = id;
		this.name = name;
		this.home = home;
		this.phone = phone;
		this.celphone = celphone;
		this.mail = mail;
	}

	public Client() {
		this(0L,"","",0,0,"");
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHome() {
		return home;
	}

	public void setHome(String home) {
		this.home = home;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public int getCelphone() {
		return celphone;
	}

	public void setCelphone(int celphone) {
		this.celphone = celphone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	
	
	
}
