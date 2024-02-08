package com.example.trabajoada

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Camionero {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var idCamionero:Int? = null
    var dni:String? = null
    var nombre:String? = null
    var email: String? = null
}