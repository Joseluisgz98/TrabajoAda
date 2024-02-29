package com.example.trabajoada.Clases

import jakarta.persistence.*

@Entity
class Comprador {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var idComprador:Int? = null
    var nombre:String? = null
    var dni:String? = null
    var email: String? = null
}