///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package Utils;
//
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//
///**
// *
// * @author prjro
// */
//public class EmailValidator {
//    // Regex pattern to valid email address
//    private static final String EMAIL_REGEX=&quot;^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a;
//    
//    //static Pattern object, since pattern is fixed
//    private static Pattern pattern;
//    //non-static Matcher object because it's created from the input String
//    private Matcher matcher;
//     
//    public EmailValidator(){
//        //initialize the Pattern object
//        pattern = Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE);
//    }
//    /**
//     * This method validates the input email address with EMAIL_REGEX pattern
//     * @param email
//     * @return boolean
//     */
//    public boolean validateEmail(String email){
//        matcher = pattern.matcher(email);
//        return matcher.matches();
//    }
//}
//    
//
