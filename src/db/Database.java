package db;

import db.exception.EntityNotFoundException;
import db.exception.InvalidEntityException;

import java.util.ArrayList;
import java.util.HashMap;

public class Database {
    private static ArrayList<Entity> entities = new ArrayList<>();
    private static int number = 1;
    private static HashMap<Integer, Validator> validators = new HashMap<>();

    private Database() {};

    public static void registerValidator(int entityCode, Validator validator){
        if (validators.containsKey(entityCode))
            throw new IllegalStateException("Validator for this entity already exists.");

        validators.put(entityCode, validator);
    }


    public static void add(Entity e)throws InvalidEntityException{
       Validator validator = validators.get(e.getEntityCode());
       if (validator != null) {
           validator.validate(e);
       }
       e.id = number++;
       Entity copy = e.copy();
     entities.add(copy);
    }
    public static Entity get(int id)throws  EntityNotFoundException{
       for(Entity e: entities) {
           if (e.id == id) {
               return e.copy();
           }
       }
       throw  new EntityNotFoundException(id);
    }
    public  static void delete(int id) throws EntityNotFoundException{
       for(int i=0;i<entities.size();i++ ){
           if(entities.get(i).id == id ){
               entities.remove(i);
               return;
           }
       }
       throw new EntityNotFoundException(id);
    }
    public static void update(Entity e) throws EntityNotFoundException, InvalidEntityException{
       Entity copy = e.copy();
        Validator validator = validators.get(e.getEntityCode());
        if (validator != null) {
            validator.validate(e);
        }

       for(int i = 0;i<entities.size();i++){
           if(entities.get(i).id ==  copy.id ){
               entities.set(i,copy);
               return;
           }
       }
       throw new EntityNotFoundException(e.id);
    }
}

