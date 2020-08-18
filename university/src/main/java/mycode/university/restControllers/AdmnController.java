package mycode.university.restControllers;

import mycode.university.model.EqualsSlotService;
import mycode.university.model.Timetable;
import mycode.university.repository.AdmnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/admn")
public class AdmnController {

    @Autowired
    private AdmnRepository admnRepository;



    @PostMapping("/create")
    public Timetable admtablePostCreate(@RequestParam(value="id", required=false) long id,
                                      @RequestParam(value="teacher_name", required=false)String teacher_name,
                                      @RequestParam(value="subject", required=false) String subject,
                                      @RequestParam(value="tchrFreTimFrom", required=false) String tchrFreTimFrom,
                                      @RequestParam(value="tchrFreTimTo", required=false) String tchrFreTimTo,
                                      @RequestParam(value="student_name", required=false) String student_name,
                                      @RequestParam(value="price_perhour$", required=false) String price_perhour$,
                                      @RequestParam(value="stddateFrom", required=false) String stddateFrom,
                                      @RequestParam(value="stddateTo", required=false) String stddateTo,
                                      @RequestParam(value="tchrstatus", required=false) String tchrstatus,
                                      @RequestParam(value="stdstatus", required=false) String stdstatus) {
        Timetable timetable = new Timetable(id, teacher_name, subject,tchrFreTimFrom,tchrFreTimTo, student_name,
                price_perhour$, stddateFrom, stddateTo, tchrstatus,stdstatus);
        timetable.setId(id);
        timetable.setTeacher_name(teacher_name);
        timetable.setSubject(subject);
        timetable.setTchrFreTimFrom(tchrFreTimFrom);
        timetable.setTchrFreTimTo(tchrFreTimTo);
        timetable.setStudent_name(student_name);
        timetable.setPrice_perhour$(price_perhour$);
        timetable.setStddateFrom(stddateFrom);
        timetable.setStddateTo(stddateTo);
        timetable.setStatusTchr(tchrstatus);
        timetable.setStatusStd(stdstatus);
        admnRepository.save(timetable);
        return timetable;
    }

    @PostMapping("/{id}/delete")
    public Timetable admtablePostDelete(@PathVariable(value="id") long id) {
        Timetable timetable = admnRepository.findById(id).orElseThrow();
        admnRepository.delete(timetable);
        return timetable;
    }


    @PostMapping("/{id}/update")
    public Timetable admtimetablePostUpdate(@RequestParam(value="id", required=false) long id,
                                      @RequestParam(value="teacher_name", required=false)String teacher_name,
                                      @RequestParam(value="subject", required=false) String subject,
                                      @RequestParam(value="tchrFreTimFrom", required=false) String tchrFreTimFrom,
                                      @RequestParam(value="tchrFreTimTo", required=false) String tchrFreTimTo,
                                      @RequestParam(value="student_name", required=false) String student_name,
                                      @RequestParam(value="price_perhour$", required=false) String price_perhour$,
                                      @RequestParam(value="stddateFrom", required=false) String stddateFrom,
                                      @RequestParam(value="stddateTo", required=false) String stddateTo,
                                      @RequestParam(value="tchrstatus", required=false) String tchrstatus,
                                      @RequestParam(value="stdstatus", required=false) String stdstatus){
        Timetable timetable = admnRepository.findById(id).orElseThrow();
        timetable.setId(id);
        timetable.setTeacher_name(teacher_name);
        timetable.setSubject(subject);
            if (new EqualsSlotService().TchrSlot(tchrFreTimFrom, tchrFreTimTo,admnRepository) == false) {
                timetable.setTchrFreTimFrom(tchrFreTimFrom);
                timetable.setTchrFreTimTo(tchrFreTimTo);
            } else {  System.out.println("This time is not correct");      }

        timetable.setStudent_name(student_name);
        timetable.setPrice_perhour$(price_perhour$);

         if (new EqualsSlotService().StdSlot(stddateFrom, stddateTo,admnRepository) == false) {
        timetable.setStddateTo(stddateTo);
        timetable.setStddateFrom(stddateFrom);
    } else {   throw new IllegalArgumentException("This time is not correct");    }
        timetable.setStatusTchr(tchrstatus);
        timetable.setStatusStd(stdstatus);
        admnRepository.save(timetable);
        return timetable;

    }

}

