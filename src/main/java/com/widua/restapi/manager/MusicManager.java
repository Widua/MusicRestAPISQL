package com.widua.restapi.manager;

import com.widua.restapi.model.MusicModel;
import com.widua.restapi.repository.MusicRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MusicManager {

    private MusicRepo musicRepo;

    @Autowired
    public MusicManager(MusicRepo musicRepo) {
        this.musicRepo = musicRepo;
    }


    public Optional<MusicModel> findById(Long id){
        return musicRepo.findById(id);
    }

    public Iterable<MusicModel> findAll(){
        return musicRepo.findAll();
    }

    public Iterable<MusicModel> findByAuthor(String author){
        List<MusicModel> withAuthor = new ArrayList<>();
        for (MusicModel model : musicRepo.findAll()) {
            if (model.getAuthor().equals(author)){
                withAuthor.add(model);
            }
        }
        return withAuthor;
    }

    public MusicModel save(MusicModel musicModel){
        return musicRepo.save(musicModel);
    }

    public void deleteById(Long id){
        musicRepo.deleteById(id);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDB() {
        if (musicRepo.count() != 3) {
            save(new MusicModel("The Beatles", "Yellow Submarine", 1));
            save(new MusicModel("Ray Charles", "Mess Around", 2));
            save(new MusicModel("Ray Charles", "Leave my woman alone", 3));
        }
    }



}
