package comp3350.termsetter.Persistence;

import android.content.Context;
import android.content.res.AssetManager;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class DBImporter {

    public static void copyDatabaseToDevice(Context context) throws IOException {
        final String DB_PATH = "databases";

        String[] assetNames;
        File dataDirectory = context.getDir(DB_PATH, Context.MODE_PRIVATE);
        AssetManager assetManager = context.getAssets();

        //copying all the contents of assets db folder to the device's data folder.
        try {
            assetNames = assetManager.list(DB_PATH);
            for (int i = 0; i < assetNames.length; i++) {
                assetNames[i] = DB_PATH + "/" + assetNames[i];
            }
            copyAssetsToDirectory(context, assetNames, dataDirectory);
            Main.setDBPathName(dataDirectory.toString() + "/" + Main.getDBPathName());
            Main.confirmImport();

        } catch (final IOException ioe) {
            throw new IOException("Unable to access application data: " + ioe.getMessage());
        }
    }

    public static void copyAssetsToDirectory(Context context, String[] assets, File directory) throws IOException {
        AssetManager assetManager = context.getAssets();

        for (String asset : assets) {
            String[] components = asset.split("/");
            String copyPath = directory.toString() + "/" + components[components.length - 1];

            char[] buffer = new char[1024];
            int count;

            File outFile = new File(copyPath);

            if (!outFile.exists()) {
                InputStreamReader in = new InputStreamReader(assetManager.open(asset));
                FileWriter out = new FileWriter(outFile);

                count = in.read(buffer);
                while (count != -1) {
                    out.write(buffer, 0, count);
                    count = in.read(buffer);
                }

                out.close();
                in.close();
            }
        }
    }
}