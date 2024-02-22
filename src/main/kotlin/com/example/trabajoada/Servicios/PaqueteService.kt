package com.example.trabajoada.Servicios

import com.example.trabajoada.Clases.Comprador
import com.example.trabajoada.Clases.Paquete
import com.example.trabajoada.Repository.CompradorRepository
import com.example.trabajoada.Repository.PaqueteRepository
import com.example.trabajoada.Repository.RepartidorRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PaqueteService {
    @Autowired
    private val compradorRepository: CompradorRepository? = null
    @Autowired
    private val paqueteRepository: PaqueteRepository? = null
    @Autowired
    private val repartidorRepository: RepartidorRepository?= null

    fun addPaquete(idComprador:Int?,idRepartidor:Int?,descripcion:String?):String{
        val paquete = Paquete()
        paquete.comprador = compradorRepository!!.findByIdComprador(idComprador)
        paquete.repartidor = repartidorRepository!!.findByIdRepartidor(idRepartidor)
        paquete.descripcion = descripcion
        paqueteRepository!!.save(paquete)
        return "Guardado"
    }
    fun allPaquete(): Iterable<Paquete?> {
        return paqueteRepository!!.findAll()
    }
    fun recuperrarPorId(idPaquete: Int?):Paquete?{
        return paqueteRepository!!.findByIdPaquete(idPaquete)
    }
    fun recuperrarPorDescripcion(descripcion: String?):Iterable<Paquete?>{
        return if (descripcion.isNullOrEmpty()) {
            paqueteRepository!!.findAll()
        } else {
            paqueteRepository!!.findByDescripcion(descripcion)
        }
    }
}