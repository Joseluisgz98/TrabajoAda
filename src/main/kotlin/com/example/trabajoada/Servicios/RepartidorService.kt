package com.example.trabajoada.Servicios

import com.example.trabajoada.Clases.Repartidor
import com.example.trabajoada.Repository.RepartidorRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class RepartidorService {
    @Autowired
    private val repartidorRepository: RepartidorRepository? = null

    /**
     * La funcion sirve para poder añadir un nuevo repartidor
     * @param nombre nombre que tendra el repartidor
     * @param email email que tendra el repatidor
     * @param dni dni que tendra el repartidor
     */
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

    /**
     * La funcion sirve para que devuelvan todos los repartidores
     */
    fun allRepartidor(): Iterable<Repartidor?> {
        return repartidorRepository!!.findAll()
    }

    /**
     * Funcion para recuperrar por dni
     * @param dni el dni por el que se filtrara
     */
    fun recuperarPorDni(dni: String?): Iterable<Repartidor?> {
        return if (dni.isNullOrEmpty()) {
            repartidorRepository!!.findAll()
        } else {
            repartidorRepository!!.findByDni(dni)
        }
    }

    /**
     * Funcion para borrar un repartidor
     * @param dni dni por el cual se filtra para borrar
     */
    fun deleteRepartidor(dni: String?): String {
        var repartidor = recuperarPorDni(dni!!)
        var primero=repartidor.first()
        return if (dni.isNullOrEmpty()) {
            return "No se encontro"
        } else {
            repartidorRepository!!.delete(primero!!)
            return "borrado"
        }
    }

    /**
     * Funcion para actualizar un repartidor
     * @param dni dni por el que filtraremos el repartidor
     * @param nombreNuevo el nuevo nombre del repartidor
     * @param nuevoEmail el nuevo email del repartidor
     */
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

    /**
     * La funcion para recuperrar por nombre
     * @param nombre el nombre de los repatidor o repartidores
     */
    fun recuperrarPorNombre(nombre: String?): Iterable<Repartidor?>{
        return if (nombre.isNullOrEmpty()) {
            repartidorRepository!!.findAll()
        } else {
            repartidorRepository!!.findByNombre(nombre)
        }
    }

    /**
     * Funcion para recuperrar por email
     * @param email email por lo que vamos a filtrar
     */
    fun recuperrarPorEmail(email: String?): Iterable<Repartidor?>{
        return if (email.isNullOrEmpty()) {
            repartidorRepository!!.findAll()
        } else {
            repartidorRepository!!.findByEmail(email)
        }
    }
}