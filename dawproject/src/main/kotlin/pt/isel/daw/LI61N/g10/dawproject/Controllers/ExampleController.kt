package pt.isel.daw.LI61N.g10.dawproject.Controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PutMapping


// A container for handlers TODO: DELETE THIS!
@RestController
@RequestMapping("/example")
class ExampleController {
    var local: String = "Begin"
    // An handler is a method
    @GetMapping("1")
    fun get() = "Get the var local that cotains $local"

    @PostMapping("2/{i}")
    fun post(@PathVariable("i") i: String): String{
        local = i
        return "Post something $local"
    }

    @PostMapping("3/{string}")
    fun post1(@PathVariable("string") i: String): String{
        local = i
        return "Post something $local"
    }

    @PutMapping("4/{id}")
    fun put(@PathVariable("id") i: String): String {
        local = i
        return "Update on $local"
    }

    @DeleteMapping("5/{del}")
    fun delete(@PathVariable("del") i: String): String {
        local = i
        return "Post was deleted: local = $local"
    }


}