package com.pramati.bookingservice.repository;

import com.pramati.bookingservice.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Doctor, Long> {
    Doctor findDoctorByDoctorId(int doctorId);

    @Query("select booked from Doctor where doctor_id=?#{[0]}")
    int getBookedStatus(int doctorId);

    @Modifying(clearAutomatically = true)
    @Query("update Doctor set booked=1 where doctor_id=?#{[0]}")
    void bookDoctor(int doctorId);
}
