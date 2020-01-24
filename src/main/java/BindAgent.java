import java.lang.instrument.ClassDefinition;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;

public class BindAgent {

    private static Instrumentation instrumentation;

    public static void premain(String args, Instrumentation inst) throws Exception {

        instrumentation = inst;
    }

    public static void agentmain(String args, Instrumentation inst) throws Exception {
        instrumentation = inst;
    }

    public static void redefineClass(ClassDefinition classDefinition)
            throws UnmodifiableClassException, ClassNotFoundException {
        instrumentation.redefineClasses(classDefinition);
    }

    public static void initialize() {
        if (instrumentation == null) {
            MyJavaAgentLoader.loadAgent();
        }
    }

}