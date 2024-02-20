package com.example.trabajoada.Controller

import com.example.trabajoada.Servicios.CompradorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody

@Controller
@RequestMapping(path=["/Comprador"])
class CompradorController {
    @Autowired
    private val compradorService:CompradorService? = null

    @PostMapping(path=["/add"])
    @ResponseBody
    fun addCamionero(
            @RequestParam nombre: String?, @RequestParam email: String?, @RequestParam dni:String?
    ): String {
        return compradorService!!.addComprador(nombre,email,dni)
    }

}