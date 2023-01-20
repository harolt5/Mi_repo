package com.otro.project.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.otro.project.modelo.VentasProducto;


@Repository
public interface IventasProducto extends JpaRepository< VentasProducto, Integer> {
    @Query("SELECT vp FROM VentasProducto vp WHERE" + " CONCAT(vp.id,vp.importeTotal,vp.comprador,vp.fechaDeVenta,vp.horaDeVenta,vp.productosVendidos)"
   
    + " LIKE %?1% order by vp.comprador asc")

    public List<VentasProducto> findAllord(String vppalabraClave);

    @Modifying
    @Query(
            value = "truncate table VentasProducto",
            nativeQuery = true
    )
    void truncateMyTablevp();
    @Query("select v1_0 from VentasProducto v1_0 order by v1_0.comprador asc")
    public List<VentasProducto> findAllord();
    

}
