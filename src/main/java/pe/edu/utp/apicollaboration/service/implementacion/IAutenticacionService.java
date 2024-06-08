package pe.edu.utp.apicollaboration.service.implementacion;

public interface IAutenticacionService {
    boolean autenticar(String codigo_universitario, String password);
}
