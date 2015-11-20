package hello;

import java.util.List;
import java.util.ArrayList;

public class Biblioteca {
  private int id;
  private String gen;
  private String autor;
  private String titlu;
  private int volum;
  private String editie;
  private long cod;

  public Biblioteca() {}

  public Biblioteca(int id, String gen, String autor, String titlu, int volum , String editie, long cod) 
  {
      this.id = id;
	  this.gen = gen;
	  this.autor = autor;
	  this.titlu = titlu;
	  this.volum = volum;
	  this.editie = editie;
	  this.cod = cod;
   }

  public String getGen() 
  {
      return this.gen;
  }

   public String getAutor() 
  {
      return this.autor;
  }
  
   public String getTitlu() 
  {
      return this.titlu;
  }
  
   public int getVolum() 
  {
      return this.volum;
  }
  
  public String getEditie() 
  {
      return this.editie;
  }
  
  public long getCod() 
  {
      return this.cod;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public int setId()
  {
    return this.id;
  }
  
  public void  setGen(String gen) 
  {
      this.gen= gen;
  }
  
  public void setAutor(String  autor )
  {
     
	  this.autor = autor;
      
  }
  
  public void setTitlu(String titlu )
  {
     
	  this.titlu = titlu;
      
  }
  
  public void setVolum(int volum )
  {
     
	  this.volum = volum;
      
  }
  
  public void setEditie(String editie )
  {
     
	  this.editie = editie;
      
  }
  
  public void setCod(long cod )
  {
     
	  this.cod = cod;
      
  }
}