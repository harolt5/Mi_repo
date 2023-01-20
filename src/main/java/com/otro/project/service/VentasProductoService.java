package com.otro.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.otro.project.interfaceService.IventasProductoService;
import com.otro.project.interfaces.IventasProducto;
import com.otro.project.modelo.VentasProducto;

@Service
public class VentasProductoService implements IventasProductoService {

    @Autowired
    private IventasProducto vpdata;

    @Override
    public List<VentasProducto> listAllvp(String vppalabraClave) {
        if(vppalabraClave != null){

            return vpdata.findAllord(vppalabraClave);


        }

        return vpdata.findAllord();
    }

    @Override
    public Optional<VentasProducto> listarIdvp(int id) {

        return vpdata.findById(id);
    }

    @Override
    public int savevp(VentasProducto vp) {
        int res = 0;
        VentasProducto vpr = vpdata.save(vp);
        if (!vpr.equals(null)|| (!vpr.equals(vp))) {

            res = 1;

        }

        return res;
    }

    @Override
    public void deletevp(int id) {
        vpdata.deleteById(id);

    }

    @Override
    @Transactional
    public void truncateMyTablevp() {
        vpdata.truncateMyTablevp();
    }

    @Override
    
    public Long totalvp() {
       return vpdata.count();
        
    }

    @Override

    public List<VentasProducto> listAllvp() {
       
        return vpdata.findAllord();
    }

}
