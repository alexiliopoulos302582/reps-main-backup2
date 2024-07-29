package com.repairs.controller;

import com.repairs.entity.product;
import com.repairs.repository.productRepository;
import com.repairs.entity.repairNote;
import com.repairs.entity.vendor;
import com.repairs.repository.repairNoteRepository;
import com.repairs.repository.vendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.engine.XMLElementDefinition;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.time.LocalDate;

@Controller
public class repairNoteController {
    @Autowired
    private repairNoteRepository repairNoteRepository;
    @Autowired
    private vendorRepository vendorRepository;
    @Autowired
    private productRepository productRepository;

    @GetMapping("/results")
    public String showRepairCard(
            @RequestParam(name="searchmanufacturer",required = false) String searchmanufacturer,
            @RequestParam(name="searchproduct",required = false) String searchproduct,
            @RequestParam(name="searchtitle",required = false) String searchtitle , Model model){

        if (searchproduct != null && !searchproduct.isEmpty() && searchtitle != null && !searchtitle.isEmpty()) {
            // Combine results from both queries
            List<repairNote> repairNoteListProduct = repairNoteRepository.findByProductname(searchproduct);
            List<repairNote> repairNoteListTitle = repairNoteRepository.findByTitle(searchtitle);
            Set<repairNote> combinedResults = new HashSet<>(repairNoteListProduct);
            combinedResults.addAll(repairNoteListTitle);

            model.addAttribute("searchcombined", new ArrayList<>(combinedResults));
        } else if (searchmanufacturer != null && !searchmanufacturer.isEmpty()) {
            List<repairNote> repairNoteListManufacturer = repairNoteRepository.findByManufacturer(searchmanufacturer);
            model.addAttribute("searchmanufacturer", repairNoteListManufacturer);
        } else if (searchproduct != null && !searchproduct.isEmpty()) {
            List<repairNote> repairNoteListProduct = repairNoteRepository.findByProductname(searchproduct);
            model.addAttribute("searchproduct", repairNoteListProduct);
        } else if (searchtitle != null && !searchtitle.isEmpty()) {
            List<repairNote> repairNoteListTitle = repairNoteRepository.findByTitle(searchtitle);
            model.addAttribute("searchtitle", repairNoteListTitle);
        } else {
            List<repairNote> repairNoteList = repairNoteRepository.findAll();
            model.addAttribute("repairNotes", repairNoteList);
        }
        model.addAttribute("repairNote", new repairNote());
        return "repairCard";

    }



    @GetMapping("/results/{vendorName}")
    public String showRepairCardforManufacturer(
            @PathVariable(name="vendorName") String vendorname,
            @RequestParam(name="searchmanufacturer",required = false) String searchmanufacturer,
            @RequestParam(name="searchproduct",required = false) String searchproduct,
            @RequestParam(name="searchtitle",required = false) String searchtitle , Model model){

        if (searchproduct != null && !searchproduct.isEmpty() && searchtitle != null && !searchtitle.isEmpty()) {
            // Combine results from both queries
            List<repairNote> repairNoteListProduct = repairNoteRepository.findByProductname(searchproduct);
            List<repairNote> repairNoteListTitle = repairNoteRepository.findByTitle(searchtitle);
            Set<repairNote> combinedResults = new HashSet<>(repairNoteListProduct);
            combinedResults.addAll(repairNoteListTitle);

            model.addAttribute("searchcombined", new ArrayList<>(combinedResults));
        } else if (searchmanufacturer != null && !searchmanufacturer.isEmpty()) {
            List<repairNote> repairNoteListManufacturer = repairNoteRepository.findByManufacturer(searchmanufacturer);
            model.addAttribute("searchmanufacturer", repairNoteListManufacturer);
        } else if (searchproduct != null && !searchproduct.isEmpty()) {
            List<repairNote> repairNoteListProduct = repairNoteRepository.findByProductname(searchproduct);
            model.addAttribute("searchproduct", repairNoteListProduct);
        } else if (searchtitle != null && !searchtitle.isEmpty()) {
            List<repairNote> repairNoteListTitle = repairNoteRepository.findByTitle(searchtitle);
            model.addAttribute("searchtitle", repairNoteListTitle);
        } else {
            List<repairNote> repairNoteList = repairNoteRepository.findAllyByManufacturer(vendorname);
            model.addAttribute("repairNotes", repairNoteList);
        }
        model.addAttribute("repairNote", new repairNote());
        return "repairCard";

    }



    @GetMapping("/results1/{productName}")
    public String showRepairCardforproductName(
            @PathVariable(name="productName") String productName,
            @RequestParam(name="searchmanufacturer",required = false) String searchmanufacturer,
            @RequestParam(name="searchproduct",required = false) String searchproduct,
            @RequestParam(name="searchtitle",required = false) String searchtitle , Model model){

        if (searchproduct != null && !searchproduct.isEmpty() && searchtitle != null && !searchtitle.isEmpty()) {
            // Combine results from both queries
            List<repairNote> repairNoteListProduct = repairNoteRepository.findByProductname(searchproduct);
            List<repairNote> repairNoteListTitle = repairNoteRepository.findByTitle(searchtitle);
            Set<repairNote> combinedResults = new HashSet<>(repairNoteListProduct);
            combinedResults.addAll(repairNoteListTitle);

            model.addAttribute("searchcombined", new ArrayList<>(combinedResults));
        } else if (searchmanufacturer != null && !searchmanufacturer.isEmpty()) {
            List<repairNote> repairNoteListManufacturer = repairNoteRepository.findByManufacturer(searchmanufacturer);
            model.addAttribute("searchmanufacturer", repairNoteListManufacturer);
        } else if (searchproduct != null && !searchproduct.isEmpty()) {
            List<repairNote> repairNoteListProduct = repairNoteRepository.findByProductname(searchproduct);
            model.addAttribute("searchproduct", repairNoteListProduct);
        } else if (searchtitle != null && !searchtitle.isEmpty()) {
            List<repairNote> repairNoteListTitle = repairNoteRepository.findByTitle(searchtitle);
            model.addAttribute("searchtitle", repairNoteListTitle);
        } else {
            List<repairNote> repairNoteList = repairNoteRepository.findByProductname(productName);
            model.addAttribute("repairNotes", repairNoteList);
        }
        model.addAttribute("repairNote", new repairNote());
        return "repairCard";

    }



    @GetMapping("/index")
    public String showmenu(Model model){
    List<vendor> vendorList = vendorRepository.findAll();
        model.addAttribute("vendors", vendorList);
        List<product> productList = productRepository.findAll();
        model.addAttribute("products", productList);
        product newproduct = new product();
        model.addAttribute("product", newproduct);
        vendor newvendor = new vendor();
        model.addAttribute("vendor", newvendor);

        return "index";
    }


    @GetMapping("/addnote")
    public String addNote(Model model){
        List<vendor> vendorList = vendorRepository.findAll();
        List<product> productList = productRepository.findAll();
        model.addAttribute("repairNote", new repairNote());
        model.addAttribute("vendor", vendorList);
        model.addAttribute("product", productList);
        return "addnote";
    }
    @PostMapping("/addnote")
    public String addnewNote(@ModelAttribute("repairNote") repairNote repairNote,
                             Model model){
        repairNote.setDateCreated(String.valueOf(LocalDate.now()));
        repairNoteRepository.save(repairNote);
        model.addAttribute("repairNote", new repairNote());
        return "repairCard";
    }

    @PostMapping("/updaterepair")
     public String updaterepairnote(@ModelAttribute("repairNote") repairNote repairNote,
    @RequestParam("additionalNote") String additionalNote
    ,Model model) {

        repairNote existingnote = repairNoteRepository.findById(repairNote.getId()).orElse(null);

        if (existingnote != null) {
            String mergedNote = existingnote.getTextNote() +" "+additionalNote;
            existingnote.setId(repairNote.getId());
            existingnote.setManufacturer(repairNote.getManufacturer());
            existingnote.setProductName(repairNote.getProductName());
            existingnote.setProductCode(repairNote.getProductCode());
            existingnote.setDateCreated(repairNote.getDateCreated());
            existingnote.setTitle(repairNote.getTitle());
            existingnote.setLink(repairNote.getLink());
//            existingnote.setTextNote(repairNote.getTextNote());
            existingnote.setTextNote(mergedNote);
        repairNoteRepository.save(existingnote);
        }
        return ("redirect:/results");
    }
    @ModelAttribute("newRepairNote")
    public repairNote getNewRepairNote() {
        return new repairNote();
    }


    @PostMapping("/addproduct")
    public String addProduct(
            @ModelAttribute("product") product newProduct
            ) {

        productRepository.save(newProduct);

        return "redirect:/index";
    }

    @PostMapping("/addmanufacturer")
    public String addManufacturer(
            @ModelAttribute("manufacturer") vendor newvendor
    ) {

        vendorRepository.save(newvendor);

        return "redirect:/index";
    }






}
