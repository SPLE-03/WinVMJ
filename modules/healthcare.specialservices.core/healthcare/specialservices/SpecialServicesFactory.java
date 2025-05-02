package healthcare.specialservices;

import healthcare.specialservices.core.SpecialServices;
import java.lang.reflect.Constructor;
import java.util.logging.Logger;

public class SpecialServicesFactory{
    private static final Logger LOGGER = Logger.getLogger(SpecialServicesFactory.class.getName());

    public SpecialServicesFactory()
    {

    }

    public static SpecialServices createSpecialServices(String fullyQualifiedName, Object ... base)
    {
        SpecialServices record = null;
        try {
            Class<?> clz = Class.forName(fullyQualifiedName);
            Constructor<?> constructor = clz.getDeclaredConstructors()[0];
            record = (SpecialServices) constructor.newInstance(base);
        } 
        catch (IllegalArgumentException e)
        {
            LOGGER.severe("Failed to create instance of SpecialServices.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            LOGGER.severe("Failed to run: Check your constructor argument");
            System.exit(20);
        }
        catch (ClassCastException e)
        {   LOGGER.severe("Failed to create instance of SpecialServices.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            LOGGER.severe("Failed to cast the object");
            System.exit(30);
        }
        catch (ClassNotFoundException e)
        {
            LOGGER.severe("Failed to create instance of SpecialServices.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            LOGGER.severe("Decorator can't be applied to the object");
            System.exit(40);
        }
        catch (Exception e)
        {
            LOGGER.severe("Failed to create instance of SpecialServices.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            System.exit(50);
        }
        return record;
    }

}
