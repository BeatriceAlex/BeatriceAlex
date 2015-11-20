package hello;

import java.util.List;
import java.util.ArrayList;

public class Cos_cumparaturi {
  private int id;
  private String categorie;
  private String produs;
  private int cantitate;
  private double pret_bucata;
  private double pret_total;
  
  public Cos_cumparaturi() {}

  public Cos_cumparaturi(int id, String categorie, String produs,  int cantitate,  double pret_bucata) 
  {
      this.id = id;
	  this.categorie=categorie;
	  this.produs = produs;
	  this.cantitate=cantitate;
	  this.pret_bucata = pret_bucata;
	  this.pret_total=pret_bucata*cantitate;
  }

  public String getcategorie() {
      return this.categorie;
  }
  
  public String getprodus() {
      return this.produs;
  }

  public int getcantitate() {
      return this.cantitate;
  }
  
  public double getpret_bucata() {
      return this.pret_bucata;
  }
  
  public double getpret_total() {
      return this.pret_total;
  }
  
  public int getId() {
    return this.id;
  }
  
  public void setcategorie(String categorie)
  {
     
	  this.categorie = categorie;
      
  }
  
  public void setprodus(String produs )
  {
     
	  this.produs = produs;
      
  }
  
  public void setcantitate(int cantitate )
  {
     
	  this.cantitate = cantitate;
      
  }
  
  public void setpret_bucata(double pret_bucata )
  {
     
	  this.pret_bucata = pret_bucata;
      
  }
  public void setpret_total(double pret_bucata , int cantitate)
  {
     
	  this.pret_total = pret_bucata*cantitate;
      
  }
}