package uz.cau.notetakingapplication;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/notes/")
public class NoteController {


    private final NoteService noteService;

    @PostMapping("post-note")
    public ModelSuccess postNotes(
            @RequestBody NoteDTO body
    ){

        noteService.saveNote(body);
        return new ModelSuccess(true, "Successfully saved", null);
    }


    @GetMapping("get-notes")
    public ModelSuccess getAllNotes(){
        return noteService.getAllNotes();
    }

    @DeleteMapping("delete-note/{noteId}")
    public String deleteNotes(
            @PathVariable(name = "noteId") Integer noteId
    ){
        return ;
    }


}
