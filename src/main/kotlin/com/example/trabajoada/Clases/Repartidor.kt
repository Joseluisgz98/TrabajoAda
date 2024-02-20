package com.example.trabajoada.Clases

import jakarta.persistence.*
@Entity
class Repartidor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var idRepartidor:Int? = null
    var dni:String? = null
    var nombre:String? = null
    var email: String? = null
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "repartidor")
    val paquetes:MutableList<Paquete>? = null
}