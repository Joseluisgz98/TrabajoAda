package com.example.trabajoada.Servicios

import com.example.trabajoada.Clases.Comprador
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
    fun allCompradores(): Iterable<Comprador?> {
        return compradorRepository!!.findAll()
    }
    fun deleteComprador(dni: String?): String {
        var repartidor = recuperarPorDni(dni!!)
        var primero=repartidor.first()
        return if (dni.isNullOrEmpty()) {
            return "No se encontro"
        } else {
            compradorRepository!!.delete(primero!!)
            return "borrado"
        }
    }
    fun updateComprador(dni: String?,nombreNuevo:String,nuevoEmail:String): String {
        var usuario = recuperarPorDni(dni)
        var primero=usuario.first()
        return if (dni.isNullOrEmpty()) {
            return "No se encontro"
        } else {
            primero?.nombre = nombreNuevo
            primero?.email = nuevoEmail
            compradorRepository!!.save(primero!!)
            return "cambiado"
        }
    }
    fun recuperarPorEmail(email: String?): Iterable<Comprador?>{
        return if (email.isNullOrEmpty()) {
            compradorRepository!!.findAll()
        } else {
            compradorRepository!!.findByEmail(email)
        }
    }
    fun recuperarPorNombre(nombre: String?): Iterable<Comprador?>{
        return if (nombre.isNullOrEmpty()) {
            compradorRepository!!.findAll()
        } else {
            compradorRepository!!.findByNombre(nombre)
        }
    }

}