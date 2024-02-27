package com.example.trabajoada.Controller

import com.example.trabajoada.Clases.Comprador
import com.example.trabajoada.Clases.Repartidor
import com.example.trabajoada.Servicios.CompradorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping(path=["/Comprador"])
class CompradorController {

    @Autowired
    private val compradorService:CompradorService? = null

    @PostMapping(path=["/add"])
    @ResponseBody
    fun addComprador(
            @RequestParam nombre: String?, @RequestParam email: String?, @RequestParam dni:String?
    ): String {
        return compradorService!!.addComprador(nombre,email,dni)
    }
    @GetMapping("/all")
    @ResponseBody
    fun allCompradores(): Iterable<Comprador?> {
        return compradorService!!.allCompradores()
    }

    @GetMapping("/delete")
    @ResponseBody
    fun deleteComprador(@RequestParam dni: String?): String {
        return compradorService!!.deleteComprador(dni)
    }
    @GetMapping("/update")
    @ResponseBody
    fun updateComprador(@RequestParam dni: String?, @RequestParam nombreNuevo:String, @RequestParam nuevoEmail:String): String {
        return compradorService!!.updateComprador(dni,nombreNuevo,nuevoEmail)
    }
    @GetMapping("/porEmail")
    @ResponseBody
    fun recuperarPorEmail(@RequestParam email: String?): Iterable<Comprador?>{
        return compradorService!!.recuperarPorEmail(email)
    }
    @GetMapping("/porNombre")
    @ResponseBody
    fun recuperarPorNombre(@RequestParam nombre: String?): Iterable<Comprador?>{
        return compradorService!!.recuperarPorNombre(nombre)
    }


}