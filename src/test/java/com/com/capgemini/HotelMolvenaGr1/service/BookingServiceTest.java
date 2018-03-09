package com.com.capgemini.HotelMolvenaGr1.service;

import com.capgemini.HotelMolvenaGr1.model.Booking;
import com.capgemini.HotelMolvenaGr1.model.Room;
import com.capgemini.HotelMolvenaGr1.repository.BookingRepository;
import com.capgemini.HotelMolvenaGr1.service.BookingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BookingServiceTest {

    @InjectMocks
    private BookingService service;

    @Mock
    private BookingRepository bookingRepository;

    @Mock
    private Booking victim;

    @Test
    public void testDeleteWithExisting() {

        // mock
        Mockito.when(this.bookingRepository.findOne(3L)).thenReturn(victim);
        Mockito.when(this.bookingRepository.exists(3L)).thenReturn(true);

        this.service.deleteBooking(3L);


        Mockito.verify(this.bookingRepository).delete(3L);
        Mockito.verify(this.victim).getRooms();
    }

    @Test
    public void testDeleteWithNonExisting() {

        //mock
        Mockito.when(this.bookingRepository.findOne(3L)).thenReturn(null);

        this.service.deleteBooking(3L);
    }
}