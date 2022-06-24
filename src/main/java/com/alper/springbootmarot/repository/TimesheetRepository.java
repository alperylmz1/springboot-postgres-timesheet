package com.alper.springbootmarot.repository;

import com.alper.springbootmarot.model.Timesheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TimesheetRepository extends JpaRepository<Timesheet , Long> {
    List<Timesheet> findAll();

    @Query("from Timesheet where CAST(userID as text) like CONCAT(:userID, '%')")
    List<Timesheet> findByUserIdStartsWith(String userID);

    /*
    @Query("from Timesheet where userID = : userID")
    List<Timesheet> findByUserId(long userID);
    */
}
