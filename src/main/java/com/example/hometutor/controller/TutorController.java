package com.example.hometutor.controller; // Define the package location of the class


import com.example.hometutor.model.Tutor;
import com.example.hometutor.service.TutorService; // Imports the Tutor model and Tutor Service class 

import org.springframework.stereotype.Controller; // Marks this class as a MVC controller

import org.springframework.ui.Model; //Used to send data from controller to user interface pages

import org.springframework.web.bind.annotation.GetMapping;  // Imports annotations for manupulation of HTTP requests
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller // Tells spring that this class handles web requests
    
@RequestMapping("/tutors") //Sets the base URL for all methods
    
public class TutorController  //Creates the controller class
{
    private final TutorService tutorService; // Creates a service variable

    public TutorController(TutorService tutorService) // Constructor (Dependency) injection procedure
    
    {
        this.tutorService = tutorService;
    }

    // Display the tutor list
    
    @GetMapping //Handles GET requests
    
    public String list(@RequestParam(required = false) String keyword, Model model) // Gets value from URL
    
    {
        model.addAttribute("tutors", tutorService.search(keyword)); // Search available tutors
        
        model.addAttribute("keyword", keyword == null ? "" : keyword); // Handle null keyword
        return "tutors"; // Return to user interface page
    }

    // Open new tutor form
    @GetMapping("/new")
    public String newForm() 
    
    {
        return "tutor-form";  // Return form page
    }
    // Create new tutor 
    @PostMapping
    
    public String create(@RequestParam String type, @RequestParam String id, @RequestParam String name,       // Receive form data     
                         @RequestParam String email, @RequestParam String phone, @RequestParam String subject,
                         @RequestParam String qualification, @RequestParam String location,
                         @RequestParam String hourlyRate, @RequestParam String availability,
                         @RequestParam(required = false) String platform,
                         @RequestParam(required = false) String travelFee)
    
    {
        Tutor tutor = tutorService.buildTutor(type, id, name, email, phone, subject, qualification,  // Build tutor object
                location, parseDouble(hourlyRate), availability, platform, parseDouble(travelFee));
        tutorService.create(tutor);
        return "redirect:/tutors";  //Redirect after saving
    }

    @GetMapping("/edit/{id}") //Open edit form
    
    public String editForm(@PathVariable String id, Model model) 
    
    {
        model.addAttribute("tutor", tutorService.findById(id).orElse(null)); //Find the corect tutor by ID nd send tutor details to user inteface 
        return "tutor-form"; // Return edit form
    }

    @PostMapping("/edit/{id}")
    
    public String update(@PathVariable String id, @RequestParam String type, @RequestParam String name, // Update Tutor
                         @RequestParam String email, @RequestParam String phone, @RequestParam String subject,
                         @RequestParam String qualification, @RequestParam String location,
                         @RequestParam String hourlyRate, @RequestParam String availability,
                         @RequestParam(required = false) String platform,
                         @RequestParam(required = false) String travelFee) 
    {
        Tutor tutor = tutorService.buildTutor(type, id, name, email, phone, subject, qualification,
                location, parseDouble(hourlyRate), availability, platform, parseDouble(travelFee));
        tutorService.update(tutor); // Create updated object and save updated data
        return "redirect:/tutors";
    }

    @GetMapping("/delete/{id}")
    
    public String delete(@PathVariable String id) //Delete tutor (details)
    
    {
        tutorService.delete(id); // Delete operation
        return "redirect:/tutors"; // Redirect after delete
    }

    private double parseDouble(String value) // Converts into double
    
    {
        // Attempts conversion
        try {
            return Double.parseDouble(value);
        } catch (Exception e) { // If inputs the invalid number, subsequently returns = 0
            return 0; 
         }
        
    }
    
}
