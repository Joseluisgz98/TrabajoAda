package com.example.trabajoada.Repository

import com.example.trabajoada.Clases.Paquete
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PaqueteRepository: CrudRepository<Paquete?, Int?> {
    fun findByIdPaquete(idPaquete:Int?):List<Paquete>
    fun findByDescripcion (descripcion:String?):List<Paquete>
}