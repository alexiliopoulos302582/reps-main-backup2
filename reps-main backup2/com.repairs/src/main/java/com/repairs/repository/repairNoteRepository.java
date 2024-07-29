package com.repairs.repository;

import com.repairs.entity.repairNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface repairNoteRepository  extends JpaRepository <repairNote,Integer> {



    @Query("SELECT t FROM repairNote t WHERE t.productName LIKE %?1% ")
    List<repairNote> findByProductname(String searchproduct);

    @Query("SELECT t FROM repairNote t WHERE t.title LIKE %?1% ")
    List<repairNote> findByTitle(String tilte);

    @Query("SELECT t FROM repairNote t WHERE t.manufacturer LIKE %?1% ")
    List<repairNote> findByManufacturer(String searchmanufacturer);

    @Query("SELECT t FROM repairNote t WHERE t.productName LIKE %?1% OR t.title LIKE %?1% ")
    List<repairNote> findProductandtitle(String searchproduct, String searchtitle);


    @Query("SELECT t FROM repairNote t WHERE t.manufacturer LIKE %?1%  ")
    List<repairNote> findAllyByManufacturer(String vendorName);

    @Query("SELECT t FROM repairNote t WHERE t.productName LIKE %?1%  ")
    List<repairNote> findAllyByProductName(String productName);



}
