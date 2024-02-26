package com.example.trabajoada.Controller

import com.example.trabajoada.Clases.Comprador
import com.example.trabajoada.Clases.Paquete
import com.example.trabajoada.Servicios.PaqueteService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody

@Controller
@RequestMapping(path=["/paquete"])
class PaqueteController {

    @Autowired
    private val paqueteService: PaqueteService? = null

    @PostMapping(path=["/add"])
    @ResponseBody
    fun addPaquete(@RequestParam idComprador:String?, @RequestParam idRepartidor:String?,@RequestParam descripcion:String?):String{
        return paqueteService!!.addPaquete(idComprador,idRepartidor,descripcion)
    }
    @GetMapping("/all")
    @ResponseBody
    fun allCompradores(): Iterable<Paquete?> {
        return paqueteService!!.allPaquete()
    }
    @GetMapping("/PorID")
    @ResponseBody
    fun recuperrarPorId(@RequestParam idPaquete: String):Paquete?{
        return paqueteService!!.recuperrarPorId(idPaquete)
    }
    @GetMapping("/PorDescripcion")
    @ResponseBody
    fun recuperrarPorDescripcion(@RequestParam descripcion: String?):Iterable<Paquete?>{
        return paqueteService!!.recuperrarPorDescripcion(descripcion)
    }
}