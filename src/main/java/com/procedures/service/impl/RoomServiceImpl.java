package com.procedures.service.impl;

import com.procedures.dao.entity.RoomEntity;
import com.procedures.dao.repository.RoomRepository;
import com.procedures.model.RoomModel;
import com.procedures.service.RoomService;
import com.procedures.service.mapper.DtoMapper;
import com.procedures.service.mapper.EntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        return optional.map(DtoMapper::toRoomDto).orElseThrow(() -> new RuntimeException("no room"));
    }

    @Override
    public List<RoomModel> getAll() {
        List<RoomEntity> rooms = roomRepository.findAll();
        return rooms.stream().map(DtoMapper::toRoomDto).collect(Collectors.toList());
    }

    @Override
    public RoomModel addRoom(RoomModel room) {
        return DtoMapper.toRoomDto(roomRepository.save(EntityMapper.toRoomEntity(room.getName())));
    }

}
