package za.ac.cput.repository.dining.impl;

import za.ac.cput.entity.dining.DiningService;
import za.ac.cput.repository.dining.IDiningServiceRepository;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DiningServiceRepository implements IDiningServiceRepository {

    private static DiningServiceRepository diningServiceRepository = null;
    private List<DiningService>diningServiceDb  = null;

    private DiningServiceRepository(){ diningServiceDb = new ArrayList<DiningService>(); }

    public static DiningServiceRepository getDiningServiceRepository(){
        if (diningServiceRepository == null)
            diningServiceRepository = new DiningServiceRepository();

        return diningServiceRepository;
    }


    @Override
    public DiningService create(DiningService x) {
        try{
            diningServiceDb.add(x);
        }catch (Exception e){
            e.printStackTrace();
        }
        return x;
    }

    @Override
    public DiningService read(String s) {
        for (DiningService din:diningServiceDb){
            if (din.getServiceType()== s)
                return din;
        }
        return null;
    }

    @Override
    public DiningService update(DiningService x, String s) {
        DiningService oldDiningService = read(x.getServiceType());
        if (oldDiningService != null){
            diningServiceDb.remove(oldDiningService);
            diningServiceDb.add(x);
            return x;
        }
        return null;
    }

    @Override
    public boolean delete(String s) {
        try {
          DiningService delDiningService = read(s);
          if(delDiningService !=null)
              diningServiceDb.remove(delDiningService);
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
