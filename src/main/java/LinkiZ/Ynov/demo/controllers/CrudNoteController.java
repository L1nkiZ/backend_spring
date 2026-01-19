package LinkiZ.Ynov.demo.controllers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

import LinkiZ.Ynov.demo.payload.requests.NoteRequest;

@RestController
public class CrudNoteController {
    private List<NoteRequest> notes = new ArrayList<>();

    @PostMapping("/notes/add")
    public String addNote(@RequestBody NoteRequest noteRequest) {
        NoteRequest newNote = new NoteRequest();
        newNote.setId(noteRequest.getId());
        newNote.setTitle(noteRequest.getTitle());
        newNote.setContent(noteRequest.getContent());
        notes.add(newNote);
        return "La note a été ajoutée avec succès";
    }

    @PostMapping("/notes/remove")
    public String removeNote(@RequestBody NoteRequest noteRequest) {
        notes.removeIf(note -> note.getId() == noteRequest.getId());
        return "La note a été supprimée avec succès";
    }

    @GetMapping("/notes/all")
    public List<NoteRequest> getAllNotes() {
        return notes;
    }

    @GetMapping("/notes/getById")
    public NoteRequest getNoteById(@RequestBody NoteRequest noteRequest) {
        return notes.stream()
                .filter(note -> note.getId() == noteRequest.getId())
                .findFirst()
                .orElse(null);
    }

    @PostMapping("/notes/update")
    public String updateNote(@RequestBody NoteRequest noteRequest) {
        for (NoteRequest note : notes) {
            if (note.getId() == noteRequest.getId()) {
                note.setTitle(noteRequest.getTitle());
                note.setContent(noteRequest.getContent());
                return "La note a été mise à jour avec succès";
            }
        }
        return "Note non trouvée";  
    }
}