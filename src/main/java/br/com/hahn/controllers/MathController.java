package br.com.hahn.controllers;

import br.com.hahn.controllers.exceptions.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MathController {

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/somar/{primeiroNumero}/{segundoNumero}", method = RequestMethod.GET)
    public Double soma(@PathVariable(value = "primeiroNumero") String primeiroNumero, @PathVariable(value = "segundoNumero") String segundoNumero) throws Exception{
        if(!isNumeric(primeiroNumero) || !isNumeric(segundoNumero)){
            throw new UnsupportedMathOperationException("Informe um valor númerico");
        }
        return convertToDouble(primeiroNumero) + convertToDouble(segundoNumero);
    }

    @RequestMapping(value = "/diminui/{primeiroNumero}/{segundoNumero}", method = RequestMethod.GET)
    public Double diminui(@PathVariable(value = "primeiroNumero") String primeiroNumero, @PathVariable(value = "segundoNumero") String segundoNumero) throws Exception{
        if(!isNumeric(primeiroNumero) || !isNumeric(segundoNumero)){
            throw new UnsupportedMathOperationException("Informe um valor númerico");
        }
        return convertToDouble(primeiroNumero) - convertToDouble(segundoNumero);
    }

    @RequestMapping(value = "/divide/{primeiroNumero}/{segundoNumero}", method = RequestMethod.GET)
    public Double divide(@PathVariable(value = "primeiroNumero") String primeiroNumero, @PathVariable(value = "segundoNumero") String segundoNumero) throws Exception{
        if(!isNumeric(primeiroNumero) || !isNumeric(segundoNumero)){
            throw new UnsupportedMathOperationException("Informe um valor númerico");
        }
        return convertToDouble(primeiroNumero) / convertToDouble(segundoNumero);
    }

    @RequestMapping(value = "/media/{primeiroNumero}/{segundoNumero}", method = RequestMethod.GET)
    public Double media(@PathVariable(value = "primeiroNumero") String primeiroNumero, @PathVariable(value = "segundoNumero") String segundoNumero) throws Exception{
        if(!isNumeric(primeiroNumero) || !isNumeric(segundoNumero)){
            throw new UnsupportedMathOperationException("Informe um valor númerico");
        }
        return (convertToDouble(primeiroNumero) + convertToDouble(segundoNumero) / 2);
    }

    @RequestMapping(value = "/multiplica/{primeiroNumero}/{segundoNumero}", method = RequestMethod.GET)
    public Double mutiplica(@PathVariable(value = "primeiroNumero") String primeiroNumero, @PathVariable(value = "segundoNumero") String segundoNumero) throws Exception{
        if(!isNumeric(primeiroNumero) || !isNumeric(segundoNumero)){
            throw new UnsupportedMathOperationException("Informe um valor númerico");
        }
        return convertToDouble(primeiroNumero) * convertToDouble(segundoNumero);
    }

    @RequestMapping(value = "/raiz/{primeiroNumero}", method = RequestMethod.GET)
    public Double raiz(@PathVariable(value = "primeiroNumero") String primeiroNumero) throws Exception{
        if(!isNumeric(primeiroNumero)){
            throw new UnsupportedMathOperationException("Informe um valor númerico");
        }
        return Math.sqrt(convertToDouble(primeiroNumero));
    }

    private Double convertToDouble(String strNumero) {
        if(strNumero == null) return 0D;
        String numero = strNumero.replaceAll(",", ".");
        if(isNumeric(numero)) return Double.parseDouble(numero);
        return 0D;
    }

    private boolean isNumeric(String strNumero) {
        if(strNumero == null) return false;
        String numero = strNumero.replaceAll(",", ".");
        return numero.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
