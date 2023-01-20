package com.otro.project.interfaceService;

import java.util.List;
import java.util.Optional;

import com.otro.project.modelo.Usuario;

public interface IusuarioService {

    public Optional<Usuario> listarId(int id);

    public int save(Usuario p);

    public void delete(int id);

    public void truncateMyTable();

    public Long total();

    public List<Usuario> listAll(String palabraClave);

}
