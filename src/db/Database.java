package db;

import db.exception.EntityNotFoundException;

import java.util.ArrayList;
import java.util.Date;

public class Database {
    private static ArrayList<Entity> entities = new ArrayList<>();
    private static int number = 1;

    private Database() {};

   public static void add(Entity e){
       
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
    public static void update(Entity e) throws EntityNotFoundException{
       Entity copy = e.copy();
       for(int i = 0;i<entities.size();i++){
           if(entities.get(i).id ==  copy.id ){
               entities.set(i,copy);
               return;
           }
       }
       throw new EntityNotFoundException(e.id);
    }
}

