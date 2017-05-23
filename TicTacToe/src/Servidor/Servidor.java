package Servidor;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.io.*;

public class Servidor{

	public void init(){
		boolean seguir = true;
		HashMap<Socket, Socket> clientes = new HashMap<>();
		int qt = 0;
		ServerSocket ss;

		try{

			ss = new ServerSocket(5051);

			Socket s1 = ss.accept();
			Socket s2 = ss.accept();
			clientes.put(s1, s2);
			clientes.put(s2, s1);
			new Thread(new Listen(s1,clientes)).start();
			new Thread(new Listen(s2,clientes)).start();
			
			
			while(true){}
		}

		catch(IOException e){

			e.printStackTrace();

		} 

	}

	private class Listen implements Runnable {
		private Socket cliente;
		private HashMap<Socket, Socket> skts;
		public Listen(Socket skt,HashMap<Socket, Socket> skts) {
			cliente = skt;
			this.skts = skts;
		}

		@Override
		public void run() {
			BufferedReader br = null;
			InputStream is = null;
			String msg;
			try {
				is = cliente.getInputStream();

				br = new BufferedReader(new InputStreamReader(is));
				Socket dst = skts.get(cliente);
				
				DataOutputStream out = new DataOutputStream(dst.getOutputStream());
				while (true) {
					msg = br.readLine();
					
					System.out.println(msg);
					out.writeBytes(msg+"\n");

				}
				

			}catch (Exception e) {
				// TODO: handle exception
			}


		}

	} 

	public static void main(String []args) {
		new Servidor().init();
	}
}
