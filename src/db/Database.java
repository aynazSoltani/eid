package db;

import db.exception.EntityNotFoundException;

import java.util.ArrayList;

public class Database {
    private static ArrayList<Entity> entities = new ArrayList<>();
    private static int number = 1;

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
       for(Entity e : entities){
           if(e.id == id ){
               entities.remove(e);
           }
       }
       throw new EntityNotFoundException(id);
    }
    public static void update(Entity e) throws EntityNotFoundException{
       for(Entity e : entities){
           if(e.id == )
       }
    }
}

