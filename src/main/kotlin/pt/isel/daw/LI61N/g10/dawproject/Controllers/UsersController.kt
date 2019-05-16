package pt.isel.daw.LI61N.g10.dawproject.Controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.UserIM
import pt.isel.daw.LI61N.g10.dawproject.CoreLogic.Contracts.IUsersCore
import pt.isel.daw.LI61N.g10.dawproject.Helpers.MessageCode

@RestController
@RequestMapping("/v1/users/")
class UsersController {

    @Autowired
    private val usersCore: IUsersCore? = null

    @PostMapping
    @ResponseBody
    fun createUser(@RequestBody user: UserIM): ResponseEntity<Any> {
        val messageCode = usersCore!!.createUser(user).MessageCode
        if(messageCode == MessageCode.Ok)
        {
            return ResponseEntity.ok().build() // todo: talk with engineer, maybe should return created but i don't know what to put on the location header.
        }
        return ResponseEntity.notFound().build()
    }

    /*
    @PostMapping
    @ResponseBody
    fun login(@RequestBody user: UserIM): ResponseEntity<Any> {
        //Todo do login
        return ResponseEntity.status(500).body("Couldn't create the project")
    }*/

    @DeleteMapping("/{user_id}/")
    fun deleteUser(@PathVariable user_id: Int) : ResponseEntity<Any>{
        val messageCode = usersCore!!.deleteUser(user_id).MessageCode
        if(messageCode == MessageCode.Ok)
        {
            return ResponseEntity.ok().build()
        }
        return ResponseEntity.notFound().build()
    }
}