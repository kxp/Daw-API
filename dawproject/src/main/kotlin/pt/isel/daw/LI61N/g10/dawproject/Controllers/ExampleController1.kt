package pt.isel.daw.LI61N.g10.dawproject.Controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

// A container for handlers TODO: DELETE THIS!
@RestController
@RequestMapping("/example")
class ExampleController1 {

    // An handler is a method
    @GetMapping("1")
    fun get() = "Hello World"

}