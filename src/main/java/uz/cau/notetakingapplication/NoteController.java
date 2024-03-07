package uz.cau.notetakingapplication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/notes/")
public class NoteController {


    @GetMapping("get-notes/{noteId}")
    public ModelSuccess getAllNotes(
            @PathVariable(name = "noteId") String noteId
    ){
        List<Notes> notes = new ArrayList<>();
        notes.add( new Notes("Hello", "This is description", 1, "12-12-2-2024"));
        notes.add( new Notes("Hello", "This is description", 1, "12-12-2-2024"));
        notes.add( new Notes("Hello", "This is description", 1, "12-12-2-2024"));
        notes.add( new Notes("Hello", "This is description", 1, "12-12-2-2024"));
        return new ModelSuccess(true, "Successfully fetched", notes);
    }


}
