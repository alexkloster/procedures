package com.procedures.service;

import com.procedures.model.RoomDto;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface RoomService {
    RoomDto getRoom(String name);
}
