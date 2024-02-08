package com.example.trabajoada

import jakarta.persistence.*

@Entity
class Camion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var idCamion:Int? = null
    var matricula:String? = null
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "camion")
    val paquetes:MutableList<Paquete>? = null
}