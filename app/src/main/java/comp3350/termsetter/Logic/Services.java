package comp3350.termsetter.Logic;

import comp3350.termsetter.Persistence.DomainSpecific.hsqldbObjects.StudentAccess;
import comp3350.termsetter.Persistence.Main;
import comp3350.termsetter.Persistence.UserPersistence;

public class Services
{
    private static UserPersistence studentAccess = null;

    public static synchronized UserPersistence getStudentAccess()
    {
        if (studentAccess == null)
        {
            studentAccess = new StudentAccess(Main.getDBPathName());
        }

        return studentAccess;
    }

}

