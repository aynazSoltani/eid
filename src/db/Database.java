package db;

import db.exception.EntityNotFoundException;

import java.util.ArrayList;

public class Database {
    private static ArrayList<Entity> entities = new ArrayList<>();
    private static int number = 1;

    private Database() {};

   public static void add(Entity e){
       e.id = number++;
     entities.add(e);
    }
    public static Entity get(int id)throws  EntityNotFoundException{
       for(Entity e: entities) {
           if (e.id == id) {
               return e;
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
       for(int i=0;i<entities.size();i++){
           if(entities.get(i).id ==  e.id ){
               entities.set(i,e);
               return;
           }
       }
       throw new EntityNotFoundException(e.id);
    }
}

