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
}