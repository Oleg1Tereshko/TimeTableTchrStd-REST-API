package mycode.university.restControllers;

import mycode.university.model.EqualsSlotService;
import mycode.university.model.Timetable;
import mycode.university.repository.AdmnRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;

@RestController
@RequestMapping("/std")
public class StudentController {

    @Autowired
    private AdmnRepository admnRepository;

    @GetMapping("/viewall")
    public Iterable<Timetable> timetableView(Model model) {
        Iterable<Timetable> rows = admnRepository.findAll();
        model.addAttribute(rows);
        return rows;
    }

    @GetMapping("/{id}/find")
    public Optional<Timetable> stdtableFind(@PathVariable(value = "id", required = false) long id, Model model) {
        Optional<Timetable> row = admnRepository.findById(id);
        model.addAttribute( row);
        return row;
    }

    @PostMapping("/{id}/update")
    public Timetable admtimetablePostUpdate(@RequestParam(value = "id", required = false) long id,
                                            @RequestParam(value = "student_name", required = false) String student_name,
                                            @RequestParam(value = "stddateFrom", required = false) String stddateFrom,
                                            @RequestParam(value = "stddateTo", required = false) String stddateTo,
                                            @RequestParam(value = "stdstatus", required = false) String stdstatus) {
        Timetable timetable = admnRepository.findById(id).orElseThrow();
        timetable.setStudent_name(student_name);

        if (new EqualsSlotService().StdSlot(stddateFrom, stddateTo,admnRepository) == false
                && new EqualsSlotService().StdTchrSlot( stddateFrom, stddateTo,admnRepository)==false) {
               timetable.setStddateFrom(stddateFrom);
               timetable.setStddateTo(stddateTo);
        } else {   throw new IllegalArgumentException("This timeslot is busy or is not correct");    }

        timetable.setStatusStd(stdstatus);
        admnRepository.save(timetable);
        return timetable;
    }

}




