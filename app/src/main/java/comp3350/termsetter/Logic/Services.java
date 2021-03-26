package comp3350.termsetter.Logic;

import android.content.Context;

import comp3350.termsetter.Persistence.DomainSpecific.StubDatabase;
import comp3350.termsetter.Persistence.DomainSpecific.hsqldbObjects.StudentAccess;
import comp3350.termsetter.Persistence.Main;
import comp3350.termsetter.Persistence.StudentPersistence;

public class Services
{
    private static StudentPersistence studentAccess = null;
    private static Context mContext;

    public static synchronized StudentPersistence getRealStudentAccess()
    {
        if (studentAccess == null)
        {

            // database = new StubDatabase(mContext,"test.db");
            //studentAccess = StubDatabase("test.db")
            studentAccess = new StudentAccess(Main.getDBPathName());
        }

        return studentAccess;
    }
    public static synchronized StudentPersistence getFakeStudentAccess(Context context)
    {
        if (studentAccess == null)
        {
            studentAccess = new StubDatabase(context,"test.db");
            //studentAccess = new StudentAccess(Main.getDBPathName());
        }

        return studentAccess;
    }

}

