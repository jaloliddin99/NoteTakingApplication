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
        return noteService.saveNote(body);
    }

    @PostMapping("update-note/{noteId}")
    public ModelSuccess updateNotes(
            @RequestBody NoteDTO body,
            @PathVariable(name = "noteId") Integer noteId
    ){
        return noteService.updateNote(body, noteId);
    }



    @GetMapping("get-notes")
    public ModelSuccess getAllNotes(){
        return noteService.getAllNotes();
    }

    @DeleteMapping("delete-note/{noteId}")
    public ModelSuccess deleteNotes(
            @PathVariable(name = "noteId") Integer noteId
    ){
        return noteService.deleteNote(noteId);
    }


}
