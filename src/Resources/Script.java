package Resources;

import java.util.Arrays;
import java.util.Vector;

/**
 * Created by danecarlson on 1/4/2016.
 */
public class Script {
    public enum Ids {IntroPrisoner}

    public static Vector<String> getScript(Ids id) {
        if (id == Ids.IntroPrisoner) {
            return new Vector<String>(Arrays.asList("Hey!  Hey you...get over here!",
                    "Good boy.  Listen, I know you ain't a guard",
                    "If you get the key from that guard, I'll make it worth your while.")
            );
        }
        return new Vector<String>(Arrays.asList(""));
    }

}
