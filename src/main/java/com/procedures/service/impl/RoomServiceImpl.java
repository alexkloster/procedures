package com.procedures.service.impl;

import com.procedures.dao.repository.RoomRepository;
import com.procedures.dao.entity.RoomEntity;

import com.procedures.model.RoomModel;
import com.procedures.service.RoomService;
import com.procedures.service.mapper.DtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    @Autowired
    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }


    @Override
    public RoomModel getRoom(String name) {
        Optional<RoomEntity> optional = roomRepository.findByName(name);
        return optional.map(DtoMapper::toRoomDto).orElseThrow(() -> new RuntimeException("no room"));    }
}
