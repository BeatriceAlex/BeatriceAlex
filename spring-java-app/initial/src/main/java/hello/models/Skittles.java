package hello;

import java.util.List;
import java.util.ArrayList;

public class Skittles {
  private int id;
  private String culoare;
  private String flavor;
  private double gramaj;
  private long cod_bare;
  private double pret;

  public Skittles() {}

  public Skittles(int id, String culoare, String flavor, double gramaj, long cod_bare, double pret) 
  {
      this.id = id;
	  this.culoare = culoare;
	  this.flavor = flavor;
	  this.gramaj = gramaj;
	  this.cod_bare = cod_bare;
	  this.pret = pret;
  }

  public String getCuloare() 
  {
      return this.culoare;
  }

   public String getFlavor() 
  {
      return this.flavor;
  }
  
   public double getGramaj() 
  {
      return this.gramaj;
  }
  
   public long getCod_bare() 
  {
      return this.cod_bare;
  }
  
  public double getpret() 
  {
      return this.pret;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public int setId()
  {
    return this.id;
  }
  
  public void  setCuloare(String culoare) 
  {
      this.culoare= culoare;
  }
  
  public void setFlavor(String  flavor )
  {
     
	  this.flavor = flavor;
      
  }
  
  public void setGramaj(double gramaj )
  {
     
	  this.gramaj = gramaj;
      
  }
  
  public void setCod_bare(long cod_bare )
  {
     
	  this.cod_bare = cod_bare;
      
  }
  
  public void setPret(double pret )
  {
     
	  this.pret = pret;
      
  }
}