package com.example.trabajoada

import jakarta.persistence.*

@Entity
class Comprador {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var idComprador:Int? = null
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "comprador")
    val paquete:MutableList<Paquete>? = null
    var nombre:String? = null
    var dni:String? = null
}