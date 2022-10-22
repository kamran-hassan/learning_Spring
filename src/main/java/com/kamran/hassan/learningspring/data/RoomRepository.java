package com.kamran.hassan.learningspring.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public class RoomRepository extends CrudRepository<Room, Long> {


}
