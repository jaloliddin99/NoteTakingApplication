package uz.cau.notetakingapplication;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Notes, Integer> {


}
