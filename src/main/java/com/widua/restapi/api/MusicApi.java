package com.widua.restapi.api;

import com.widua.restapi.manager.MusicManager;
import com.widua.restapi.model.MusicModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/api")
@RestController
public class MusicApi {

   private MusicManager songs;

    @Autowired
    public MusicApi(MusicManager songs) {
        this.songs = songs;
    }

    @GetMapping("/all")
    public Iterable<MusicModel> getAll(){
        return songs.findAll();
    }

    @GetMapping("/id")
    public Optional<MusicModel> getByID(@RequestParam long id){
        return songs.findById(id);
    }

    @GetMapping("/author")
    public Iterable<MusicModel> getByAuthor(@RequestParam String author){
        return songs.findByAuthor(author);
    }

    @PostMapping("/add")
    public MusicModel addSong(@RequestBody MusicModel musicModel){
        return songs.save(musicModel);
    }

    @PutMapping("/put")
    public MusicModel editSong(@RequestBody MusicModel musicModel){
        return songs.save(musicModel);
    }

    @DeleteMapping("/delete")
    public void delSongbyID(@RequestParam long id){
        songs.deleteById(id);
    }





}
