package pt.isel.daw.LI61N.g10.dawproject.Controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.CommentIM
import pt.isel.daw.LI61N.g10.dawproject.Controllers.Models.InputModels.CommentOM
import pt.isel.daw.LI61N.g10.dawproject.CoreLogic.Contracts.ICommentsCore
import pt.isel.daw.LI61N.g10.dawproject.Helpers.MessageCode

@RestController
@RequestMapping("/v1/projects/{project_id}/issues/{issue_id}/comments/")
class CommentsController {

    @Autowired
    private val commentsCore: ICommentsCore? = null

    @PostMapping
    @ResponseBody
    fun createComment(@RequestBody comment: CommentIM, @PathVariable issue_id: Int): ResponseEntity<Any> {
        var returningData =commentsCore!!.createComment(issue_id, comment)
        var commentReceived = returningData.Data
        if(returningData.MessageCode == MessageCode.Ok && commentReceived != null){
            return ResponseEntity.ok(commentReceived)
        }
        return ResponseEntity.status(500).body("Couldn't create the project") //todo change error message
    }

    @GetMapping
    @ResponseBody
    fun getAllComments(@PathVariable issue_id: Int): ResponseEntity<Collection<CommentOM>> {
        val returningData = commentsCore!!.getComments(issue_id)
        if(returningData.MessageCode == MessageCode.Ok && returningData.Data != null) {
            return ResponseEntity.ok(returningData.Data!!)
        }
        return ResponseEntity.notFound().build<Collection<CommentOM>>()
    }

    @DeleteMapping("/{comment_id}/")
    fun deleteComment(@PathVariable comment_id: Int) : ResponseEntity<Any>{
        val messageCode = commentsCore!!.deleteComment(comment_id).MessageCode
        if(messageCode == MessageCode.Ok)
        {
            return ResponseEntity.ok().build()
        }
        return ResponseEntity.notFound().build()
    }
}