package com.otro.project.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.otro.project.modelo.Usuario;

@Repository
public interface Iusuario extends JpaRepository<Usuario, Integer> {

        @Query("SELECT u FROM Usuario u WHERE" + " CONCAT(u.id,u.nombre,u.apellido,u.nucleo,u.correo)"

                        + " LIKE %?1%")
        public List<Usuario> findAllord(String palabraClave);

        @Modifying
        @Query(value = "truncate table Usuario", nativeQuery = true)
        public void truncateMyTable();

        @Query("select u1_0 from Usuario u1_0 order by u1_0.nombre asc")
        public List<Usuario> findAllord();
}
