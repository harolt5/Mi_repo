package com.otro.project.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.otro.project.modelo.Producto;


@Repository
public interface Iproducto extends JpaRepository< Producto, Integer> {
    @Query("SELECT pr FROM Producto pr WHERE" + " CONCAT(pr.id,pr.nombre,pr.precio,pr.estado)"
   
    + " LIKE %?1% order by pr.nombre asc")

    public List<Producto> findAllord(String palabraClave);

    @Modifying
    @Query(
            value = "truncate table Producto",
            nativeQuery = true
    )
    void truncateMyTableP();

    @Query("select p1_0 from Producto p1_0 order by p1_0.nombre asc")
    public List<Producto> findAllord();

}
