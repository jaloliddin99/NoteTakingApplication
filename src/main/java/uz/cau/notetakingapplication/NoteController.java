package uz.cau.notetakingapplication;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("api/v1/notes/")
public class NoteController {


    List<Notes> notes = new ArrayList<>();

    @PostMapping("post-note")
    public ModelSuccess postNotes(
            @RequestBody Notes body
    ){
        notes.add(body);

        return new ModelSuccess(true, "Successfully saved", null);
    }

    @GetMapping("get-notes")
    public ModelSuccess getAllNotes(){
        return new ModelSuccess(true, "Successfully fetched", notes);
    }

    @DeleteMapping("delete-note/{noteId}")
    public String deleteNotes(
            @PathVariable(name = "noteId") Integer noteId
    ){

        notes.removeIf(notes1 -> Objects.equals(notes1.getId(), noteId));
        return "Deleted";
    }


}
