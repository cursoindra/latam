package chat;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import chat.hilos.HiloEnvio;
import chat.hilos.HiloRecibir;

public class VentanaChat extends Frame implements WindowListener, ActionListener
{

	Label lMensaje;
	TextField tMensaje;
	Button bEnviar;
	TextArea taMensajes;
	
	public static final String IP="10.101.158.192";
	
	//public static final String IP="192.168.189.135";
	
	public VentanaChat()
	{
		setTitle("VENTANA RECEPCION");
		setlMensaje(new Label("MENSAJE:"));
		settMensaje(new TextField(80));
		setbEnviar(new Button("ENVIAR"));
		setTaMensajes(new TextArea());
		
		Panel panel= new Panel();
		panel.setBackground(Color.PINK);
		panel.add(getlMensaje());
		panel.add(gettMensaje());
		panel.add(getbEnviar());
		this.add(panel,BorderLayout.NORTH);
		this.add(getTaMensajes(),BorderLayout.CENTER);
		getbEnviar().addActionListener(this);
		
		HiloRecibir hiloRecibir= new HiloRecibir(this);
		hiloRecibir.start();
	}
	public static void main(String[] args)
	{
		VentanaChat ventanaChat= new VentanaChat();
		ventanaChat.setSize(1000,500);
		ventanaChat.setVisible(true);
		ventanaChat.addWindowListener(ventanaChat);

	}

	@Override
	public void windowOpened(WindowEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e)
	{
		System.exit(0);
		
	}

	@Override
	public void windowClosed(WindowEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e)
	{
		// TODO Auto-generated method stub
		
	}
	public Label getlMensaje()
	{
		return lMensaje;
	}
	public void setlMensaje(Label lMensaje)
	{
		this.lMensaje = lMensaje;
	}
	public TextField gettMensaje()
	{
		return tMensaje;
	}
	public void settMensaje(TextField tMensaje)
	{
		this.tMensaje = tMensaje;
	}
	public Button getbEnviar()
	{
		return bEnviar;
	}
	public void setbEnviar(Button bEnviar)
	{
		this.bEnviar = bEnviar;
	}
	public TextArea getTaMensajes()
	{
		return taMensajes;
	}
	public void setTaMensajes(TextArea taMensajes)
	{
		this.taMensajes = taMensajes;
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		//getTaMensajes().append(gettMensaje().getText()+"\n");
		HiloEnvio hiloEnvio= new HiloEnvio(this);
		hiloEnvio.start();
		
	}

}
