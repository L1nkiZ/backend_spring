package LinkiZ.Ynov.demo.controllers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;

import LinkiZ.Ynov.demo.model.Note;

@RestController
@RequestMapping("/notes")
public class CrudNoteController {
    private List<Note> notes = new ArrayList<>();

    @PostMapping("/add")
    public String addNote(@RequestBody Note noteRequest) {
        Note newNote = new Note();
        newNote.setId(noteRequest.getId());
        newNote.setTitle(noteRequest.getTitle());
        newNote.setContent(noteRequest.getContent());
        notes.add(newNote);
        return "La note a été ajoutée avec succès";
    }

    @PostMapping("/remove")
    public String removeNote(@RequestBody Note noteRequest) {
        notes.removeIf(note -> note.getId() == noteRequest.getId());
        return "La note a été supprimée avec succès";
    }

    @GetMapping("/")
    public List<Note> getAllNotes() {
        return notes;
    }

    @GetMapping("/getById")
    public Note getNoteById(@RequestBody Note noteRequest) {
        for (Note note : notes) {
            if (note.getId() == noteRequest.getId()) {
                return note;
            }
        }
        return null;
    }

    @PostMapping("/update")
    public String updateNote(@RequestBody Note noteRequest) {
        for (Note note : notes) {
            if (note.getId() == noteRequest.getId()) {
                note.setTitle(noteRequest.getTitle());
                note.setContent(noteRequest.getContent());
                return "La note a été mise à jour avec succès";
            }
        }
        return "Note non trouvée";  
    }
}