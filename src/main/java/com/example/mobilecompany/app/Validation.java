package com.example.mobilecompany.app;




    public  class Validation {

        public static boolean CheckString(String str){
            boolean exp=true;

            if(str.equals("")){
                exp=false;
            }
            return exp;
        }

        public static boolean CheckString(String str, int size){
            boolean exp=true;

            if(str.equals("") || str.length()>size){
                exp=false;
            }
            return exp;
        }

        public static boolean CheckNumber(String str){
            boolean isOnlyDigits = true;
            for(int i = 0; i < str.length() && isOnlyDigits; i++){
                if(Character.isDigit(str.charAt(i))) {
                    isOnlyDigits = true;
                } else if (str.charAt(i)=='+') {
                    isOnlyDigits = true;
                }else {
                    isOnlyDigits = false;
                }
            }

            if(str.length()==13) {
                return isOnlyDigits;
            }else{
                return false;
            }
        }
        public static boolean checkParametr(String str){
            boolean isOnlyDigits = true;
            for(int i = 0; i < str.length() && isOnlyDigits; i++){
                if(Character.isDigit(str.charAt(i))) {
                    isOnlyDigits = true;
                } else {
                    isOnlyDigits = false;
                }
            }

            if(! isOnlyDigits ) {
                if(str.equals("Безліміт")||str.equals("безліміт")){
                    isOnlyDigits = true;
                }
            }
            return isOnlyDigits;
            }

    }



