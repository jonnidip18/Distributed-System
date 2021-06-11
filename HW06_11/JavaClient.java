package HW06_11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Vector;

import org.apache.xmlrpc.XmlRpcClient;

public class JavaClient {
	public static void main(String[] args) {
		try {
			// XmlRpcClient
			XmlRpcClient client =  new XmlRpcClient("http://localhost:90");

			while (true) {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Input 1 for addition, 2 for subtraction, 3 for multiplication, 4 for division, 5 for stop.");
				int num = Integer.parseInt(br.readLine());
				if (num == 5) break;
				System.out.println("First number");
				int num1 = Integer.parseInt(br.readLine());
				System.out.println("Second number");
				int num2 = Integer.parseInt(br.readLine());
				
				// params
				Vector params = new Vector();
				params.addElement(num1);
				params.addElement(num2);
				switch (num){
					case 1:
						// call a remote function
						Object result1 =  client.execute("JavaServer.sum", params);

						// process result
						int sum = ((Integer) result1).intValue();
						System.out.println("The sum is: " + sum);
						break;
						
					case 2:
						// call a remote function
						Object result2 =  client.execute("JavaServer.sub", params);

						// process result
						int sub = ((Integer) result2).intValue();
						System.out.println("The sub is: " + sub);
						break;
						
					case 3:
						// call a remote function
						Object result3 =  client.execute("JavaServer.mul", params);

						// process result
						int mul = ((Integer) result3).intValue();
						System.out.println("The sub is: " + mul);
						break;
						
					case 4:
						Vector params1 = new Vector();
						params1.addElement(num1*1.0);
						params1.addElement(num2*1.0);
						// call a remote function
						Object result4 =  client.execute("JavaServer.div", params1);

						// process result
						double div = ((Double) result4).doubleValue();
						System.out.println("The sub is: " + div);
						break;
				}
			}
		} catch (Exception exception) {
			System.err.println("JavaClient: " + exception);
		}
	}
}