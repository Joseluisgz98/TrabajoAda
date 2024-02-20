package com.example.trabajoada.Controller

import com.example.trabajoada.Clases.Repartidor
import com.example.trabajoada.Servicios.RepartidorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*


@Controller
@RequestMapping(path=["/repartidor"])
class RepartidorController {

    @Autowired

    private val repartidorService:RepartidorService? = null

    @PostMapping(path=["/add"]) // Map ONLY POST Requests
    @ResponseBody
    fun addCamionero(
            @RequestParam nombre: String?, @RequestParam email: String?, @RequestParam dni:String?
    ): String {
        return repartidorService!!.addRepartidor(nombre,email,dni)
    }
    @GetMapping("/all")
    @ResponseBody
    fun allCamionero(): Iterable<Repartidor?> {
        return repartidorService!!.allRepartidor()
    }
    fun recuperrarPorDni(@RequestParam dni: String?): Iterable<Repartidor?> {
        return if (dni.isNullOrEmpty()) {
            repartidorService!!.allRepartidor()
        } else {
            repartidorService!!.recuperarPorDni(dni)
        }
    }

    @GetMapping("/delete")
    @ResponseBody
    fun deleteCamionero(@RequestParam dni: String?): String {
            return repartidorService!!.deleteRepartidor(dni)
    }
    @GetMapping("/update")
    @ResponseBody
    fun updateCamionero(@RequestParam dni: String?, @RequestParam nombreNuevo:String, @RequestParam nuevoEmail:String): String {
            return repartidorService!!.updateRepartidor(dni,nombreNuevo,nuevoEmail)
    }
}