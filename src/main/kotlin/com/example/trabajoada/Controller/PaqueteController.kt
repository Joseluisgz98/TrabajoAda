package com.example.trabajoada.Controller

import com.example.trabajoada.Servicios.PaqueteService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
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


}