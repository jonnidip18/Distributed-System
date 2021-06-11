package HW06_11;

import org.apache.xmlrpc.WebServer;

public class JavaServer {
	public int sum(int x, int y) {
		return x + y;
	}
	
	public int sub(int x, int y) {
		return x - y;
	}
	
	public int mul(int x, int y) {
		return x * y;
	}
	
	public double div(int x, int y) {
		return x / y;
	}


	public static void main(String[] args) {
		try {
			// setup server
			WebServer server = new WebServer(90);
			
			// add services
			server.addHandler("JavaServer", new JavaServer());
			
			// start server
			server.start();
			System.out.println("Started successfully.");
		} catch (Exception exception) {
			System.err.println("JavaServer: " + exception);
		}
	}
}