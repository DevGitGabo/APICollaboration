package pe.edu.utp.apicollaboration.service;

public interface IAutenticacionService {
    boolean autenticar(String codigo_universitario, String password);
}
