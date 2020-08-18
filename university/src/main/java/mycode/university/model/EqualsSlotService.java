package mycode.university.model;
import mycode.university.repository.AdmnRepository;
import org.springframework.stereotype.Service;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Optional;

@Service
public class EqualsSlotService implements AdmnRepository {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");


     private  AdmnRepository admnRepository;



    public  boolean TchrSlot(String tchrFreTimFrom, String tchrFreTimTo,AdmnRepository admnRepository) {
      if(admnRepository != null) {
          Iterable<Timetable> rows = admnRepository.findAll();

          for (Timetable row : rows) {

              try {
                  Date tchrdateFr = dateFormat.parse(tchrFreTimFrom);
                  Date tchrdateTo = dateFormat.parse(tchrFreTimTo);
                  Date tchrdateFrDB = dateFormat.parse(row.getTchrFreTimFrom());
                  Date tchrdateToDB = dateFormat.parse(row.getTchrFreTimTo());

                  if (tchrdateFrDB.getTime() < tchrdateTo.getTime() && tchrdateToDB.getTime() >= tchrdateTo.getTime()
                          || tchrdateFrDB.getTime() < tchrdateFr.getTime() && tchrdateToDB.getTime() > tchrdateFr.getTime()
                          || tchrdateFrDB.getTime() == tchrdateFr.getTime() && tchrdateToDB.getTime() > tchrdateFr.getTime()
                          || tchrdateFrDB.getTime() == tchrdateFr.getTime() && tchrdateToDB.getTime() == tchrdateTo.getTime()
                          || tchrdateFrDB.getTime() > tchrdateFr.getTime() && tchrdateToDB.getTime() < tchrdateTo.getTime()) {

                      return true;
                  }

              } catch (ParseException e) {
                  e.printStackTrace();
              }
          }
      } else {System.out.println(" TchrRepository Null");}
        return false;
    }

    public  boolean StdSlot(String stddateFrom, String stddateTo,AdmnRepository admnRepository) {
        if(admnRepository != null) {
            Iterable<Timetable> rows = admnRepository.findAll();
            for (Timetable row : rows) {
                try {
                    Date stddateFr = dateFormat.parse(stddateFrom);
                    Date stddateToo = dateFormat.parse(stddateTo);
                    Date stddateFrDB = dateFormat.parse(row.getStddateFrom());
                    Date stddateTooDB = dateFormat.parse(row.getStddateTo());

                    if (stddateFrDB.getTime() < stddateToo.getTime() && stddateTooDB.getTime() >= stddateToo.getTime()
                            || stddateFrDB.getTime() < stddateFr.getTime() && stddateTooDB.getTime() > stddateFr.getTime()
                            || stddateFrDB.getTime() == stddateFr.getTime() && stddateTooDB.getTime() > stddateFr.getTime()
                            || stddateFrDB.getTime() == stddateFr.getTime() && stddateTooDB.getTime() == stddateToo.getTime()
                            || stddateFrDB.getTime() > stddateFr.getTime() && stddateTooDB.getTime() < stddateToo.getTime()) {

                        return true;
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }else {System.out.println("StdSlotRepository Null");}
        return false;
    }

    public boolean StdTchrSlot(String stddateFrom, String stddateTo,AdmnRepository admnRepository) {
        if(admnRepository != null) {
            Iterable<Timetable> rows = admnRepository.findAll();
            for (Timetable row : rows) {
                try {
                    Date stddateFr = dateFormat.parse(stddateFrom);
                    Date stddateToo = dateFormat.parse(stddateTo);

                    Date tchrdateFrDB = dateFormat.parse(row.getTchrFreTimFrom());
                    Date tchrdateToDB = dateFormat.parse(row.getTchrFreTimTo());

                    if (tchrdateFrDB.getTime() == stddateFr.getTime() && tchrdateToDB.getTime() == stddateToo.getTime()
                            || tchrdateFrDB.getTime() < stddateFr.getTime() && tchrdateToDB.getTime() > stddateToo.getTime()
                            || tchrdateFrDB.getTime() == stddateFr.getTime() && tchrdateToDB.getTime() > stddateToo.getTime()
                            || tchrdateFrDB.getTime() < stddateFr.getTime() && tchrdateToDB.getTime() == stddateToo.getTime()) {

                        return false;
                    }

                } catch (ParseException e) {
                    e.printStackTrace();

                }
            }
        }else {System.out.println("StdTchrSlotRepository Null");}
        return true;
    }



    public boolean Dateequalstchr(String tchrFreTimFrom, String tchrFreTimTo){
        try {
            Date tchrdateFr = dateFormat.parse(tchrFreTimFrom);
            Date tchrdateTo = dateFormat.parse(tchrFreTimTo);
            if(tchrdateFr.after(tchrdateTo)==true && tchrdateTo.before(tchrdateFr)== false )
            { return true; }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean DateequalsStd(String stddateFrom, String stddateTo){
        try {
            Date stddateFr = dateFormat.parse(stddateFrom);
            Date stddateToo = dateFormat.parse(stddateTo);
            if(stddateFr.after(stddateToo)==true && stddateToo.before(stddateFr)==false)
            {    return true;}
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }

    public String TchrPrice(String price){
        int r = Integer.parseInt(price);
        switch (r) {
            case 1:
                return String.valueOf(Price.FIFTEENMIN) + Price.FIFTEENMIN.getPrice();

            case 2:
                return String.valueOf(Price.THIRTYMIN) + Price.THIRTYMIN.getPrice();

            case 3:
                return String.valueOf(Price.HOUR) + Price.HOUR.getPrice();

            default:
                return  String.valueOf(Price.NOTPRICE);
        }
    }

    public String Status(String status){
        int s = Integer.parseInt(status);
        switch (s) {
            case 0:
               return  String.valueOf(Status.DECLINED);

            case 1:
                return String.valueOf(Status.APPROVE);

            default:
                return   String.valueOf(Status.NOTSELECT);
        }
    }

    @Override
    public <S extends Timetable> S save(S s) {
        return null;
    }

    @Override
    public <S extends Timetable> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Timetable> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Timetable> findAll() {
        return null;
    }

    @Override
    public Iterable<Timetable> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Timetable timetable) {

    }

    @Override
    public void deleteAll(Iterable<? extends Timetable> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
