
package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.ArrayList;


@RestController
public class BibliotecaController {
  private List<Biblioteca> Biblioteca = new ArrayList<Biblioteca>();

  BibliotecaController() {
    Biblioteca b1 = new Biblioteca(1, "politist","Agatha Christie", "Cadavrul din biblioteca", 3, "Humanic", 4736482 );
    Biblioteca b2 = new Biblioteca(2, "fantastic", "Garth Nix" , "Sabriell", 1, "RAO", 2456721);
    Biblioteca b3 = new Biblioteca(3, "actiune" , "Veronica Roth", "Divergent", 1, "Leda", 9263482);

    Biblioteca.add(b1);
    Biblioteca.add(b2);
    Biblioteca.add(b3);
  }

  @RequestMapping(value="/Biblioteca", method = RequestMethod.GET)
  public List<Biblioteca> index() {
    return this.Biblioteca;
  }

@RequestMapping(value="/Biblioteca/{gen}/{autor}/{titlu}/{volum}/{editie}/{cod}}", method = RequestMethod.POST)
  public List<Biblioteca> adauga(@PathVariable("gen") String gen,@PathVariable("autor")  String autor,@PathVariable("titlu") String titlu,  @PathVariable("volum") int volum, @PathVariable("editie") String editie ,@PathVariable("cod") long cod) {
	int aux=1;
	for(Biblioteca p : this.Biblioteca) 
	{
		aux++;
	}
	Biblioteca p = new Biblioteca(aux, gen , autor, titlu , volum, editie, cod);
	Biblioteca.add(p);
	
    return this.Biblioteca;
  } 


  @RequestMapping(value="/Biblioteca/{id}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id") int id) {
    for(Biblioteca b : this.Biblioteca) {
      if(b.getId() == id) {
        return new ResponseEntity<Biblioteca>(b , new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/Biblioteca/{id}/{gen}/{autor}/{titlu}/{volum}/{editie}/{cod}", method = RequestMethod.PUT)
  public List<Biblioteca> inlocuire(@PathVariable("id") int id,@PathVariable("gen") String gen , @PathVariable("autor") String autor ,@PathVariable("titlu") String titlu, @PathVariable("volum") int volum , @PathVariable("editie") String editie , @PathVariable("cod") long cod )
  {
    for(Biblioteca b : this.Biblioteca)
		{
      if(b.getId() == id)		  
	  {
		  b.setGen(gen);
		  b.setAutor(autor);
		  b.setTitlu(titlu);
		  b.setVolum(volum);
		  b.setEditie(editie);
		  b.setCod(cod);
      }
    }
    return this.Biblioteca;
  }
  
  @RequestMapping(value="/Biblioteca/{id}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("id") int id) {
    for(Biblioteca b : this.Biblioteca) {
      if(b.getId() == id) {
        this.Biblioteca.remove(b);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
}