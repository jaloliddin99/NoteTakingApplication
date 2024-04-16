package uz.cau.notetakingapplication;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NoteService {
    private final NoteRepository noteRepository;

    public void saveNote(NoteDTO body) {

        Notes note = Notes.builder()
                .title(body.getTitle())
                .description(body.getDescription())
                .priority(body.getPriority())
                .build();

        noteRepository.save(note);
    }

    public ModelSuccess getAllNotes() {
        return new ModelSuccess(true,
                "Successfully fetched",
                noteRepository.findAll()
        );
    }

    public String deleteNote(Integer noteId) {

        noteRepository.deleteById(noteId);
        return "Successfully deleted";
    }
}
