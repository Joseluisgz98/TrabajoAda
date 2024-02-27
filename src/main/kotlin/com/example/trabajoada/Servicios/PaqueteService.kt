package com.example.trabajoada.Servicios


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

    /**
     * Funcion para añadir un paquete
     * @param idComprador id del comprador para poder asociarselo
     * @param idRepartidor id del repartidor para poder asociarlo
     * @param descripcion descripcion del paquete
     */
    fun addPaquete(idComprador:String?,idRepartidor:String?,descripcion:String?):String{
        val paquete = Paquete()
        if (idComprador.isNullOrEmpty() or idRepartidor.isNullOrEmpty()){
            return "El comprador o el repartidor no existe"
        }else{
        paquete.comprador = compradorRepository!!.findByIdComprador(idComprador!!.toInt())
        paquete.repartidor = repartidorRepository!!.findByIdRepartidor(idRepartidor!!.toInt())
        paquete.descripcion = descripcion
        paqueteRepository!!.save(paquete)
        return "Guardado"
        }
    }

    /**
     * Funcion para devolver todos los paquetes
     */
    fun allPaquete(): Iterable<Paquete?> {
        return paqueteRepository!!.findAll()
    }

    /**
     * Funcion para recuperrar por id
     * @param idPaquete id del paquete
     */
    fun recuperrarPorId(idPaquete: String?):Paquete?{
        return paqueteRepository!!.findByIdPaquete(idPaquete!!.toInt())
    }

    /**
     * Funcion para recuperrar por descripcion
     * @param descripcion el contenido del paquete
     */
    fun recuperrarPorDescripcion(descripcion: String?):Iterable<Paquete?>{
        return if (descripcion.isNullOrEmpty()) {
            paqueteRepository!!.findAll()
        } else {
            paqueteRepository!!.findByDescripcion(descripcion)
        }
    }

    /**
     * Funcion para actualizar el paquete
     * @param idPaquete id del paquete
     * @param nuevaDescripcion nueva descripcion del paquete
     */
    fun updatePaquete(idPaquete: String?,nuevaDescripcion:String):String{
        val paquete = recuperrarPorId(idPaquete)
        return if (idPaquete.isNullOrEmpty()){
            return "No se encontro"
        }else{
            paquete?.descripcion = nuevaDescripcion
            paqueteRepository!!.save(paquete!!)
            return "Guardado"
        }
    }

    /**
     * Funcion para borrar el paquete
     * @param idPaquete id del paquete
     */
    fun deletePaquete(idPaquete: String?):String{
        val paquete = recuperrarPorId(idPaquete)
        return if (idPaquete.isNullOrEmpty()){
            return "No se encontro"
        }else{
            paqueteRepository!!.delete(paquete!!)
            return "Borrado"
        }
    }
}