package com.pramati.bookingservice.service;

import com.pramati.bookingservice.model.Doctor;
import com.pramati.bookingservice.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public List<Doctor> getAllDoctors(){
        return bookingRepository.findAll();
    }

    public boolean checkIfDoctorAvailable(int doctorId) {
       Doctor doctor = bookingRepository.findDoctorByDoctorId(doctorId);
       return doctor != null;
    }

    @Transactional
    public String bookDoctor(int doctorId) {
        if(canDoctorBook(doctorId)){
            bookingRepository.bookDoctor(doctorId);
            return "Booked successfully";
        }
        return "Doctor already booked, can not book anymore";
    }

    public boolean canDoctorBook(int doctorId) {
        int bookedStatus = bookingRepository.getBookedStatus(doctorId);
        return bookedStatus == 0;
    }
}
