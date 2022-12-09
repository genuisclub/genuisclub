package club.genuis.web.utils;

import java.util.Random;
import java.util.UUID;

public class RandomUtil {
    private final static String CHARS = "ABCDEFGHIJKLMNOPQRESTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public static String generateNonce(){
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 12; i++) {
            sb.append(CHARS.charAt(random.nextInt(CHARS.length())));
        }
        return sb.toString();
    }

    public static String generateNonce(int length){
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(CHARS.charAt(random.nextInt(CHARS.length())));
        }
        return sb.toString();
    }

    public static String generateToken(){
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 32; i++) {
            sb.append(CHARS.charAt(random.nextInt(CHARS.length())));
        }
        return sb.toString();
    }

    public static int nextInt(int min,int max){
        Random random = new Random();
        return min + random.nextInt(max-min);
    }

    public static double nextDouble(double min,double max){
        Random random = new Random();
        return min + random.nextDouble()*(max-min);
    }

    public static String genEmailValidityCode(){
        Random random = new Random();
        return String.valueOf(100000+random.nextInt(899999));
    }

    /**
     * 生成aws上传的key
     * @param prefix
     * @param ext
     * @return
     */
    public static String genAwsKey(String prefix, String ext){
     StringBuilder sb = new StringBuilder(prefix);
     if(!prefix.endsWith("/")){
         sb.append("/");
     }
     sb.append(DateUtil.getYmd());
     sb.append("/");
     sb.append(UUID.randomUUID().toString().replaceAll("-",""));
     if(!prefix.startsWith(".")){
         sb.append(".");
     }
     sb.append(ext);
     return sb.toString();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println("eeff"+generateNonce());
        }
    }
}
