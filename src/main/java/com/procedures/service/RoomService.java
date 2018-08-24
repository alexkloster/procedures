package com.procedures.service;

import com.procedures.model.RoomModel;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface RoomService {
    RoomModel getRoom(String name);
}
