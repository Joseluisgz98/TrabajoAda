package com.example.trabajoada.Servicios

import com.example.trabajoada.Clases.Comprador
import com.example.trabajoada.Clases.Repartidor
import com.example.trabajoada.Repository.CompradorRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CompradorService {
    @Autowired

    private val compradorRepository:CompradorRepository? = null

    fun addComprador(nombre: String?,email: String?,dni:String?): String{
        val comprobar = recuperarPorDni(dni)
        if (comprobar.any()){
            return "Ya existe un repartidor con este DNI"
        }else{
            val comprador = Comprador()
            comprador.nombre = nombre
            comprador.email = email
            comprador.dni = dni
            compradorRepository!!.save(comprador)
            return "Guardado"
        }
    }
    fun recuperarPorDni(dni: String?): Iterable<Comprador?> {
        return if (dni.isNullOrEmpty()) {
            compradorRepository!!.findAll()
        } else {
            compradorRepository!!.findByDni(dni)
        }
    }
    
}