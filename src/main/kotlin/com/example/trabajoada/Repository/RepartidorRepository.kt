package com.example.trabajoada.Repository

import com.example.trabajoada.Clases.Repartidor
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface RepartidorRepository: CrudRepository<Repartidor?, Int?> {
    fun findByNombre(nombre: String): List<Repartidor?>
    fun findByEmail(email:String): List<Repartidor?>
    fun findByDni(dni:String): List<Repartidor?>
    fun findByIdRepartidor(idCamionero:Int?):List<Repartidor?>

}