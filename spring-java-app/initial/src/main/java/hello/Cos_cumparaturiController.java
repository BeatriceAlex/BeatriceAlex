package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.ArrayList;


@RestController
public class Cos_cumparaturiController {
  private List<Cos_cumparaturi> Cos_cumparaturi = new ArrayList<Cos_cumparaturi>();

  Cos_cumparaturiController() {
    Cos_cumparaturi p1 = new Cos_cumparaturi(1,"Dulciuri" , "Ciocolata", 3, 20);
    Cos_cumparaturi p2 = new Cos_cumparaturi(2, "Fainoase", "Paine",1,  1.5);
    Cos_cumparaturi p3 = new Cos_cumparaturi(3, "cereale", "Grau",4,  25);

    Cos_cumparaturi.add(p1);
    Cos_cumparaturi.add(p2);
    Cos_cumparaturi.add(p3);
  }

  @RequestMapping(value="/Cos_cumparaturi", method = RequestMethod.GET)
  public List<Cos_cumparaturi> index() {
    return this.Cos_cumparaturi;
  }

@RequestMapping(value="/Cos_cumparaturi/{categorie}/{produs}/{cantitate}/{pret_bucata}", method = RequestMethod.POST)
  public List<Cos_cumparaturi> adauga(@PathVariable("categorie") String categorie,@PathVariable("produs") String produs,@PathVariable("cantitate") int cantitate,  @PathVariable("pret_bucata") double pret_bucata) {
	int aux=1;
	for(Cos_cumparaturi p : this.Cos_cumparaturi) 
	{
		aux++;
	}
	Cos_cumparaturi p = new Cos_cumparaturi(aux,categorie,  produs,cantitate,  pret_bucata);
	Cos_cumparaturi.add(p);
	
    return this.Cos_cumparaturi;
  } 
  @RequestMapping(value="/Cos_cumparaturi/{id}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id") int id) {
    for(Cos_cumparaturi p : this.Cos_cumparaturi) {
      if(p.getId() == id) {
        return new ResponseEntity<Cos_cumparaturi>(p, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/Cos_cumparaturi/{id}/{categorie}/{produs}/{cantitate}/{pret_bucata}", method = RequestMethod.PUT)
  public List<Cos_cumparaturi> inlocuire(@PathVariable("id") int id,@PathVariable("categorie") String categorie,@PathVariable("produs") String produs,@PathVariable("cantitate") int cantitate, @PathVariable("pret_bucata") double pret_bucata)
  {
    for(Cos_cumparaturi p : this.Cos_cumparaturi)
		{
      if(p.getId() == id)		  
	  {
		  p.setcategorie(categorie);
		  p.setprodus(produs);
		  p.setcantitate(cantitate);
		  p.setpret_bucata(pret_bucata);
		  p.setpret_total(pret_bucata, cantitate);
		  
      }
    }
    return this.Cos_cumparaturi;
  }
  
  @RequestMapping(value="/Cos_cumparaturi/{id}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("id") int id) {
    for(Cos_cumparaturi p : this.Cos_cumparaturi) {
      if(p.getId() == id) {
        this.Cos_cumparaturi.remove(p);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
}