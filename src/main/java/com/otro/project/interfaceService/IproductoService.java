package com.otro.project.interfaceService;

import java.util.List;
import java.util.Optional;

import com.otro.project.modelo.Producto;

public interface IproductoService {
    public List<Producto> listAllP(String palabraClave);

    public Optional<Producto> listarIdp(int id);

    public int savep(Producto p);

    public void deletep(int id);

    void truncateMyTableP();

    public Long total();
}
