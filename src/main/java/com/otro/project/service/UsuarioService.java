package com.otro.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.otro.project.interfaceService.IusuarioService;
import com.otro.project.interfaces.Iusuario;
import com.otro.project.modelo.Usuario;

@Service
public class UsuarioService implements IusuarioService {

    @Autowired
    private Iusuario data;

    @Override
    public List<Usuario> listAll(String palabraClave) {
        if(palabraClave != null){

            return data.findAllord(palabraClave);
        }

        return data.findAllord();
    }

    @Override
    public Optional<Usuario> listarId(int id) {

        return data.findById(id);
    }

    @Override
    public int save(Usuario p) {
        int res = 0;
        Usuario pe = data.save(p);
        if (!pe.equals(null)|| (!pe.equals(pe))) {

            res = 1;

        }

        return res;
    }

    @Override
    public void delete(int id) {
        data.deleteById(id);

    }

    @Override
    @Transactional
    public void truncateMyTable() {
        data.truncateMyTable();
    }

    @Override
    
    public Long total() {
       return data.count();
        
    }


  
  


    

}
