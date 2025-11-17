package com.arnex.booting.data.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arnex.booting.data.entity.RoomEntity;

public interface RoomRepository extends JpaRepository<RoomEntity, UUID> {

}
