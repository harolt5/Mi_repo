package com.otro.project.interfaceService;

import java.util.List;
import java.util.Optional;

import com.otro.project.modelo.VentasProducto;

public interface IventasProductoService {
    public List<VentasProducto> listAllvp();

    public List<VentasProducto> listAllvp(String vppalabraClave);

    public Optional<VentasProducto> listarIdvp(int id);

    public int savevp(VentasProducto vp);

    public void deletevp(int id);

    void truncateMyTablevp();

    public Long totalvp();
}
