package com.widua.restapi.api;

import com.widua.restapi.manager.MusicManager;
import com.widua.restapi.model.MusicModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/api")
@RestController
public class MusicApi {

    private final MusicManager songs;

    @Autowired
    public MusicApi(MusicManager songs) {
        this.songs = songs;
    }

    @GetMapping(path = "/all", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Iterable<MusicModel> getAll(){
        return songs.findAll();
    }

    @GetMapping(path = "/id/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Optional<MusicModel> getByID(@PathVariable long id){
        return songs.findById(id);
    }

    @GetMapping(path = "/{author}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Iterable<MusicModel> getByAuthor(@PathVariable String author){
        return songs.findByAuthor(author);
    }

    @PostMapping(path = "/add", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public MusicModel addSong(@RequestBody MusicModel musicModel){
        return songs.save(musicModel);
    }

    @PutMapping(path = "/put", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public MusicModel editSong(@RequestBody MusicModel musicModel){
        return songs.save(musicModel);
    }

    @DeleteMapping(path = "/delete/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public void delSongByID(@PathVariable long id){
        songs.deleteById(id);
    }





}
