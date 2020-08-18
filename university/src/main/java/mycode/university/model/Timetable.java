package mycode.university.model;
import javax.persistence.*;



@Entity
@Table(name ="timetable")
public class Timetable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id")
    private Long id;

    @Column(name= "teacher_name")
    public String teacher_name;

    @Column(name= "subject")
    public String subject;

    @Column(name= "tchrFreTimFrom")
    public String tchrFreTimFrom;

    @Column(name= "tchrFreTimTo")
    public String tchrFreTimTo;

    @Column(name= "student_name")
    public String student_name;

    @Column(name= "price_perhour$")
    public String price_perhour$;

    @Column(name= "stddateFrom")
    public String stddateFrom;

    @Column(name= "stddateTo")
    public String stddateTo;

    @Column(name= "statusTchr")
    public String statusTchr;

    @Column(name= "statusStd")
    public String statusStd;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        if(id != null) {
        this.id = id;
        }else {  throw new IllegalArgumentException("This id is not correct");  }
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name( String teacher_name) {
       if (teacher_name != "") {
        this.teacher_name = teacher_name;
       }else {  throw new IllegalArgumentException("This teacher_name is not correct");  }
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject( String subject) {
        if (subject != "") {
        this.subject = subject;
        }else {  throw new IllegalArgumentException("This subject is not correct");  }
    }

    public String getTchrFreTimFrom() {     return tchrFreTimFrom;    }

    public void setTchrFreTimFrom( String tchrFreTimFrom) {
        if (tchrFreTimFrom != "") {
                if (new EqualsSlotService().Dateequalstchr(tchrFreTimFrom, tchrFreTimTo) == false) {
                    this.tchrFreTimFrom = tchrFreTimFrom;
                } else {
                    throw new IllegalArgumentException("This time is not correct");
                }
            }else {  throw new IllegalArgumentException("This tchrFreTimFrom is not correct");  }
        }

    public String getTchrFreTimTo() {
        return tchrFreTimTo;
    }

    public void setTchrFreTimTo( String tchrFreTimTo) {
        if(tchrFreTimTo !="") {
            this.tchrFreTimTo = tchrFreTimTo;
                }else {  throw new IllegalArgumentException("This tchrFreTimTo is not correct");  }
    }
    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name( String student_name) {
        if (student_name != "") {
            this.student_name = student_name;
        } else {
            throw new IllegalArgumentException("This student_name is not correct");
        }
    }
        public String getPrice_perhour$() {
        return price_perhour$;
    }

    public void setPrice_perhour$( String price_perhour$) {
        if (price_perhour$ != "") {
            this.price_perhour$ = new EqualsSlotService().TchrPrice(price_perhour$);
        }else {  throw new IllegalArgumentException("This price_perhour$ is not correct");  }
    }


    public String getStddateFrom() {
        return stddateFrom;
    }

    public void setStddateFrom( String stddateFrom) {
        if (stddateFrom != "") {
                if (new EqualsSlotService().DateequalsStd(stddateFrom, stddateTo) == false) {
                    this.stddateFrom = stddateFrom;
                } else {
                    throw new IllegalArgumentException("This time is not correct");
                }
            }else {  throw new IllegalArgumentException("This stddateFrom is not correct");  }
        }


    public String getStddateTo() {
        return stddateTo;
    }

    public void setStddateTo( String stddateTo) {
        if (stddateTo != "") {
           this.stddateTo = stddateTo;
             }else {  throw new IllegalArgumentException("This stddateTo is not correct");  }
    }
    public String getStatusTchr() {
        return statusTchr;
    }

    public void setStatusTchr(String statusTchr) {
        if (statusTchr != "") {
            this.statusTchr = new EqualsSlotService().Status(statusTchr);
        }else {  throw new IllegalArgumentException("This statusTchr is not correct");  }
    }
    public String getStatusStd() {
        return statusStd;
    }

    public void setStatusStd( String statusStd) {
        if (statusStd != "") {
            this.statusStd =  new EqualsSlotService().Status(statusStd);
        }else {  throw new IllegalArgumentException("This statusStd is not correct");  }
    }

    public Timetable() {
    }

    public Timetable(Long id, String teacher_name, String subject, String tchrFreTimFrom, String tchrFreTimTo,
                     String student_name, String price_perhour$, String stddateFrom, String stddateTo,
                     String statusTchr, String statusStd) {
        this.id = id;
        this.teacher_name = teacher_name;
        this.subject = subject;
        this.tchrFreTimFrom = tchrFreTimFrom;
        this.tchrFreTimTo = tchrFreTimTo;
        this.student_name = student_name;
        this.price_perhour$ = price_perhour$;
        this.stddateFrom = stddateFrom;
        this.stddateTo = stddateTo;
        this.statusTchr = statusTchr;
        this.statusStd = statusStd;
    }

    public Timetable(Long id, String teacher_name, String tchrFreTimFrom, String tchrFreTimTo, String price_perhour$, String statusTchr) {
        this.id = id;
        this.teacher_name = teacher_name;
        this.tchrFreTimFrom = tchrFreTimFrom;
        this.tchrFreTimTo = tchrFreTimTo;
        this.price_perhour$ = price_perhour$;
        this.statusTchr = statusTchr;
    }

    public Timetable(Long id, String student_name, String stddateFrom, String stddateTo, String statusStd) {
        this.id = id;
        this.student_name = student_name;
        this.stddateFrom = stddateFrom;
        this.stddateTo = stddateTo;
        this.statusStd = statusStd;
    }


    @Override
    public String toString() {
        return "Timetable{" +
                "id=" + id +
                ", teacher_name='" + teacher_name + '\'' +
                ", subject='" + subject + '\'' +
                ", tchrFreTimFrom='" + tchrFreTimFrom + '\'' +
                ", tchrFreTimTo='" + tchrFreTimTo + '\'' +
                ", student_name='" + student_name + '\'' +
                ", price_perhour$='" + price_perhour$ + '\'' +
                ", stddateFrom='" + stddateFrom + '\'' +
                ", stddateTo='" + stddateTo + '\'' +
                ", statusTchr='" + statusTchr + '\'' +
                ", statusStd='" + statusStd + '\'' +
                '}';
    }


}



