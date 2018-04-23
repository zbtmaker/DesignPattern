Pacakge Singletone_Pattern
public class LazySingletoneObject{
    private static LazySingletoneObject instance = null;
    
    //private constructor
    private LazySingletoneObject(){};
    
    //get a instance of LazySingletoneObject 
    public static LazySingletoneObject getInstance(){
        if(instance == null){
          instance = new LazySingletoneObject();
        }
        return instance;
    }
}
