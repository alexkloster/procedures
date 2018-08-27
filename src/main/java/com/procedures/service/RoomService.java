package com.procedures.service;

import com.procedures.model.RoomModel;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface RoomService {
    RoomModel getRoom(String name);

    List<RoomModel> getAll();

    RoomModel addRoom(RoomModel room);
}
