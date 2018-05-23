package chat.hilos;

import java.io.PrintWriter;
import java.net.Socket;

import chat.VentanaChat;

public class HiloEnvio extends Thread
{
	private VentanaChat ventanaChat;
	public HiloEnvio(VentanaChat ventanaChat)
	{
		this.ventanaChat=ventanaChat;
	}
	
	
	@Override
	public void run()
	{
		try(Socket socket= new Socket(VentanaChat.IP, 5000);
				PrintWriter printWriter= new PrintWriter(socket.getOutputStream()))
		{
			socket.setSoTimeout(5);
			printWriter.println(getVentanaChat().gettMensaje().getText());
			socket.getOutputStream().flush();
			getVentanaChat().getTaMensajes().append("yo digo:"+getVentanaChat().gettMensaje().getText()+"\n");
			getVentanaChat().gettMensaje().setText("");
			
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
