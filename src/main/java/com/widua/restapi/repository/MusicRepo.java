package com.widua.restapi.repository;

import com.widua.restapi.model.MusicModel;
import org.springframework.data.repository.CrudRepository;

public interface MusicRepo extends CrudRepository<MusicModel,Long> {

}
