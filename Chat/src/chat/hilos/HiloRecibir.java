package chat.hilos;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import chat.VentanaChat;

public class HiloRecibir extends Thread
{
	
	private VentanaChat ventanaChat;
	public HiloRecibir(VentanaChat ventanaChat)
	{
		this.ventanaChat=ventanaChat;
	}
	
	@Override
	public void run()
	{
		try(ServerSocket serverSocket= new ServerSocket(5000))
		{
			while(true)
			{
				Socket socket=serverSocket.accept();
				InputStreamReader inputStreamReader= new InputStreamReader(socket.getInputStream());
				BufferedReader bufferedReader= new BufferedReader(inputStreamReader);
				String texto=bufferedReader.readLine();
				getVentanaChat().getTaMensajes().append("el otro dice:"+texto+"\n");
				socket.close();
			}
			
		} catch (Exception e)
		{
			getVentanaChat().getTaMensajes().append(e.getMessage()+"\n");
		}
	}
	

	public VentanaChat getVentanaChat()
	{
		return ventanaChat;
	}

	public void setVentanaChat(VentanaChat ventanaChat)
	{
		this.ventanaChat = ventanaChat;
	}
	

}
