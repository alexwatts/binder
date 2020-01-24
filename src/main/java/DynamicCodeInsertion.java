import java.io.IOException;
import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;

public class DynamicCodeInsertion {

    public byte[] getBytes(String clazz, String methodName)
            throws NotFoundException, CannotCompileException, IOException {

        ClassPool cp = ClassPool.getDefault();
        cp.importPackage(".");
        CtClass cc = cp.get(clazz);
        CtMethod method = cc.getDeclaredMethod(methodName);

        new IntTransformer().transform(method);

        return cc.toBytecode();
    }

}








