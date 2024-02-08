package com.example.trabajoada

import jakarta.persistence.*

@Entity
class Paquete {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var idPaquete:Int? = null
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idComprador")
    var comprador : Comprador? = null
    var descripcion:String? = null
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCamion")
    var camion:Camion? = null
}