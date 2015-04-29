
package socket;
public class DatosClienteServidor {

	private String nick;
	private String ip;
	private Integer puerto;

	public DatosClienteServidor(){
		nick = null;
		ip = null;
		puerto = 12345;
	}


	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getNick() {
		return nick;
	}


	public String getIp() {
		return ip;

	}

	public void setIp(String ip) {
		this.ip = ip;
	}


	public Integer getPuerto() {
		return puerto;
	}

	public void setPuerto(Integer puerto) {
		this.puerto = puerto;
	}





}
