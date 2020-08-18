package mycode.university.restControllers;


import mycode.university.model.EqualsSlotService;
import mycode.university.model.Timetable;
import mycode.university.repository.AdmnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.text.SimpleDateFormat;
import java.util.Optional;


@RestController
@RequestMapping("/tchr")
public class TeacherController {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    @Autowired
    private AdmnRepository admnRepository;


    @GetMapping("/viewall")
    public Iterable<Timetable> timetableView(Model model) {
        Iterable<Timetable> rows = admnRepository.findAll();
        model.addAttribute(rows);
        return rows;
    }

    @GetMapping("/{id}/find")
    public Optional<Timetable> tchrtableFind(@PathVariable(value = "id", required = false) long id, Model model) {
        Optional<Timetable> row = admnRepository.findById(id);
        model.addAttribute(row);
        return row;
    }

    @PostMapping("/{id}/update")
    public Timetable tchrPostUpdate(@RequestParam(value = "id", required = false) long id,
                                    @RequestParam(value = "teacher_name", required = false) String teacher_name,
                                    @RequestParam(value = "tchrFreTimFrom", required = false) String tchrFreTimFrom,
                                    @RequestParam(value = "tchrFreTimTo", required = false) String tchrFreTimTo,
                                    @RequestParam(value = "price_perhour$", required = false) String price_perhour$,
                                    @RequestParam(value = "tchrstatus", required = false) String tchrstatus) {
        Timetable timetable = admnRepository.findById(id).orElseThrow();
        timetable.setTeacher_name(teacher_name);
                if (new EqualsSlotService().TchrSlot(tchrFreTimFrom, tchrFreTimTo,admnRepository) == false) {
                timetable.setTchrFreTimFrom(tchrFreTimFrom);
                timetable.setTchrFreTimTo(tchrFreTimTo);

        } else {    throw new IllegalArgumentException("This timeslot is busy or is not correct");    }
        timetable.setPrice_perhour$(price_perhour$);
        timetable.setStatusTchr(tchrstatus);
        admnRepository.save(timetable);
        return timetable;
    }

}






