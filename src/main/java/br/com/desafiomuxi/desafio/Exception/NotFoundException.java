package br.com.desafiomuxi.desafio.Exception;

public class NotFoundException extends RuntimeException{

    public NotFoundException(String message){
        super(message);
    }

    public NotFoundException(){
        super();
    }
}
