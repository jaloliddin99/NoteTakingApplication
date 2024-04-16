package uz.cau.notetakingapplication;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class NoteService {
    private final NoteRepository noteRepository;

    public ModelSuccess saveNote(NoteDTO body) {

        Notes note = Notes.builder()
                .title(body.getTitle())
                .description(body.getDescription())
                .priority(body.getPriority())
                .build();
        noteRepository.save(note);
        return new ModelSuccess(true, "Successfully saved", null);
    }

    public ModelSuccess getAllNotes() {
        return new ModelSuccess(true,
                "Successfully fetched",
                noteRepository.findAll()
        );
    }

    public ModelSuccess deleteNote(Integer noteId) {

        Optional<Notes> notesOptional = noteRepository.findById(noteId);

        if (notesOptional.isEmpty()){
            return new ModelSuccess(false, "Note which associated with this "+ noteId +" id is not present in db", null);
        }

        noteRepository.deleteById(noteId);
        return new ModelSuccess(true, "Successfully deleted", null);

    }

    public ModelSuccess updateNote(NoteDTO body, Integer noteId) {

        Optional<Notes> notesOptional = noteRepository.findById(noteId);
        if (notesOptional.isEmpty()){
            return new ModelSuccess(false, "Note which associated with this "+ noteId +" id is not present in db", null);
        }
        Notes note = notesOptional.get();

        if (body.getDescription() != null){
            note.setDescription(body.getDescription());
        }

        if (body.getPriority() != null){
            note.setPriority(body.getPriority());
        }
        if (body.getTitle() != null){
            note.setTitle(body.getTitle());
        }
        noteRepository.save(note);
        return  new ModelSuccess(true, "Successfully updated", null);


    }
}
