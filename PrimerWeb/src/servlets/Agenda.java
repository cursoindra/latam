package servlets;

import java.io.Serializable;

public class Agenda implements Serializable,Comparable<Agenda>
{

	private String nombre, direccion;
	private  String telefono;

	public String getNombre()
	{
		return nombre;
	}

	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}

	public String getDireccion()
	{
		return direccion;
	}

	public void setDireccion(String direccion)
	{
		this.direccion = direccion;
	}

	public String getTelefono()
	{
		return telefono;
	}

	public void setTelefono(String telefono)
	{
		this.telefono = telefono;
	}
	
	public void dameDatos()
	{
		System.out.println(this.getNombre()+" - "+this.getDireccion()+" - "+this.getTelefono());
	}

	//@Override
	public int compareTo(Agenda otro)
	{
		
		return this.getNombre().compareTo(otro.getNombre());
	}
	
	@Override
	public int hashCode()
	{
		
		return this.getNombre().hashCode()+this.getDireccion().hashCode()+this.getTelefono().hashCode();
	}

	
	@Override
	public boolean equals(Object obj)
	{
		Agenda otro=(Agenda) obj;
		return this.getNombre().equals(otro.getNombre()) && this.getDireccion().equals(otro.getDireccion()) && this.getTelefono().equals(otro.getTelefono());
	}
}


