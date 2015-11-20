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
public class SkittlesController {
  private List<Skittles> Skittles = new ArrayList<Skittles>();

  SkittlesController() {
    Skittles p1 = new Skittles(1, "rosu","original", 25.5, 89001029, 25);
    Skittles p2 = new Skittles(2, "verde","fruitfresh", 25.0, 89321029, 25);
    Skittles p3 = new Skittles(3, "mov","blueberry", 500.0, 892341029, 50);

    Skittles.add(p1);
    Skittles.add(p2);
    Skittles.add(p3);
  }

  @RequestMapping(value="/Skittles", method = RequestMethod.GET)
  public List<Skittles> index() {
    return this.Skittles;
  }

@RequestMapping(value="/Skittles/{culoare}/{flavor}/{gramaj}/{cod_bare}/{pret}", method = RequestMethod.POST)
  public List<Skittles> adauga(@PathVariable("culoare") String culoare , @PathVariable("flavor") String flavor ,@PathVariable("gramaj") double gramaj, @PathVariable("cod_bare") long cod_bare , @PathVariable("pret") double pret ) {
	int aux=1;
	for(Skittles p : this.Skittles) 
	{
		aux++;
	}
	Skittles p = new Skittles(aux, culoare, flavor, gramaj, cod_bare , pret);
	Skittles.add(p);
	
    return this.Skittles;
  } 
  @RequestMapping(value="/Skittles/{id}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id") int id) {
    for(Skittles p : this.Skittles) {
      if(p.getId() == id) {
        return new ResponseEntity<Skittles>(p, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/Skittles/{id}/{culoare}/{flavor}/{gramaj}/{cod_bare}/{pret}", method = RequestMethod.PUT)
  public List<Skittles> inlocuire(@PathVariable("id") int id,@PathVariable("culoare") String culoare , @PathVariable("flavor") String flavor ,@PathVariable("gramaj") double gramaj, @PathVariable("cod_bare") long cod_bare , @PathVariable("pret") double pret)
  {
    for(Skittles p : this.Skittles)
		{
      if(p.getId() == id)		  
	  {
		  p.setCuloare(culoare);
		  p.setFlavor(flavor);
		  p.setGramaj(gramaj);
		  p.setCod_bare(cod_bare);
		  p.setPret(pret);
      }
    }
    return this.Skittles;
  }
  
  @RequestMapping(value="/Skittles/{id}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("id") int id) {
    for(Skittles p : this.Skittles) {
      if(p.getId() == id) {
        this.Skittles.remove(p);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
}