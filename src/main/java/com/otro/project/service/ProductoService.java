package com.otro.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.otro.project.interfaceService.IproductoService;
import com.otro.project.interfaces.Iproducto;
import com.otro.project.modelo.Producto;

import jakarta.transaction.Transactional;

@Service
public class ProductoService implements IproductoService {

    @Autowired
    private Iproducto pdata;

    @Override
    public List<Producto> listAllP(String ppalabraClave) {
        if(ppalabraClave != null){

            return pdata.findAllord( ppalabraClave);


        }

        return pdata.findAllord();
    }

    @Override
    public Optional<Producto> listarIdp(int id) {

        return pdata.findById(id);
    }

    @Override
    public int savep(Producto p) {
        int res = 0;
        Producto pr = pdata.save(p);
        if (!pr.equals(null)) {

            res = 1;

        }

        return res;
    }

    @Override
    public void deletep(int id) {
        pdata.deleteById(id);

    }
    @Override
    @Transactional
    public void truncateMyTableP() {
        pdata.truncateMyTableP();
    }

    
    @Override
    
    public Long total() {
       return pdata.count();
        
    }

}
