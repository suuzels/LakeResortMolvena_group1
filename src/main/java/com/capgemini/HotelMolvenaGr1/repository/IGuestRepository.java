package com.capgemini.HotelMolvenaGr1.repository;

import com.capgemini.HotelMolvenaGr1.model.Guest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IGuestRepository extends CrudRepository<Guest, Long> {

    List<Guest> findByLastNameContainingIgnoreCase(String lastName);
}
