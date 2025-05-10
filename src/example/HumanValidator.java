package example;
import db.Validator;
import db.Entity;
import db.exception.InvalidEntityException;

    public class HumanValidator implements Validator {
        @Override
        public void validate(Entity entity) throws InvalidEntityException {

            if (!(entity instanceof Human)) {
                throw new IllegalAccessError("Type of Entity is not correct!");
            }
                Human humanobj = (Human) entity;

                if (humanobj.name == null || humanobj.name.isEmpty())
                    throw new InvalidEntityException("Name Cannot be null or empty!");

                if (humanobj.age < 0)
                    throw new InvalidEntityException("Age can not be negative!");


            }


        }


