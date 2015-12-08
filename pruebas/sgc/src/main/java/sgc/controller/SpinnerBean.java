package sgc.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import sgc.entity.Persona;
import sgc.service.PersonaService;

@Controller
public class SpinnerBean {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
 
    private int numero1;
     
    private double numero2;
     
    private int numero3;
     
    private int numero4;
     
    private int numero5;
    
    private Persona persona;
    
    @Autowired
    private PersonaService personaService;
    
    //@PostConstruct
    public void init(){
    	System.out.println("Listando Personas 1 ");
    	logger.info("Listando Personas 1 ");
    	List<Persona> personas = personaService.listar();
    	if(personas!=null)
    	for (Persona persona : personas) {
			this.persona = persona;
		}
    	
    }
    
    public Persona getPersona() {
		return persona;
	}

	public int getNumero1() {
		System.out.println("Listando Personas 2 ");
		logger.info("Listando Personas 2 ");
		List<Persona> personas = personaService.listar();
    	for (Persona persona : personas) {
			this.persona = persona;
		}
		return numero1;
	}

	public void setNumero1(int numero1) {
		this.numero1 = numero1;
	}

	public double getNumero2() {
		return numero2;
	}

	public void setNumero2(double numero2) {
		this.numero2 = numero2;
	}

	public int getNumero3() {
		return numero3;
	}

	public void setNumero3(int numero3) {
		this.numero3 = numero3;
	}

	public int getNumero4() {
		return numero4;
	}

	public void setNumero4(int numero4) {
		this.numero4 = numero4;
	}

	public int getNumero5() {
		return numero5;
	}

	public void setNumero5(int numero5) {
		this.numero5 = numero5;
	}
 
}