package com.example.trabajoada.Servicios

import com.example.trabajoada.Clases.Repartidor
import com.example.trabajoada.Repository.RepartidorRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestParam


@Service
class RepartidorService {
    @Autowired

    private val repartidorRepository: RepartidorRepository? = null
    fun addRepartidor(nombre: String?,email: String?,dni:String?): String {
        val comprobar = recuperarPorDni(dni)
        if (comprobar.any()){
            return "Ya existe un repartidor con este DNI"
        }else{
            val repartidor = Repartidor()
            repartidor.nombre = nombre
            repartidor.email = email
            repartidor.dni = dni
            repartidorRepository!!.save(repartidor)
            return "Guardado"
        }
    }
    fun allRepartidor(): Iterable<Repartidor?> {
        return repartidorRepository!!.findAll()
    }
    fun recuperarPorDni(dni: String?): Iterable<Repartidor?> {
        return if (dni.isNullOrEmpty()) {
            repartidorRepository!!.findAll()
        } else {
            repartidorRepository!!.findByDni(dni)
        }
    }
    fun deleteRepartidor(dni: String?): String {
        var camionero = recuperarPorDni(dni!!)
        var primero=camionero.first()
        return if (dni.isNullOrEmpty()) {
            return "No se encontro"
        } else {
            repartidorRepository!!.delete(primero!!)
            return "borrado"
        }
    }
    fun updateRepartidor(dni: String?,nombreNuevo:String,nuevoEmail:String): String {
        var usuario = recuperarPorDni(dni)
        var primero=usuario.first()
        return if (dni.isNullOrEmpty()) {
            return "No se encontro"
        } else {
            primero?.nombre = nombreNuevo
            primero?.email = nuevoEmail
            repartidorRepository!!.save(primero!!)
            return "cambiado"
        }
    }
}