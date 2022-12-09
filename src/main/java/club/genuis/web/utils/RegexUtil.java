package club.genuis.web.utils;

import java.util.regex.Pattern;

public class RegexUtil {

    public static boolean checkEmail(String email){
        String reg = "[a-zA-Z0-9_\\-\\.\\|]+@[a-zA-Z0-9]+(\\.[a-zA-Z]+)+"; // 较为精确的匹配
        return email.matches(reg);
    }

    public static boolean checkPwd(String pwd){
        String reg = "(?=^.{8,16}$)(?=.*?\\d{1})(?=.*?[a-zA-Z]{1})(?=(?:.*?[\\/!@#$%*()_+^&}{:;\\?\\.`~<>]){1})(?!.*\\s)[0-9a-zA-Z\\/!@#$%*()_+^&}{:;\\?\\.`~<>]*$";
        return pwd.matches(reg);
    }

    public static boolean checkNftSourceUrl(String url){
        String reg = "^https://element-pixel.s3.ap-southeast-1.amazonaws.com/.*$";
        return url.matches(reg);
    }
    public static boolean isMobile(String mobile) {
        String reg = "^1\\d{10}$";
        return Pattern.matches(reg, mobile);
    }


    public static void main(String[] args) {
        System.out.println(checkEmail("1lin.cheu12ng.jkl_-12@gmail.com"));
    }
}
