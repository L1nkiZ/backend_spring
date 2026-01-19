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

    @GetMapping("/notes/all")
    public List<NoteRequest> getAllNotes() {
        return notes;
    }

    @PostMapping("/notes/add")
    public String addNote(@RequestBody NoteRequest noteRequest) {
        NoteRequest newNote = new NoteRequest();
        newNote.setId(noteRequest.getId());
        newNote.setTitle(noteRequest.getTitle());
        newNote.setContent(noteRequest.getContent());
        notes.add(newNote);
        return "La note a été ajoutée avec succès";
    }

    // @GetMapping("/notes/edit")

    // }

    // @GetMapping("/notes/{id}")
    

    
}
// CRUD 
//     Note
//      id
//         title
//         content

// ArrayList
//         add
//         remove
//         getAll
//         getById
//         update