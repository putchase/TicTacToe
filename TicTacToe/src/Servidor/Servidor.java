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
		ServerSocket servidor;

		try{

			servidor = new ServerSocket(5051);
			
			//mensagem inicial apenas pro primeiro cliente a se conectar
			Socket s1 = servidor.accept();
			DataOutputStream first = new DataOutputStream(s1.getOutputStream());
			first.writeBoolean(true);
	
			Socket s2 = servidor.accept();
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
			BufferedReader reader = null;
			InputStream inCliente = null;
			String msg;
			try {
				inCliente = cliente.getInputStream();

				reader = new BufferedReader(new InputStreamReader(inCliente));
				Socket dst = skts.get(cliente);
				
				DataOutputStream outCliente = new DataOutputStream(dst.getOutputStream());
				while (true) {
					msg = reader.readLine();
					
					System.out.println(msg);
					outCliente.writeBytes(msg+"\n");

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

