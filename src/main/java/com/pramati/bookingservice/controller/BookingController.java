package com.pramati.bookingservice.controller;

import com.pramati.bookingservice.model.Doctor;
import com.pramati.bookingservice.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/doctor")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @RequestMapping("/all")
    public List<Doctor> getAllDoctors(){
        return bookingService.getAllDoctors();
    }

    @RequestMapping("/book/{doctorId}")
    public String bookDoctor(@PathVariable("doctorId") int doctorId){
        boolean doctorPresentInSystem = bookingService.checkIfDoctorAvailable(doctorId);
        if(doctorPresentInSystem){
            return bookingService.bookDoctor(doctorId);
        }
        return "Doctor with doctor_id="+doctorId+" is not present in the system";
    }
}
